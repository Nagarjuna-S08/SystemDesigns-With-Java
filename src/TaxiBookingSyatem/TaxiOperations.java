package TaxiBookingSyatem;

import java.util.ArrayList;
import java.util.Scanner;

public class TaxiOperations {

    static ArrayList<TaxiDetails> carList = new ArrayList<>();
    static int cid = 1 ;
    static Scanner sc = new Scanner(System.in);

    public void createInstance(int no){
        for (int i = 1; i <= no; i++) {
            carList.add(new TaxiDetails(i));
        }
    }

    public void bookTaxi(){

        System.out.print("Enter the Pick Up Loc: ");
        char p = sc.next().toUpperCase().charAt(0);
        System.out.print("Enter the drop Loc: ");
        char d = sc.next().toUpperCase().charAt(0);
        System.out.print("Enter the Pick Up Time: ");
        int t = sc.nextInt();

        TaxiDetails slectedCar = null;
        int distance = Integer.MAX_VALUE;

        for (TaxiDetails car : carList){
            if (car.dropTime<=t){
                int minDistance = Math.abs(p-car.location);
                if(distance>minDistance || (distance==minDistance && slectedCar.income>car.income)){
                    slectedCar = car;
                    distance = minDistance;
                }
            }
        }

        if(slectedCar==null){
            System.out.println("\nN0 Taxi is Available.........\n");
            return;
        }

        slectedCar.lastRideIncome = 100 + (((Math.abs(p-d)*15)-5)*10);
        slectedCar.income += slectedCar.lastRideIncome;
        slectedCar.dropTime = t+Math.abs(p-d);
        slectedCar.location = d;

        System.out.println("\nBooked Details..");
        System.out.println("customer id : "+cid++);
        System.out.println("The Booked Car : "+slectedCar.taxiId+"Car");
        System.out.println("The Fair Amount : "+slectedCar.lastRideIncome);
        System.out.println("The Time of reach : "+slectedCar.dropTime);
        System.out.println("..............................................\n");
    }

    public void printCarDetails(){
        System.out.println();
        for(TaxiDetails taxi : carList){
            System.out.println("CarId\tCarLocation\tCarIncome\t");
            System.out.println("car"+taxi.taxiId+"\t\t"+taxi.location+"\t\t"+taxi.income+"\t");
            System.out.println("..............................................\n");
        }
    }
}
