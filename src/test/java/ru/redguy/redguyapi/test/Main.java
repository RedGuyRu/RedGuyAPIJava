package ru.redguy.redguyapi.test;
import ru.redguy.redguyapi.RedGuyApi;
import ru.redguy.redguyapi.ValueChange;
import ru.redguy.redguyapi.event.Wins;
import ru.redguy.redguyapi.math.NumberLevels;

public class Main {
    public static void main(String[] args) throws Exception {
        RedGuyApi redGuyApi = new RedGuyApi(System.getenv("TOKEN"));
        /*if(redGuyApi.math().get(NumberLevels.factorial,2) != 2) {
            throw new IllegalArgumentException("Incorrect result!");
        } else {
            System.out.println("math.get - OK!");
        }
        System.out.println("math.max - OK! Got:"+redGuyApi.math().max(NumberLevels.factorial));*/
        if(redGuyApi.users().get(1).getId() != 1) {
            throw new IllegalArgumentException("Incorrect result!");
        } else {
            System.out.println("users.get - OK!");
        }

        int wins = redGuyApi.event().wins().get("b12").getWins();
        Wins.AddResponse add = redGuyApi.event().wins().add("b12",1);
        if(add.getOldWins() != wins) {
            throw new IllegalArgumentException("Incorrect result!");
        }
        Wins.SetResponse set = redGuyApi.event().wins().set("b12",wins);
        if(set.getNewWins() != wins) {
            throw new IllegalArgumentException("Incorrect result!");
        }
        System.out.println("Event.Wins.* - OK!");

        /*if(!redGuyApi.teams().get(195680093, "vk").get(0).team.name.equals("RedGuyGames")) {
            throw new IllegalArgumentException("Incorrect result!");
        }
        System.out.println("Teams.get - OK!");*/
    }
}
