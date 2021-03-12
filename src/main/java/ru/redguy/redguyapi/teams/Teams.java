package ru.redguy.redguyapi.teams;

import org.json.JSONArray;
import org.json.JSONObject;
import ru.redguy.redguyapi.ApiError;
import ru.redguy.redguyapi.ApiRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Teams {
    private Map<String, String> options;

    public Teams(Map<String, String> options) {
            this.options = options;
        }

    public List<TeamPosition> get(int id, String socNet) throws IOException, ApiError {
        JSONArray objects =  ApiRequest.mainGetArray("team/users/get",
                this.options,
                new HashMap<String, Object>() {{put("id",id); put("type",socNet);}}
        );
        ArrayList<TeamPosition> positions = new ArrayList<>();
        for (Object rawobject : objects) {
            JSONObject object = (JSONObject) rawobject;
            positions.add(new TeamPosition(
                    new Team(object.getInt("companyId"),object.getString("companyName")),
                    object.getString("nick"),
                    object.getString("position")
            ));
        }
        return positions;
    }
}
