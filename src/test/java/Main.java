import ru.redguy.redguyapi.ApiError;
import ru.redguy.redguyapi.RedGuyApi;
import ru.redguy.redguyapi.math.NumberLevels;
import ru.redguy.rednetworker.clients.http.exceptions.OpenConnectionException;
import ru.redguy.rednetworker.clients.http.exceptions.URLException;

public class Main {
    public static void main(String[] args) throws Exception {
        RedGuyApi redGuyApi = new RedGuyApi(System.getenv("TOKEN"));
        if(redGuyApi.math().get(NumberLevels.factorial,2) != 2) {
            throw new Exception("Incorrect result!");
        } else {
            System.out.println("math.get - OK!");
        }
        System.out.println("math.max - OK! Got:"+redGuyApi.math().max(NumberLevels.factorial));
    }
}
