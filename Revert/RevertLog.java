import java.util.*;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
import javax.swing.JFrame;
//import javax.swing.JButton;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class RevertLog extends JFrame
{
	JLabel lLine;
	JScrollPane fieldText;
	JTextArea field;

	
	public RevertLog()            //okienko z wyswietlonymi logami
	{
		setLayout(null);
		
		setSize(700,300);
		setTitle("Logs of Revert");
		
		field = new JTextArea();
		fieldText = new JScrollPane(field);
		fieldText.setBounds(5,5,690,290);
		add(fieldText);	
		
		
		
		//odczyt z pliku log.txt
			File fConfig = new File("./Logs/Log.txt");
			FileReader fr = null;
			BufferedReader br = null;
			
			
			try {
			fr = new FileReader(fConfig);
			br = new BufferedReader(fr);
		
			int i = 1;
			String currentLine;
		
		while((currentLine = br.readLine()) != null) {
			/*
			lLine = new JLabel(currentLine);
			lLine.setBounds(20,i*20,660,20);
			lLine.setFont(new Font("Dialog", Font.ITALIC, 10));
			add(lLine);
			i++;*/
			field.append(currentLine + "\n");
		}
		}
		catch (IOException e) {
      System.out.println(e);
    }finally {

			try {
				if (br != null)
					br.close();
				
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

}	
	
}	