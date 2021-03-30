package com.rutgerkloppenburg.api.RaspPiApi.app.files;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;

public class FileWrapper {

    public String filePath = "/home/pi/Desktop/API/storage/";

    public void writeFile(String file, JsonObject writeData){
        try(FileWriter writer = new FileWriter(filePath + file)){
            writer.write(writeData.toString());
            writer.flush();
        } catch (IOException exception){
            exception.printStackTrace();
        }
    }

    public JsonObject getFile(String file) {
        if(new File(filePath + file).isFile()) {
            try (FileReader reader = new FileReader(filePath + file)) {
                return new JsonParser().parse(reader).getAsJsonObject();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        } else {
            return new JsonObject();
        }
        return new JsonObject();
    }

}
