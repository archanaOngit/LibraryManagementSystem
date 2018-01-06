import java.io.IOException;
import java.util.List;

/**
 * Created by archanasingh on 06/01/18.
 */
public class Main {
    public static List<String[]> userRecords,  bookRecords;
    public static void main(String args[]) throws IOException{
        DataHandler dh = new DataHandler();
        Books books = new Books();
        Users users = new Users();
        userRecords = dh.readData("src/resources/users.csv");
        bookRecords = dh.readData("src/resources/books.csv");

        bookRecords = books.registerBook(bookRecords,"title1", "author1");
        dh.display(bookRecords);
        userRecords = users.registerUser(userRecords,"username1",5,"");
        dh.display(userRecords);
        System.out.println("bookIndex :: " + books.bookExists("title1", "author1"));
        System.out.println("userIndex :: " + Users.userExists("username1"));
        books.lendBook("title1", "author1","username1");
        books.returnBook("title1", "author1","");
        dh.display(bookRecords);
        dh.display(userRecords);
    }
}
