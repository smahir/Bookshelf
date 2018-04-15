import java.util.ArrayList;

public class Book {

    private int id;
    private String title;
    private String author;
    private String description;

    static ArrayList <Book>booksList = new ArrayList();

    public Book(){}

    public Book(int id, String title, String author, String description) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        booksList.add(this);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }


    public String getDescription() {
        return description;
    }


    public ArrayList getBooksList() {
        return booksList;
    }

    public static void printBooks() {
        for(Book e : booksList) {
            System.out.println("ID: " + e.id +
                               "\nTitle: " + e.title +
                               "\nAuthor: " + e.author +
                               "\nDescription: " + e.description);
        }
    }
}
