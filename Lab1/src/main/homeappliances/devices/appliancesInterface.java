package main.homeappliances.devices;

public interface appliancesInterface extends Comparable <appliancesInterface>{
    boolean isOn();

    int getPower();
    typePlug getPlug();

    void setPlug(typePlug plug);

    appliances clone() throws CloneNotSupportedException;

    @Override
    int compareTo(appliancesInterface o);
}
