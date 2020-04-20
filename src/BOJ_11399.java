import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_11399 {
    static int N;
    static ArrayList<Person> people = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            people.add(new Person(i, Integer.parseInt(st.nextToken())));
        }

        Collections.sort(people);

        int sum =0;
        for (int i = 0; i < N; i++) {
            sum += people.get(i).time * (N-i);
        }
        System.out.println(sum);

    }

    static class Person implements Comparable<Person> {
        int no;
        int time;

        public Person(int no, int time) {
            this.no = no;
            this.time = time;
        }

        @Override
        public int compareTo(Person o) {
            if (this.time > o.time) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
