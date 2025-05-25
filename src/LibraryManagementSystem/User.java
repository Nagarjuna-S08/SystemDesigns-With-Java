package LibraryManagementSystem;

import java.util.HashMap;

public class User {
    private static int uniqueId=1;
    int id;
    String name;
    String password;
    String phNo;
    HashMap<Integer,Book> bookList;

    public User(String name, String password, String phNo) {
        this.id = uniqueId++;
        this.name = name;
        this.password = password;
        this.phNo = phNo;
        this.bookList = new HashMap<>();
        Services.uMap.put(this.name,this);
    }

    public boolean borrowBook(int bookId){
        Book b = Services.bMap.get(bookId);
        if (!b.isAvailable()){
            return false;
        }
        b.isAvailable = false ;
        this.bookList.put(bookId,b);
        return true;
    }

    public void bookReturn(int bookId){
        Book b = this.bookList.remove(bookId);
        b.isAvailable = true;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", phNo='" + phNo + '\'' +
                ", bookList=" + bookList +
                '}';
    }
}
