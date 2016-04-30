
import java.io.*;
import java.util.*;

/**
 *  This executes on runtime, this class operated on BRU intermeduate bytecode
 *  And produces output
 */
public class Bru {

    /**
     * Map variable to store the variable and there values
     */
    public static Map<String, String> values = new HashMap<String, String>();

    /**
     * Symbol table for code
     */
    public static Stack<Map<String, String>> symtab = new Stack<Map<String, String>>();

    /**
     * Operation stack or execution stack
     */
    public static Stack<String> run = new Stack<String>();

    /**
     * stack data structure maintainance
     */
    public static Map<String, Stack<Integer>> StackMap = new HashMap<String, Stack<Integer>>();

    /**
     * Store Function name
     */
    public static String funcName = "";

    /**
     * instruction pointer maintainance
     */
    public static Stack<BufferedReader> fileReaderStack = new Stack<BufferedReader>();

    /**
     * Here we have symbol table for storing values of variable in each scope
     */
    public static void printSymtab() {
        System.out.print("Current symbol table: [ ");
        for(String key : values.keySet()){
            if(values.get(key).equals("#stack#")){
                System.out.print(key + " -> " + Arrays.toString(StackMap.get(key).toArray()) + " | ");
            }
            else{
                System.out.print(key + " -> " + values.get(key) + " | ");
            }
        }
        System.out.println("end ]");
    }

