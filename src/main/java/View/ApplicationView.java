package View;

import Controller.Controller;
import Controller.IController;
import Model.DummyDataStoring;

public class ApplicationView {

	private IController controller;
	private ITable table;
	
	
	
	public static void main(String[] args) {
		
		ApplicationView view = new ApplicationView(new Controller(new DummyDataStoring()));
		
		view.startApplication();	
	}
	
	public ApplicationView(IController controller) {
		this.controller = controller;
		table = new ConsoleTable(controller);
	}

	private void startApplication() {

		boolean isRunning = false;
		printMenu();
		int choice = 1; // set to ;

		
		while(isRunning){
			//user choice
			switch(choice) {
				case 0 -> isRunning = false;
			    case 1 -> printTable();
			    case 2 -> addProduct();
			    case 3 -> removeProduct();
			    case 4 -> removeAll();
			};
		}
		
	}


	
	private void addProduct() {
		String name;
		String brand;
		int price;
		int quantity;
		int mass;
		
		//user input which products to add
		//check
		
		printAddProductMenu();

		
		int userInput = 0;
		
		if(userInput == 0) {
			return;
		}
		else if(userInput == 1) {
			controller.addFood("name", "brand", 100);
		}
		else if(userInput == 2) {
			controller.addFoodWithMass("name", "brand", 100, 100, "g");
		}
		else if(userInput == 3) {
			controller.addFoodWithQuantity("name", "brand", 100, 5);
		}
		else {
			System.out.println("bad input");
		}
		
	}

	private void removeProduct() {
		printRemoveProductMenu();
		
		if (controller.removeFood(getIntInput())) {
			System.out.println("item has been removed");
		}
		else {
			System.out.println("item not found");
		}
	}

	private void removeAll() {
		controller.removeAll();
		System.out.println("all items have been removed");
	}
	
	
	private void printTable() {
		table.printTable();
		printTabletMenu();
	}
	
	private int getIntInput() {
	return 0;
	}
	
	private String getStringInput(){
	return "";
	}
	
	
	
	private void printMenu() {
		System.out.println(	  "Press [0] to quit the application"	+"\n"
							+ "Press [1] to view products"			+"\n"
							+ "Press [2] to add a products"			+"\n"
							+ "Press [3] to remove a product"		+"\n"
							+ "Press [4] to remove all products"	+"\n");		
	}
	
	private void printAddProductMenu() {
		System.out.println(	  "Press [0] to back"						+"\n"
							+ "Press [1] to add product"				+"\n"
							+ "Press [2] to add product with mass"		+"\n"
							+ "Press [3] to add product with quanity"	+"\n"
							+ "Press [4] to remove all products"		+"\n");	
	}
	
	private void printRemoveProductMenu() {
		System.out.println(	  "Press [0] to back"				+"\n"
							+ "Enter Product # to remove it"	+"\n");
	}
	
	private void printTabletMenu() {
		System.out.println("Press [1] to go back to menu"	+"\n");
	}
	
	private void printWhiteSpace() {
		String whiteSpace = "\n";
		System.out.print(whiteSpace.repeat(30));
	}
	
}
