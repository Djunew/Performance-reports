package employees;

public class SalesEmployee implements Employee {
	
	private String name;
	private int totalSales;
	private int salesPeriod;
	private double experienceMultiplier;
	private double score = 0;
	private boolean addToReport;
	
	public SalesEmployee(String name, int totalSales, int salesPeriod, double experienceMultiplier) {
		this.name = name;
		this.totalSales = totalSales;
		this.salesPeriod = salesPeriod;
		this.experienceMultiplier = experienceMultiplier;
	}
	
    public String toString() {
        return "Employee [name=" + name + ", total sales=" + totalSales + ", sales period=" + salesPeriod + ", exp multiplier=" + experienceMultiplier + "]";
    }

	/*
	 * Calculate the score for each employee
	 * uem = useExperienceMultiplier
	 */
	@Override
	public double calculateScore(boolean uem) {
		
		if (uem == true) {
			score = totalSales / salesPeriod * experienceMultiplier;
		} else {
			score = totalSales / salesPeriod;
		}
		
		return score;
	}

	/*
	 * This method determines if the employee will be added to the Result report
	 * flag should come from checkConditions method
	 */
	public boolean addEmployeeToReport(boolean flag) {
		
		return this.addToReport = flag;
	}
	
	@Override
	public int getTotalSales() {
		return totalSales;
	}

	@Override
	public void setTotalSales(int totalSales) {
		this.totalSales = totalSales;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int getSalesPeriod() {
		return salesPeriod;
	}

	@Override
	public void setSalesPeriod(int salesPeriod) {
		this.salesPeriod = salesPeriod;
	}

	@Override
	public double getExperienceMultiplier() {
		return experienceMultiplier;
	}

	@Override
	public void setExperienceMultiplier(double experienceMultiplier) {
		this.experienceMultiplier = experienceMultiplier;
	}

	@Override
	public double getScore() {
		return score;
	}
	
}
