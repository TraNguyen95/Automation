package helpler;

import com.google.gson.Gson;
import common.GlobleVariables;
import model.User;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFileJson {
    public static final String FILE_PATH_XML = System.getProperty("user.dir");

    public static User readFileUser() throws IOException {
        String ev = GlobleVariables.eviroment;
        String path = FILE_PATH_XML +  "/src/test/resources/" + ev + "/user.json";
        System.out.println(path);
        Reader reader = Files.newBufferedReader(Paths.get(path));
        Gson gson = new Gson();
        User[] users = gson.fromJson(reader, User[].class);
        return users[0];
    }
}
