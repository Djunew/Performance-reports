package reports;

public class PerformanceReport implements Report{
	
	public int topPerformersThreshold;
	public boolean useExperienceMultiplier;
	public int periodLimit;
	public int topPercent;
	
	public PerformanceReport(int topPerformersThreshold, boolean useExperienceMultiplier, int periodLimit) {
		this.topPerformersThreshold = topPerformersThreshold;
		this.useExperienceMultiplier = useExperienceMultiplier;
		this.periodLimit = periodLimit;
	}
	
	//This method calculates what is the top X percent of the results,
	//where X is defined by the topPerformersThreshold property of the report definition file
	public int calculateTopXpercent(int topPerformersThreshold) {
		
		//TODO create the calculation and change the condition in checkConditions method
		return topPercent = topPerformersThreshold;
	}

	/*
	 * This method checks does the current employee meets the requirements to be
	 * added to the Results report
	 * 
	 * It return true if the employee has to be added to the Results report
	 */
	public boolean checkConditions(int salesPer, double employeeScore) {
		
		return salesPer <= this.periodLimit && employeeScore <= this.topPerformersThreshold;
	}

}