import java.io.*;
import java.util.*;

public class Bru {
	//current symbol table
	public static Map<String, String> values = new HashMap<String, String>();
	//stack for symbol table
	public static Stack<Map<String, String>> symtab = new Stack<Map<String, String>>();
	//execution stack
	public static Stack<Integer> run = new Stack<Integer>(); //string
	
	public static Map<String, Stack<Map<String, String>>> funcMasterTable= new HashMap<String, Stack<Map<String, String>>>();
	public static String funcName;
	
	
	public static void main(String args[])throws IOException {
		String path = args[0];
		String line = null;
		Boolean condition = null;
		String whilelabel = "";
		BufferedReader br = new BufferedReader(new FileReader(path));
		while((line = br.readLine()) != null){
			String[] command = line.split(" ");
			switch(command[0]){
				case "PUSH": 	run.push(Integer.parseInt(command[1]));
					     	break;
				case "LOAD": 	run.push(Integer.parseInt(values.get(command[1])));
					     	break;
				case "STORE": //CHECK FOROVERRITE
					      	values.put(command[1], (run.pop()).toString());
				 	      	break;
				case "ADD": 	run.push(run.pop() + run.pop());
					    	break;
				case "MUL": 	run.push(run.pop() * run.pop());
					    	break;
				case "SUB": 	run.push(run.pop() - run.pop());
				     	    	break;
				case "DIV": 	run.push(run.pop() / run.pop());
					    	break;
				case "PRINT": 	System.out.println(values.get(command[1]));
				  	      	break;
				case "ME" : 	int a = run.pop();
					    	int b = run.pop();
					    	if(a >= b) condition = true;
					    	else condition = false;
					    	break;
				case "LE" : 	a = run.pop();
					    	b = run.pop();
					    	if(a <= b) condition = true;
					    	else condition = false;
						break;
				case "EQ" : 	a = run.pop();
						b = run.pop();
						if(a == b) condition = true;
						else condition = false;
						break;
				case "NEQ" : 	a = run.pop();
						b = run.pop();
						if(a != b) condition = true;
						else condition = false;
						break;
				case "LESS" : 	a = run.pop();
						b = run.pop();
						if(a < b) condition = true;
						else condition = false;
						break;	
				case "GRT" : 	a = run.pop();
						b = run.pop();
						if(a > b) condition = true;
						else condition = false;
						break;
				case "LAND" : 	Boolean abool = converttobool(run.pop());
						Boolean bbool = converttobool(run.pop());
						if (abool == null || bbool == null)System.exit(0); //error to be done
						if(abool && bbool) condition = true;
						else condition = false;
						break;
				case "LOR" : abool = converttobool(run.pop());
						bbool = converttobool(run.pop());
						if (abool == null || bbool == null)System.exit(0); //error to be done
						if(abool && bbool) condition = true;
						else condition = false;
						break;
				case "IFtrue" : if(!condition){
							while((line = br.readLine()).equals("Go-Endifelse") == false);  //Semi-Colon used to skip and avoid labeling
						}	
						break;
				case "IFfalse" : if(condition){
							while((line = br.readLine()).equals("EndIfelse") == false);  //Semi-Colon used to skip labeling and avoid labeling
						}
						break;
				case "Go-Endifelse": break;
				case "EndIfelse" :break;
				case "WStart" : whilelabel = command[1];
						break;
				case "Whiletrue" : if(!condition){
							while((line = br.readLine()).equals("WEnd") == false);
						}
						break;
				case "Go-WStart": br.close();
						br = new BufferedReader(new FileReader(path));
						while((line = br.readLine()).equals("WStart "+whilelabel) == false);
						break;
				case "FuncCall":
								System.out.println("Calling functinon "+command[1]);
								funcName = command[1];
								System.out.println(funcName);
								while((line = br.readLine()).equals("FuncCall Ends") == false){
								System.out.println(line);
								command = line.split(" ");
								switch(command[0]){
									case "PUSH": 	run.push(Integer.parseInt(command[1]));
										break;
									case "LOAD": 	
										if(values.containsKey(command[1])){
											String value = values.get(command[1]);
											run.push(Integer.parseInt(value));
										}
										else{
											System.out.println("Undeclared variable "+command[1]+", initialize it with some value before passing it to function");
										}
										break;
									default: 	System.out.println("Not able to identify the argument passed to function " + command[0]);
								  } // End of inner switch series inside the while loop
								} //End of while
								System.out.println(run.pop());
								System.out.println(run.pop());
								//break;
				case "FuncDef":
								br = new BufferedReader(new FileReader(path));
								while((line = br.readLine()).equals("FuncDef "+funcName) == false); //Semi-Colon used to skip labeling, shortcut method
								System.out.println("Found "+line);
								break;
				case ".func":
								break;
				case "RETURN" : values = symtab.pop();
						break;
				case "" : 	break;				
				default: 	System.out.println("command not found " + command[0]); //System.exit(0);
			}	
		}
		br.close();		
}
	public static Boolean converttobool(int i){
		if(i == 1)return true;
		else if(i == 0) return false;
		else return null;
	}
}
