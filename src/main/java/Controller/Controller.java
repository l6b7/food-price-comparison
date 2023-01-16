package Controller;

import java.util.Arrays;
import java.util.Iterator;

import Model.FoodList;
import Model.IDataStoring;
import Model.IFoodList;

public class Controller implements IController{

	private IFoodList foodList;
	
	public Controller(IDataStoring dataStoring) {
		foodList = new FoodList(dataStoring);
	}

	
	
	@Override
	public String[] getTableCollumns() {
		String[] collumnTitles = foodList.getCollumnNames();
		String[] collumnTitlesWithID = new String[collumnTitles.length+1];
		
		collumnTitlesWithID[0] = "#";
		
		for (int i = 0; i < collumnTitles.length; i++) {
			collumnTitlesWithID[i+1] = collumnTitles[i];
		}
		
	    return collumnTitlesWithID;
	}

	@Override
	public String[][] getTableContent() {
		if(foodList.getFoodList().isEmpty()) {
			return new String[0][0];
		}
		
		int y = foodList.getFoodList().size();
		int x = getTableCollumns().length;
		
		String[][] tableContent = new String[y][x];
		
		for (int i = 0; i < y; i++) {
			tableContent[i][0] = Integer.toString(i+1);
			tableContent[i][1] = foodList.getFoodList().get(i).getName();
			tableContent[i][2] = foodList.getFoodList().get(i).getBrand();
			tableContent[i][3] = foodList.getFoodList().get(i).getPrice();
			tableContent[i][4] = foodList.getFoodList().get(i).getExactPrice();
		}
		
		return tableContent;
	}

	@Override
	public void addFood(String name, String brand, int price) {
		foodList.addFood(name, brand, price);
		
	}
	
	@Override
	public void addFoodWithQuantity(String name, String brand, int price, int quantity) {
		foodList.addFoodWithQuantity(name, brand, price, quantity);
		
	}
	
	@Override
	public void addFoodWithMass(String name, String brand, int price, int mass, String measurementUnit) {
		foodList.addFoodWithMass(name, brand, price, mass, measurementUnit);
		
	}

	@Override
	public boolean removeFood(int index) {
		return foodList.removeFood(index);
	}


	
	@Override
	public void removeAll() {
		foodList.removeAll();
		
	}



}
