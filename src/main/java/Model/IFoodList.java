package Model;

import java.util.ArrayList;

public interface IFoodList {
	public String[] getCollumnNames();
	public ArrayList<Food> getFoodList();
	
	public void addFood(String name, String brand,int price);
	public void addFoodWithQuantity(String name, String brand,int price,int quantity);
	public void addFoodWithMass(String name, String brand,int price,int mass, String measurementUnit);
	public boolean removeFood(int index);
	public void removeAll();
}
