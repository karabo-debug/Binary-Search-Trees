// Last modified: 02 Mar 2022
// Lehlohonolo Mosikili

public class VaccineArray{

    Vaccination len = new Vaccination(); 
    Vaccination[] data = new Vaccination[len.readLines()]; // create a Vaccination object 
    int records = 0;
    String numOfVaccines;
    int opCountS = 0;
    int opCountI = 0;


    
    /** 
     * @param vacc
     */
    // Adds vaccines into array data structure
    public void add(Vaccination vacc){
        data[records++] = vacc;
        opCountI++;
    }

    
    /** 
     * @param v
     * @return String
     */
    // Searches the vaccines using country and date
    public String search(Vaccination v){
        for(int i = 0; i < data.length; i++){
            if(v.compareTo(data[i]) == 0){
                numOfVaccines = (data[i].getVaccine()).toString();
                opCountS++;
                break;
            }
            else if(v.compareTo(data[i]) < 0 || v.compareTo(data[i]) > 0){
                numOfVaccines = "<Not Found>";
                opCountS++;
            }
        }
        return numOfVaccines;
    }
}