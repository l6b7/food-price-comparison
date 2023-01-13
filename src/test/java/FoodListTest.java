import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.FoodList;
import Model.DummyDataStoring;

class FoodListTest {

	@Test
	void testIfFoodListIsGettingSortedAutomatically() {

		FoodList f = new FoodList(new DummyDataStoring());
		f.addFood("fff", "brand", 1);
		f.addFood("abc", "brand", 1);
		f.addFood("zzz", "brand", 1);
		f.addFood("aaa", "brand", 1);

		assertEquals(f.getFoodList().get(0).getName(), "aaa");
	}

	@Test
	void testIfFoodListIsImmutableForClients() {
		FoodList f = new FoodList(new DummyDataStoring());
		f.addFood("name", "brand", 1);

		f.getFoodList().removeAll(f.getFoodList());
		
		assertEquals(f.getFoodList().get(0).getName(), "name");
	}

	@Test
	void testRemovingIndexOutOfBounds() {
		FoodList f = new FoodList(new DummyDataStoring());
		f.addFood("name", "brand", 1);
		assertDoesNotThrow(() -> f.removeFood(999));

	}

}
