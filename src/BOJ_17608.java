import java.util.Scanner;
import java.util.Stack;

public class BOJ_17608 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        int num = sc.nextInt();

        for (int i = 1; i <= num; i++) {
            int temp = sc.nextInt();

            while (!stack.empty() && isVisible(stack, temp)) {
                stack.pop();
            }
            stack.push(temp);
        }

        System.out.println(stack.size());
    }

    // 현재 막대기의 길이가 stack의 top에 들어있는 막대기보다 크거나 같아서
    // 왼쪽에서 봤을 때 막대기가 보이는지 여부를 리턴하는 함수
    public static boolean isVisible(Stack stack, int temp) {
        int top = (int) stack.peek();

        return temp >= top;
    }
}
