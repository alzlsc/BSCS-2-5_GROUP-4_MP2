import java.util.*;

public class OptimizedSequentialSearch{

    public List<Integer> optimizedSequentialSearchAll(int[] arrayElements, int intTarget){
        int arraySize = arrayElements.length;
        int intMid = arraySize / 2;
        List<Integer> listResultIndices = new ArrayList<>();

        for (int i = 0; i < intMid; i += 2){
            if (arrayElements[i] == intTarget){
                listResultIndices.add(i);
            } else if (i + 1 < intMid && arrayElements[i + 1] == intTarget){
                listResultIndices.add(i + 1);
            }
        }

        for (int i = intMid; i < arraySize; i += 2){
            if (arrayElements[i] == intTarget){
                listResultIndices.add(i);
            } else if (i + 1 < arraySize && arrayElements[i + 1] == intTarget){
                listResultIndices.add(i + 1);
            }
        }

        return listResultIndices;
    }

    public static void main (String[] args){
        OptimizedSequentialSearch oss = new OptimizedSequentialSearch();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of the array: ");
        int intSize = scanner.nextInt();

        int[] intArray = new int[intSize];
        System.out.println("Enter the array elements: ");
        for (int i = 0; i < intSize; i++){
            intArray[i] = scanner.nextInt();
        }

        System.out.println("\nEnter the element you want to search: ");
        int intSearchElement = scanner.nextInt();

        List<Integer> listFoundIndices = oss.optimizedSequentialSearchAll(intArray, intSearchElement);

        if (!listFoundIndices.isEmpty()){
            System.out.print(intSearchElement + " is found at index");
            if (listFoundIndices.size() > 1) System.out.print("es");
            System.out.print(": ");
            for (int i = 0; i < listFoundIndices.size(); i++){
                System.out.print(listFoundIndices.get(i));
                if (i < listFoundIndices.size() - 1) System.out.print(", ");
            }
            System.out.println();
        } else {
            System.out.println(intSearchElement + " is not found");
        }

        scanner.close();
    }
}
