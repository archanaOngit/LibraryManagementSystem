import java.util.List;
/**
 * Created by archanasingh on 06/01/18.
 * This file contains all methods pertaining to add, edit, delete, lend, search books
 */
public class Books {
    /**
     * Ability to add books to the system
     */
    public List registerBook(List<String[]> bookRecords, String title, String author){
        if (bookExists(title, author) == 0) {
            int index = bookRecords.size();
            String[] element = new String[]{String.valueOf(index), title, author, ""};

            bookRecords.add(index, element);
        }
        return bookRecords;
    }

    /**
     * Ability to lend books to users.csv.
     */
    public void lendBook(String title, String author, String username){
        int bookIndex = bookExists(title, author);
        String[] record = Main.bookRecords.get(bookIndex);
        if (Users.isAllowedbook(username)) {
            if (bookIndex > 0 && record[3].isEmpty()) {
                DataHandler.editRecords(bookIndex, username, true);
            }
        }
    }

    /**
     * Ability to return books to the library.
     */
    public void returnBook(String title, String author, String username){
        int bookIndex = bookExists(title, author);
        String[] record = Main.bookRecords.get(bookIndex);
        if (bookIndex > 0 && !record[3].isEmpty()) {
            DataHandler.editRecords(bookIndex, username, false);
        }
    }

    /**
     * Ability to search a book by title, author.
     */
    public int bookExists(String title, String author){
        for (String[] record : Main.bookRecords) {
            if (record[1].contains(title)) {
                return Main.bookRecords.indexOf(record);
            }
        }
        return 0;
    }
}
