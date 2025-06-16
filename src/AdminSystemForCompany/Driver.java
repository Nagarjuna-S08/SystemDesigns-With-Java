package AdminSystemForCompany;

public class Driver {
    private static int idGenerate = 2051;

    public int id;
    public int baseSalary;
    private String name;
    public int ratePerKM;

    public Driver(int baseSalary, String name,int km) {
        this.id = idGenerate++;
        this.baseSalary = baseSalary;
        this.name = name;
        this.ratePerKM = km;
    }
}
