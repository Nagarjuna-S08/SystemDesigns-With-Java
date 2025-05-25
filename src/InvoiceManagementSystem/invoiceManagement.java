package InvoiceManagementSystem;

import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class invoiceManagement {

    static Scanner sc = new Scanner(System.in);

    static Services im = new Services();
    private static int customerId = 1;
    private static int invoiceId = 1;
    private static int itemId = 1;


    public static void main(String[] args) {
        boolean loop = true;
        while(loop){
            System.out.println("\n1. Add a Customer\n2. Add a Invoice\n3. Add item to Invoice\n4. List all Customer\n5. List all Invoice\n6. List all Invoice of Customer\n");
            System.out.print("Enter the Choice : ");
            int choice = sc.nextInt();

            switch(choice){
                case 1:{
                    System.out.print("Enter the Customer Name : ");
                    String name = sc.next();
                    System.out.print("Enter the Phone Number : ");
                    String phNo = sc.next();
                    int id = im.addCustomer(customerId++,name,phNo);
                    System.out.println("\nSuccessfully Created Given ID (Customer) : "+id);
                    break;
                }
                case 2:{
                    System.out.print("Enter the Customer Id : ");
                    int mapCustomerId = sc.nextInt();
                    int id = im.addInvoice(invoiceId++,mapCustomerId);
                    System.out.println("\nSuccessfully Created Given ID (Invoice) : "+id);
                    break;
                }
                case 3:{
                    System.out.print("Enter Invoice Id : ");
                    int invoiceId = sc.nextInt();
                    System.out.print("How many Items to Add : ");
                    int cnt = sc.nextInt();
                    for (int i = 1; i <= cnt ; i++) {
                        System.out.print("Enter the Item("+i+")"+" Name : ");
                        String name = sc.next();
                        System.out.print("Enter the Item("+i+")"+" Description : ");
                        String description = sc.next();
                        System.out.print("Enter Number of Items("+i+") : ");
                        int count = sc.nextInt();
                        System.out.print("Enter Item("+i+")"+" Price (Individual Price) : ");
                        int price = sc.nextInt();
                        im.addItem(itemId++,invoiceId,name,description,count,price);
                    }
                    break;
                }
                case 4:{
                    im.printCustomers();
                    break;
                }
                case 5:{
                    im.printInvoice();
                    break;
                }
                case 6:{
                    System.out.print("Enter the Customer Id : ");
                    int cusId = sc.nextInt();
                    im.printInvoiceOfCustomer(cusId);
                    break;
                }
                case 7:{
                    loop=false;
                    break;
                }
                default:
                    System.out.println("Enter a Valid Choice.");
                    break;
            }
        }
    }
}
