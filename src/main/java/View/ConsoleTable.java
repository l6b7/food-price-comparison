package View;

public class ConsoleTable implements ITable{
	
	public static void main(String[] args) {
		
		ConsoleTable table;
		table = SampleTable();
		
		
		
		
		
		
		
		table.printTable(table);
		
	}
	
	//x >  arr[?].length  <--->
	//y ^  arr.length  ^v
	//[y][x]
	
	
	public static  ConsoleTable SampleTable() {
	
	String[] c =	 {"First","Second","Third"};
	
	String[][] r = {{"[0][0]","[0][1]","[0][2]"},
			
					{"[1][0]","[1][1]","[1][2]"},
					
					{"[2][0]","[2][1]","[2][2]"},
					
					{"[3][0]","[3][1]","[3][2]"}};
	
	return new ConsoleTable(c,r);
	}
	
	
	
	
	
	
	private String[] collumnNames;
	private String[][] rows;
	
	
	
	
	public ConsoleTable(String[] collumnNames, String[][] rows){
		this.collumnNames = collumnNames;
		this.rows = rows;
	}
	
	
	
	
	
	@Override
	public void printTable(ITable table) {
		
		for (String values : collumnNames) {
			System.out.print(values + "  ");
		}
		
		System.out.println();
		
		for (int i = 0; i < rows.length; i++) {
			for (int j = 0; j < rows[i].length; j++) {
				System.out.print(rows[i][j] + " ");
				
				
			}
			System.out.println();
		}
		
		
		
	}
}
