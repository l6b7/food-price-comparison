import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import Controller.Controller;
import Model.DummyDataStoring;

class ControllerTest {

	@Test
	void testControllerTableArrayFirstElement() {
		//add operation should sort content by name 
		//so alphabetical order by name of elements expected

		Controller controller = new Controller(new DummyDataStoring());

		controller.addFood("BBB", "brand1", 100);
		controller.addFood("AAA", "brand2", 200);
		controller.addFood("CCC", "brand3", 300);

		String[][] tableContent = controller.getTableContent();
		
		
		assertEquals(tableContent[0][0], "AAA");

	}

	@Test
	void testIfIsEmpty() {

		Controller controller = new Controller(new DummyDataStoring());

		assertEquals(controller.getTableContent().length, 0);
	}

	@Test
	void testRemoveOperationWhenEmpty() {

		Controller controller = new Controller(new DummyDataStoring());
		//TODO change
		assertEquals(true, false);
	}
}