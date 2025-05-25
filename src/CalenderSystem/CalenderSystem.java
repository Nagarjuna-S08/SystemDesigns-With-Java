package CalenderSystem;

import java.util.Scanner;

public class CalenderSystem {

    static Scanner sc = new Scanner(System.in);
    static Serives obj = new Serives();
    static String currentDate = "01 Apr 2025";

    public static void main(String[] args) {

        String date;
        boolean loop = true;

        System.out.println("\nwelcome to Calender System");
        obj.currentMonthSheetPrep(currentDate);
        while (loop){
            System.out.println("\n1. Find Day of a Date\n2. Custom Month Sheet\n3. Current Month Sheet\n4. Next Month Sheet\n5. Previous Month Sheet\n6. Exit");
            int option;
            System.out.print("Enter the Option : ");
            option = sc.nextInt();

            switch(option){
                case 1:{
                    sc.nextLine();
                    System.out.print("Enter the Date (For Eg: 08 Oct 2004) : ");
                    date = sc.nextLine();
                    String result = obj.helperToFindDate(date.trim());
                    System.out.println("Day : "+result);
                    break;
                }
                case 2:{
                    sc.nextLine();
                    System.out.print("Enter the Date (For Eg: Oct 2004) : ");
                    date = sc.nextLine();
                    obj.currentMonthSheetPrep("01"+" "+date);
                    break;
                }
                case 3:{
                    obj.currentMonthSheetPrep(currentDate);
                    break;
                }
                case 4:{
                    obj.nextMonthSheetPrep();
                    break;
                }
                case 5:{
                    obj.previousMonthSheetPrep();
                    break;
                }
                case 6:{
                    loop = false;
                    break;
                }
                default:{
                    System.out.println("Enter Valid Option");
                }
            }
        }
    }

}
