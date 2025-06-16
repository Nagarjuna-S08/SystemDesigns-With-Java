package AdminSystemForCompany;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Service {

    private static HashMap<Integer,Emoloyee> employeesDetail = new HashMap<>();
    private static HashMap<Integer,Driver> driversDetail = new HashMap<>();
    private static HashMap<String,Car> carDetail = new HashMap<>();

    private static HashMap<Integer,Booking> bookingDetails = new HashMap<>();



    public void addEmployee(String name,String role,String salary,String carType){
        Emoloyee emp = new Emoloyee(name, role, salary, carType);
        employeesDetail.put(emp.empId,emp);
    }

    public void addDriver(int baseSalary,String name,int ratePerKm){
        Driver driver = new Driver(baseSalary,name,ratePerKm);
        driversDetail.put(driver.id,driver);
    }

    public void addCar(String id,String type,int ratePerKm){
        Car car = new Car(id,type,ratePerKm);
        carDetail.put(id,car);
    }

    public Booking addBooking(int empId, String carId, int driverId, String pickUpLoc, String dropLoc,int km){
        Date date = new Date();
        Emoloyee emp = employeesDetail.get(empId);
        Driver driver = driversDetail.get(driverId);
        Car car = carDetail.get(carId);
        int cost = km*car.ratePerKm;

        Booking b = new Booking(date,emp,car,driver,pickUpLoc,dropLoc,km,cost);
        bookingDetails.put(b.id,b);

        return b;
    }

    private ArrayList<Booking> getValidList(Date from, Date to){
        ArrayList<Booking> list = new ArrayList<>();

        for (int id : bookingDetails.keySet()){
            Booking trip = bookingDetails.get(id);
            if( ( trip.date.compareTo(from)>=0 ) && ( trip.date.compareTo(to)<=0 )){
                list.add(trip);
            }
        }
        return list;
    }

    public void CarExpenses(Date from,Date to){
        HashMap<String,Integer> carCostDetail = new HashMap<>();

        ArrayList<Booking> validList = getValidList(from,to);
        for (Booking trip : validList){
            if(carCostDetail.containsKey(trip.car.type)){
                carCostDetail.put(trip.car.type,carCostDetail.get(trip.car.type)+trip.cost);
            }else{
                carCostDetail.put(trip.car.type,trip.cost);
            }
        }

        System.out.println(carCostDetail);
    }

    public void EmployeeExpenses(Date from,Date to){
        HashMap<Integer,Integer> empCostDetail = new HashMap<>();

        ArrayList<Booking> validList = getValidList(from,to);
        for (Booking trip : validList){
            if(empCostDetail.containsKey(trip.emp.empId)){
                empCostDetail.put(trip.emp.empId,empCostDetail.get(trip.emp.empId)+trip.cost);
            }else{
                empCostDetail.put(trip.emp.empId,trip.cost);
            }
        }

        System.out.println(empCostDetail);
    }

    public void DriverExpenses(Date from,Date to){
        HashMap<Integer,Integer> DriverCostDetail = new HashMap<>();

        ArrayList<Booking> validList = getValidList(from,to);
        for (Booking trip : validList){
            if(DriverCostDetail.containsKey(trip.emp.empId)){
                DriverCostDetail.put(trip.driver.id,DriverCostDetail.get(trip.driver.id)+trip.cost);
            }else{
                DriverCostDetail.put(trip.driver.id,trip.cost);
            }
        }

        System.out.println(driversDetail);
    }
}
