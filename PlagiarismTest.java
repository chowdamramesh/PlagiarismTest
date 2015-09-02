import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Scanner;

class Plagiarism {

	public List<String> getAllWords (String obtained,String token) {
		StringTokenizer str = new StringTokenizer(obtained,token);
		List<String> compare = new ArrayList<String>();
		String temp = "";
	   	while(str.hasMoreTokens()){
	   	temp = str.nextToken();
	   	compare.add(temp);
	   	}
	   	return compare;
	}
	public void computeAndDisplay (List<String> one , List<String> two) {
		int match = 0;
	    for (int i = 0; i < one.size(); i ++) {
	    	for (int j =0; j < two.size(); j++) {
	    		if((one.get(i)).equals((two.get(j)))) {
	    		match++;
	    		break;
	    		}
	    	}
	    }
	    display(match,one.size());
	}

	public void display(int matched , int total) {
		int percent = 0 ;
		percent = (matched * 100) / total ;
		System.out.println(percent);
	}
}

class FileRead {
	
	public String readFromFile(String fileName) {
		BufferedReader read = null;
	    String givenText = "";
	    try {
	    	String allTextFromfile = "";
	      	read = new BufferedReader(new FileReader(fileName));
	      	while ((allTextFromfile = read.readLine()) != null) {
	        givenText += allTextFromfile;
	    	}
	    	read.close();
	  	} catch (IOException e) {
	      e.printStackTrace();
	    }
		return givenText;
	}
	
}

public class PlagiarismTest {
	public static void main(String[] args) {
		
		FileRead read1 = new FileRead();

		String obtained1 = read1.readFromFile("one.txt");
		String obtained2 = read1.readFromFile("two.txt");

		Plagiarism first = new Plagiarism();

		List<String> one = first.getAllWords(obtained1," ");
		System.out.println(one);

	    System.out.println("-------------------------");
	    List<String> two = first.getAllWords(obtained2," ");
	    System.out.println(two);

	    first.computeAndDisplay(one,two);
	}
} 