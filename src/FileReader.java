import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    String path;
    List<String> lines = new ArrayList<String>();

    public FileReader(String path){
        this.path = path;
    }
    
    public Reader(){
        File file = new File(this.path);
        Scanner scan = new Scanner(file);
        String fileContent = "";
        while(scan.hasNextLine()){
            lines.add(scan.nextLine);
        }
    }

    public void setpath(String path) {
        this.nNodes = path;
    }

    public List<String> getlines(){
        return lines;
    }

    public String getpath(){
        return path;
    }
}