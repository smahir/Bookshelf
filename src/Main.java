import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static User user;
    private static Book book;

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        User.load();
        boolean checker = true;

        while(checker) {

            System.out.println("Select option: ");
            System.out.println("1.Create account " +
                    "\n" +
                            "2.Create book \n" +
                            "3.Borrow book \n" +
                            "4.Return book \n" +
                            "5.Print accounts \n" +
                            "6.Print books \n" +
                            "7.Exit");

            int option = input.nextInt();

            switch (option) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    createBook();
                    break;
                case 3:
                    borrowBook();
                    break;
                case 4:

                    break;
                case 5:
                    user.printUsers();
                    System.out.println();
                    break;
                case 6:
                    book.printBooks();
                    System.out.println();
                    break;
                case 7:
                    checker = false;
                    User.save();
                    break;
            }

        }

    }

    private static void borrowBook() {


    }

    private static void createAccount() {
        System.out.println("Enter account ID: ");
                int accID = input.nextInt();
        while(checkID(accID)) {
            System.out.println("Account ID is taken, try another one: ");
                    accID = input.nextInt();
        }

        System.out.println("Enter username: ");
                String userName = input.next();
        while(checkName(userName)) {
            System.out.println("Account name is take, try another one: ");
                    userName = input.next();
        }

        writeAccount(new User(accID, userName));

    }

    private static void writeAccount(User user) {
        Main.user = user;
    }

    private static boolean checkName(String userName) {
        for (User e : User.usersList) {
            if(userName == e.getName()) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkID(int accID) {
        for(User e : User.usersList) {
            if(accID == e.getId()) {
                return true;
            }
        }
        return false;
    }

    //Methods for Books

    private static void createBook() {
        System.out.println("Enter book ID: ");
        int bookID = input.nextInt();
        while(checkIDbook(bookID)) {
            System.out.println("Book ID is taken, try another one: ");
            bookID = input.nextInt();
        }

        System.out.println("Enter title: ");
        String title = input.next();
        while(checkTitleBook(title)) {
            System.out.println("Title is taken, try another one: ");
            title = input.next();
        }

        System.out.println("Enter author name: ");
        String author = input.next();

        System.out.println("Enter description: ");
        String description = input.next();

        writeBook(new Book(bookID, title, author, description));

    }

    private static void writeBook(Book book) {
        Main.book = book;
    }

    private static boolean checkTitleBook(String title) {
        for (Book e : Book.booksList) {
            if(title == e.getTitle()) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkIDbook(int bookID) {
        for(Book e : Book.booksList) {
            if(bookID == e.getId()) {
                return true;
            }
        }
        return false;
    }


}
