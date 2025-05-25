package InvoiceManagementSystem;

import java.util.ArrayList;

public class Customer {
    int id;
    String customerName;
    String phoneNumber;
    ArrayList<Integer> invoiceIds;

    Customer(int id,String name,String phNo){
        this.id = id ;
        this.customerName = name ;
        this.phoneNumber = phNo ;
        this.invoiceIds = new ArrayList<>();
    }

}
