import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_7568 {
    static ArrayList<Person> people;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            people.add(new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 1));
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                Person p1 = people.get(i);
                Person p2 = people.get(j);

                if (p1.weight > p2.weight && p1.height > p2.height) {
                    p2.rank++;
                }
            }
        }

        print();
    }

    static void print() {
        for (Person p : people) {
            System.out.print(p.rank + " ");
        }
    }

    static class Person {
        int weight;
        int height;
        int rank;

        public Person(int weight, int height, int rank) {
            this.weight = weight;
            this.height = height;
            this.rank = rank;
        }
    }
}
