package utils;

import pojos.User;

import java.io.File;

public class UserRemover {

    public static boolean remove(User user) {
        File file = UserNamer.getFileName(user);
        System.out.println(file);
        return file.delete();
    }
}
