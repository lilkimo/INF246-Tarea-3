import java.util.List;

public class MyThread extends Thread {

    private List <String> funciones;
    private Integer nHebra;
    
    public MyThread(List<String> funciones, Integer nHebra){
        this.funciones = funciones;
        this.nHebra = nHebra;
    }
    public void run(){
        
    }
}
