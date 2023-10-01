import java.util.Arrays;
import java.util.Scanner;

class AllSort {

    AllSortAns basicSort(int[] arr) {
        AllSortAns allSortAns = new AllSortAns();
        long startTime = System.nanoTime();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        long endTime = System.nanoTime();
        long executionTime = (endTime - startTime);
        allSortAns.setName("Basic Sort");
        allSortAns.setTime(executionTime);
        allSortAns.setSortedArray(arr);
        return allSortAns;
    }

    AllSortAns bubbleSort(int[] arr) {
        AllSortAns allSortAns = new AllSortAns();
        long startTime = System.nanoTime();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        long endTime = System.nanoTime();
        long executionTime = (endTime - startTime);
        allSortAns.setName("Bubble Sort");
        allSortAns.setTime(executionTime);
        allSortAns.setSortedArray(arr);
        return allSortAns;
    }

    AllSortAns selectionSort(int[] arr) {
        AllSortAns allSortAns = new AllSortAns();
        long startTime = System.nanoTime();
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minPos]) {
                    minPos = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minPos];
            arr[minPos] = temp;
        }
        long endTime = System.nanoTime();
        long executionTime = (endTime - startTime);
        allSortAns.setName("Selection Sort");
        allSortAns.setSortedArray(arr);
        allSortAns.setTime(executionTime);
        return allSortAns;
    }

    AllSortAns insertionSort(int[] arr) {
        AllSortAns allSortAns = new AllSortAns();
        long startTime = System.nanoTime();
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > curr) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = curr;
        }
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        allSortAns.setName("Insertion Sort");
        allSortAns.setTime(executionTime);
        allSortAns.setSortedArray(arr);
        return allSortAns;
    }

    AllSortAns countingSort(int[] arr) {
        AllSortAns allSortAns = new AllSortAns();
        long startTime = System.nanoTime();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int[] count = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        allSortAns.setName("Counting Sort");
        allSortAns.setTime(executionTime);
        allSortAns.setSortedArray(arr);
        return allSortAns;
    }

    void printArr(AllSortAns[] allSortAnsArr) {
        for (int i = 0; i < allSortAnsArr.length; i++) {
            System.out
                    .println(allSortAnsArr[i].getName() + " " + Arrays.toString(allSortAnsArr[i].getsortedArray()) + " "
                            + allSortAnsArr[i].getTime());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = { 5, 4, 1, 3, 2 };
        AllSort allSort = new AllSort();
        AllSortAns[] allSortAnsArr = new AllSortAns[5];

        int[] arrCopy1 = Arrays.copyOf(arr, arr.length);
        int[] arrCopy2 = Arrays.copyOf(arr, arr.length);
        int[] arrCopy3 = Arrays.copyOf(arr, arr.length);
        int[] arrCopy4 = Arrays.copyOf(arr, arr.length);
        int[] arrCopy5 = Arrays.copyOf(arr, arr.length);

        allSortAnsArr[0] = allSort.basicSort(arrCopy1);
        allSortAnsArr[1] = allSort.bubbleSort(arrCopy2);
        allSortAnsArr[2] = allSort.selectionSort(arrCopy3);
        allSortAnsArr[3] = allSort.insertionSort(arrCopy4);
        allSortAnsArr[4] = allSort.countingSort(arrCopy5);

        allSort.printArr(allSortAnsArr);
    }
}