package Model;

public class ExactPriceFromQuantity implements IExactPrice {

	private int quantity;

	public ExactPriceFromQuantity(int quantity) {
		this.quantity = quantity;

	}

	@Override
	public String getExactPrice(int price) {
		if(quantity == 0) {
			return "0.00 per unit";
		}
		return IFood.formatPrice(price / quantity) + " per unit";
	}

}
