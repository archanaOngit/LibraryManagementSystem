/**
 * Created by archanasingh on 06/01/18.
 */
import com.opencsv.CSVReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DataHandler {

    public List readData(String path) throws IOException {

        try (
                Reader reader = Files.newBufferedReader(Paths.get(path));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            // Reading All Records at once into a List<String[]>
            List<String[]> userRecords = csvReader.readAll();
            return userRecords;
        }


    }
    public void display(List<String[]> list) throws IOException {
        for (String[] record : list) {
            System.out.println("column1 : " + record[0]);
            System.out.println("column2 : " + record[1]);
            System.out.println("column3 : " + record[2]);
            System.out.println("column4 : " + record[3]);
            System.out.println("---------------------------");
        }
    }

    public static void editRecords(int bookIndex, String username, boolean flag){
        String[] currentRecord = Main.bookRecords.get(bookIndex);
        int userIndex = Users.userExists(username);
        String[] currentUserRecord = Main.userRecords.get(userIndex);
        if (flag) {
            currentRecord[3] = username;
            //Edit userrecord
            if (!username.isEmpty() && !currentUserRecord[2].equals("books_allowed")) {
                currentUserRecord[2] = String.valueOf(Integer.parseInt(currentUserRecord[2]) - 1);
                currentUserRecord[3] = currentUserRecord[3].concat(" " + currentRecord[1]);
            }
        }
        else {
            currentRecord[3] = "";
            if (!currentUserRecord[2].equals("books_allowed")) {
                currentUserRecord[2] = String.valueOf(Integer.parseInt(currentUserRecord[2]) + 1);
                currentUserRecord[3] = currentUserRecord[3].concat(" ");
            }
        }
        //Edit bookrecord
        Main.bookRecords.add(bookIndex, currentRecord);

    }

}
