import java.util.*;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.text.*;

public class Number {
	
	int number;
	
	ArrayList<Integer> inverted = new ArrayList<Integer>();

	public Number(int n1) {

	number = n1;
	}
	public void invert() {
		
		int buff = 0;
		int i = 1;
		int m;
		int n = this.number;
	
		while (this.number - buff > 0) {
	
		m = n % (int)Math.pow(10, i);
		buff = buff + m;

		n = n - m;
		m = m / (int)Math.pow(10, i-1);
		i++;
		//System.out.print(Math.round(m));
		this.inverted.add(m);
		
		}	
		
	}	
	

	public void printingOut() {
	
		System.out.println("Number is: " + this.number);
		System.out.print("Inverted number is: ");
		for(int i = 0 ; i < this.inverted.size(); i++) {
			System.out.print(this.inverted.get(i));
		}
		System.out.println("");
			
	}	
	
	public void save(Config currentC) {
		
		try {
		//File output = new File("./Logs/Log.txt");
		File output = new File(currentC.outputDirectory);
		FileWriter writer = new FileWriter(output, true);
		
		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat(currentC.dateFormat);
		
		writer.write("At " + ft.format(date) + " number for inversion was " );
		
		Integer temp = this.number;
		String changeType = temp.toString();
		writer.write(changeType + ". Inverted number is ");
		
		for(int j = 0 ; j < this.inverted.size(); j++) {
			changeType = this.inverted.get(j).toString();
			writer.write(changeType);
		}
		writer.write(System.getProperty("line.separator"));
		writer.close();
		
		
		}catch (IOException e) {
		System.out.println("e");
		}

		}
}	
	