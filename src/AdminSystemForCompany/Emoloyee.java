package AdminSystemForCompany;

public class Emoloyee {
    private static int idGenerate = 91311;

    public int empId;
    public String salary;
    public String carType;
    private String name;
    private String role;

    public Emoloyee(String name, String role, String salary, String carType) {
        this.empId = idGenerate++;
        this.name = name;
        this.role = role;
        this.salary = salary;
        this.carType = carType;
    }


}
