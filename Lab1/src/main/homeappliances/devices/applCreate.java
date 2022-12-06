package main.homeappliances.devices;

import java.util.List;
import java.util.Random;

public class applCreate {           //Створення приборів
    private List<appliancesInterface> devices;
    private Random random = new Random(41);

    private appliancesInterface getDevice() {
        return new appliancesPlug(Enums.random(
                appliancesTypes.class), random.nextBoolean(),
                Enums.random(typePlug.Europlug.class));
    }

    public applCreate(List<appliancesInterface> devices) {
        this.devices = devices;
    }       //Конструктор

    public void add(int countOfDevices) {
        for (int i = 0; i < countOfDevices; i++) {
            devices.add(getDevice());
        }
    }

    public static class Enums {
        private static Random random = new Random();

        public static <T extends Enum<T>> T random(Class<T> ec) {
            return random(ec.getEnumConstants());
        }

        public static <T> T random(T[] values) {
            return values[random.nextInt(values.length)];
        }
    }

}
