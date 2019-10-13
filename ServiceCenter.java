//calling packages for exception handling
import java.io.*; 
import java.lang.Throwable;

public class ServiceCenter {
    private WaitingList awl;

    public ServiceCenter() {
        this.awl = new WaitingList();
    }

    /**
     * Record patient's data and add the patient into waiting list
     * @param name
     * @param phoneNumber
     * @param triageLevel
     * @param location
     */

    public void addPatientIntoList(String name, String phoneNumber, int triageLevel, String location) {
        //Running Throwable for avoid null pointer exception
        if (triageLevel>=1 && triageLevel<=5){
            Patient patient = new Patient(name, phoneNumber, triageLevel, location);
            if(this.awl.isInList(patient)){
                System.out.println(patient.getName() + " is in waiting list. ");
            }else{
                this.awl.addToList(patient);
                System.out.println("Add " + patient.getName() + " into waiting list. ");
            }
        }else{
        throw new IllegalArgumentException("The system should only accept (1-5) as legal input for triage level");  
        }
    }



    /**
     * Pop out the first patient in the waiting list and assign an Ambulance for him/her
     * @return the patient object
     */
    public Patient assignAmbulanceForPatient(){
        // TODO: The tester report that the system will crash when waiting list is empty
       
        Patient patient = this.awl.popPatient();

        //Running try and cach for avoid null pointer exception
        try{
        System.out.println("Assigned an ambulance for patient: " + patient.getName());
        }catch(NullPointerException e){
            System.out.println("Error! The waiting list is empty");
            Main.displayMenu();
        }
        return patient;
    }

    /**
     * Print out the waiting list
     */
    public void printWaitingList(){
        this.awl.printList();
    }

    /**
     * Search id patient in the waiting list and pop it out in the waiting list and assign an Ambulance for him/her
     * @return the patient object
     */
    public Patient assignAmbulanceForPatientById(int idd){
        
        Patient patient = this.awl.popPatientById(idd);
        
        //Running try and cach for avoid null pointer exception
        try{
        System.out.println("Success! An ambulance as assigned for patient: " + patient.getId());
        }catch(NullPointerException e){
            System.out.println("Error! The waiting list is empty");
            Main.displayMenu();
        }    
        return patient;
    }

    public int checkPositionById(int iddd){
        Patient patient = this.awl.searchById(iddd);
        int positions = this.awl.countPositions(iddd);
        System.out.println("There are "+positions+ " patients before patient "+ patient.getId());
        return positions;
    }
}
