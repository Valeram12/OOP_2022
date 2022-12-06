package main.homeappliances.devices;


public abstract class appliances implements appliancesInterface, Cloneable {
    private appliancesTypes typeOfAppl;
    private int powerOfAppl;
    private boolean stateOfAppl;

    public appliances(appliancesTypes typeOfAppl, boolean stateOfAppl) {
        this.typeOfAppl = typeOfAppl;
        this.powerOfAppl = appliancesPowerFromFile.getPower().get(typeOfAppl);
        this.stateOfAppl = stateOfAppl;
    }

    @Override
    public boolean isOn() {
        return stateOfAppl;
    }

    @Override
    public int getPower() {
        return powerOfAppl;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(").append(this.typeOfAppl)
                .append(" : ").append(this.getPlug()).append(" : ")
                .append(this.powerOfAppl).append(" : ")
                .append(this.isOn()? "on" : "off").append(")");
        return sb.toString();
    }

    @Override
    public appliances clone() throws CloneNotSupportedException {
        return (appliances) super.clone();
    }

    @Override
    public int compareTo(appliancesInterface devToCompare) {
        int result;
        result = Boolean.compare(isOn(), devToCompare.isOn());
        if (result != 0) return result;
        result = Integer.compare(getPower(), devToCompare.getPower());
        return result;
    }
}
