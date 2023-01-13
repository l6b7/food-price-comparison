package Model;

public class Food implements IFood{

	public static void main(String[] args) {
		Food f = new Food("bread", "tesco", 25, new ExactPriceFromMass(123,"g"));
		System.out.println(f);

	}


	private String name;
	private String brand;
	private int price;
	private IExactPrice amount;
	

	public Food(String name, String brand, int price, IExactPrice amount) {
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public String getBrand() {
		return brand;
	}

	public String getPrice() {
		return String.format("%.2f",((double) price / 100 ));
	}

	public String getExactPrice() {
		return amount.getExactPrice(price);
	}

	@Override
	public String toString() {
	return "[" + getName() + "] ["+ getBrand() + "] [" + getPrice() + "] [" + getExactPrice()+"]";
	}

}
