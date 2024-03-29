import java.util.Random;


public class App {
    public static void main(String[] args) {
        int[] array = generateRandomArray(10000);
        int[] array2 = generateRandomArray(10000);

        System.out.println(" Starting call ");

        long bstartTime = System.currentTimeMillis();
        sortRandomArray(array);
        long bendTime = System.currentTimeMillis();
        
        if (isSorted(array)) {
            System.out.println("ALL Good :- )");
        }
        else 
        {
         System.out.println("SOMETHING FISHY !!!!!!!!!!!!!!!!");
        }
           
        System.out.println("Time taken to merge sort: " + (bendTime - bstartTime) + " milliseconds");
        
        long qstartTime = System.currentTimeMillis();	
        sortRandomArray2(array2);
        long qendTime = System.currentTimeMillis();

        if (isSorted(array2)) {
            System.out.println("ALL Good :- )");
        }
        else 
        {
         System.out.println("SOMETHING FISHY !!!!!!!!!!!!!!!!");
        }
        System.out.println("Time taken to quick sort: " + (qendTime - qstartTime) + " milliseconds");
    }
    

    public static int[] sortRandomArray(int[] inArray) {
        try {
            int numThreads = 4; // Change this to the number of threads you want to use
            MergeSort.mergeSort(inArray, numThreads);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return inArray;
    }

    public static int[] sortRandomArray2(int[] inArray) {
        QuickSort quickSort = new QuickSort(inArray, 0, inArray.length - 1);
        quickSort.call();
        return inArray;
    }


    // Method to generate an array of random numbers
    public static int[] generateRandomArray(int size) {
        System.out.println("Generating an array of " + size + " numbers");
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }
    
    // Method to print an array (for debugging)
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1])
                return false;
        }
        return true;
    }

}