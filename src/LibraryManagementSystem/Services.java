package LibraryManagementSystem;

import java.util.HashMap;

public class Services {

    static HashMap<Integer,Book> bMap = new HashMap<>();
    static HashMap<String,Admin> aMap = new HashMap<>();
    static HashMap<String,User> uMap = new HashMap<>();

    public static void printUser(){
        System.out.println();
        for (User u : uMap.values()){
            System.out.println(u);
        }
        System.out.println();
    }

    public static void printAdmin(){
        System.out.println();
        for (Admin a : aMap.values()){
            System.out.println(a);
        }
        System.out.println();
    }

    public static void printBook(){
        System.out.println();
        for (Book b : bMap.values()){
            System.out.println(b);
        }
        System.out.println();
    }
}
