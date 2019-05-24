package entities;

public class Seller {
    private String name;
    private int totalSales;
    private int salesPeriod;
    private double experienceMultiplier;

    public String getName() {
        return name;
    }

    public int getTotalSales() {
        return totalSales;
    }

    public int getSalesPeriod() {
        return salesPeriod;
    }

    public double getExperienceMultiplier() {
        return experienceMultiplier;
    }
}
