package Model;

import java.util.ArrayList;

public class DataStoringWithJSON implements IDataStoring {

	@Override
	public ArrayList<Food> loadData() {
		if("something".equals("somethingelse")) {
			//(could find data) -> load it
			return new ArrayList<Food>();
		}
		else {
			return new ArrayList<Food>();
		}

		
	}

	@Override
	public void saveData(ArrayList<Food> foodList) {
		System.out.println("saving");
		
	}

}
