package TollPaymentSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PaymentSystem {

    static Scanner sc = new Scanner(System.in);

    static HashMap<Integer,Vehicle> vehicles =  new HashMap<>();
    static HashMap<Integer,Toll> tolls = new HashMap<>();

    public static void main(String[] args){
        boolean loop = true;
        while(loop){
            System.out.print("\n1. Find journey cost\n2. Show The Tolls Details\n3. Show The Vehicle Details\n4. To Find Shortest Path\n5. Add Vehicle\n6. Add Toll\n7. Exit\n");
            System.out.print("\nEnter the Choice : ");
            int choice = sc.nextInt();

            switch(choice){
                case 1:{
                    System.out.print("Enter the Vehicle ID : ");
                    int id = sc.nextInt();
                    // Find the Vehicle
                    Vehicle vh = vehicles.get(id);

                    System.out.print("Start : ");
                    int start = sc.nextInt();
                    System.out.print("Destination : ");
                    int destination = sc.nextInt();

                    vh.addJourney(start,destination);
                    break;
                }
                case 2:{
                    for (Toll t:tolls.values()){
                        t.printTollDetails();
                    }
                    break;
                }
                case 3:{
                    for (Vehicle t:vehicles.values()){
                        t.printVehicleDetails();
                    }
                    break;
                }
                case 4:{
                    break;
                }
                case 5:{
                    System.out.print("Enter the Vehicle ID : ");
                    int id = sc.nextInt();
                    System.out.print("Enter the Vehicle type (Car,bike,truck) : ");
                    String type = sc.next().toUpperCase();
                    System.out.print("Are you VIP (YES/NO) : ");
                    String vip = sc.next().toUpperCase();

                    // Add to list of Vehicles
                    vehicles.put(id,new Vehicle(id,type,vip));
                    break;
                }
                case 6:{
                    System.out.print("Enter the Toll ID : ");
                    int id = sc.nextInt();
                    Toll t = new Toll(id);
                    // Add  to List of Tolls
                    tolls.put(id,t);

                    System.out.print("Enter Number Of Vehicle : ");
                    int cnt = sc.nextInt();
                    // To add vehicles
                    t.addVehicles(cnt);
                    break;
                }
                case 7:{
                    loop=false;
                    break;
                }
                default:{
                    System.out.println("\nEnter a Valid Choice");
                }
            }
        }
    }
}
