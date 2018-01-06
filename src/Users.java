import java.util.List;

/**
 * Created by archanasingh on 06/01/18.
 */
public class Users {
    /**
     * Ability to add users.csv to the system.
     */
    public List registerUser(List<String[]> userRecords, String username, int books_allowed, String[] books_borrowed){
        System.out.println(userRecords.size());
        int index = userRecords.size();
        String[] element = new String[]{String.valueOf(index),username, String.valueOf(books_allowed), books_borrowed.toString() };
        userRecords.add(index, element);
        return userRecords;
    }
    /**
     * Ability to limit the number of books borrowed by user.
     */
    public static int booksAllowed(String username){
        for (String[] record : Main.userRecords) {
            if (!record[2].contains("5")) {
                return Integer.parseInt(record[2]);
            }
        }
        return 0;
    }

    /**
     * Helper function to check if a user is allowed books to lend.
     */
    public static boolean isAllowedbook(String username){
        if (booksAllowed(username)<1){
            return false;
        }
        return true;
    }
    /**
     * Ability to search a user by name
     */
    public static int userExists(String username){
        for (String[] record : Main.userRecords) {
            if (record[1].contains(username)) {
                return Main.userRecords.indexOf(record);
            }
        }
        return 0;
    }
}

