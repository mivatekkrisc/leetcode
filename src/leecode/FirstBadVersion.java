package leecode;

import javax.swing.*;

public class FirstBadVersion {

    int badVersion;

    public FirstBadVersion(int badVersion) {
        this.badVersion = badVersion;
    }

    public int firstBadVersion(int n) {

        int lo = 1, hi = n;
        boolean isBad = false;

        while(lo <= hi) {
            int middle = lo + (hi-lo)/2;
            if(isBadVersion(middle) == false)
                lo = middle + 1;
            else
                hi = middle - 1;
        }
        return lo;
    }

    public boolean isBadVersion(int version) {
        return version >= badVersion;
    }

    public static void main(String args[]) {
        FirstBadVersion f = new FirstBadVersion(4);
        System.out.println(f.firstBadVersion(5));

        System.out.println(new FirstBadVersion(2).firstBadVersion(3));
        System.out.println(new FirstBadVersion(1702766719).firstBadVersion(2126753390));
    }
}
