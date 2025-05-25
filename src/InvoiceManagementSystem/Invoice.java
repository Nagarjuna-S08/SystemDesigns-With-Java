package InvoiceManagementSystem;

import java.util.ArrayList;

public class Invoice {
    int id;
    int customerId;
    ArrayList<Integer> itemIds;

    Invoice(int id,int customerId){
        this.id = id ;
        this.customerId = customerId;
        this.itemIds = new ArrayList<>();
    }
}
