package employees;

public interface Employee {
	
	   public int getTotalSales();
	   
	   public void setTotalSales(int totalSales);
	   
	   public String getName();
	   
	   public void setName(String name);
	   
	   public int getSalesPeriod();
	   
	   public void setSalesPeriod(int salesPeriod);
	   
	   public double getExperienceMultiplier();
	   
	   public void setExperienceMultiplier(double experienceMultiplier);
	   
	   public double getScore();
	
	   public double calculateScore(boolean uem);

}
