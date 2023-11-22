package utils.user.IO;

import pojos.User;
import utils.user.UserFileNamer;

import java.io.File;

public class UserRemover {

    public static boolean remove(User user) {
        File file = UserFileNamer.getFileName(user);
        System.out.println(file);
        return file.delete();
    }
}
