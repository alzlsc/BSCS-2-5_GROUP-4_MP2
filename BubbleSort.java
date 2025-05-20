import java.util.*;

public class BubbleSort {

    public void bubbleSort(int[] arrayElements){

        int arraySize = arrayElements.length;

        for (int i = 0; i < arraySize - 1; i++){
            for (int j = 0; j < arraySize - i - 1; j++){
                if (arrayElements[j] > arrayElements[j + 1]){

                    int intTemp = arrayElements[j];
                    arrayElements[j] = arrayElements[j + 1];
                    arrayElements[j + 1] = intTemp;
                }
            }
        }
    }

    public static void main(String[] args){
        BubbleSort bs = new BubbleSort();
        Scanner scanner = new Scanner(System.in);

        int intSize = 0;

        System.out.println("Enter the size of the array: ");
        intSize = scanner.nextInt();

        int[] intArray = new int[intSize];
        System.out.println("Enter the array elements: ");
        for (int i = 0; i < intSize; i++){
            intArray[i] = scanner.nextInt();
        }

        bs.bubbleSort(intArray);
        System.out.println("\nThe sorted array elements using bubble sort: ");
        for (int i = 0; i < intSize; i++){
            System.out.println(intArray[i]);
        }

        scanner.close();

    }
}