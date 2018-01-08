import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;


public class RevertGui extends JFrame implements ActionListener 
{
	JButton bInvert, bShowLog;
	JTextField tNum;
	Config currentConfiguration;

	
	public RevertGui()
	{
		currentConfiguration = new Config();
		currentConfiguration.readConfiguration();
		
		setLayout(null);
		setSize(600,400);
		setTitle("Revert");
		
		bInvert = new JButton("Invert the number!");
		bInvert.setBounds(20,120,150,30);
		bInvert.addActionListener(this);
		add(bInvert);
		
		bShowLog = new JButton("Show logs");
		bShowLog.setBounds(200,120,150,30);
		bShowLog.addActionListener(this);
		add(bShowLog);
		
		tNum = new JTextField("");
		tNum.setBounds(20,40,150,30);
		add(tNum);
		
	
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Object signalSource = e.getSource();
		
		if(signalSource == bInvert)
		{
			Scanner sc = new Scanner(tNum.getText());
			
			if(!sc.hasNextInt())
			{
				//JFrame frame = new JFrame();
				//frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				JOptionPane.showMessageDialog(this, "Wrong data. Apply RTFM rule!");
			
			}else
			{
			
			Number forInversion = new Number(Integer.parseInt(tNum.getText()));
			forInversion.invert();
			//forInversion.save("E, yyyy.MM.dd HH:mm:ss");
			forInversion.save(currentConfiguration);
			
			}
		}
		
		
		else if(signalSource == bShowLog)
		{
			RevertLog wLogs = new RevertLog();
			wLogs.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			wLogs.setVisible(true);
		}
	}
	
	public static void main(String []args) {
	
			
		RevertGui mainWindow = new RevertGui();
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setVisible(true);
	
	}
	
	
}



