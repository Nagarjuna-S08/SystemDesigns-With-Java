package TollPaymentSystem;

import java.util.ArrayList;

public class Vehicle {
    int vehicleId;
    String type;
    String VIP;
    ArrayList<Journey> journey;
    int totalAmount=0;

    Vehicle(int vehicleId,String type,String VIP){
        this.type = type;
        journey = new ArrayList<>();
        this.vehicleId = vehicleId;
        this.VIP = VIP;
    }

    public void addJourney(int start,int destination){
        Journey jn = new Journey(start,destination);
        // Add to the List of Journey of Vehicle
        journey.add(jn);

        int amount = 0;
        //To find the amount
        for (int i : jn.tollPoints){
            Toll t = PaymentSystem.tolls.get(i);
            amount = t.vehiclePaymentSchema.get(this.type);
            if(this.VIP.equals("YES")){
                amount = amount - amount/5;
            }
            //Update Toll Current Toll
            if(t.vehicleRecord.getOrDefault(this,-1)==-1){
                t.vehicleRecord.put(this,amount);
            }
            else{
                t.vehicleRecord.put(this,t.vehicleRecord.get(this)+amount);
            }
            t.totalAmount+=amount;
            //Update Journey amount to journey Obj
            jn.amount += amount;
            // Update Total Amount Of Vehicle
            this.totalAmount+=amount;
        }
    }

    public void printVehicleDetails(){
        System.out.println("......................................................................\n");
        System.out.print("VehicleId : "+this.vehicleId+this.type+"\tVIP : "+this.VIP);
        System.out.println("\nJourneys........ ");
        for (Journey jn : this.journey){
            System.out.println("Start -> "+jn.tollPoints+" <- Destination");
            System.out.println(jn.amount);
        }
        System.out.println("\n......................................................................");
    }
}
