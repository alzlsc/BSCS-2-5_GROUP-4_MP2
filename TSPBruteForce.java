import java.util.*;
public class TSPBruteForce {

    static List<String> cities = new ArrayList<>();
    static int[][] cityDis;                                 // cityDistances
    static int minDis = Integer.MAX_VALUE;                  // minDistances
    static List<Integer> bestRoute = new ArrayList<>();
    static int startCityIndex = 0;

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.print("\n> Mabuhay! Ilang syudad ang nais mong ilagay? ");
        int numCities = userInput.nextInt();
        userInput.nextLine();

        cityDis = new int[numCities][numCities];

        System.out.print("> Pangalanan ang mga siyudad na ilalagay: \n");
        for(int i = 0; i < numCities; i++) {
            System.out.print("City " + i + ": ");
            cities.add(userInput.nextLine());
        }

        System.out.println("\nMga Syudad na Iniliagay: ");
        for(int i = 0; i < numCities; i++) {
            System.out.println((i + 1) + ". " + cities.get(i) + " City");
        }

        String userChoice = "";
        do{
            System.out.println("\nIlagay ang koneksyon ng mga syudad, sa pamamagitan ng kanilang distansya!");
            System.out.print("> Ilagay ang ngalan ng unang siyudad: ");
            String city1 = userInput.nextLine();
            int city1Index = cities.indexOf(city1);

            if(city1Index == -1) {
                System.out.println("> Oops! Maling ngalan ang nailagay sa unang siyudad. Maaring  ulitin muli!.");
                continue;
            }

            System.out.print("> Ilagay ang ngalan ng pangalawang siyudad: ");
            String city2 = userInput.nextLine();
            int city2Index = cities.indexOf(city2);

            if(city2Index == -1) {
                System.out.println("> Oops! Maling ngalan ang nailagay sa pangalawang siyudad. Maaring  ulitin muli!.");
                continue;
            }

            System.out.print("> Anong distansya ng siyudad " + city1 + " at " + city2 + "? ");
            int distance = userInput.nextInt();
            userInput.nextLine();

            cityDis[city1Index][city2Index] = distance;
            cityDis[city2Index][city1Index] = distance;

            System.out.print("\n> Gusto mo bang mag lagay ng panibagong koneksyon? (oo/hindi): ");
            userChoice = userInput.nextLine();
        } while(userChoice.equalsIgnoreCase("oo"));

        // Display all connections
        System.out.println("\nKabuuan ng mga siyudad na may koneksyon sa isa't isa:");
        for(int i = 0; i < numCities; i++) {
            for(int j = i + 1; j < numCities; j++) {
                if(cityDis[i][j] != 0) {
                    System.out.println(cities.get(i) + " --> " + cities.get(j) + ": " + cityDis[i][j]);
                }
            }
        }

        System.out.println("\n> Note: The city connections are biderectional, so the distance from A to B is the same as from B to A.");

        System.out.print("\n> Pumili ng umpisa at dulong siyudad: ");
        String startCity = userInput.nextLine();
        startCityIndex = cities.indexOf(startCity);

        if(startCityIndex == -1) {
            System.out.println("> Engk! Maling ngalan ng siyudad. Idederakta sa unang siyudad.");
            startCityIndex = 0;
        }

        System.out.println("\n> Kasalukuyang hinahanap ang pinaka mabisang ruta... Maaaring tumagal ito ng ilang sandali.");
        List<Integer> cityIndices = new ArrayList<>();
        for(int i = 0; i < numCities; i++) {
            if (i != startCityIndex) {
                cityIndices.add(i);
            }
        }

        bestPossibleRoute(cityIndices, 0);

        System.out.println("\n> Nakahanap na ang pinaka mabisang ruta (Optimal Route Found)!\n> Kabuuang Pinaka maikling Distansya (Total Minimum Distance): " + minDis);
        System.out.print("         = " + cities.get(startCityIndex) + " -> ");
        for(int index : bestRoute) {
            System.out.print(cities.get(index) + " -> ");
        }
        System.out.println(cities.get(startCityIndex) + "\n");
    }

    static void bestPossibleRoute(List<Integer> arr, int start) {
        if(start == arr.size() - 1) {
            List<Integer> fullRoute = new ArrayList<>();
            fullRoute.add(startCityIndex);                          

            fullRoute.addAll(arr);
            int currentDis = routeDistance(fullRoute);      // currentDistance
            if(currentDis != -1 && currentDis < minDis) {
                minDis = currentDis;    
                bestRoute = new ArrayList<>(arr);
            }
            return;
        }

        for(int i = start; i < arr.size(); i++) {
            Collections.swap(arr, i, start);
            bestPossibleRoute(arr, start + 1);
            Collections.swap(arr, i, start);
        }
    }

    static int routeDistance(List<Integer> route) {                             
        int sumDis = 0;                                                                // sumDistance
        for(int i = 0; i < route.size() - 1; i++) {
            int distance = cityDis[route.get(i)][route.get(i + 1)];
            if(distance == 0) return -1;
            sumDis += distance;
        }

        int returnDis = cityDis[route.get(route.size() - 1)][route.get(0)];     // returnDistance
        if(returnDis == 0) return -1;
        sumDis += returnDis;
        return sumDis;
    }
}

