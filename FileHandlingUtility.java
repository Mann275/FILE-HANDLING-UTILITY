import java.io.*;
import java.nio.file.*;


public class FileHandlingUtility {

    // File path constant
    private static final String FILE_PATH = "example.txt";

    public static void main(String[] args) {
        // Writing initial content to file
        writeToFile("This is the original content of the file.\nLine 2: Hello, World!");

        // Reading the content from file
        readFromFile();

        // Modifying the file content
        modifyFile("World", "Mann");

        // Reading again to verify modification
        readFromFile();
    }


    // Writes text content to a file.
    // If the file does not exist, it will be created.
    
    public static void writeToFile(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write(content);
            System.out.println("✅ File written successfully.\n");
        } catch (IOException e) {
            System.err.println("❌ Error writing to file: " + e.getMessage());
        }
    }

    
    // Reads and prints the contents of the file line by line.

    public static void readFromFile() {
        System.out.println("📄 Reading file content:");
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("  " + line);
            }
            System.out.println();
        } catch (IOException e) {
            System.err.println("❌ Error reading file: " + e.getMessage());
        }
    }

    
    // Modifies the file by replacing a target string with a replacement string.
    
    public static void modifyFile(String target, String replacement) {
        try {
            // Read file content into a single string
            String content = new String(Files.readAllBytes(Paths.get(FILE_PATH)));

            // Replace target with replacement
            content = content.replace(target, replacement);

            // Write the modified content back to the file
            Files.write(Paths.get(FILE_PATH), content.getBytes());
            System.out.println("✏️ File modified successfully (replaced '" + target + "' with '" + replacement + "').\n");

        } catch (IOException e) {
            System.err.println("❌ Error modifying file: " + e.getMessage());
        }
    }
}
