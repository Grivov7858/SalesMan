package entities;

public class Report {
    private int topPerformersThreshold;
    private boolean useExperienceMultiplier;
    private int periodLimit;

    public int getTopPerformersThreshold() {
        return topPerformersThreshold;
    }

    public boolean isUseExperienceMultiplier() {
        return useExperienceMultiplier;
    }

    public int getPeriodLimit() {
        return periodLimit;
    }
}
