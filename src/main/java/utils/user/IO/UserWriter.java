package utils.user.IO;

import com.fasterxml.jackson.databind.ObjectMapper;
import pojos.User;
import utils.user.UserNamer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class UserWriter {

    public static void write(User user) {
        File file = UserNamer.getFileName(user);
        try {
            file.createNewFile();
        } catch (IOException ex) {
            System.out.println("\n\n\nFile creating error message: " + ex.getMessage());
        }
        String jsonString = "";
        try {
            ObjectMapper mapper = new ObjectMapper();
            jsonString = mapper.writeValueAsString(user);
        } catch (Exception ex) {
            System.out.println("\n\n\nMapping error message: " + ex.getMessage());
        }
        try (FileWriter writer = new FileWriter(file, false)) {

            writer.write(jsonString);
            writer.flush();
        } catch (IOException ex) {
            System.out.println("\n\n\nIO error message: " + ex.getMessage() + "\n\n\n");
        }
    }

    public static void write(User[] users) {
        for (int i = 0; i < users.length; i++) {
            write(users[i]);
        }
    }

    public static void write(List<User> users) {
        for (User user : users) {
            write(user);
        }
    }
}
