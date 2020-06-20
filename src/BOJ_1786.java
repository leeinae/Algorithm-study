import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_1786 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] text = br.readLine().toCharArray();
        char[] pattern = br.readLine().toCharArray();

        ArrayList<Integer> arr = kmp(text, pattern);

        sb.append(arr.size() + "\n");
        for (int i = 0; i < arr.size(); i++) {
            sb.append(arr.get(i) + 1 + " ");
        }

        System.out.println(sb.toString());
    }

    static int[] makeTable(char[] pattern) {
        int m = pattern.length;
        int j = 0;
        int[] table = new int[m];

        for (int i = 1; i < m; i++) {
            while (j > 0 && pattern[i] != pattern[j]) {
                j = table[j - 1];
            }
            if (pattern[i] == pattern[j]) {
                table[i] = ++j;
            }
        }
        return table;
    }

    static ArrayList<Integer> kmp(char[] text, char[] pattern) {
        ArrayList<Integer> arr = new ArrayList();
        int[] table = makeTable(pattern);
        int m = pattern.length;
        int j = 0;

        for (int i = 0; i < text.length; i++) {
            while (j > 0 && text[i] != pattern[j]) {
                j = table[j - 1];
            }
            if (text[i] == pattern[j]) {
                if (j == pattern.length - 1) {
                    arr.add(i - m + 1);
                    j = table[j];
                } else {
                    j++;
                }
            }
        }

        return arr;
    }
}
