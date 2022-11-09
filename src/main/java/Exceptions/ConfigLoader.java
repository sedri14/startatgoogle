package Exceptions;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Map;


public class ConfigLoader {

    private ConfigLoader() {
    }

    public static Map<String, String> loadConfig(String filePath) {
        Map<String, String> configMap = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            Type stringStringMap = new TypeToken<Map<String, String>>() {
            }.getType();
            configMap = new Gson().fromJson(bufferedReader, stringStringMap);
        } catch (FileNotFoundException e) {
            handleFileNotFound();
        } catch (IOException e) {
            System.out.println("Couldn't read from file");
            throw new RuntimeException(e);
        }

        return configMap;
    }

    private static void handleFileNotFound() {
        System.out.println("File is not found");
        loadDefaultConfig();
        System.out.println("defaultConfig.txt has been created and loaded!");
    }

    public static Map<String, String> loadDefaultConfig() {
        System.out.println("Creating and loading a default file of configurations...");
        String defaultConfigFilePath = "C:\\Users\\Sedri\\IdeaProjects\\StartAtGoogle\\src\\Exceptions\\" + DefaultConfig.fileName;
        File newFile = new File(defaultConfigFilePath);
        try {
            BufferedWriter output = new BufferedWriter(new FileWriter(newFile));
            output.write(DefaultConfig.defaultConfig);
            output.close();
        } catch (IOException e) {
            System.out.println("Couldn't write to file");
            throw new RuntimeException(e);
        }

        return loadConfig(defaultConfigFilePath);
    }

    private class DefaultConfig {

        final static String fileName = "defaultConfig.txt";

        //TODO- make this a map <String,String> and convert this to json.
        final static String defaultConfig = "{\n" +
                "    \"_id\": \"635bec401f39c2d496c56d60\",\n" +
                "    \"index\": 0,\n" +
                "    \"guid\": \"d5cf5537-f902-4532-a8d1-461881f71dba\",\n" +
                "    \"isActive\": true,\n" +
                "    \"balance\": \"$1,504.90\",\n" +
                "    \"picture\": \"http://placehold.it/32x32\",\n" +
                "    \"age\": 20,\n" +
                "    \"eyeColor\": \"green\",\n" +
                "    \"name\": \"Sonia Gibson\",\n" +
                "    \"gender\": \"female\",\n" +
                "    \"company\": \"VIDTO\",\n" +
                "    \"email\": \"soniagibson@vidto.com\"" +
                "\n}";
    }
}
