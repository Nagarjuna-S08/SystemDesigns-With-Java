package MoraPonnuCalculator;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static HashMap<String,Person> personDetail = new HashMap<>();

    public static void main(String[] args) {
        personDetail.put("naga", new Person("naga", "shan", "mala", 'M'));
        personDetail.put("shan", new Person("shan", "kand", "subbu", 'M'));
        personDetail.put("mala", new Person("mala", "ramu", "vijya", 'F'));
        personDetail.put("sitha", new Person("sitha", "kand", "subbu", 'F'));
        personDetail.put("balu", new Person("balu", "ramu", "vijya", 'M'));
        personDetail.put("indhu", new Person("indhu", "mohan", "sitha", 'F'));
        personDetail.put("trisha", new Person("trisha", "balu", "theba", 'F'));
        personDetail.put("kand", new Person("kand", "nagaling", "ling", 'M'));
        personDetail.put("ramu", new Person("ramu", "nagaling", "ling", 'M'));

        Main obj = new Main();
        obj.findMoraponnuCount(personDetail.get("naga"));
    }

    public void findMoraponnuCount(Person userObject){
        char userGender = userObject.gender;

        Person fatherObject = findParent(userObject.fatherName);
        char fatherGender = fatherObject.gender;
        Person grandFatherObject = findParent(fatherObject.fatherName);
        ArrayList<Person> fathersSiblings = findSiblings(grandFatherObject.gender,grandFatherObject.name,fatherGender);

        Person motherObject = findParent(userObject.motherName);
        char motherGender = motherObject.gender;
        Person MotherSideGrandFatherObject = findParent(motherObject.fatherName);
        ArrayList<Person> mothersSiblings = findSiblings(MotherSideGrandFatherObject.gender,MotherSideGrandFatherObject.name,motherGender);

        ArrayList<Person> fatherSideCousin =countValidCount(fathersSiblings,fatherGender,userGender);
        System.out.println(fatherSideCousin);

        ArrayList<Person> motherSideCousin =countValidCount(mothersSiblings,motherGender,userGender);
        System.out.println(motherSideCousin);
    }

    public ArrayList<Person> countValidCount(ArrayList<Person> siblingsList,char parentGender,char userGender){
        ArrayList<Person> validList = new ArrayList<>();
        if(parentGender=='M'){
            for (Person siblingObject : siblingsList){
                String motherName = siblingObject.name;
                for (String  username : personDetail.keySet()) {
                    Person userObject = personDetail.get(username);
                    if(userObject.motherName.equals(motherName) && userObject.gender!=userGender){
                        validList.add(userObject);
                    }
                }
            }
        }
        else{
            for (Person siblingObject : siblingsList){
                String fatherName = siblingObject.name;
                for (String  username : personDetail.keySet()) {
                    Person userObject = personDetail.get(username);
                    if(userObject.fatherName.equals(fatherName) && userObject.gender!=userGender){
                        validList.add(userObject);
                    }
                }
            }
        }

        return validList;
    }

    public ArrayList<Person> findSiblings(char parentGender,String parentName,char siblingGender){
        ArrayList<Person> siblingsList = new ArrayList<>();

        for (String  username : personDetail.keySet()) {
            Person userObject = personDetail.get(username);

            if(userObject.fatherName.equals(parentName) && userObject.gender!=siblingGender){
                siblingsList.add(userObject);
            }
        }

        return siblingsList;
    }

    public Person findParent(String name){
        return personDetail.get(name);
    }

}
