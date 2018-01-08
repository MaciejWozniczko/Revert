import java.util.*;

public class Lesson3 {
	
	double number;

	public Lesson3(double n1) {

	number = n1;

	}
	
	public static void main(String []args) {
	
	Scanner scan = new Scanner(System.in);
	System.out.println("Please enter the value");
	double question = scan.nextDouble();
	System.out.println("thank you for entering " + Math.round(question));	

	Lesson3 data = new Lesson3(question);
	
	int diff = 0;
	double buff = 0;
	int i = 1;
	double n = data.number;
	double m;

	while (data.number - buff > 0) {
	
	m = n % Math.pow(10, i);
	buff = buff + m;

	n = n - m;
	m = m / Math.pow(10, i-1);
	i++;
	System.out.print(Math.round(m));
		
	}

}

}