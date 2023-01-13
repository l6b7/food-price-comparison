package Model;

import java.util.ArrayList;
import java.util.stream.Collectors;


public class FoodList implements IFoodList{
	
	
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
	public boolean removeFood(int index) {
		if(index > foodList.size()-1) {
			return false;
		}
		else {
			foodList.remove(index);
			dataStoring.saveData(foodList);
			return true;
		}
	}

	@Override
	public void removeAll() {
		foodList = new ArrayList<>();
		dataStoring.saveData(foodList);
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