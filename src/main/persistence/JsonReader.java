package persistence;

import model.HouseOfPets;
import model.Pet;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Represents a reader that reads HouseOfPets from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads HouseOfPets from file and returns it;
    // throws IOException if an error occurs reading data from file
    public HouseOfPets read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseHouseOfPets(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses HouseOfPets from JSON object and returns it
    private HouseOfPets parseHouseOfPets(JSONObject jsonObject) {
        HouseOfPets hp = new HouseOfPets();
        addPets(hp, jsonObject);
        return hp;
    }

    // MODIFIES: hp
    // EFFECTS: parses thingies from JSON object and adds them to HouseOfPets
    private void addPets(HouseOfPets hp, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("pets");
        for (Object json : jsonArray) {
            JSONObject nextPet = (JSONObject) json;
            addPet(hp, nextPet);
        }
    }

    // MODIFIES: hp
    // EFFECTS: parses Pet from JSON object and adds it to HouseOfPets
    private void addPet(HouseOfPets hp, JSONObject jsonObject) {
        String petname = jsonObject.getString("name");
        Double petage = jsonObject.getDouble("age");
        String petbreed = jsonObject.getString("breed");
        Double petweight = jsonObject.getDouble("weight");
        String typeofpet = jsonObject.getString("typeofpet");
        JSONArray petact = jsonObject.getJSONArray("petactions");

        Pet p = new Pet(petname, petage, typeofpet, petbreed, petweight);

        p.updateActionsJson(petact);

        hp.addPet(p);
    }
}
