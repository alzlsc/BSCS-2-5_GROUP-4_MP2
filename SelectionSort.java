import java.util.*;

public class SelectionSort{

    public void selectionSort(int[] arrayElements){
        int arraySize = arrayElements.length;

        for (int i = 0; i < arraySize - 1; i++){
            int intMinIndex = i;

            for (int j = i + 1; j < arraySize; j++){
                if (arrayElements[j] < arrayElements[intMinIndex]){
                    intMinIndex = j;
                }
            }

            if (intMinIndex != i){
                int intTemp = arrayElements[i];
                arrayElements[i] = arrayElements[intMinIndex];
                arrayElements[intMinIndex] = intTemp;
            }
        }
    }
    public static void main(String[] args){
        SelectionSort ss = new SelectionSort();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of the array you want to sort using Selection Sort: ");
        int intSize =  scanner.nextInt();

        int[] intArray = new int[intSize];
        System.out.println("Enter the array elements: ");

        for (int i = 0; i < intSize; i++){
            intArray[i] = scanner.nextInt();
        }

        ss.selectionSort(intArray);

        System.out.println("The sorted array using Selection Sort is: ");
        for (int i = 0; i < intSize; i++){
            System.out.println(intArray[i]);
        }

        scanner.close();
    }
}