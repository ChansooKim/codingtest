package level2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * packageName    : level2
 * fileName       : generator
 * author         : KimChansoo
 * date           : 24. 8. 2.
 * description    : goorm level3
 * @see <a href="https://level.goorm.io/exam/195695/%EB%B0%9C%EC%A0%84%EA%B8%B0-2/quiz/1">발전기(2)</a>
 * @see <a href="https://tussle.tistory.com/1072">풀이</a>
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 8. 2.       KimChansoo       최초 생성
 */
class generator2 {

    //상하좌우 y 변경값
    static int[] dr = {-1, 1, 0, 0};
    //상하좌우 x 변경값
    static int[] dc = {0, 0, -1, 1};
    //집 위치 관련 정보 클래스
    static class Pos{
        //r : y좌표
        //c : x좌표
        int r, c;
        //기본 생성자
        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        //입력값 저장
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] town = new int[M][M];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                town[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //마을 단지 확인 여부 배열
        boolean[][] visited = new boolean[M][M];
        //단지 개수 배열
        int[] complexCnt = new int[31];
        //BFS 탐색 진행
        for(int i=0;i<M;i++){
            for(int j=0;j<M;j++){
                //이미 단지에 속하는지 탐색한 집일 때
                if(visited[i][j]){
                    continue;
                }
                //BFS탐색으로 단지 개수 더하기
                complexCnt[town[i][j]] += search(i, j, town, visited, M, K);

            }
        }
        //단지 개수 최대값 변수
        int max = 0;
        //단지 개수 최대값 관련 유형 변수
        int result = 0;
        //단지 개수 최대값 유형 구하기
        for(int i=1;i<31;i++){
            if(complexCnt[i] == 0){
                continue;
            }
            if(complexCnt[i] >= max){
                max = complexCnt[i];
                result = i;
            }
        }
        //단지 최대값 유형 BufferedWriter 저장
        bw.write(String.valueOf(result));
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }

    //BFS을 이용하여 상하좌우 같은 집 탐색하여 단지 구분하는 함수
    static int search(int r, int c, int[][] town, boolean[][] visited, int M, int K){
        //BFS에 사용할 Queue
        Queue<Pos> queue = new ArrayDeque<>();
        //초기 집 저장
        queue.offer(new Pos(r, c));
        //초기 집 단지 탐색 확인
        visited[r][c] = true;
        int cnt = 1;
        //BFS 탐색 진행
        while(!queue.isEmpty()){
            Pos cur=  queue.poll();
            //인접한 상하좌우 집 탐색
            for(int i=0;i<4;i++){
                int tempR = cur.r + dr[i];
                int tempC = cur.c + dc[i];
                //마을에 존재하고, 방문하지 않았으며, 초기 유형과 같은 유형일 때
                if(inSpace(tempR,tempC, M) && !visited[tempR][tempC] && town[tempR][tempC] == town[r][c]){
                    //인접한 집 Queue 저장
                    queue.offer(new Pos(tempR, tempC));
                    visited[tempR][tempC] = true;
                    cnt++;		//집 개수 증가
                }
            }
        }

        //집의 개수가 K보다 작으면 올바르 단지로 인식 X
        if(cnt < K){
            return 0;
        }else{		//집의 개수가 K이상일 때 올바른 단지 O
            return 1;
        }

    }
    //인접한 집이 마을 내에 존재하는지 확인하는 함수
    static boolean inSpace(int r, int c, int M){
        //마을 내 존재하는 집일 때
        if(r >= 0 && r < M && c >= 0 && c < M){
            return true;
        }
        return false;
    }
}
