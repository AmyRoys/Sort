import java.util.concurrent.*;

public class QuickSort implements Callable<Void> {
    private int[] arr;
    private int low;
    private int high;

    public QuickSort(int[] arr, int low, int high) {
        this.arr = arr;
        this.low = low;
        this.high = high;
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public Void call() {
        if (low < high) {
            int pi = partition(arr, low, high);
            QuickSort left = new QuickSort(arr, low, pi - 1);
            QuickSort right = new QuickSort(arr, pi + 1, high);

            ExecutorService executor = Executors.newFixedThreadPool(2);
            Future<Void> leftResult = executor.submit(left);
            Future<Void> rightResult = executor.submit(right);

            try {
                leftResult.get();
                rightResult.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

            executor.shutdown();
        }
        return null;
    }
}
