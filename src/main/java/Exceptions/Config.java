package Exceptions;

import java.util.Map;

public class Config {

    private Map<String, String> configMap = null;

    public Config(){

    }

    public String getParameterByName(String name) throws IllegalAccessException {
        //TODO- use get map (we don't know if configMap is initialized)
        if (configMap.containsKey(name)) {
            return configMap.get(name);
        } else {
            //TODO- if config map does not exist this catch will be wrong.
            throw new IllegalAccessException("There is no parameter with name: " + name);
        }
    }

    public Map<String, String> getConfigMap() throws IllegalAccessException {
        if (configMap == null) {
            throw new IllegalAccessException("Configurations are not initialized");
        }

        return getConfigMap();
    }

    public void loadConfigFromFile(String configFilePath) {
        System.out.println("Loading config from file:" + configFilePath);
        configMap = ConfigLoader.loadConfig(configFilePath);
    }

    public void loadDefaultConfig() {
        configMap = ConfigLoader.loadDefaultConfig();
        System.out.println("Default config loaded successfully");
    }
}
