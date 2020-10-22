import ru.redguy.redguyapi.ApiError;
import ru.redguy.redguyapi.RedGuyApi;
import ru.redguy.redguyapi.math.NumberLevels;
import ru.redguy.rednetworker.clients.http.exceptions.OpenConnectionException;
import ru.redguy.rednetworker.clients.http.exceptions.URLException;

public class Main {
    public static void main(String[] args) throws OpenConnectionException, ApiError, URLException {
        RedGuyApi redGuyApi = new RedGuyApi(System.getenv("TOKEN"));
        System.out.println(redGuyApi.math().get(NumberLevels.factorial,2));
    }
}
