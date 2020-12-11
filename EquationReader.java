import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EquationReader {
    private String path;
    private String[] lines;

    public EquationReader(String path) {
        this.path = path;
    }
    
    public void Read() throws FileNotFoundException {
        File file = new File(this.path);
        Scanner scan = new Scanner(file);
        lines = new String[Integer.parseInt(scan.nextLine())];
        for (int i = 0; i < lines.length; i++)
            lines[i] = scan.nextLine();
        scan.close();
    }

    public String[] getLines() {
        return lines.clone();
    }

    public String getPath(){
        return path;
    }
}

/*import java.util.Random;
public class Example {
    public static void main(String[] args) {
            Random rd = new Random(); // creating Random object
            int[] arr = new int[1000];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = rd.nextInt(); // storing random integers in an array
            }
        }
    }*/