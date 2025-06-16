package AdminSystemForCompany;

import java.util.Scanner;

public class Main {

    private static Service service = new Service();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        service.addCar("1","RR",5);
        service.addCar("2","RR",5);
        service.addCar("3","SUV",10);
        service.addCar("4","SUV",10);
        service.addCar("5","MARUTHI",1);
        service.addCar("6","MARUTHI",1);
        service.addCar("7","BMW",50);

        service.addDriver(5000,"Naga",10);
        service.addDriver(5000,"Kannan",10);
        service.addDriver(5000,"Kathir",10);
        service.addDriver(5000,"Sameer",10);
        service.addDriver(5000,"guru",50);
    }
}
