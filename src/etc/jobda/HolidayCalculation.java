package etc.jobda;

/**
 * <a href="https://m.jobda.im/info/348">잡다 디챔스 "윤호는 쉬고싶다"</a>
 */
public class HolidayCalculation {
    static int X = 7;

    public static void main(String[] args) {
        System.out.println(solution(X));
    }

    static int[] arr = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static int solution(int X) {
        int answer = 0;
        int[][] cal = new int[32][32];
        int day = X;
        cal[1][1] = X;
        for(int i=1; i<=12; i++) {
            for(int j=1; j<=arr[i-1]; j++) {
                if(day > 7) {
                    day = 1;
                }
                if(cal[i][j] == 0) {
                    cal[i][j] = day++;
                }
            }
        }

        for(int i=1; i<cal.length; i++) {
            for(int j=1; j<cal[i].length; j++) {
                int date = cal[i][j];
                if(date==6 || date==7) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
