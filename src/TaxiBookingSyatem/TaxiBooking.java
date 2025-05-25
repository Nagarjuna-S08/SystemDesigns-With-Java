package TaxiBookingSyatem;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TaxiBooking {

    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        int noOfCars;
        int opt;
        boolean loop = true;
        System.out.print("Enter No of Cars : ");
        noOfCars = sc.nextInt();

        TaxiOperations taxiOpt = new TaxiOperations();
        taxiOpt.createInstance(noOfCars);

        while(loop){
            System.out.println("1.Booking a car\n2.show the Details of Cars\n3.Exit");
            System.out.print("Enter the Options : ");
            opt = sc.nextInt();

            switch(opt){
                case 1:
                {
                    taxiOpt.bookTaxi();
                    break;
                }
                case 2:{
                    taxiOpt.printCarDetails();
                    break;
                }
                case 3:{
                    loop = false;
                    break;
                }
                default:
                {
                    System.out.println("Choose the correct Operation");
                    break;
                }
            }
        }
    }
}