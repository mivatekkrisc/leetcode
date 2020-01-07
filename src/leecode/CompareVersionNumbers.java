package leecode;

public class CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {
        if (version1.length() == 0 && version2.length() == 0) return 0;
        else if (version1.length() == 0) return -1;
        else if (version2.length() == 0) return 1;


        int localResult1 = 0, localResult2 = 0;
        int index1 = 0, index2 = 0;

        while (index1 < version1.length() || index2 < version2.length()) {

            while (index1 < version1.length() && version1.charAt(index1) != '.') {
                localResult1 *= 10;
                localResult1 += version1.charAt(index1) - '0';
                index1++;
            }
            index1++; //skip .

            while (index2 < version2.length() && version2.charAt(index2) != '.') {
                localResult2 *= 10;
                localResult2 += version2.charAt(index2) - '0';
                index2++;
            }
            index2++;

            if (localResult1 != localResult2)
                return localResult1 < localResult2 ? -1 : 1;

            localResult1 = 0;
            localResult2 = 0;

        }
        if (localResult1 == localResult2)
            return 0;
        else
            return localResult1 < localResult2 ? -1 : 1;

    }

    public static void main(String args[]) {

        CompareVersionNumbers c = new CompareVersionNumbers();
        System.out.println(c.compareVersion("0.1", "1.1"));
        System.out.println(c.compareVersion("1.0.1", "1"));
        System.out.println(c.compareVersion("7.5.2.4", "7.5.3"));
        System.out.println(c.compareVersion("1.01", "1.001"));
        System.out.println(c.compareVersion("1.0","1.0.0"));

    }
}
