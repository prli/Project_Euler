package leetcode;

//https://leetcode.com/problems/nim-game/
class canWinNim {
    //i go first
    public boolean canWinNim2(int n) {
        if (n >= 1 && n <= 3) {
            return true;
        } else if (n == 4) {
            return false;
        } else {
            return canLoseNim(n - 1) || canLoseNim(n - 2) || canLoseNim(n - 3);
        }
    }

    //friend go first
    public boolean canLoseNim(int n) {
        if (n >= 1 && n <= 3) {
            return false;
        } else if (n == 4) {
            return true;
        } else {
            return canWinNim(n - 1) && canWinNim(n - 2) && canWinNim(n - 3);
        }
    }

    //dp approach
    public boolean canWinNim3(int n) {
        boolean[] canWin = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (i <= 3) {
                canWin[i] = true;
            } else {
                canWin[i] = canWin[i - 1] || canWin[i - 2] || canWin[i - 3];
            }
        }
        return canWin[n - 1];
    }

    //dp approach?
    public boolean canWinNim(int n) {
        return (n % 4 != 0);
    }
}