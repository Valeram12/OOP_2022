package main.homeappliances.devices;

import main.homeappliances.exceptions.LoadFromFileException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class appliancesPowerFromFile {
    private final static String SOURCE_PATH = "devices.txt";
    private static Map<appliancesTypes, Integer> powerFromFile = new HashMap<>();

    private void loadPower() throws LoadFromFileException {
        try {
            Properties properties = new Properties();
            FileInputStream fis = new FileInputStream(SOURCE_PATH);
            properties.load(fis);
            for (int i = 0; i < appliancesTypes.values().length; i++) {
                powerFromFile.put(appliancesTypes.values()[i],
                        Integer.valueOf(properties.getProperty(
                                appliancesTypes.values()[i].name())));
            }
        } catch (IOException e) {
            throw new LoadFromFileException("Error with loading file");
        }
    }

    public appliancesPowerFromFile() throws LoadFromFileException {
        loadPower();
    }

    public static Map<appliancesTypes, Integer> getPower() {
        return powerFromFile;
    }
}
