import java.util.*;

public class OptimizedSelectionSort{

    public void optimizedSelectionSort(int[] arrayElements){
        int intStart = 0, intEnd = arrayElements.length - 1;

        while (intStart < intEnd){
            int minIndex = intStart, maxIndex = intStart;
            boolean boolSwapped = false;

            for (int i = intStart; i <= intEnd; i++) {
                if (arrayElements[i] < arrayElements[minIndex]){
                    minIndex = i;
                } 
                if (arrayElements[i] > arrayElements[maxIndex]){
                    maxIndex = i;
                }
            }

            if (minIndex != intStart) {
                int intTemp = arrayElements[intStart];
                arrayElements[intStart] = arrayElements[minIndex];
                arrayElements[minIndex] = intTemp;
                boolSwapped = true;

                if (maxIndex == intStart){
                    maxIndex = minIndex;
                }
            }

            if (maxIndex != intEnd) {
                int intTemp = arrayElements[intEnd];
                arrayElements[intEnd] = arrayElements[maxIndex];
                arrayElements[maxIndex] = intTemp;
                boolSwapped = true;
            }

            if (!boolSwapped) {
                break;
            }

            intStart++;
            intEnd--;
        }
    }
    public static void main (String[] args){
        OptimizedSelectionSort oss = new OptimizedSelectionSort();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of the array you want to sort using oOtimized Selection Sort: ");
        int intSize =  scanner.nextInt();

        int[] intArray = new int[intSize];
        System.out.println("Enter the array elements: ");

        for (int i = 0; i < intSize; i++){
            intArray[i] = scanner.nextInt();
        }

        oss.optimizedSelectionSort(intArray);

        System.out.println("The sorted array using the Optimized Selection Sort is: ");
        for (int i = 0; i < intSize; i++){
            System.out.println(intArray[i]);
        }

        scanner.close();
    }
}