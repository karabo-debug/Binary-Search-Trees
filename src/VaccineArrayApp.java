// VaccineArrayApp to read the given csv file 
// Last Modified: 02 Mar 2022
// Lehlohonolo Mosikili

import java.io.*;
import java.util.*;

public class VaccineArrayApp
{
    VaccineArray vac = new VaccineArray();
    ArrayList<String> arrayOfResults = new ArrayList<String>(); // array to store results
    ArrayList<Integer> storeInsertOp = new ArrayList<Integer>(); // array to store insert operations
    String key, result;

    // Read the file into data structure
    public void readFromFile(){

        File f = new File("data/vaccinations.csv");
        try{
            Scanner scanner = new Scanner(f);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                vac.add(new Vaccination(line));
            }
            scanner.close();

        }catch(Exception e){
            System.out.println("File not found!");
        }
    }

    // Interactive interface
    public void userInterface(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the date:");
        String date = scan.nextLine();

        System.out.println("Enter the list of countries (end with an empty line):");
        String country = scan.nextLine();

        while(!country.equals("")){

            // Concatenate country and date to create a specific key
            key = country+","+date;

            // Search for country and date using key
            result = vac.search(new Vaccination(key));
            
            // Number of operations generated for a certain search and insert data item
            int opSearch = vac.opCountS;
            int opInsert = vac.opCountI;

            // Add results of searches into an array
            arrayOfResults.add(country+" = "+result+", "+Integer.toString(opSearch)+" search operations"+", "+Integer.toString(opInsert)+" insert operations");
            country = scan.nextLine();

            // Add insert oprations to array
            storeInsertOp.add(opInsert);

            // Set number of operations back to zero
            vac.opCountS = 0;
        }
        scan.close();
    }

    // Print out the vaccines results
    public void vaccinesResults(){
        System.out.println("Results:");
        Iterator i = arrayOfResults.iterator();

        while(i.hasNext()){
            System.out.println(i.next());
        }
    }

    /** 
     * @param args
     */
    public static void main(String[] args){
        VaccineArrayApp v = new VaccineArrayApp();
        v.readFromFile();
        v.userInterface();
        v.vaccinesResults();
    }
}