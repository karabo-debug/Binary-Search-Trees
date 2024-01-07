/* Vaccination class which implements Comparable class to use the compareTo method
   to match the country and date found in the dataset.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Vaccination implements Comparable<Vaccination>{
    String country;
    String date;
    String numOfVaccines;
    
    public Vaccination(){}
    
    public Vaccination(String line){
    
        // Format country, date, vaccine
        String[] portions = line.split(",");
        country = portions[0];
        date = portions[1];
        
        if(portions.length == 3)
            numOfVaccines = portions[2];
        else
            numOfVaccines = "0";
    }
    
    
    /** 
     * @param v
     * @return int
     */
    // Compares two objects
    public int compareTo(Vaccination v){
        return (country+","+date).compareTo(v.country+","+v.date);
    }
    
    // Finds number of lines in the file
    public int readLines(){
        int lines = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data/vaccinations.csv"));
            while(reader.readLine() != null){
                lines++;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return lines;

    }
    /** 
     * @return String
     */
    public String getCountry(){
        return country;
    }
    
    
    /** 
     * @return String
     */
    public String getDate(){
        return date;
    }
    
    
    /** 
     * @return String
     */
    public String getVaccine(){
        return numOfVaccines;
    } 
    
    
    /** 
     * @return String
     */
    public String toString(){
        return country+","+date;
    }
    
    
    /** 
     * @return String
     */
    public String results(){
        return country+" = "+numOfVaccines;
    }
}