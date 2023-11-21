package utils.pet.IO;

import com.fasterxml.jackson.databind.ObjectMapper;
import pojos.Pet;
import utils.pet.PetNamer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PetWriter {

    public static void write(Pet pet) {
        File file = PetNamer.getFileName(pet);
        try {
            file.createNewFile();
        } catch (IOException ex) {
            System.out.println("\n\n\nFile creating error message: " + ex.getMessage());
        }
        String jsonString = "";
        try {
            ObjectMapper mapper = new ObjectMapper();
            jsonString = mapper.writeValueAsString(pet);
        } catch (Exception ex) {
            System.out.println("\n\n\nMapping error message: " + ex.getMessage());
        }
        try (FileWriter writer = new FileWriter(file, false)) {
            writer.write(jsonString);
            writer.flush();
        } catch (IOException ex) {
            System.out.println("\n\n\nIO error message: " + ex.getMessage() + "\n\n\n");
        }
    }

    public static void write(Pet[] pets) {
        for (int i = 0; i < pets.length; i++) {
            write(pets[i]);
        }
    }

    public static void write(List<Pet> pets) {
        for (Pet pet : pets) {
            write(pet);
        }
    }
}
