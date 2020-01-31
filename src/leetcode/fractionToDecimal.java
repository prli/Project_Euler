package leetcode;

import java.util.HashMap;

//https://leetcode.com/problems/fraction-to-recurring-decimal/
public class fractionToDecimal {
    public String fractionToDecimal(int n, int d) {
        Long numerator = (long) n;
        Long denominator = (long) d;
        StringBuilder decimalString = new StringBuilder();
        if (numerator < 0 && denominator > 0) {
            decimalString.append("-");
        } else if (numerator > 0 && denominator < 0) {
            decimalString.append("-");
        }
        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);
        decimalString.append(numerator/denominator);
        if (numerator % denominator != 0) {

            decimalString.append(".");
            // deal with the float part
            // key is the remainder, value is the start positon of possible repeat numbers
            HashMap<Long, Integer> map = new HashMap<>();
            Long r = numerator % denominator;
            while (r > 0) {
                if (map.containsKey(r)) {
                    decimalString.insert(map.get(r), "(");
                    decimalString.append(")");
                    break;
                }
                map.put(r, decimalString.length());
                r *= 10;
                decimalString.append(r / denominator);
                r %= denominator;
            }
        }

        return decimalString.toString();
    }
}
