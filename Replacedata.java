import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Replacedata {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();
        
        System.out.print("Enter word to find: ");
        String wordToFind = scanner.nextLine();
        
        System.out.print("Enter word to replace with: ");
        String replacementWord = scanner.nextLine();
        
        scanner.close();
        
        try {
            String fileContent = readFile(filePath);
            String replacedContent = fileContent.replaceAll(wordToFind, replacementWord);
            writeFile(filePath, replacedContent);
            System.out.println("Replacement successful. File saved.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
    
    public static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }
    
    public static void writeFile(String filePath, String content) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.print(content);
        }
    }
}

