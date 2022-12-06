package main.homeappliances;

public class main {
    public static void main(String[] args) {
        administrator administrator = new administrator();
        administrator.generateDevices(10);
        System.out.println("\nGenerated:");
        System.out.println(administrator.getOutput());
        System.out.println("\nsorted by Comparable(State off/on & Power):");
        administrator.sort();
        System.out.println(administrator.getOutput());
        System.out.println("\nsorted by Comparator SortByState():");
        administrator.sortByState();
        System.out.println(administrator.getOutput());
        System.out.println("\nsorted by Comparator SortByPower():");
        administrator.sortByPower();
        System.out.println(administrator.getOutput());
        System.out.println("\nFound [300 - 750]:");
        System.out.println(administrator.foundByPower(300, 750));
    }
}
