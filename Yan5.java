package test.some;

import java.io.*;
import java.util.Arrays;

public class Yan5 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        ////      ------------------memory
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memoryBefore = runtime.freeMemory();
////      ------------------time
        long startTime = System.nanoTime();


        int amount = Integer.parseInt(reader.readLine());

        long[][] blocks = new long[amount][2];

        for(int i = 0; i < amount; i++){
            blocks[i] = Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        }
        blocks = Arrays.stream(blocks)
                .sorted((x,y) ->{
                    if (x[0] != y[0]) {
                        return Long.compare( y[0], x[0]);
                    }
                    return Long.compare(y[1], x[1]);
                }).toArray(long[][]::new);

//        for (int[] block: blocks){
//            System.out.print(block[0]);
//            System.out.println(block[1]);
//        }

        if (blocks.length > 0){
            long height = blocks[0][1];
            long curW = blocks[0][0];

            for (int i = 1; i < blocks.length; i++) {
                if (blocks[i][0] < curW){
                    height += blocks[i][1];
                    curW = blocks[i][0];
                }
            }
            writer.write(String.valueOf(height));
        }else{
            writer.write("0");
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Время выполнения: " + duration / 1_000_000_000 + " секунд");

        long memoryAfter = runtime.freeMemory();
        System.out.println("Использованная память: " + (memoryBefore - memoryAfter)/1_048_576 + " Мбайт");

        reader.close();
        writer.close();
    }
}
