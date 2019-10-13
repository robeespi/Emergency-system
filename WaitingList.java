//Defining a class
public class WaitingList{
    
    //Defining attributes
    protected Node head;
    protected int numNodes;

    //Non-parametric constructor
    public WaitingList(){
        this.head = null;
        this.numNodes = 0;
    }

    /**
     * This method will pop the first patient from the waiting list
     * @return the patient popped from the waiting list
     */
    
    public Patient popPatient(){
        //TODO: Implement this method
        
        //Condition to know if the linkedlist is not empty
        if (this.head!=null) {
            
            //Instantiating an Patient object and attributing it the head of Linkedlist
            Patient tmp = this.head.getPatient();
            
            //Head is equal to the next node in the LinkedList
            this.head = this.head.getNext();
            
            //Returning the patient who pop from the waiting list
            return tmp;
        }
        //returning null if the linkedlist is empty
        return null;  
    }


    /**
     * This method will add patient into the waiting list according to the triage level
     * @param patient patient's data
     */
    public void addToList(Patient patient){
        //TODO: Implement this method
        
        //Instantiating nodes
        Node ptr,tmp = null;
        Node nptr = new Node(patient);
        boolean ins = false;
        
        //Case empty linkedlist
        if (head == null){
            head = nptr;
        }
        
        //Condition to know is the new patient should be positioned in the head of the waiting list
        else if (nptr.patient.getTriageLevel() >= head.patient.getTriageLevel()){
           
            nptr.setNext(head);
            head = nptr;
        }
        
        //Condition to know where the new patient can be inserted in the linked list
        else{
            
            //Setting auxiliar nodes
            tmp = head;
            ptr = head.getNext();

            //Traversing the linked list to find a position according to the order of waiting list
            while (ptr != null){
                if(nptr.patient.getTriageLevel() <= tmp.patient.getTriageLevel() &&  nptr.patient.getTriageLevel() >= ptr.patient.getTriageLevel()){
                    tmp.setNext(nptr);
                    nptr.setNext(ptr);
                    ins = true;
                    break;
                }
                else{
                    tmp = ptr;
                    ptr = ptr.getNext();
                }
            }
            if(ins == false){
                tmp.setNext(nptr);
            }
        }
    }


    /**
     * print out the information for each patient in waiting list
     */
    public void printList() {
        //TODO: Implement this method

        //Case not empty linked list
        if(this.head != null){
            Node tmp = this.head;
            do{
                tmp.printNode();
                tmp = tmp.getNext();
            }while(tmp != null);
        
        //Case empty linked list
        }else
        System.out.println("Waiting List is empty");
    }

    /**
     * Check whether the patient is in this list or not
     * @return
     */
    public boolean isInList(Patient patient){
        if (this.head == null) {
            return false;
        }
        Node temp = this.head;
        while(temp != null){
            if(temp.getPatient().getName().equals(patient.getName())
                    && temp.getPatient().getPhoneNumber().equals(patient.getPhoneNumber())){
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    public Patient popPatientById(int idd){
        
        // Store head node 
        Node temp = this.head;
        Node prev = null; 
        Node patient = null;
  
        // If head node itself holds the key to be deleted 
        if (temp != null && temp.getPatient().getId() == idd){ 
            patient = temp;
            head = temp.getNext(); // Changed head 
            return patient.getPatient(); 
        } 
  
        // Search for the key to be deleted, keep track of the 
        // previous node as we need to change temp.next 
        while (temp != null && temp.getPatient().getId() != idd){ 
            prev = temp; 
            temp = temp.getNext(); 
        }     
  
        // If key was not present in linked list 
        if (temp == null){
            return null; 
        } 
        // Unlink the node from linked list 
        patient = temp;
        prev.setNext(temp.getNext());
        return patient.getPatient(); 
   
    }

    public Patient searchById(int iddd){
        
        //Case not empty linked list
        //Traversing until find the id
        if(this.head != null){
            Node tmp = this.head;
            do{
                if(tmp.getPatient().getId() == iddd)
                    return tmp.getPatient();
                tmp = tmp.next;
            }while(tmp != null);
        }
        //Case empty linked list
        return null;
    }

    public int countPositions(int iddd){
        int count = 0;
        if(this.head != null){
            Node tmp = this.head;
            do{
                count++;
                tmp = tmp.next;
            }while(tmp.getPatient().getId()!= iddd);
        }
        return count;
    }
}
