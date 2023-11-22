package utils.pet.IO;

import pojos.Pet;
import pojos.User;
import utils.pet.PetFileNamer;
import utils.user.UserFileNamer;

import java.io.File;

public class PetRemover {

    public static boolean remove(Pet pet) {
        File file = PetFileNamer.getFileName(pet);
        return file.delete();
    }
}
