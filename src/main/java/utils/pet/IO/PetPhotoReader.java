package utils.pet.IO;

import com.fasterxml.jackson.databind.ObjectMapper;
import pojos.User;
import utils.Constants;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
