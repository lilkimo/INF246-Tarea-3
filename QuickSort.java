public class QuickSort implements SortAlgorithm {
    public void Sort(Integer[] array) {
        Sort(array, 0, array.length-1);
    }

    private void Sort(Integer[] array, Integer low, Integer high) {
        if (low < high) {
            Integer pivot = partition(array, low, high);
            Sort(array, low, pivot-1);
            Sort(array, pivot+1, high);
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
