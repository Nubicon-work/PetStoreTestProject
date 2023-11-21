package utils.user;

import pojos.User;
import utils.Constants;

import java.io.File;

public class UserNamer {

    public static File getFileName(User user) {
        return new File(Constants.createdUsersDirectory + user.username + "#" + user.id + ".json");
    }
}
