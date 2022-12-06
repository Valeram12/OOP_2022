package main.homeappliances.devices;

public class appliancesPlug extends appliances {
    private main.homeappliances.devices.typePlug typePlug;

    public appliancesPlug(appliancesTypes typeOfAppl,
                          boolean stateOfAppl,  main.homeappliances.devices.typePlug typePlug) {
        super(typeOfAppl, stateOfAppl);
        this.typePlug = typePlug;
    }

    @Override
    public  main.homeappliances.devices.typePlug getPlug() {
        return typePlug;
    }

    @Override
    public void setPlug( main.homeappliances.devices.typePlug typePlug) {
        this.typePlug = typePlug;
    }

}
