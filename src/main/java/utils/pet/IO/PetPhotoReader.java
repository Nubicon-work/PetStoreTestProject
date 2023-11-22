package utils.pet.IO;

import utils.Constants;

import java.io.File;
import java.util.Random;

public class PetPhotoReader {

    public static File readRandom() {
        File[] allPhotos = new File(Constants.petPhotosDirectory).listFiles();
        if (allPhotos == null) {
            System.out.println("\n\n\nNo files in directory " + Constants.petPhotosDirectory);
            return null;
        }
        return allPhotos[new Random().nextInt(allPhotos.length)];
    }
}
