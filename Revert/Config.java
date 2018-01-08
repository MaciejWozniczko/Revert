import java.nio.charset.Charset;
//import java.nio.file.Files;
//import java.nio.file.Path;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Config {

	String dateFormat;
	String outputDirectory;
	
	
	public void readConfiguration() {
	
	File fConfig = new File("./Configuration/Config.txt");
	BufferedReader br = null;
	FileReader fr = null;
	
	
	try {
		fr = new FileReader(fConfig);
		br = new BufferedReader(fr);
		
		
		String currentLine;
		List<String> settings = new ArrayList<String>();
		
		while((currentLine = br.readLine()) != null) {
			
			settings.add(currentLine);
		}
		
	
	Pattern patt = Pattern.compile("\\[(.*?)\\]");
	
	for(int j = 0; j < settings.size(); j++) {
	
	Matcher param = patt.matcher(settings.get(j));
	
	if(param.find( )){
	settings.set(j, param.group(1));
	}
	}
	
	dateFormat = settings.get(0);
	outputDirectory = settings.get(1);
	
	/*wersja matcher
	Path loc = Paths.get("C:/Users/Maciej/Documents/Java_nauka/Revert","config.txt");
	List<String> conf = Files.readAllLines(loc, Charset.defaultCharset());
	
	Pattern patt = Pattern.compile("\\[(.*?)\\]");
	
	Matcher param = patt.matcher(conf.get(0));
	
	
	if(param.find( )){
	System.out.println(param.group(0));
	}
	*/
	/*wersja split
	
	List<String> conf = Files.readAllLines(loc, Charset.defaultCharset());
	String[] divided1 = conf.get(0).split("=");
	String[] divided2 = conf.get(1).split("=");
	
	dateFormat = divided1[1];
	outputDirectory = divided2[1];
	*/
	
	}catch (IOException e) {
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
	
	
	/*
public static void main(String[] args) {
		
		Config cnf = new Config();
		cnf.readConfiguration();
		System.out.println(cnf.dateFormat);
		System.out.println(cnf.outputDirectory);
		
		
	}
	*/
	
	
	}
	
