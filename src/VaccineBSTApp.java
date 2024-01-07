// Binary Search Tree
// Last Modified: 02 Mar 2022
// Lehlohonolo Mosikili

import java.io.*;
import java.util.*;

public class VaccineBSTApp
{
      BinarySearchTree<Vaccination> bt = new BinarySearchTree<Vaccination> ();
      ArrayList<String> arrayOfResults = new ArrayList<String>();
      String key, result;
      int opInsert; // Instrumentation
      

      public void readFromFile(){
            File f = new File("data/vaccinations.csv");
            try {
                  Scanner scan = new Scanner(f);
                  while(scan.hasNextLine()){
                        String line = scan.nextLine();
                        bt.insert(new Vaccination(line));
                        opInsert++;
                  }
                  scan.close();
            } catch (Exception e) {
                  System.out.println("File not found!");
            }
      }

      public void userInterface(){
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the date:");
            String date = scan.nextLine();
    
            System.out.println("Enter the list of countries (end with an empty line):");
            String country = scan.nextLine();
    
            while(!country.equals("")){
    
                // Concatenate country and date to create a specific key
                String key = country+","+date;
    
                // Search for country and date using key
                if (bt.find(new Vaccination(key))==null){
                  result = "<Not found>";
                }
                else{
                  result = bt.find(new Vaccination(key)).getObject().getVaccine();
                }

                // Number of operations generated for a certain search and insertion data item
                int opSearch = bt.opCountS;

                // Add results of searches into an array
                arrayOfResults.add(country+" = "+result+", "
                            +Integer.toString(opSearch)+" search operations"+
                           ", "+Integer.toString(opInsert)+" insert operations");
                country = scan.nextLine();

                // Set number of operations back to zero to count new operations of another country
                bt.opCountS = 0;
            }
            scan.close();
      }

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
   public static void main ( String [] args )
   {
      VaccineBSTApp bst = new VaccineBSTApp();
      bst.readFromFile();
      bst.userInterface();
      bst.vaccinesResults();
   }
}
