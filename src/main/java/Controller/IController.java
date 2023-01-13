package Controller;

public interface IController {
	
	public String[] getTableCollumns();
	public String[][] getTableContent();
	
	public void addFood(String name, String brand, int price);
	public void addFoodWithQuantity(String name, String brand,int price,int quantity);
	public void addFoodWithMass(String name, String brand,int price,int mass, String measurementUnit);
	public boolean removeFood(int index);
	public void removeAll();
	
}
