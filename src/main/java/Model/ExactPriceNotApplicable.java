package Model;

public class ExactPriceNotApplicable implements IExactPrice {

	@Override
	public String getExactPrice(int price) {
		return IFood.formatPrice(price);
	}

}
