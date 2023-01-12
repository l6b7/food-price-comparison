import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.ExactPriceFromMass;
import Model.ExactPriceFromQuantity;
import Model.ExactPriceNotApplicable;
import Model.Food;
import Model.IExactPrice;
import Model.IFood;
import View.ConsoleTable;

class FoodTest {

	//Food f = new Food("bread", "tesco", 25, new ExactPriceFromMass(123,"g"));
	
	public static  ConsoleTable SampleTable() {
		
	String[] c =	 {"First","Second","Third"};
	
	String[][] r = {{"[0][0]","[0][1]","[0][2]"},
			
					{"[1][0]","[1][1]","[1][2]"},
					
					{"[2][0]","[2][1]","[2][2]"},
					
					{"[3][0]","[3][1]","[3][2]"}};
	
	return new ConsoleTable(c,r);
	}
	
	@Test
	void testIfPriceIsDisplayedProperly() {
		IFood f = new Food("name", "brand", 2233, new ExactPriceNotApplicable());
		assertEquals("22.33",f.getPrice());
	}
	@Test
	void testIfPriceWhen0() {
		IFood f = new Food("name", "brand", 0, new ExactPriceNotApplicable());
		assertEquals("0.00",f.getPrice());
	}
	@Test
	void testIfExactPriceIsDisplayedProperly() {
		IFood f = new Food("name", "brand", 1200, new ExactPriceFromMass(600, "g"));
		assertEquals("2.00/100g",f.getExactPrice());
	}
	@Test
	void testIfExactPriceWhen0Mass() {
		IFood f = new Food("name", "brand", 0, new ExactPriceFromMass(0, "g"));
		assertEquals("0.00/100g",f.getExactPrice());
	}
	@Test
	void testIfExactPriceWhenNotApplicable() {
		IFood f = new Food("name", "brand", 1, new ExactPriceNotApplicable());
		assertEquals("0.01",f.getExactPrice());
	}
	@Test
	void testIfExactPriceWithQuantity() {
		IFood f = new Food("name", "brand", 1000, new ExactPriceFromQuantity(3));
		assertEquals("3.33 per unit",f.getExactPrice());
	}
	@Test
	void testIfExactPriceWhenQuantity0() {
		IFood f = new Food("name", "brand", 1000, new ExactPriceFromQuantity(0));
		assertEquals("0.00 per unit",f.getExactPrice());
	}
	

}
