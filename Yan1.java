package test.some;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Yan1 {

    public static void main(String[] args) throws IOException {
//      ------------------memory
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memoryBefore = runtime.freeMemory();
//      ------------------time
        long startTime = System.nanoTime();


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int amount = Integer.parseInt(reader.readLine());
        int[] nums = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(str -> Integer.parseInt(str))
                .sorted()
                .toArray();

        Map<Integer,Integer> counter = new HashMap<>();
        Arrays.stream(nums).forEach(num -> counter.put(num,counter.getOrDefault(num, 0) + 1));

        int result = 0;
        for (Integer num: counter.keySet()){
            result = (counter.get(num) == 1) ? result + 1 : result;
        }

        writer.write(String.valueOf(result));


        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Время выполнения: " + duration / 1_000_000_000 + " секунд");

        long memoryAfter = runtime.freeMemory();
        System.out.println("Использованная память: " + (memoryBefore - memoryAfter)/1_048_576 + " Мбайт");


        reader.close();
        writer.close();
    }
}
