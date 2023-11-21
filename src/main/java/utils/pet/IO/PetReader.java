package utils.pet.IO;

import com.fasterxml.jackson.databind.ObjectMapper;
import pojos.Pet;
import pojos.User;
import utils.Constants;
import utils.pet.PetNamer;
import utils.user.UserNamer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Random;

public class PetReader {

    public static Pet readRandom() {
        File[] allPets = new File(Constants.createdPetsDirectory).listFiles();
        if (allPets == null) {
            System.out.println("\n\n\nNo files in directory " + Constants.createdPetsDirectory);
            return null;
        }
        File randomFile = allPets[new Random().nextInt(allPets.length)];
        StringBuilder json = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(randomFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json.toString(), Pet.class);
        } catch (Exception ex) {
            System.out.println("\n\n\nMapping error message: " + ex.getMessage());
            return null;
        }
    }

    public static Pet read(File file) {
        StringBuilder json = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json.toString(), Pet.class);
        } catch (Exception ex) {
            System.out.println("\n\n\nMapping error message: " + ex.getMessage());
            return null;
        }
    }

    public static Pet read(Pet pet) {
        return read(PetNamer.getFileName(pet));
    }
}
