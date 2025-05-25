package InvoiceManagementSystem;

public class Item {
    int id;
    String itemName;
    String itemDescription="";
    int price;
    int cnt;
    int totalAmt;

    Item(int id,String name,String description,int price,int cnt){
        this.id = id;
        this.cnt = cnt;
        this.itemName = name;
        this.itemDescription = description;
        this.price =price;
        this.totalAmt = this.cnt*this.price;
    }
}
