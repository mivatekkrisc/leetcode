package leecode;

public class FibonacciNum {


    public int fib(int N) {

        if (N == 0 || N == 1) return N;

        int[] result = new int[N + 1];
        result = new int[N + 1];
        result[0] = 0;
        result[1] = 1;

        for (int n = 2; n <= N; n++)
            result[n] = result[n - 1] + result[n - 2];

        return result[N];
    }

    public static void main(String args[]) {
        FibonacciNum f = new FibonacciNum();
        System.out.println(new FibonacciNum().fib(3));
        System.out.println(new FibonacciNum().fib(4));
    }
}
