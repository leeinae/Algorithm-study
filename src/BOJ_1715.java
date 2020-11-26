import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class BOJ_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> card = new PriorityQueue<>();
        LinkedList<Integer> acc = new LinkedList<>();

        for (int i = 0; i < num; i++) {
            card.add(Integer.parseInt(br.readLine()));
        }

        while (card.size() >= 2) {
            int c1 = card.poll();
            int c2 = card.poll();

            acc.add(c1 + c2);
            card.add(c1 + c2);
        }

        int answer = 0;
        for (int n : acc) {
            answer += n;
        }

        System.out.println(answer);
    }
}