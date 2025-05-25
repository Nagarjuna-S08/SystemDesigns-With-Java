package LibraryManagementSystem;

public class Admin {
    private static int uniqueId=1;
    int id;
    String name;
    String password;

    public Admin(String name, String password) {
        this.id = uniqueId++;
        this.name = name;
        this.password = password;
        Services.aMap.put(this.name,this);
    }

    public void addUser(String name,String password,String phNo){
        new User(name,password,phNo);
    }

    public void addBook(String bookName,String authorName,String journal){
        new Book(bookName,authorName,journal);
    }

    public void deleteBook(int id){
        Services.bMap.remove(id);
    }

    public void UpdateBook(int id,String bookName,String authorName,String journal){
        Book b  = Services.bMap.get(id);
        b.bookName = bookName.isEmpty() ?b.bookName:bookName;
        b.author  = authorName.isEmpty() ?b.author:authorName;
        b.journal = journal.isEmpty() ?b.journal:journal;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
