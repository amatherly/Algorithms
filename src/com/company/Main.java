package com.company;


public class Main {

    public static void main(String[] args) {
////        int[] arr = {5, 7, 1, 3, 2, 9, 0, 4};
//        int[] sortedArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//
//
//        int[] bigSortedArr = new int[1000];
//        for (int i = 0; i < bigSortedArr.length; i++) {
//            bigSortedArr[i] = i;
//        }
//        int[] longUnsortedArr = new int[100];
//        for (int i = 0; i < 100; i++) {
//            longUnsortedArr[i] = (int) (Math.random() * 1000) + 0;
//        }
//
////        System.out.println(binarySearch(sortedArr, 7));
//        mergeSort(longUnsortedArr);
//        int[] randSortedArr = new int[longUnsortedArr.length];
//        for (int i = 0; i < randSortedArr.length; i++) {
//            randSortedArr[i] = longUnsortedArr[i];
//        }
//        int value = randSortedArr[10];
//
//        recursiveBinarySearch(randSortedArr, value, randSortedArr.length / 2, randSortedArr.length);


        int[] arr1 = {5, 7, 1, 0, 2, 9};
        int[] arr2 = {8, 6, 4, 3, 7};
        mergeTwoUnsortedArr(arr1, arr2);
    }

    public static int binarySearch(int[] arr, int value) {
        int mid = arr.length / 2;
        int end = arr.length - 1;
        while (true) {
            if (arr[mid] == value) {
                break;
            }
            if (mid == end || mid == 0) {
                System.out.println("Value not found");
                return -1;
            } else if (arr[mid] < value) {
                mid = (end - mid + 1) / 2 + mid;
            } else {
                end = mid - 1;
                mid = (mid / 2);
            }
        }
        return arr[mid];
    }

    /*
    returns the index of the passed value after searching a sorted array recursively
     */
    public static int recursiveBinarySearch(int[] arr, int value, int mid, int end) {
        if (arr[mid] == value) {
            System.out.print("Index of value (" + value + "): " + mid);
            return mid;
        }
        if (mid == end || mid == 0 || value > arr[end - 1] || value < arr[0]) {
            System.out.println("Value not found");
            return -1;
        } else if (arr[mid] < value) {
            mid = ((end - mid) / 2) + mid;
            return recursiveBinarySearch(arr, value, mid, end);
        } else {
            end = mid;
            mid = (mid / 2);
            return recursiveBinarySearch(arr, value, mid, end);
        }

    }

    public static void mergeSort(int[] arr) {
        int counter = 0;
        while (true) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int bubble = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = bubble;
                    counter = 0;
                } else {
                    counter++;
                }
                if (counter == arr.length) {
//                    for (int j = 0; j < arr.length; j++) {
//                        System.out.print(arr[j] + " ");
//                    }
//                    System.out.println();
                    return;
                }
            }
        }
    }

    public static int[] mergeTwoUnsortedArr(int[] arr1, int[] arr2) {

        int[] sorted = new int[arr2.length + arr1.length];

        for (int i = 0; i < arr1.length; i++) {
            sorted[i] = arr1[i];
        }
        int j = 0;
        for (int i = arr1.length; i < sorted.length; i++) {
            sorted[i] = arr2[j];
            j++;
        }

        int counter = 0;
        while (true) {
            for (int i = 0; i < sorted.length - 1; i++) {
                if (sorted[i] > sorted[i + 1]) {
                    int bubble = sorted[i];
                    sorted[i] = sorted[i + 1];
                    sorted[i + 1] = bubble;
                    counter = 0;
                } else {
                    counter++;
                }
                if (counter == sorted.length) {
                    for (int x = 0; x < sorted.length; x++) {
                        System.out.print(sorted[x] + " ");
                    }
                    System.out.println();
                    return sorted;
                }
            }
        }
    }

}
