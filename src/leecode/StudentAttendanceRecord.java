package leecode;

public class StudentAttendanceRecord {

    public boolean checkRecord(String s) {

        int lateCount = 0, absentCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                absentCount++;
                lateCount = 0;
            } else if (s.charAt(i) == 'L') {
                lateCount++;
            } else {
                lateCount = 0;
            }

            if (absentCount >= 2 || lateCount >= 3)
                return false;
        }
        return true;

    }
}
