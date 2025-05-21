import java.util.*;

public class SequentialSearch {
    public static void main (String[] args){
        Scanner scanner = new Scanner (System.in);
        System.out.println("Enter the size of the array: ");

        int intSize = scanner.nextInt();

        int[] intArray = new int[intSize];
        System.out.println("Enter the array elements: ");

        for (int i = 0; i < intSize; i++){
            intArray[i] = scanner.nextInt();
        }

        int intFound = -1;

        System.out.println("\nEnter the element you want to search: ");
        int intSearchElement = scanner.nextInt();

        for (int i = 0; i < intSize; i++){
            if (intSearchElement == intArray[i]){
                System.out.println("\n"+intSearchElement+" found at index "+i);
                intFound = 1;
                break;
            }
        }

        if (intFound == -1){
            System.out.println("\nElement not found in the array!");

        }
        scanner.close();
    }
}