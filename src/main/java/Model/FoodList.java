package Model;

import java.util.ArrayList;
import java.util.stream.Collectors;


public class FoodList implements IFoodList{
	
	//TODO create unit tests from main
	public static void main(String[] args) {
		FoodList f = new FoodList(new DummyDataStoring());
		f.addFood("name", "name", 2312);
		f.addFood("name", "name", 2312);
		System.out.println(f.checkIfFoodExists(0));
		System.out.println(f.getFood(0).toString());
		if(f.checkIfFoodExists(1)) {
			System.out.println(f.checkIfFoodExists(1));
			System.out.println(f.getFood(1).toString());			
		}
		System.out.println(f.checkIfFoodExists(2));
	}
	
	private final String[] collumnNames = {"Name","Brand","Price","Exact Price"};
	
	private ArrayList<Food> foodList;
	private IDataStoring dataStoring;
	
	public FoodList(IDataStoring dataStoring) {
		this.dataStoring = dataStoring;
		foodList = dataStoring.loadData();
	}

	@Override
	public String[] getCollumnNames() {
		return collumnNames; 
	}

	@Override
	public ArrayList<Food> getFoodList() {
		return new ArrayList<>(foodList);
	}
	

	
	@Override
	public void addFood(String name, String brand,int price) {
		foodList.add(new Food(name,brand,price,new ExactPriceNotApplicable()));
		sortAndStoreFoodList();
	}
	
	@Override
	public void addFoodWithQuantity(String name, String brand, int price, int quantity) {
		foodList.add(new Food(name,brand,price,new ExactPriceFromQuantity(quantity)));
		sortAndStoreFoodList();
		
	}
	
	@Override
	public void addFoodWithMass(String name, String brand, int price, int mass, String measurementUnit) {
		foodList.add(new Food(name,brand,price,new ExactPriceFromMass(mass, measurementUnit)));
		sortAndStoreFoodList();
		
	}

	@Override
	public void removeFood(int index) {
		foodList.remove(index);
		if(!checkIfFoodExists(index)) {
			System.out.println("index doesn't exist");
			return;
		}
		foodList.remove(index);
		dataStoring.saveData(foodList);
	}

	@Override
	public void removeAll() {
		foodList = new ArrayList<>();
		dataStoring.saveData(foodList);
	}
	
	@Override
	public boolean checkIfFoodExists(int index) {
		return index >= 0 && index < foodList.size();
	}
	
	@Override
	public String getFood(int index) {
		if(!checkIfFoodExists(index)) {
			System.out.println("index doesn't exist");
			return "";
		}
		return foodList.get(index).toString();
	}
	
	
	public ArrayList<Food> sortList() {
		return foodList.stream()
				.sorted((e,e2) -> e.getName().compareTo(e2.getName()))
				.collect(Collectors.toCollection(ArrayList::new));
	}
	
	public void sortAndStoreFoodList() {
		foodList = sortList();
		dataStoring.saveData(foodList);
	}
	
}