import java.util.Random;


public class App {
    public static void main(String[] args) {
        int[] array = generateRandomArray(1000);
        int[] array2 = generateRandomArray(1000);

        System.out.println(" Starting call ");

        long startTime = System.currentTimeMillis();
        sortRandomArray(array);
        long endTime = System.currentTimeMillis();
        
        if (isSorted(array)) {
            System.out.println("ALL Good :- )");
        }
        else 
        {
         System.out.println("SOMETHING FISHY !!!!!!!!!!!!!!!!");
        }
           
        System.out.println("Time taken to bubble sort: " + (endTime - startTime) + " milliseconds");
        System.out.println("Time taken to quick sort: " + (endTime - startTime) + " milliseconds");
    }
    

    public static int[] sortRandomArray(int[] inArray) {
        BubbleSort bubbleSort = new BubbleSort(inArray, 0, inArray.length);
        bubbleSort.run();
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