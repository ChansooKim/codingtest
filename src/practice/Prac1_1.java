package practice;

public class Prac1_1 {

    public static void main(String[] args) {
        System.out.println("max4 (1,2,3,4)" + max4(1,2,3,4));
        System.out.println("max4 (4,2,5,1)" + max4(4,2,5,1));
        System.out.println("med3 (1,3,5)" + med3(1,3,5));
        System.out.println("med3 (1,9,6)" + med3(1,9,6));
    }

    static int max4(int a, int b, int c, int d) {
        int max = a;

        if(b > max) {
            max = b;
        }
        if(c > max) {
            max = c;
        }
        if(d > max) {
            max = d;
        }
        return max;
    }

    static int med3(int a, int b, int c) {
        if(a >= b) {
            if(a <= c) {
                return a;
            } else if(b >= c) {
                return b;
            } else {
                return c;
            }
        } else if(a > c) {
            return a;
        } else if(b > c) {
            return c;
        } else {
            return b;
        }
    }

}
