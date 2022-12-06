package main.homeappliances.devices.sortF;

import  main.homeappliances.devices.appliancesInterface;
import java.util.Comparator;

public class SortByPower implements Comparator<appliancesInterface> {
    @Override
    public int compare(appliancesInterface d1, appliancesInterface d2) {
        if (d1.getPower() > d2.getPower()) {
            return 1;
        } else if (d1.getPower() < d2.getPower()) {
            return -1;
        } else return 0;
    }
}


