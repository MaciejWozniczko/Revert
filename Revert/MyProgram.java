import java.util.*;

public class MyProgram {

	public static void main(String []args) {
	
	Config currentConfiguration = new Config();
	currentConfiguration.readConfiguration();
	
	char toContinue = 'a';
	
	do {
	
	Scanner scan = new Scanner(System.in);
	System.out.println("Please enter the value");
	int question = scan.nextInt();
	System.out.println("thank you for entering " + Math.round(question));
	System.out.println(" ");
	
	Number forInversion = new Number(question);
	
	forInversion.invert();
	
	forInversion.printingOut();

	forInversion.save(currentConfiguration.dateFormat);
	
	Scanner scanForCharacter = new Scanner(System.in);
	System.out.println("If you would like to quit please type in q. If you wish to continue type in any other character");
	toContinue = scanForCharacter.next().charAt(0);
	
	} while(toContinue != 'q');
	
	System.out.println("Have a nice day!");
	}

}

