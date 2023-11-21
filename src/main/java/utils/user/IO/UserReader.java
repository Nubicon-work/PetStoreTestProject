package utils.user.IO;

import com.fasterxml.jackson.databind.ObjectMapper;
import pojos.User;
import utils.Constants;
import utils.user.UserNamer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Random;

public class UserReader {

    public static User readRandom() {
        File[] allUsers = new File(Constants.createdUsersDirectory).listFiles();
        if (allUsers == null) {
            System.out.println("\n\n\nNo files in directory " + Constants.createdUsersDirectory);
            return null;
        }
        File randomFile = allUsers[new Random().nextInt(allUsers.length)];
        StringBuilder json = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(randomFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json.toString(), User.class);
        } catch (Exception ex) {
            System.out.println("\n\n\nMapping error message: " + ex.getMessage());
            return null;
        }
    }

    public static User read(File file) {
        StringBuilder json = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json.toString(), User.class);
        } catch (Exception ex) {
            System.out.println("\n\n\nMapping error message: " + ex.getMessage());
            return null;
        }
    }

    public static User read(User user) {
        return read(UserNamer.getFileName(user));
    }
}
