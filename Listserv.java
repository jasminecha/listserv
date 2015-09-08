import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Listserv{
  public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
    System.out.print("What is your filename? ");
    Scanner scan = new Scanner(System.in);
    String filename = scan.next();
    System.out.println(filename);

    File file = new File(filename);
    Scanner readFile = new Scanner(file);

    PrintWriter write = new PrintWriter("lists-compatible.txt", "UTF-8");

    while(readFile.hasNextLine()){
      String info = readFile.nextLine();
      String computingID = info.substring(info.lastIndexOf(',')+1);

      if(!computingID.contains("@")){
        computingID = computingID + "@virginia.edu";
      }

      String name = info.substring(0, info.lastIndexOf(','));
      System.out.println(name);

      String fullLine = computingID + " " + name;
      System.out.println(fullLine);

      write.println(fullLine);
    }
    write.close();
    scan.close();
  }
}
