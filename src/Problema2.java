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
        Integer[] set = {15, 2, 7, 20, 4, 3, 19, 45, 30, 100, 8, 1};
        SortAlgorithm noThreads = new QuickSort();
        SortAlgorithm withThreads = new ThreadsQuickSort();
        long start;
        
        start = System.currentTimeMillis();
        noThreads.Sort(set);
        System.out.println("Single array sorted in "+(System.currentTimeMillis()-start)+" ms");
        if (isSorted(set))
            System.out.println("The array was successfully sorted");
        else
            System.out.println("The array is not sorted");

        set = new Integer[] {15, 2, 7, 20, 4, 3, 19, 45, 30, 100, 8, 1};
        
        start = System.currentTimeMillis();
        withThreads.Sort(set);
        System.out.println("Threaded array sorted in "+(System.currentTimeMillis()-start)+" ms");
        if (isSorted(set))
            System.out.println("The array was successfully sorted");
        else
            System.out.println("The array is not sorted");
    }
}
