package Model;

import java.util.ArrayList;

public class DummyDataStoring implements IDataStoring{
	
	//class for testing purposes
	
	@Override
	public ArrayList<Food> loadData() {
		//System.out.println("Dummy Load");
		return new ArrayList<Food>();
	}

	@Override
	public void saveData(ArrayList<Food> foodList) {
		//System.out.println("Dummy Save");
	}

}
