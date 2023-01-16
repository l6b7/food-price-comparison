package View;

import java.util.Formatter;

import Controller.Controller;
import Controller.IController;
import Model.DummyDataStoring;

public class ConsoleTable implements ITable{
	
	private IController controller;
	


	public static void main(String[] args) {
		
		ConsoleTable c = new ConsoleTable(new Controller(new DummyDataStoring()));
		
		c.controller.addFood("BBB", "brand", 1000);
		c.controller.addFood("AAA", "brandbrand", 2000);
		c.controller.addFood("FFF", "brand", 3000);
		c.controller.addFood("KKK", "brand", 4000000);
		c.controller.addFood("AAA", "brand", 5000);
		c.controller.addFood("ZZZZZZZZZ", "brand", 6000);
		c.controller.addFood("AAA", "brandbrand", 2000);
		c.controller.addFood("FFF", "brand", 3000);
		c.controller.addFood("KKK", "brand", 4000000);
		c.controller.addFood("AAA", "brand", 5000);
		c.controller.addFood("ZZZZZZZZZ", "brand", 6000);

		
		c.printTable();
	}
	
	
	
	
	public ConsoleTable(IController controller) {
		this.controller = controller;
	}
	
	@Override
	public void printTable() {
		Formatter formatter = new Formatter();
		String[][] tableContent = controller.getTableContent();
		String[] titles = controller.getTableCollumns();
		
		
		int[] maxWidths = calcualteMaxWidth(titles,tableContent);
		
		String rowFormat = createRowFormat(maxWidths);
		String horizontalLine = createLine(maxWidths);
		
		formatter.format(horizontalLine);
		formatter.format(rowFormat,(Object[]) titles);
		formatter.format(horizontalLine);
		
		for (int i = 0; i < tableContent.length; i++) {
			formatter.format(rowFormat,(Object[]) tableContent[i]);
		}
		
		formatter.format(horizontalLine);
		
		System.out.println(formatter);
		formatter.close();
			
	}

	
	public static int[] calcualteMaxWidth(String[] titles, String[][] tableContent) {
		
		int[] maxWidths = new int[titles.length];
		
		for (int i = 0; i < maxWidths.length; i++) {
			maxWidths[i] = titles[i].length();
		}

		for (int i = 0; i < tableContent.length; i++) {
			for (int j = 0; j < tableContent[i].length; j++) {
				
				if(maxWidths[j] < tableContent[i][j].length()) {
					maxWidths[j] = tableContent[i][j].length();
					
				}
			}
		}
		
		return maxWidths;
	}
	
	
	public static String createLine(int[] maxWidths) {
		String line = "+";
		for (int i = 0; i < maxWidths.length; i++) {
			line = line + "-".repeat(maxWidths[i]) + "+";
		}
		return line+"\n";
	}
	
	
	
	public static String createRowFormat(int[] maxWidths) {
		String nameSpace = "|";
		for (int i = 0; i < maxWidths.length; i++) {

			nameSpace += "%-" + (maxWidths[i]) + "s|";
		}
		return nameSpace+"\n";
	}


	
	
}
