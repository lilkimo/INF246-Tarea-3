
import java.util.Random;

public class Problema2 {
    static void printArray(Integer[] array) { 
        int n = array.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(array[i]+" "); 
        System.out.println(); 
    }

    static boolean isSorted(Integer[] array) {
        Integer last = array[0];
        for (int i = 1; i < array.length; i++) {
            if (last > array[i])
                return false;
            last = array[i];
        }
        return true;
    }

    public static void main(String[] args) {
        Random rd = new Random(); // creating Random object
        Integer[] set = new Integer[10000];
        Integer[] set2 = new Integer[10000];
        for (int i = 0; i < set.length; i++) {
            set[i] = rd.nextInt(); // storing random integers in an array
            set2[i] = set[i];
        }
        SortAlgorithm noThreads = new QuickSort();
        SortAlgorithm withThreads = new ThreadsQuickSort();
        long start;
        
        start = System.currentTimeMillis();
        noThreads.Sort(set);
        System.out.println("Single array sorted in " + (System.currentTimeMillis() - start) + " ms");
        if (isSorted(set))
            System.out.println("The array was successfully sorted");
        else
            System.out.println("The array is not sorted");

        start = System.currentTimeMillis();
        withThreads.Sort(set2);
        System.out.println("Threaded array sorted in " + (System.currentTimeMillis() - start) + " ms");
        if (isSorted(set2))
            System.out.println("The array was successfully sorted");
        else
            System.out.println("The array is not sorted");
    }
}
