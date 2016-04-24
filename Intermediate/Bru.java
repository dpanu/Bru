import java.io.*;
import java.util.*;

public class Bru {
	//current symbol table
	public static Map<String, String> values = new HashMap<String, String>();
	//stack for symbol table
	public static Stack<Map<String, String>> symtab = new Stack<Map<String, String>>();
	//execution stack
	public static Stack<Integer> run = new Stack<Integer>(); //string
	
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
							label1: while((line = br.readLine()).equals("Go-Endifelse") == false){continue label1;}
						}	
						break;
				case "IFfalse" : if(condition){
							label2: while((line = br.readLine()).equals("EndIfelse") == false){continue label2;}
						}
						break;
				case "Go-Endifelse": break;
				case "EndIfelse" :break;
				case "WStart" : whilelabel = command[1];
						break;
				case "Whiletrue" : if(!condition){
							label3: while((line = br.readLine()).equals("WEnd") == false){continue label3;}
						}
						break;
				case "Go-WStart": br.close();
						br = new BufferedReader(new FileReader(path));
						label4: while((line = br.readLine()).equals("WStart "+whilelabel) == false){continue label4;}
						break;
				case "RETURN" : values = symtab.pop();
						break;
				case "" : 	break;				
				default: 	System.out.println("command not found " + command[0]); System.exit(0);
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
