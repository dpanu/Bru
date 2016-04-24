import java.io.*;
import java.util.*;

public class Bru {
	public static Map<String, String> values = new HashMap<String, String>();
	public static Stack<Integer> run = new Stack<Integer>();
	
	
	public static void main(String args[])throws IOException {
		String path = args[0];
		String line = null;
		Boolean condition = false;
		BufferedReader br = new BufferedReader(new FileReader(path));
		while((line = br.readLine()) != null){
			String[] command = line.split(" ");
			switch(command[0]){
				case "PUSH": run.push(Integer.parseInt(command[1]));
							 break;
				case "LOAD": run.push(Integer.parseInt(values.get(command[1])));
							 break;
				case "STORE": values.put(command[1], (run.pop()).toString());
				 			 break;
				case "ADD": run.push(run.pop() + run.pop());
							 break;
				case "MUL": run.push(run.pop() * run.pop());
							 break;
				case "SUB": run.push(run.pop() - run.pop());
						     break;
				case "DIV": run.push(run.pop() / run.pop());
					         break;
				case "PRINT": System.out.println(values.get(command[1]));
				  			  break;
				case "ME" : int a = run.pop();
							int b = run.pop();
							if(a >= b) condition = true;
							else condition = false;
							break;
				case "LE" : a = run.pop();
							b = run.pop();
							if(a <= b) condition = true;
							else condition = false;
							break;
				case "IFtrue" : //System.out.println("came IFtrue 45");
								if(!condition){
									label1: while((line = br.readLine()).equals("Go-Endifelse") == false){continue label1;}
								}	
								break;
				case "IFfalse" : //System.out.println("came IFfalse 54");
								if(condition){
									label2: while((line = br.readLine()).equals("EndIfelse") == false){continue label2;}
								}
								break;
				case "Go-Endifelse"	://System.out.println("came go end");
									break;
				case "EndIfelse" ://System.out.println("came end");
									break;
				case "\n" : break;					
				default: System.out.println("command not found");
			}	
		}
		br.close();		
}


	
	
}
