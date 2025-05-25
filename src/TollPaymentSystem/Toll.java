package TollPaymentSystem;

import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Toll {

    static Scanner sc = new Scanner(System.in);

    int tollId;
    int totalAmount=0;
    HashMap<String,Integer> vehiclePaymentSchema;
    HashMap<Vehicle,Integer> vehicleRecord;

    Toll(int id){
        this.tollId = id;
        vehicleRecord = new HashMap<>();
        vehiclePaymentSchema = new HashMap<>();
    }

    public void addVehicles(int cnt){
        for (int i = 1; i <= cnt; i++) {

            System.out.print("Enter the Vehicle type (Car,bike,truck) : ");
            String type = sc.next().toUpperCase();
            System.out.print("Enter Amount : ");
            int amt = sc.nextInt();

            this.vehiclePaymentSchema.put(type,amt);
        }
    }

    public void printTollDetails(){
        System.out.println("......................................................................\n");
        System.out.print("TollID : "+this.tollId);
        System.out.println("\nVehicle Crossed the TOll........ ");

        Set<Vehicle> vh = this.vehicleRecord.keySet();
        for (Vehicle i : vh){
            System.out.println("VehicalId : "+i.vehicleId+i.type);
            System.out.println("Amount paid : "+this.vehicleRecord.get(i));
        }
        System.out.println("\n......................................................................");
    }
}
