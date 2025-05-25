package InvoiceManagementSystem;

import java.util.HashMap;
import java.util.Scanner;

public class Services {

    private static final HashMap<Integer,Customer> cusMap = new HashMap<>();
    private static final HashMap<Integer,Invoice> incMap = new HashMap<>();
    private static final HashMap<Integer,Item> itemMap = new HashMap<>();

    public int addCustomer(int id,String name,String phNo){
        cusMap.put(id,new Customer(id,name,phNo));
        return id;
    }

    public int addInvoice(int id,int CustomerId){

        incMap.put(id,new Invoice(id,CustomerId));
        cusMap.get(CustomerId).invoiceIds.add(id);
        return id;
    }

    public void addItem(int id,int invoiceId,String name,String description,int price,int cnt ){
        itemMap.put(id,new Item(id,name,description,price,cnt));
        incMap.get(invoiceId).itemIds.add(id);
    }

    public void printCustomers(){
        System.out.println("----Customer----");
        for (Customer c: cusMap.values()){
            System.out.println("Customer Name :"+c.customerName+"\tCustomer PhoneNumber : "+c.phoneNumber);
        }
    }

    public void printInvoice(){
        System.out.println("----Invoices----");
        for (Invoice i: incMap.values()){
            System.out.println("InVoice Id :"+i.id+"\tCustomer Id : "+i.customerId);
        }
    }

    public void printInvoiceOfCustomer(int customerId){
        Customer c = cusMap.get(customerId);
        System.out.println("------Invoice Of Customer------");
        System.out.println("Customer Name :"+c.customerName+"\tCustomer PhoneNumber : "+c.phoneNumber);
        for (int i:c.invoiceIds) {
            Invoice inc = incMap.get(i);
            System.out.println("InVoice Id :"+inc.id);
            for(int j:inc.itemIds){
                Item item = itemMap.get(j);
                System.out.println("Item Name : "+item.itemName+"\t\tItem Quantity : "+item.cnt+"\t\tItem Price : "+item.price+"\t\tItem Amount : "+item.totalAmt);
            }
        }
    }
}
