import java.util.*;

public class BOJ_15903 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Long> card = new PriorityQueue();

        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            card.offer(sc.nextLong());
        }

        for (int i = 0; i < m; i++) {
            long c1 = card.poll();
            long c2 = card.poll();

            card.offer(c1 + c2);
            card.offer(c1 + c2);
        }

        long answer = 0;
        while(!card.isEmpty()) {
            answer += card.poll();
        }

        System.out.println(answer);
    }
}
