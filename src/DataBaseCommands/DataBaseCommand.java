package DataBaseCommands;

import java.util.Scanner;

public class DataBaseCommand {

    static Scanner sc = new Scanner(System.in);
    static Services service = new Services();

    public static void main(String[] args) {
        boolean choise = true;
        while (choise){
            System.out.println("\n1.SET\n2.GET\n3.UNSET\n4.BEGIN\n5.ROLLBCK\n6.COMMIT\n7.EXIT\n");
            System.out.print("Enter the Choice : ");
            int opt = sc.nextInt();

            switch (opt){
                case 1:{
                    String name;
                    int val;
                    System.out.print("Enter the Name(Variable) : ");
                    name = sc.next();
                    System.out.print("Enter the value : ");
                    val = sc.nextInt();
                    service.set(name,val);
                    break;
                }
                case 2:{
                    System.out.print("Enter the Name(Variable) : ");
                    String name = sc.next();
                    String val = service.get(name);
                    System.out.printf("Value for %s is %s",name,val);
                    break;
                }
                case 3:{
                    System.out.print("Enter the Name(Variable) : ");
                    String name = sc.next();
                    service.unSet(name);
                    break;
                }
                case 4:{
                    service.begin();
                    break;
                }
                case 5:{
                    service.rollBack();
                    break;
                }
                case 6:{
                    service.commit();
                    break;
                }
                case 7:{
                    choise = false;
                    break;
                }
            }
        }
    }
}
