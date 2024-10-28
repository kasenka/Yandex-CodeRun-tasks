package test.some;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;

public class Yan4Schedule {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> daysOfTheWeek = Map.of(
                "Monday", 0,
                "Tuesday", 1,
                "Wednesday", 2,
                "Thursday", 3,
                "Friday", 4,
                "Saturday", 5,
                "Sunday", 6

        );
        StringBuilder month = new StringBuilder();

        String[] input = reader.readLine().split(" ");
        int dayOfTheWeek = daysOfTheWeek.get(input[1]);
        int daysInMonth = Integer.parseInt(input[0]);

        month.append(".. ".repeat(dayOfTheWeek));
        for (int i = 1; i <= daysInMonth; i++) {
            if (i < 10) {
                month.append("." + String.valueOf(i) + " ");
            } else {
                month.append(String.valueOf(i) + " ");
            }
        }

        for (int i = 0; i <= month.length() - 21; i += 21) {
            writer.write(month.substring(i, i + 21) + "\n");
        }
        if (month.length() % 21 != 0) {
            writer.write(month.substring(month.length() - (month.length() % 21)) + "\n");
        }

        reader.close();
        writer.close();
    }
}


