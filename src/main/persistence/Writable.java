package persistence;

import org.json.JSONObject;

// Source: Modelled code based on Writable interface of JsonSerializationDemo
public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
