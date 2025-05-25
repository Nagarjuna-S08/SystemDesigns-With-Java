package LibraryManagementSystem;

public class Book {
    private static int uniqueId = 1;
    int id;
    String bookName;
    String author;
    String journal;
    boolean isAvailable = true ;

    public Book(String journal, String author, String bookName) {
        this.id = uniqueId++;
        this.journal = journal;
        this.author = author;
        this.bookName = bookName;
        Services.bMap.put(this.id,this);
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", journal='" + journal + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
