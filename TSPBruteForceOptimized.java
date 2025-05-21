import java.util.*;

public class TSPBruteForceOptimized {

    static List<String> cities = new ArrayList<>();
    static int[][] cityDis;
    static int minDis = Integer.MAX_VALUE;
    static int[] bestRoute;
    static int startCityIndex = 0;

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.print("\n> Mabuhay! Ilang syudad ang nais mong ilagay? ");
        int numCities = userInput.nextInt();
        userInput.nextLine();

        cityDis = new int[numCities][numCities];

        System.out.println("> Pangalanan ang mga siyudad na ilalagay:");
        for(int i = 0; i < numCities; i++) {
            System.out.print("  City " + i + ": ");
            cities.add(userInput.nextLine());
        }

        System.out.println("\n> Ilagay ang distansya sa pagitan ng bawat pares ng siyudad:");
        for(int i = 0; i < numCities; i++) {
            for (int j = i + 1; j < numCities; j++) {
                System.out.print("  Distansya mula " + cities.get(i) + " sa " + cities.get(j) + ": ");
                int distance = userInput.nextInt();
                cityDis[i][j] = cityDis[j][i] = distance;
            }
        }
        userInput.nextLine(); 

        System.out.println("\n> Mga koneksyon:");
        for(int i = 0; i < numCities; i++) {
            for(int j = i + 1; j < numCities; j++) {
                if(cityDis[i][j] > 0) {
                    System.out.println("  " + cities.get(i) + " --> " + cities.get(j) + ": " + cityDis[i][j]);
                }
            }
        }

        System.out.print("\n> Ilagay ang pangalan ng panimulang siyudad: ");
        String startCity = userInput.nextLine();
        startCityIndex = cities.indexOf(startCity);

        if(startCityIndex == -1) {
            System.out.println("> Engk! Maling ngalan. Gagamitin ang unang siyudad bilang panimula.");
            startCityIndex = 0;
        }

        int[] arr = new int[numCities - 1];
        for(int i = 0, j = 0; i < numCities; i++) {
            if (i != startCityIndex) arr[j++] = i;
        }

        System.out.println("\n> Hinahanap ang pinaka-mabisang ruta...");

        bestRouteEvaluated(arr, 0);

        System.out.println("\n> Pinaka-mabisang ruta ay nahanap! (Optimal route Found!)");
        System.out.println("> Kabuuang distansya: " + minDis);
        System.out.print("  Ruta: " + cities.get(startCityIndex) + " -> ");
        for(int idx : bestRoute) {
            System.out.print(cities.get(idx) + " -> ");
        }
        System.out.println(cities.get(startCityIndex));
    }

    static void bestRouteEvaluated(int[] arr, int start) {
        if(start == arr.length - 1) {
            int totalDis = 0;
            int current = startCityIndex;
            for(int next : arr) {
                int d = cityDis[current][next];
                if (d == 0) return;
                totalDis += d;
                current = next;
            }

            int returnDis = cityDis[current][startCityIndex];
            if(returnDis == 0) return;
            totalDis += returnDis;

            if(totalDis < minDis) {
                minDis = totalDis;
                bestRoute = Arrays.copyOf(arr, arr.length);
            }
            return;
        }

        for(int i = start; i < arr.length; i++) {
            swap(arr, i, start);
            bestRouteEvaluated(arr, start + 1);
            swap(arr, i, start);
        }
    }

    static void swap(int[] arr, int i, int j){
        if (i == j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
