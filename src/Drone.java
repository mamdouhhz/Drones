import java.util.LinkedList;
import java.util.Queue;

public class Drone {
    private final String Serial;
    private final String Model;
    private final int weight;
    private int Battery;
    private DroneState State;
    Queue<Medications> meds = new LinkedList<>();

    public Drone(String Serial, String Model, String weight) {
        State = DroneState.IDLE;
        Battery = 100;
        this.Serial = Serial;
        this.Model = Model;
        this.weight = Integer.parseInt(weight);
        System.out.println("Drone "+ Serial+ " registered successfully.");
    }

    public void deliverMeds() {
        if (meds.isEmpty()) {
            System.out.println("No medications loaded on "+Serial);
        }
        else {
            while (!meds.isEmpty() && Battery>25) {
                Medications med = meds.remove();
                System.out.println("Delivering medication "+med.getName() + " from "+Serial);
                Battery-=20;
                System.out.println("Battery Capacity: "+Battery+"%");
            }
            if (meds.isEmpty()) {
                System.out.println("All medications delivered from "+Serial);
                State = DroneState.DELIVERED;
            }
        }
    }

    public void checkStatus(){
        System.out.println("Drone Serial Number: "+Serial);
        System.out.println("Model: "+Model);
        System.out.println("Weight Limit: " +weight);
        System.out.println("Battery Capacity: "+Battery);
        System.out.println("State: "+State);
        System.out.println("Loaded Medications: ");
        for (Medications med : meds) {
            System.out.println(med.getName() + "(Weight: "+med.getWeight()+ ", Code: "+med.getCode()+")");
        }
    }

    public void loadMeds(Medications med) {
        if(State == DroneState.IDLE || State == DroneState.DELIVERED || State == DroneState.LOADED && Battery>25) {
            meds.add(med);
            System.out.println(meds.size());
            System.out.println("Medication " + med.getName() + " loaded onto " + this.Serial +" successfully.");
        }
        else {
            System.out.println("not enough battery " +Battery);
        }
        State = DroneState.LOADED;
    }

    public String getState() {
        return State.toString();
    }

    public int getBattery() {
        return Battery;
    }

//    public String getSerial() {
//        return Serial;
//    }
//
//    public String getModel() {
//        return Model;
//    }
//
//    public void setState(DroneState state) {
//        this.State = state;
//    }
//
//    public int getWeight() {
//        return weight;
//    }
//
//    public void setBattery(int battery) {
//        this.Battery = battery;
//    }
}
