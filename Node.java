//Defining a node class
public class Node {
    protected Node next;
    protected Patient patient;

    //Parametric constructor
    public Node(Patient patient) {
        this.patient = patient;
        this.next = null;
    }

    //Accesors and mutators
    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    //Implementing method as required
    public void printNode() {
        //TODO: Implement this method
        System.out.println("Id: "+this.patient.getId()+"  Name: "+this.patient.getName()+" Patient: "+this.patient.getTriageLevel());
    }
}
