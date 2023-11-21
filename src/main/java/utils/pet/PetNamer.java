package utils.pet;

import interfaces_and_abstract_classes.Entity;
import pojos.Pet;
import utils.Constants;

import java.io.File;

public class PetNamer {

    public static File getFileName(Pet pet) {
        return new File(Constants.createdPetsDirectory + pet.name + "#" + pet.id + ".json");
    }
}
