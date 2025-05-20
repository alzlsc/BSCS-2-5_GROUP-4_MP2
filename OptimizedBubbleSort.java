import java.util.*;

public class OptimizedBubbleSort {

    public void optimizedBubbleSort(int[] arrayElements){

        int arraySize = arrayElements.length;

        int intFirstElement = 0;
        int intLastElement = arraySize - 1;
        boolean boolSwapped = true;

        while (boolSwapped){
            boolSwapped = false;

            for (int i = intFirstElement; i < intLastElement; i++){
                if (arrayElements[i] > arrayElements[i + 1]){

                    int intTemp = arrayElements[i];
                    arrayElements[i] = arrayElements[i + 1];
                    arrayElements[i + 1] = intTemp;
                    boolSwapped = true;
                }
            }

            if (!boolSwapped){
                break;
            }

            intLastElement--;

            boolSwapped = false;

            for (int i = intLastElement; i > intFirstElement; i--){
                if (arrayElements[i] < arrayElements[i - 1]){

                    int intTemp = arrayElements[i];
                    arrayElements[i] = arrayElements[i - 1];
                    arrayElements[i - 1] = intTemp;
                    boolSwapped = true;
                }
            }

            if (!boolSwapped){
                break;
            }

            intFirstElement++;
        }
    }    
    public static void main (String[] args){
        OptimizedBubbleSort bs = new OptimizedBubbleSort();
        Scanner scanner = new Scanner(System.in);

        int intSize = 0;

        System.out.println("Enter the size of the array: ");
        intSize = scanner.nextInt();

        int[] intArray = new int[intSize];
        System.out.println("Enter the array elements: ");
        for (int i = 0; i < intSize; i++){
            intArray[i] = scanner.nextInt();
        }

        bs.optimizedBubbleSort(intArray);
        System.out.println("\nThe sorted array elements using the optimized bubble sort: ");
        for (int i = 0; i < intSize; i++){
            System.out.println(intArray[i]);
        }

        scanner.close();
    }
}