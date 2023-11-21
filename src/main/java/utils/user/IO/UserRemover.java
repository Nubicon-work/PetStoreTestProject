package utils.user.IO;

import pojos.User;
import utils.user.UserNamer;

import java.io.File;

public class UserRemover {

    public static boolean remove(User user) {
        File file = UserNamer.getFileName(user);
        System.out.println(file);
        return file.delete();
    }
}
