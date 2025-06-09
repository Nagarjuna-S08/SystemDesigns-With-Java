package MoraPonnuCalculator;

public class Person {
    String name;
    String fatherName;
    String motherName;
    char gender;

    Person(String name,String fatherName,String motherName,char gender){
        this.name=name;
        this.fatherName=fatherName;
        this.motherName=motherName;
        this.gender=gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", gender=" + gender +
                '}';
    }
}
