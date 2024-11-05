package _3181_maxTotalReward;
import java.math.BigInteger;
import java.util.Arrays;

public class _3181_maxTotalReward {

}


class Solution {
    public int maxTotalReward(int[] rewardValues) {
        int n = rewardValues.length;
        Arrays.sort(rewardValues);
        if (n >= 2 && rewardValues[n - 2] == rewardValues[n - 1] - 1) {
            return 2 * rewardValues[n - 1] - 1;
        }
        BigInteger f = BigInteger.ONE;
        for (int x : Arrays.stream(rewardValues).distinct().toArray()) {
            BigInteger mask = BigInteger.ONE.shiftLeft(x).subtract(BigInteger.ONE);
            f = f.or(f.and(mask).shiftLeft(x));
        }
        return f.bitLength() - 1;
    }
}