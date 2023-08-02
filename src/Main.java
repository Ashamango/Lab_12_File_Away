import java.nio.file.Files; // import java.nio.file.Files;
import java.nio.file.Path; // import java.nio.file.Path;
import java.util.ArrayList; // import java.util.ArrayList;
import static java.nio.file.StandardOpenOption.CREATE; // import static java.nio.file.StandardOpenOption.CREATE;
import java.io.BufferedInputStream; // import java.io.BufferedInputStream;
import java.io.BufferedReader; // import java.io.BufferedReader;
import java.io.File; // import java.io.File;
import java.io.FileNotFoundException; // import java.io.FileNotFoundException;
import java.io.IOException; // import java.io.IOException;
import java.io.InputStream; // import java.io.InputStream;
import java.io.InputStreamReader; // import java.io.InputStreamReader;
import java.util.Scanner; // import java.util.Scanner;
import javax.swing.JFileChooser; // import javax.swing.JFileChooser;

public class Main { // class FileAway

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { // main
        JFileChooser chooser = new JFileChooser(); // JFileChooser chooser = new JFileChooser();
        Scanner inFile; // Scanner inFile;
        int lineCount = 0; // num lineCount = 0
        String rec =""; // String rec =""
        int word = 0; // num word = 0
        int characters; // num characters
        int charactersAdd = 0; // num charactersAdd = 0
        int word1; // num word1
        String [] words = new String[lineCount]; // String [] words = new String[lineCount];
        ArrayList<String> lines = new ArrayList<>(); // ArrayList<String> lines = new ArrayList<>();
        Path target = new File(System.getProperty("user.dir")).toPath(); // Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src"); // target = target.resolve("src");

        // set the chooser to be at the project src directory
        chooser.setCurrentDirectory(target.toFile()); // chooser.setCurrentDirectory(target.toFile());

        try  // Any code that might trigger the exception
        {

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) // if a file is chosen (they did not click cancel or exit) then
            {
                target = chooser.getSelectedFile().toPath();  // this is a File object not a String filename

                inFile = new Scanner(target); // inFile = new Scanner(target)

                InputStream in = // InputStream in =
                        new BufferedInputStream(Files.newInputStream(target, CREATE)); // new BufferedInputStream(Files.newInputStream(target, CREATE))
                BufferedReader reader = // BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in)); // new BufferedReader(new InputStreamReader(in))

                while(reader.ready()) // while reader.ready
                {
                    rec = reader.readLine(); // set rec to read the file lines
                    lines.add(rec); // add this to array
                    // lines
                    lineCount++; // keeps count of lines and adds as loop continues

                    // display
                    System.out.printf("\nLine %4d %-60s ", lineCount, rec); // output "\nLine %4d %-60s ", lineCount, rec

                    // characters
                    characters = rec.length(); // set characters to be the length of the word
                    charactersAdd = charactersAdd + characters; // keeps a count of the characters and adds on

                    // number of words
                    String sentence = rec; // String sentence = rec
                        words = sentence.split(" "); // words = sentence.split(" ")
                        word = word + words.length; // keeps a count of the words
                    }

                    System.out.println("\n"); // new line
                    System.out.println("Summary report of file: "); // output Summary report of file:
                    System.out.println("The file that you chose was " + chooser.getSelectedFile()); // output The file that you chose was " + chooser.getSelectedFile()
                    System.out.println("The number of lines in the file is: " + lines.size()); // output "The number of lines in the file is: " + lines.size()
                    System.out.println("The number of words in the file is: " + word); // output The number of words in the file is: " + word
                    System.out.println("The number of characters in the file is: " + charactersAdd); // output "The number of characters in the file is: " + charactersAdd

                inFile.close(); // closes the file
            }
            else   // else the user did not pick a file, close the chooser
            {
                System.out.println("Sorry, you must select a file! Terminating, please run the program again!"); // output "Sorry, you must select a file! Terminating, please run the program again!"
                System.exit(0); // exit
            }
        }
        catch (FileNotFoundException e) // catch (FileNotFoundException e)
        {
            System.out.println("File Not Found Error"); // output File Not Found Error
            e.printStackTrace(); // e.printStackTrace()
        }
        catch (IOException e) // catch (IOException e)
        {
            System.out.println("IOException Error"); // output IOException Error
            e.printStackTrace(); // e.printStackTrace()
        }
    } // return
} // end class
