import java.io.*;
import java.util.*;

public class BOJ_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> listen = new HashSet<>();
        HashSet<String> see = new HashSet<>();

        for (int i = 0; i < n; i++) {
            listen.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            see.add(br.readLine());
        }

        listen.retainAll(see);
        List<String> answer = new ArrayList<>(listen);

        System.out.println(answer.size());
        answer.stream().sorted().forEach(System.out::println);
    }
}
