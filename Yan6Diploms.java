package test.some;

import java.io.*;
import java.util.Arrays;

public class Yan6Diploms {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        long[] input = Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long w = input[0],h = input[1],n = input[2];

        long minS = (long) Math.ceil(Math.sqrt(w * h * n)), maxS = h * n;

        long mean = 0;
        while (minS < maxS){
            mean = minS + (maxS - minS) / 2;
            long valueInLine = mean / w, lines = mean / h;
            if (valueInLine * lines < n) {
                minS = mean + 1;
            }
            else{
                maxS = mean;
            }
        }
        writer.write(String.valueOf(minS));

        reader.close();
        writer.close();
    }
}
