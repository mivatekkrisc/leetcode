package leecode;

public class Sqrt {

    public int mySqrt(int x) {
        if(x == 0) return 0;

        long hi = x/2 + 1;
        long lo = 0;
        while(lo <= hi) {
            long mid = (hi + lo)/2;
            if(mid * mid == x)
                return (int)mid;
            else if(mid * mid > x)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return (int)hi;
    }

    public static void main(String args[]) {

        Sqrt s = new Sqrt();
        System.out.println(s.mySqrt(2147395599));
        System.out.println(s.mySqrt(4));
        System.out.println(s.mySqrt(8));
        System.out.println(s.mySqrt(15));
        System.out.println(s.mySqrt(1));

    }
}
