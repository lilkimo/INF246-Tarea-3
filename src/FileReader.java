import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    private String path;
    private List<String> lines = new ArrayList<String>();

    public FileReader(String path) {
        this.path = path;
    }
    
    public void Read() throws FileNotFoundException {
        File file = new File(this.path);
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine())
            lines.add(scan.nextLine());
        scan.close();
    }

    public List<String> getLines(){
        return lines;
    }

    public String getPath(){
        return path;
    }
}