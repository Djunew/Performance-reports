package employees;

public class SalesEmployee implements Employee {
	
	private String name;
	private int totalSales;
	private int salesPeriod;
	private double experienceMultiplier;
	private double score = 0;
	
	public SalesEmployee(String name, int totalSales, int salesPeriod, double experienceMultiplier) {
		this.name = name;
		this.totalSales = totalSales;
		this.salesPeriod = salesPeriod;
		this.experienceMultiplier = experienceMultiplier;
	}
	
    @Override
    public String toString() {
        return "Employee [name=" + name + ", total sales=" + totalSales + ", sales period=" + salesPeriod + ", exp multiplier=" + experienceMultiplier + "]";
    }

	//uem = useExperienceMultiplier
	@Override
	public double calculateScore(boolean uem) {
		
		if (uem == true) {
			score = totalSales / salesPeriod * experienceMultiplier;
		} else {
			score = totalSales / salesPeriod;
		}
		
		return score;
	}

	@Override
	public int getTotalSales() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setTotalSales(int totalSales) {
		// TODO Auto-generated method stub
		
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
