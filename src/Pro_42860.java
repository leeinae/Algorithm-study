public class Pro_42860 {
    public static void main(String[] args) {
        int solution = solution("JAN");
        System.out.println(solution);
    }

    public static int solution(String name) {
        int answer = 0;
        int minMove = name.length()-1; //왼 -> 오로 한 번에 쭉 이동하는 경우

        /*
        * 좌 - 우 이동
        * 다음 번호가 A 일때까지 이동한 거리 count
        * 현재 위치 i + (전체 길이 - 이동 거리) + i
        * */
        for(int i=0; i<name.length(); i++) {
            if(name.charAt(i) != 'A'){
                int next = i+1;
                while (next < name.length() && name.charAt(next) == 'A') {
                    next++;
                }
                int move = i + name.length() - next + i;

                minMove = Math.min(move, minMove);
            }
        }

        /*
        * 위 - 아래 이동
        * 알파벳의 중간 M을 기준으로
        * M보다 작으면 Z - 현재 알파벳
        * M보다 크면 현재 알파벳 - A
        * */
        for(int i=0; i<name.length(); i++) {
            if(name.charAt(i) != 'A') {
                if( name.charAt(i) >= 'M' ) {
                    answer += ('Z' - name.charAt(i) + 1);
                } else {
                    answer += ( name.charAt(i) - 'A');
                }
            }
        }

        return minMove + answer;
    }
}


// 테스트 케이스 8, 10 실패
// 왼쪽 오른쪽 어디도 이동할 필요가 없는 경우 해결 실패!!
// ex) 'AAAAA'
