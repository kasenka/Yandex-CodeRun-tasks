package test.some;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Yan2 {
    public static void main(String[] args) throws IOException {
////      ------------------memory
//        Runtime runtime = Runtime.getRuntime();
//        runtime.gc();
//        long memoryBefore = runtime.freeMemory();
////      ------------------time
//        long startTime = System.nanoTime();


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int amount = Integer.parseInt(reader.readLine());

        int[][] data = new int[amount][2];
        for(int i = 0; i < amount; i++){
            data[i] = (Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(str -> Integer.parseInt(str))
                    .toArray());
        }


        List<Double> arrOfErrors = new ArrayList<Double>();
        double allErrors = 0.0;

        for (int[] arr : data) {
            allErrors += (double) (arr[0]/100.0 * arr[1]/100.0);
            arrOfErrors.add((double) (arr[0]/100.0 * arr[1]/100.0));
        }

        for (int i = 0; i < data.length; i++) {
            double value = arrOfErrors.get(i)/allErrors;
            writer.write(String.valueOf(Math.round(value*Math.pow(10,11))/Math.pow(10,11)) + "\n");
        }

        reader.close();
        writer.close();
    }
}