import java.io.*;
import java.util.*;

public class Pizzeria {

    public static void main(String[] args) {

        try {
            /*
            * File Writer
            * */

            PrintWriter output = new PrintWriter("output/e_example.txt");

            FileReader file = new FileReader ("input/e_many_teams.in");

            BufferedReader buffer = new BufferedReader(file);

            String[] topLine = buffer.readLine().split(" ");

            int numberOfPizzas = Integer.parseInt(topLine[0]);
            int team2s = Integer.parseInt(topLine[1]);
            int team3s = Integer.parseInt(topLine[2]);
            int team4s = Integer.parseInt(topLine[3]);

            int totalTeam = team2s + team3s + team4s;
            Pizza[] pizzas = new Pizza[numberOfPizzas];
            for (int j = 0; j < numberOfPizzas; j++) {
                String[] line = buffer.readLine().split(" ");
                String[] ingredients = new String[line.length -1];
                System.arraycopy(line, 1, ingredients, 0, ingredients.length);
                pizzas[j] = new Pizza(ingredients, j);
            }

            /*
            * The idea is to get the teams available in an array
            * Find the combination of teams that adds up to the number of pizzas available
            * This teams are then given the available pizzas
            * */

            // this gives the total number of people available in the teams
            // this array will be sorted
            int[] arrayOfTeams = new int[totalTeam];

            for (int i = 0; i < totalTeam; i++) {
                if (i < team2s) {
                    arrayOfTeams[i] = 2;
                } else if (i < (team2s + team3s)) {
                    arrayOfTeams[i] = 3;
                } else {
                    arrayOfTeams[i] = 4;
                }
            }


            ArrayList<Integer> sumTeamToPizzaAmount = findNumbersToSum(numberOfPizzas, arrayOfTeams);

            output.println(sumTeamToPizzaAmount.size());

            /*
               To optimise, ensure pizzas with more ingredients are delivered first;
             */

            HashMap<Pizza, Integer> rankedPizzas = rankPizzas(pizzas);
            Pizza[] sortedPizzaList = new Pizza[rankedPizzas.size()];

            int index = 0;
            for (Map.Entry<Pizza, Integer> pizza: rankedPizzas.entrySet() ) {
                sortedPizzaList[index] = pizza.getKey();
                index++;
            }

            for (int el: sumTeamToPizzaAmount) {
                index = 0;
                output.print(el + " ");
                for (int l = 0; l < el; l++) {
                    output.print(sortedPizzaList[index].index + " ");
                    index++;
                }
                output.println();
                Pizza[] leftOverPizzas = Arrays.copyOfRange(sortedPizzaList, index, sortedPizzaList.length);
                rankedPizzas = rankPizzas(leftOverPizzas);
                int count = 0;
                sortedPizzaList = new Pizza[rankedPizzas.size()];
                for (Map.Entry<Pizza, Integer> pizza: rankedPizzas.entrySet() ) {
                    sortedPizzaList[count] = pizza.getKey();
                    count++;
                }
            }
            output.close();


        } catch(Exception e) {
            e.getStackTrace();
            System.out.println(e.getMessage());
        }
    }

    private static ArrayList<Integer> findNumbersToSum( int sumValue, int[] array) {

        int currentSum = 0;
        int currentSumBottom = 0;
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> resultFromBottom = new ArrayList<>();

        for (int value : array) {

            if ((currentSum + value) <= sumValue) {
                result.add(value);
                currentSum += value;
            }
        }

        for (int i = array.length - 1; i >= 0; i--) {
            if ((currentSumBottom + array[i]) <= sumValue) {
                resultFromBottom.add(array[i]);
                currentSumBottom += array[i];
            }
        }

        if (currentSumBottom > currentSum) {
            return resultFromBottom;
        }
        return result;
    }

    private static HashMap<Pizza, Integer> rankPizzas(Pizza[] pizzas) {
        HashSet<String> ingredients = new HashSet<>();

        // first sort the pizza list and let the pizzas with many ingredients be ahead

        Arrays.sort(pizzas, (pizza1, pizza2) -> pizza2.ingredients.length - pizza1.ingredients.length);         // using the compare method

        HashMap<Pizza, Integer> uniquePizzaCount = new HashMap<>();
        for (Pizza pizza: pizzas) {
            int uniqueIngredientCount = 0;
            String[] pizzaIngredients = pizza.ingredients;

            for (String ingredient: pizzaIngredients) {
                if (!ingredients.contains(ingredient)) {
                    uniqueIngredientCount++;
                    ingredients.add(ingredient);
                }
            }
            uniquePizzaCount.put(pizza, uniqueIngredientCount);
        }

        // sort uniquePizzaCount by uniqueIngredientCount;
        return sortMapByValue(uniquePizzaCount);
    }

    private static HashMap<Pizza, Integer> sortMapByValue(HashMap<Pizza, Integer> map) {
        List<Map.Entry<Pizza, Integer>> pizzaList = new LinkedList<>(map.entrySet());
        pizzaList.sort((entry1, entry2) -> (entry2.getValue()).compareTo(entry1.getValue()));       // using the compare method

        HashMap<Pizza, Integer> newPizzaMap = new LinkedHashMap<>();
        for (Map.Entry<Pizza, Integer> entry : pizzaList) {
            newPizzaMap.put(entry.getKey(), entry.getValue());
        }
        return newPizzaMap;
    }
}

class Pizza {
    String[] ingredients;
    int index;

    Pizza(String[] pizzaIngredients, int index) {
        this.ingredients = pizzaIngredients;
        this.index = index;
    }
}