    /**
     * This is the main method of execution
     * @param args Arguments passed to this include the bytecode file
     * @throws IOException Throw exception if any errors while handling code
     */
    public static void main(String args[])throws IOException {
        String path = args[0];
        Boolean psymtab = false;
        if(args.length > 1){
            if (args[1].trim().equals("-sym"))
                psymtab = true;
        }
        String line = null;
        Boolean condition = null;
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            while((line = br.readLine()).equals(".MainMethodStarts") == false);
            while((line = br.readLine()) != null){
                String[] command = line.split(" ");
                switch(command[0]){
                    case "PUSH":
                        run.push((command[1]));
                        break;
                    case "LOAD":
                        if(values.containsKey(command[1])){
                            run.push(values.get(command[1]));
                        }
                        else{
                            System.out.println("Error:Undeclared variable "+command[1]+", initialize it with some value before using it");
                            System.exit(0);
                        }
                        break;
                    case "STORE"://check for type mismatch if variable already exists
                        if (values.containsKey(command[1])) {

                            if ((values.get(command[1]).equals("true") || values.get(command[1]).equals("false")) &&
                                    (run.peek().matches("[0-9]+"))) {
                                System.out.println("Idhar se 1");
                                System.out.println("Error:Type Mismatch for variable " + command[1]);
                                System.exit(0); //runtime error

                            } else if ((values.get(command[1]).matches("[0-9]+")) && (run.peek().equals("false") || run.peek().equals("true"))) {
                                System.out.println("Idhar se 2");
                                System.out.println("Error:Type Mismatch for variable " + command[1]);
                                System.exit(0); //runtime error
                            }
                            else {

                                values.put(command[1], (run.pop()));
                                if (psymtab)
                                    printSymtab();

                            }
                        }
                        else {

                            values.put(command[1], (run.pop()));
                            if (psymtab)
                                printSymtab();

                        }
                        break;
                    case "ADD":
                        run.push(Integer.toString(Integer.parseInt(run.pop()) + Integer.parseInt(run.pop())));
                        break;
                    case "MUL":
                        run.push(Integer.toString(Integer.parseInt(run.pop()) * Integer.parseInt(run.pop())));
                        break;
                    case "SUB":
                        run.push(Integer.toString(Integer.parseInt(run.pop()) - Integer.parseInt(run.pop())));
                        break;
                    case "DIV":
                        run.push(Integer.toString(Integer.parseInt(run.pop()) / Integer.parseInt(run.pop())));
                        break;
                    case "PRINT":
                        if(command[1].charAt(0) == '\"')
                            System.out.println(line.split(" ", 2)[1].split("\"")[1]);
                        else if(!(values.containsKey(command[1])))
                            System.out.println("Error:Undeclared variable "+command[1]+", initialize it with some value before using it");
                        else
                            System.out.println(values.get(command[1]));
                        break;
                    case "ME" :
                        int a = Integer.parseInt(run.pop());
                        int b = Integer.parseInt(run.pop());
                        if(a >= b)
                            condition = true;
                        else
                            condition = false;
                        break;
                    case "LE" :
                        a = Integer.parseInt(run.pop());
                        b = Integer.parseInt(run.pop());
                        if(a <= b)
                            condition = true;
                        else
                            condition = false;
                        break;
                    case "EQ" :
                        Boolean abool, bbool;
                        if (run.peek().equals("true") || run.peek().equals("false")){
                            abool = Boolean.valueOf(run.pop());
                            bbool = Boolean.valueOf(run.pop());
                            if(abool == bbool)
                                condition = true;
                            else
                                condition = false;
                        }
                        else {
                            a = Integer.parseInt(run.pop());
                            b = Integer.parseInt(run.pop());
                            if(a == b)
                                condition = true;
                            else
                                condition = false;
                        }
                        break;
                    case "NEQ" :
                        if (run.peek().equals("true") || run.peek().equals("false")){
                            abool = Boolean.valueOf(run.pop());
                            bbool = Boolean.valueOf(run.pop());
                            if(abool != bbool)
                                condition = true;
                            else
                                condition = false;
                        }
                        else{
                            a = Integer.parseInt(run.pop());
                            b = Integer.parseInt(run.pop());
                            if(a != b)
                                condition = true;
                            else
                                condition = false;
                        }
                        break;
                    case "LESS" :
                        a = Integer.parseInt(run.pop());
                        b = Integer.parseInt(run.pop());
                        if(a < b)
                            condition = true;
                        else
                            condition = false;
                        break;
                    case "GRT" :
                        a = Integer.parseInt(run.pop());
                        b = Integer.parseInt(run.pop());
                        if(a > b)
                            condition = true;
                        else
                            condition = false;
                        break;
                    case "AND" :
                        abool = Boolean.valueOf(run.pop());
                        bbool = Boolean.valueOf(run.pop());
                        if (abool == null || bbool == null){
                            System.out.println("Error:Unassigned boolean variable, assign true or false before use");
                            System.exit(0);
                        }
                        if(abool && bbool)
                            condition = true;
                        else
                            condition = false;
                        break;
                    case "OR" :
                        abool = Boolean.valueOf(run.pop());
                        bbool = Boolean.valueOf(run.pop());
                        if (abool == null || bbool == null){
                            System.out.println("Error:Unassigned boolean variable, assign true or false before use");
                            System.exit(0);
                        }
                        if(abool && bbool)
                            condition = true;
                        else
                            condition = false;
                        break;
                    case "IFtrue" :
                        run.push(Boolean.toString(condition));
                        if(!Boolean.parseBoolean(run.peek())){
                            while((line = br.readLine()).equals("Go-Endifelse "+command[1]) == false);
                        }
                        break;
                    case "IFfalse" :
                        if(Boolean.parseBoolean(run.peek())){
                            while((line = br.readLine()).equals("EndIfelse "+command[1]) == false);
                            run.pop();
                        }
                        break;
                    case "Go-Endifelse":
                        break;
                    case "EndIfelse" : run.pop();
                        break;
                    case "WStart" :
                        break;
                    case "Whiletrue":
                        if(!condition){
                            while((line = br.readLine()).equals("WEnd "+command[1]) == false);
                        }
                        break;
                    case "WEnd" :
                        break;
                    case "Go-WStart":
                        br.close();
                        br = new BufferedReader(new FileReader(path));
                        while((line = br.readLine()).equals("WStart "+command[1]) == false);
                        break;
                    case "STKDEC":
                        try {
                            if (values.containsKey(command[1])){
                                System.out.println("Error:Stack already been declared");
                            }
                            else {
                                StackMap.put(command[1], new Stack<Integer>());
                                values.put(command[1], "#stack#");
                                if(psymtab)
                                    printSymtab();
                            }
                            break;
                        }
                        catch(Exception e) {
                            System.out.println("Stack declaration error:" + e);
                            break;
                        }
                    case "STORESTK":
                        try {
                            StackMap.get(command[1]).push(Integer.parseInt(run.pop()));
                            if(psymtab)
                                printSymtab();
                            break;
                        }
                        catch(Exception e) {
                            System.out.println("Stack error:" + e);
                            break;
                        }
                    case "STKPEEK":
                        try {
                            run.push(Integer.toString(StackMap.get(command[1]).peek()));
                            break;
                        }
                        catch(Exception e) {
                            System.out.println("Stack error:" + e);
                            break;
                        }
                    case "STKPOP":
                        try {
                            StackMap.get(command[1]).pop();
                            if(psymtab)
                                printSymtab();
                            break;
                        }
                        catch(Exception e) {
                            System.out.println("Stack error:" + e);
                            break;
                        }
                    case "STKEMPTY"  :
                        try {
                            if(StackMap.get(command[1]).empty())
                            run.push("true");
                            else run.push("false");
                            break;
                        }
                        catch(Exception e) {
                            System.out.println("Stack error:" + e);
                            break;
                        }
                    case "FuncCall":
                        funcName = command[1];
                        while((line = br.readLine()).equals("FuncCall Ends") == false){
                            command = line.split(" ");
                            switch(command[0]){
                                case "PUSH": 	run.push((command[1]));
                                    break;
                                case "LOAD":
                                    if(values.containsKey(command[1])){
                                        run.push(values.get(command[1]));
                                    }
                                    else{
                                        System.out.println("Error: Undeclared variable "+command[1]+", initialize it with some value before using.");
                                    }
                                    break;
                                default: ;
                            } // End of inner switch series inside the while loop
                        } //End of while
                        //push current function symbol table to stack
                        symtab.push(new HashMap<String,String>(values));
                        //push file reader to stack
                        fileReaderStack.push(new BufferedReader(br));
                        //define new symbol table
                        values = new HashMap<String,String>();
                        if(psymtab){
                            System.out.println("Entering Function " + funcName);
                            printSymtab();
                        }
                        //start searching for function
                        br = new BufferedReader(new FileReader(path));
                        try{
                            while((line = br.readLine()).equals("FuncDef "+funcName) == false);
                        }
                        catch(Exception e){
                            System.out.println("Error:Function " + funcName + "not found. Define function before calling");
                            System.exit(0);
                        }
                        while((line = br.readLine()).equals(".funcBodyStarts "+funcName) == false){
                            command = line.split(" ");
                            switch(command[0]){
                                case "STORE"://check for type mismatch if variable already exists
                                    if (values.containsKey(command[1])) {

                                        if ((values.get(command[1]).equals("true") || values.get(command[1]).equals("false")) && (!run.peek().equals("false") || !run.peek().equals("true"))) {

                                            System.out.println("Error:Type Mismatch for variable " + command[1]);
                                            System.exit(0); //runtime error

                                        } else if ((values.get(command[1]).matches("[0-9]+")) && (run.peek().equals("false") || run.peek().equals("true"))) {

                                            System.out.println("Error:Type Mismatch for variable " + command[1]);
                                            System.exit(0); //runtime error
                                        }
                                        else {

                                            values.put(command[1], (run.pop()));
                                            if (psymtab)
                                                printSymtab();

                                        }
                                    }
                                    else {

                                        values.put(command[1], (run.pop()));
                                        if (psymtab)
                                            printSymtab();

                                    }
                                    break;
                                default: 	;//System.out.println("Not able to identify the argument passed to function " + command[0]);
                            } // End of inner switch series inside the while loop
                        }//end of while
                        break;

                    case ".funcbodyends" : //return to previous functions' symbol table, current function scope ends
                        for (String var : values.keySet()){
                            if(values.get(var).equals("#stack#"))
                                StackMap.remove(var);
                        }
                        values = symtab.pop();
                        if(psymtab)
                            if(psymtab){
                                System.out.println("Exiting Function " + funcName);
                                printSymtab();
                            }
                        //return to instruction pointer
                        br.close();
                        br = fileReaderStack.pop();
                        break;
                    case ".MainMethodEnds":
                        values.clear();
                        break;
                    case "" :
                        break;
                    default:
                        System.out.println("Error: runtime command not found " + command[0]); //System.exit(0);
                }
            }
            br.close();
        }//end of try
        catch(Exception e){
            System.out.println("Error:" + e);
        }

    }//end of main

}//end of class
