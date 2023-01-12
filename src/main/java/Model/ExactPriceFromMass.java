package Model;

public class ExactPriceFromMass implements IExactPrice  {
	
	private int mass;
	private String measurementUnit;
	private String perAmountValue = "/100";

	
	public ExactPriceFromMass(int mass, String measurementUnit){
		this.mass = mass;
		this.measurementUnit = measurementUnit;
	}

	@Override
	public String getExactPrice(int price) {
		
		if(mass == 0) {
			return "0.00/100"+measurementUnit;
		}
		

		return  IFood.formatPrice(getAdjustedPrice(price))+ perAmountValue + measurementUnit;
	}
	
	public int getAdjustedPrice(int price) {
		return (int) (((double)price) / mass * 100);
	}


}
