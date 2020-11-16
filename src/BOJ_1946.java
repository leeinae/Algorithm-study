import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_1946 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        while (testCase-- > 0) {
            int applicant = sc.nextInt();
            ArrayList<Person> person = new ArrayList<>();

            for (int i = 0; i < applicant; i++) {
                int docScore = sc.nextInt();
                int interScore = sc.nextInt();

                person.add(new Person(docScore, interScore));
            }

            Collections.sort(person);

            int count = 1;
            int min = person.get(0).interviewScore;
            for (int i = 1; i < applicant; i++) {
                if (person.get(i).interviewScore < min) {
                    min = person.get(i).interviewScore;
                    count++;
                }
            }

            System.out.println(count);
        }
    }

    static class Person implements Comparable<Person> {
        int docScore;
        int interviewScore;

        public Person(int docScore, int interviewScore) {
            this.docScore = docScore;
            this.interviewScore = interviewScore;
        }

        @Override
        public int compareTo(Person o) {
            return o.docScore > this.docScore ? -1 : 1;
        }
    }
}
