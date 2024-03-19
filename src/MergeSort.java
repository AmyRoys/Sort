import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] arr, int numThreads) throws InterruptedException {
        if (arr.length <= 1) {
            return;
        }

        int mid = arr.length / 2;

        int[] leftArr = Arrays.copyOfRange(arr, 0, mid);
        int[] rightArr = Arrays.copyOfRange(arr, mid, arr.length);

        Thread leftThread = new Thread(() -> {
            try {
                mergeSort(leftArr, numThreads / 2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread rightThread = new Thread(() -> {
            try {
                mergeSort(rightArr, numThreads / 2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        leftThread.start();
        rightThread.start();

        leftThread.join();
        rightThread.join();

        merge(arr, leftArr, rightArr);
    }

    private static void merge(int[] arr, int[] leftArr, int[] rightArr) {
        int leftIndex = 0, rightIndex = 0, mergedIndex = 0;

        while (leftIndex < leftArr.length && rightIndex < rightArr.length) {
            if (leftArr[leftIndex] <= rightArr[rightIndex]) {
                arr[mergedIndex++] = leftArr[leftIndex++];
            } else {
                arr[mergedIndex++] = rightArr[rightIndex++];
            }
        }

        while (leftIndex < leftArr.length) {
            arr[mergedIndex++] = leftArr[leftIndex++];
        }

        while (rightIndex < rightArr.length) {
            arr[mergedIndex++] = rightArr[rightIndex++];
        }
    }
}
