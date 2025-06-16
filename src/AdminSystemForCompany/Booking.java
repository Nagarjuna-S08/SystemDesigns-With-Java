package AdminSystemForCompany;

import java.util.Date;

public class Booking {
    private static int bookingId = 1;

    public int id;
    public Date date;
    public Emoloyee emp;
    public Car car;
    public Driver driver;
    public String pickUpLoc;
    public String dropLoc;
    public int km;
    public int cost;

    public Booking(Date date, Emoloyee emp, Car car, Driver driver, String pickUpLoc, String dropLoc, int km, int cost) {
        this.id = bookingId++;
        this.date = date;
        this.emp = emp;
        this.car = car;
        this.driver = driver;
        this.pickUpLoc = pickUpLoc;
        this.dropLoc = dropLoc;
        this.cost = cost;
        this.km = km;
    }
}
