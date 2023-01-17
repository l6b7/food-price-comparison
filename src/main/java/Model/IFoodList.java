package Model;

import java.util.ArrayList;

public interface IFoodList {
	public String[] getCollumnNames();
	public ArrayList<Food> getFoodList();
	
	public void addFood(String name, String brand,int price);
	public void addFoodWithQuantity(String name, String brand,int price,int quantity);
	public void addFoodWithMass(String name, String brand,int price,int mass, String measurementUnit);
	public void removeFood(int index);
	public void removeAll();
	public String getFood(int index);
	public boolean checkIfFoodExists(int index);
}
