import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class DataComparsion{
    public static void main(String[] args) throws IOException {
        String file1 = "D:file1.txt";
        String file2 = "D:file2.txt";

        Set<String> emails1 = new HashSet<>();
        Set<String> emails2 = new HashSet<>();

        try (BufferedReader br1 = new BufferedReader(new FileReader(file1));
             BufferedReader br2 = new BufferedReader(new FileReader(file2))) {

            String line;
            while ((line = br1.readLine()) != null) {
                emails1.add(line);
            }

            while ((line = br2.readLine()) != null) {
                emails2.add(line);
            }
        }

        // Print emails that are present in both files.
        System.out.println("Emails present in both files:");
        Set<String> intersection = new HashSet<>(emails1);
        intersection.retainAll(emails2);
        System.out.println(intersection);

        // Print emails that are present in file1 but not in file2.
        System.out.println("Emails present in file1 but not in file2:");
        Set<String> difference1 = new HashSet<>(emails1);
        difference1.removeAll(emails2);
        System.out.println(difference1);

        // Print emails that are present in file2 but not in file1.
        System.out.println("Emails present in file2 but not in file1:");
        Set<String> difference2 = new HashSet<>(emails2);
        difference2.removeAll(emails1);
        System.out.println(difference2);

        // Print all the unique emails present in both file1 and file2.
        System.out.println("All unique emails present in both files:");
        Set<String> union = new HashSet<>(emails1);
        union.addAll(emails2);
        System.out.println(union);
    }
}
