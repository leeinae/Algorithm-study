class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] student = new int[n+1];
        int[] borrow = {-1, 1};

        for ( int i=1; i<=n; i++) {
            student[i] = 1;
        }

        for (int i=0; i<reserve.length; i++) {
            student[reserve[i]] +=1;
        }

        for (int i=0; i<lost.length; i++) {
            student[lost[i]] -=1 ;
        }

        for( int i=0; i< lost.length; i++) {
            if(student[lost[i]] == 0 ) {
                for(int j =0; j<2; j++) {
                    int temp = lost[i] + borrow[j]; //빌려주는 학생 번호
                    if( temp <= 0 || temp > n ) {
                        continue;
                    }

                    if( student[temp] == 2 ) {
                        student[temp] -= 1;
                        student[lost[i]] += 1;
                    }
                }
            }
        }

        for(int i=1; i<=n; i++) {
            if( student[i] != 0) {
                answer++;
            }
        }


        return answer;
    }
}

//다른 풀이 시도
//class Solution {
//    public int solution(int n, int[] lost, int[] reserve) {
//        int answer = 0;
//        int[] student = new int[n+1];
//        int[] borrow = {-1, 1};
//
//        for ( int i=1; i<=n; i++) {
//            student[i] = 1;
//        }
//
//        for (int i : reserve) {
//            student[i] +=1;
//        }
//
//        for (int i : lost) {
//            student[i] -=1 ;
//        }
//
//        for( int i=0; i< lost.length; i++) {
//            if(student[lost[i]] == 0 ) {
//                for(int j =0; j<2; j++) {
//                    int temp = lost[i] + borrow[j]; //빌려주는 학생 번호
//                    if( temp <= 0 || temp > n ) {
//                        continue;
//                    }
//
//                    if( student[temp] == 2 ) {
//                        student[temp] -= 1;
//                        student[lost[i]] += 1;
//                    }
//                }
//            }
//        }
//
//        for(int i=1; i<=n; i++) {
//            if( student[i] != 0) {
//                answer++;
//            }
//        }
//
//
//        return answer;
//    }
//}

/*
* 프로그래머스 그리디 Lv.1_체육복
*
* 그리디 알고리즘
* 현재 상황에서 가장 최적해를 찾고, 조건이 맞으면 그것을 답으로 도출하는 알고리즘.
* 모든 케이스에서 최적해를 도출한다는 보장은 없지만, 특수한 경우에 대해 최적해를 도출할 수 있다.
* */