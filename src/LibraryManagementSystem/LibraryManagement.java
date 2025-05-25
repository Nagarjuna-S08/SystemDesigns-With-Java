package LibraryManagementSystem;

import java.util.HashMap;
import java.util.Scanner;

public class LibraryManagement {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        Services.aMap.put("Nagarjuna",new Admin("Nagarjuna","naga2004"));

        boolean loop = true;
        while (true){
            String name,password,role;
            System.out.print("Enter UserName : ");
            name = sc.next();
            System.out.print("Enter Role : ");
            role = sc.next();
            System.out.print("Enter Password : ");
            password = sc.next();
            if(role.equals("admin")){
                Admin admin = Services.aMap.get(name);
                if (admin==null){
                    System.out.println("No Such User Exists in DB");
                    continue;
                }
                if(admin.password.equals(password)){
                    loop = true;
                    while (loop){
                        System.out.println("1. Add Book\n2. Update Book\n3. Delete Book\n4. Add Member\n5. Display All Books\n6. Display All Members\n7. Exit\n");
                        System.out.print("Enter Option : ");
                        int option = sc.nextInt();

                        switch (option){
                            case 1:{
                                String bookName;
                                String authorName;
                                String journal;
                                System.out.print("Enter Book Name : ");
                                bookName = sc.next();
                                System.out.print("Enter Author Name : ");
                                authorName = sc.next();
                                System.out.print("Enter Journal : ");
                                journal = sc.next();
                                admin.addBook(bookName,authorName,journal);
                                System.out.println("Book Added Successfully......");
                                break;
                            }
                            case 2:{
                                int bookId;
                                String bookName;
                                String authorName;
                                String journal;
                                System.out.println("Enter Book Id : ");
                                bookId = sc.nextInt();
                                System.out.print("Enter Book Name : ");
                                bookName = sc.next();
                                System.out.print("Enter Author Name : ");
                                authorName = sc.next();
                                System.out.print("Enter Journal : ");
                                journal = sc.next();
                                admin.UpdateBook(bookId,bookName,authorName,journal);
                                System.out.println("Book Updated Successfully......");
                                break;
                            }
                            case 3:{
                                int bookId;
                                System.out.println("Enter Book Id : ");
                                bookId = sc.nextInt();
                                admin.deleteBook(bookId);
                                System.out.println("Book Deleted Successfully......");
                                break;
                            }
                            case 4:{
                                String userName;
                                String userPassword;
                                String phNo;
                                System.out.print("Enter User Name : ");
                                userName = sc.next();
                                System.out.print("Enter Password : ");
                                userPassword = sc.next();
                                System.out.print("Enter PhNo. : ");
                                phNo = sc.next();
                                admin.addUser(userName,userPassword,phNo);
                                System.out.println("User Added Successfully......");
                                break;
                            }
                            case 5:{
                                Services.printBook();
                                break;
                            }
                            case 6:{
                                Services.printUser();
                                break;
                            }
                            case 7:{
                                loop=false;
                                break;
                            }
                            default:{
                                System.out.println("Enter a Valid Option.....");
                                break;
                            }
                        }
                    }
                }
                else{
                    System.out.println("Wrong User Name or Password");
                    continue;
                }
            }
            else if(role.equals("user")){
                User user = Services.uMap.get(name);
                if(user==null){
                    System.out.println("Something Wrong");
                    continue;
                }
                if(user.password.equals(password)){
                    loop = true ;
                    while (loop){
                        System.out.println("1. Borrow Book\n2. Return Book\n3. Display All Books\n4. Display All Members\n5. Exit\n");
                        System.out.print("Enter Option : ");
                        int option = sc.nextInt();

                        switch (option){
                            case 1:{
                                int bookId;
                                System.out.print("Enter Book Id : ");
                                bookId = sc.nextInt();
                                if (user.borrowBook(bookId)){
                                    System.out.println("Book Borrowed SuccessFully........");
                                }
                                else {
                                    System.out.println("Book is Not Available........");
                                }
                                break;
                            }
                            case 2:{
                                int bookId;
                                System.out.print("Enter Book Id : ");
                                bookId = sc.nextInt();
                                user.bookReturn(bookId);
                                System.out.println("Book Return SuccessFully........");
                                break;
                            }
                            case 3:{
                                Services.printBook();
                                break;
                            }
                            case 4:{
                                Services.printUser();
                                break;
                            }
                            case 5:{
                                loop=false;
                                break;
                            }
                            default:{
                                System.out.println("Enter a Valid Option.....");
                                break;
                            }
                        }
                    }
                }
                else{
                    System.out.println("Wrong User Name or Password");
                    continue;
                }
            }
        }
    }
}
