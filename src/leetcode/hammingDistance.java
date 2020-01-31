package leetcode;

//https://leetcode.com/problems/hamming-distance/
class hammingDistance {
    public int hammingDistance(int x, int y) {
        //convert to bit in string form (keep divide by 2 for bit?)
        //iterate bit by bit and compare and tally
        int count = 0;
        for (int i = 31; i >= 0; i--) {
            double pow = Math.pow(2, i);
            boolean xBit = x / pow >= 1;
            boolean yBit = y / pow >= 1;
            if (xBit) {
                x = (int) (x - pow);
            }
            if (yBit) {
                y = (int) (y - pow);
            }
            if (xBit != yBit) {
                count++;
            }
        }

        return count;

    }
}