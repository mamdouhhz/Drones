import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Drone> drones = new HashMap<>();

        while (true) {
            String command = sc.nextLine();
            String[] tokens = command.split(" ");

            switch (tokens[0]) {
                case "register":
                    if(tokens.length == 4) {
                        boolean isNumeric = isNumeric(tokens);
                        if(isNumeric)
                            drones.put(tokens[1], new Drone(tokens[1], tokens[2], tokens[3]));
                        else
                            System.out.println("invalid format");
                    }
                    else{
                        System.out.println("Invalid number of values,  invalid format");
                    }
                    break;


                case "load":
                    if(tokens.length == 5) {
                        String serial = tokens[1];
                        boolean isNumeric = isNumeric(tokens);
                        if(isNumeric)
                            drones.get(serial).loadMeds(new Medications(tokens[2], Integer.parseInt(tokens[3]), tokens[4]));
                        else
                            System.out.println("invalid format");
                    }
                    else
                        System.out.println("Invalid number of values,  invalid format");
                    break;

                case "check_status":
                    if(tokens.length == 2){
                        String serial = tokens[1];
                        drones.get(serial).checkStatus();
                    }
                    else
                        System.out.println("Invalid register command");
                    break;

                case "deliver":
                    String serial = tokens[1];
                    drones.get(serial).deliverMeds();
                    break;

                case "list_drones":
                    for (Map.Entry<String, Drone> d : drones.entrySet()) {
                        System.out.println(d.getKey() + "- State: "+d.getValue().getState() + ", Battery: "+d.getValue().getBattery() +"%");
                    }
                    break;

                case "exit":
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid command");
            }
        }
    }

    private static boolean isNumeric(String[] tokens) {
        boolean isNumeric = true;
        try {
            Integer num = Integer.parseInt(tokens[3]);
        } catch (NumberFormatException e) {
            isNumeric = false;
        }
        return isNumeric;
    }
}