public class ThreadsQuickSort extends Thread implements SortAlgorithm {
    private Integer low, high;
    private Integer[] array;

    public ThreadsQuickSort() {
        ;
    }
    
    public ThreadsQuickSort(Integer[] array, Integer low, Integer high) {
        this.array = array;
        this.low = low;
        this.high = high;
    }

    public void run() {
        Sort(array, low, high);
    }

    public void Sort(Integer[] array) {
        Sort(array, 0, array.length - 1);
    }

    private void Sort(Integer[] array, Integer low, Integer high) {
        if (low < high) {
            Integer pivot = partition(array, low, high);
            ThreadsQuickSort lowQSort = new ThreadsQuickSort(array, low, pivot - 1);
            lowQSort.start();
            ThreadsQuickSort highQSort = new ThreadsQuickSort(array, pivot + 1, high);
            highQSort.start();
            try {
                lowQSort.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                highQSort.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Integer partition(Integer[] array, Integer low, Integer high) {
        Integer pivot = array[high];  
        Integer i = (low-1);
        for (Integer j=low; j<high; j++) 
            if (array[j] < pivot) { 
                i++; 
                Integer temp = array[i]; 
                array[i] = array[j]; 
                array[j] = temp; 
            } 

        Integer temp = array[i+1]; 
        array[i+1] = array[high]; 
        array[high] = temp; 

        return i+1; 
    }
}
