package Exceptions;

public class Main {
    public static void main(String[] args) {

        final String configFilePath = "C:\\Users\\Sedri\\IdeaProjects\\StartAtGoogle\\src\\Exceptions\\config1.txt";
        Config config = new Config();
        try {
            config.getConfigMap();
        } catch (IllegalAccessException e) {
            e.getMessage();
            config.loadDefaultConfig();
        }

        String lookup1 = "picture";
        try {
            String val = config.getParameterByName(lookup1).toLowerCase();
            System.out.println(lookup1 + " :" + val);
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }

        config.loadConfigFromFile(configFilePath);

        String lookup2 = "version";
        String lookup3 = "blablabla";
        try {
            String val = config.getParameterByName(lookup2).toLowerCase();
            System.out.println(lookup2 + " :" + val);
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }

        try {
            String val = config.getParameterByName(lookup3).toLowerCase();
            System.out.println(lookup3 + " :" + val);
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }
}