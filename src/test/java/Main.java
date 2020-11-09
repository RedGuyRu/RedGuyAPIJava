import ru.redguy.redguyapi.RedGuyApi;
import ru.redguy.redguyapi.math.NumberLevels;

public class Main {
    public static void main(String[] args) throws Exception {
        RedGuyApi redGuyApi = new RedGuyApi(System.getenv("TOKEN"));
        if(redGuyApi.math().get(NumberLevels.factorial,2) != 2) {
            throw new Exception("Incorrect result!");
        } else {
            System.out.println("math.get - OK!");
        }
        System.out.println("math.max - OK! Got:"+redGuyApi.math().max(NumberLevels.factorial));
        if(redGuyApi.users().get(1).getId() != 1) {
            throw new Exception("Incorrect result!");
        } else {
            System.out.println("users.get - OK!");
        }
    }
}
