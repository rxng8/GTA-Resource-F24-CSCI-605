package JoinExamples;

import java.io.*;

public class MultiThreadedQuickSort {
    private static final int THRESHOLD = 1; // Threshold for switching to single-threaded sort

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java MultiThreadedQuickSort <input_file>");
            return;
        }

        String inputFile = args[0];
        int[] array = readFile(inputFile);
        
        if (array != null) {
            QuickSortThread sorter = new QuickSortThread(array, 0, array.length - 1);
            sorter.start();
            try {
                sorter.join(); // Wait for the sorting thread to finish
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            printArray(array);
        }
    }

    private static int[] readFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            return br.lines().mapToInt(Integer::parseInt).toArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Thread class for Quick Sort
    static class QuickSortThread extends Thread {
        private int[] array;
        private int low;
        private int high;

        public QuickSortThread(int[] array, int low, int high) {
            this.array = array;
            this.low = low;
            this.high = high;
        }

        @Override
        public void run() {
            quickSort(array, low, high);
        }

        private void quickSort(int[] array, int low, int high) {
            if (low < high) {
                int pivotIndex = partition(array, low, high);
                
                if (high - low > THRESHOLD) {
                    // Create new threads for left and right partitions
                    QuickSortThread leftSorter = new QuickSortThread(array, low, pivotIndex - 1);
                    QuickSortThread rightSorter = new QuickSortThread(array, pivotIndex + 1, high);
                    
                    leftSorter.start();
                    rightSorter.start();
                    
                    try {
                        leftSorter.join(); // Wait for left sorting to finish
                        rightSorter.join(); // Wait for right sorting to finish
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    quickSort(array, low, pivotIndex - 1);
                    quickSort(array, pivotIndex + 1, high);
                }
            }
        }

        private int partition(int[] array, int low, int high) {
            int pivot = array[high];
            int i = low - 1;

            for (int j = low; j < high; j++) {
                if (array[j] < pivot) {
                    i++;
                    swap(array, i, j);
                }
            }
            swap(array, i + 1, high);
            return i + 1;
        }

        private void swap(int[] array, int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}

