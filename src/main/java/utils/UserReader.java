package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import pojos.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Random;

public class UserReader {

    private static final String usersDirectory = new File("").getAbsolutePath() + "/src/test/resources/createdUsers/";

    public static User readRandom() {
        File[] allUsers = new File(usersDirectory).listFiles();
        if (allUsers == null) {
            System.out.println("\n\n\nNo files in directory " + usersDirectory);
            return null;
        }
        File randomFile = allUsers[new Random().nextInt(allUsers.length)];
        StringBuilder json = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(allUsers[new Random().nextInt(allUsers.length)]))) {
            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            User user = mapper.readValue(json.toString(), User.class);
            return user;
        } catch (Exception ex) {
            System.out.println("\n\n\nMapping error message: " + ex.getMessage());
            return null;
        }
    }
}
