package utils;

import pojos.User;

import java.io.File;

public class UserNamer {

    private static final String path = new File("").getAbsolutePath() + "/src/test/resources/createdUsers/";

    public static File getFileName(User user) {
        return new File(path + user.username + "#" + user.id + ".json");
    }
}
