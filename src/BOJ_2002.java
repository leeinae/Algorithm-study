import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_2002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> input = new HashMap<>();
        String[] output = new String[n];

        for (int i = 0; i < n; i++) {
            input.put(br.readLine(), i);
        }

        for (int j = 0; j < n; j++) {
            output[j] = br.readLine();
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (input.get(output[i]) > input.get(output[j])) {
                    answer++;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
