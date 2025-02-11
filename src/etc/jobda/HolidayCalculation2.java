package etc.jobda;

public class HolidayCalculation2 {
    static int X = 7;
    static int[][] H = {
            {1,1}, {1,21}, {1,22}, {1,23}, {3,1}, {5,5},
            {5,27}, {6,6}, {8,15}, {9,28}, {9,29}, {9,30},
            {10,3}, {10,9}, {12,25}
    };

    public static void main(String[] args) {
        System.out.println(solution(X, H));
    }

    static int[] arr = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static int solution(int X, int[][] H) {
        int answer = 0;
        int[][] cal = new int[13][32]; // [월][일] 형태로 저장
        int day = X;

        // 날짜별 요일 채우기
        for(int i=1; i<=12; i++) {
            for(int j=1; j<=arr[i-1]; j++) {
                cal[i][j] = day;
                day++;
                if (day > 7) {
                    day = 1;
                }
            }
        }

        // 공휴일 처리 (주말이 아닐 경우만 추가)
        for (int[] su : H) {
            int month = su[0], date = su[1];
            if (cal[month][date] != 6 && cal[month][date] != 7) {
                cal[month][date] = 8; // 공휴일을 8로 표시
            }
        }

        // 쉬는 날 카운트 (주말 + 공휴일)
        for (int i=1; i<=12; i++) {
            for (int j=1; j<=arr[i-1]; j++) {
                if (cal[i][j] == 6 || cal[i][j] == 7 || cal[i][j] == 8) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
