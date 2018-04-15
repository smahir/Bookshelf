import java.io.*;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class User implements Serializable {

    private int id;
    private String name;

    static ArrayList <User> usersList = new ArrayList();
    static ArrayList <User> booksTaken = new ArrayList();


    //Writing to file
    public void save(String fileName) throws FileNotFoundException {
        FileOutputStream fout= new FileOutputStream (fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(usersList);
        fout.close();
    }

    public void read(String fileName) throws FileNotFoundException {
        FileInputStream fin= new FileInputStream (fileName);
        ObjectInputStream ois = new ObjectInputStream(fin);
        usersList = (ArrayList<User>)ois.readObject();
        fin.close();
    }

    public User(){}

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        usersList.add(this);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList getUsersList() {
        return usersList;
    }

    public ArrayList getBooksTaken() {
        return booksTaken;
    }

    public static void printUsers() {
        for(User e : usersList) {
           System.out.println("ID: " + e.id + "\nUsername: " + e.name);
        }
    }
}