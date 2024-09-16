package baekjoon.bronze;

import java.io.IOException;

public class BJ_10989 {
    public static void main(String[] args) throws IOException {
        int N = 0;
        int in = System.in.read();
        while (in > 32) {
            N = (N << 3) + (N << 1) + (in & 15);
            in = System.in.read();
        }
        byte[] buf = new byte[N * 9];
        int idx = -1;
        System.in.read(buf, 0, buf.length);
        int[] table = new int[10001];
        while (--N != -1) {
            int num = 0;
            while (buf[++idx] > 32)
                num = (num << 3) + (num << 1) + (buf[idx] & 15);
            ++table[num];
        }
        idx = 0;
        for (int i = 0; i <= 10000; i++)
            if (table[i] > 0) {
                int len;
                if (i < 10)
                    len = 1;
                else if (i < 100)
                    len = 2;
                else if (i < 1000)
                    len = 3;
                else if (i < 10000)
                    len = 4;
                else
                    len = 5;
                int num = i;
                for (int loc = idx + len - 1; loc != idx - 1; loc--) {
                    buf[loc] = (byte)((num % 10) + '0');
                    num /= 10;
                }
                buf[idx + len] = '\n';
                for (int j = 0; j <= len; j++)
                    for (int k = 1; k < table[i]; k++)
                        buf[idx + k * (len + 1) + j] = buf[idx + j];
                idx += table[i] * (len + 1);
            }

        System.out.write(buf, 0, idx);
    }
}
