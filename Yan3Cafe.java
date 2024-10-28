package test.some;

import java.io.*;
import java.util.HashMap;
import java.util.Map;



public class Yan3Cafe {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int amountOfDays = Integer.parseInt(reader.readLine());

        int[] prices = new int[amountOfDays];
        int sumOfDinners = 0, k1 = 0, k2 = 0, AllK = 0, firstSale = -1;

        for(int i = 0; i < amountOfDays; i++){   // считываем цены + находим цены > 100 + к1 + к2 + сумма
            prices[i] = Integer.parseInt(reader.readLine());
            if (prices[i] > 100) {
                if (k2 == 0){
                    firstSale = i;
                }
                AllK+=1;
            }
            sumOfDinners += prices[i];
        }
        
        int maxMeal = Integer.MIN_VALUE, maxMealIndex = -1,flag = 0;  // для каждой скидки находим выгодную цену

        Map<Integer,Integer> freeMeals = new HashMap<>();


        //  пытаемся найти наибольшее возможное кол-во дней когда можем применить скидку
        if (firstSale >= 0 ){
            for (int k = 0; k < AllK; k++) {
                for (int i = (firstSale + 1); i < prices.length; i++) {
                    if (prices[i] <= 100 && prices[i] > maxMeal) {
                        maxMeal = prices[i];
                        maxMealIndex = i;
                        flag = 1;
                    }
                }
                if (flag == 1) {
                    freeMeals.put(maxMealIndex, maxMeal);
                    prices[maxMealIndex] = Integer.MIN_VALUE;
                    maxMeal = Integer.MIN_VALUE;
                    flag = 0;
                }
            }
        }
        k2 = freeMeals.keySet().size();
        k1 = AllK - freeMeals.keySet().size();
        sumOfDinners -= freeMeals.values().stream().mapToInt(Integer::intValue).sum();
        Integer[] freeMealsSorted = freeMeals.keySet().stream().sorted().map(i -> i+1).toArray(Integer[]::new);

        writer.write(String.valueOf(sumOfDinners) + "\n");
        writer.write(String.valueOf(k1) + " " + String.valueOf(k2) + "\n");
        for(Integer day: freeMealsSorted){
            writer.write(String.valueOf(day) + "\n");
        }

        reader.close();
        writer.close();

    }
}

// 50 60 110   50 70   110   0   0   05 60   101    0   10 90
//99  <101