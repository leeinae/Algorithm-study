public class PRO_43162 {
    class Solution {
        public int solution(int n, int[][] computers) {
            int answer = 0;
            boolean[] visited = new boolean[n];

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    answer++;
                    dfs(visited, i, computers);
                }
            }

            return answer;
        }

        public void dfs(boolean[] visited, int idx, int[][] computers) {
            visited[idx] = true;
            System.out.println(computers.length);
            for (int i = 0; i < computers.length; i++) {
                if (!visited[i] && computers[idx][i] == 1) {
                    dfs(visited, i, computers);
                }
            }
        }
    }
}
