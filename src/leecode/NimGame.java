package leecode;

public class NimGame {

    public boolean canWinNim(int n) {
        return n % 4 != 0;
//        return canWin(n, true);
    }

    public static void main(String args[]) {
        NimGame n = new NimGame();
        System.out.println(n.canWinNim(8));
    }
}
