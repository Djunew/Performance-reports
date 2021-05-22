package reports;

public class Report {
	
	public int topPerformersThreshold;
	public boolean useExperienceMultiplier;
	public int periodLimit;
	
	public Report(int topPerformersThreshold, boolean useExperienceMultiplier, int periodLimit) {
		this.topPerformersThreshold = topPerformersThreshold;
		this.useExperienceMultiplier = useExperienceMultiplier;
		this.periodLimit = periodLimit;
	}

	public boolean checkConditions(int salesPer, double employeeScore) {
		
		boolean addEmployee = true;
		
		if (salesPer == periodLimit && employeeScore <= topPerformersThreshold) {
			addEmployee = true;
		}
		
		return addEmployee;		
	}

}