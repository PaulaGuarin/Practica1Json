import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class App {

    static Gson gson = new Gson();
    private File fileJson;
    private  static final String jsonFilePath = "src/main/resources/User";

    public static void main(String[] args) {
        user userTransformation = new App().JsonToUserT();
        System.out.printf(String.format("Desde el objeto >>\n%s\n", userTransformation));
        String newJsonT = gson.toJson(userTransformation);
        System.out.printf(String.format("Tran hacia Json \n%s\n", newJsonT));
    }

    public user JsonToUserT() {
        try {
            fileJson = new File(jsonFilePath);
            BufferedReader buffer = new BufferedReader(new FileReader(fileJson));
            String json = "";
            String line = "";
            while ((line = buffer.readLine()) != null) {
                json = json + line;
            }
            buffer.close();
            user user = gson.fromJson(json, user.class);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}