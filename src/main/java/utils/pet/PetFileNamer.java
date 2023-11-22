package utils.pet;

import pojos.Pet;
import utils.Constants;

import java.io.File;

public class PetFileNamer {

    public static File getFileName(Pet pet) {
        return new File(Constants.createdPetsDirectory + pet.name + "#" + pet.id + ".json");
    }
}
