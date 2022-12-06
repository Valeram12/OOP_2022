package main.homeappliances;

import main.homeappliances.devices.appliancesInterface;
import main.homeappliances.devices.sortF.SortByPower;
import main.homeappliances.devices.sortF.SortByState;
import main.homeappliances.devices.applCreate;
import main.homeappliances.devices.appliancesPowerFromFile;
import main.homeappliances.exceptions.LoadFromFileException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class administrator {                    //Найважливіший клас який керує всіма
    private List<appliancesInterface> devices;
    private applCreate generate;

    private String getOutput(List<appliancesInterface> devices) {               //Повертає рядок зі списком приладів
        StringBuilder sb = new StringBuilder();
        int totalOnPower = 0;
        int countOnPower = 0;
        for (appliancesInterface device : devices) {
            sb.append(device).append("\n");
            if (device.isOn()) {
                totalOnPower += device.getPower();
                countOnPower++;
            }
        }
        sb.append("\nTotal ON count: ").append(countOnPower)
                .append("\nTotal ON power: ").append(totalOnPower);
        return sb.toString();
    }

    public administrator() {                                                //Ініціалізує список пристроїв, генератор та загрузку даних з файлу
        try {
            appliancesPowerFromFile appliancesProp = new appliancesPowerFromFile();
        } catch (LoadFromFileException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        this.devices = new ArrayList<>();
        generate = new applCreate(devices);
    }

    public void generateDevices(int countOfDevices) {                       // Генерує прибори
        if (countOfDevices > 0) generate.add(countOfDevices);
        else System.out.println("Cant generate " + countOfDevices + " devices");
    }

    public void sort() {
        Collections.sort(devices);
    }                       //Сортування за станом та потужністю.

    public void sortByPower() {
        Collections.sort(devices, new SortByPower());
    }   //Сортування за потужністю.

    public void sortByState() {
        Collections.sort(devices, new SortByState());
    }   //Сортування за станом.

    public String getOutput() {
        return getOutput(devices);
    }

    public String foundByPower(int startPower, int endPower) {                  //Пошук приборів
        List<appliancesInterface> foundDevices = new ArrayList<>();
        for (appliancesInterface device : devices) {
            if (device.getPower() >= startPower
                    && device.getPower() <= endPower) try {
                foundDevices.add(device.clone());
            } catch (CloneNotSupportedException e) {
                    System.out.println("Cloning error");
            }
        }
        return getOutput(foundDevices);
    }

}
