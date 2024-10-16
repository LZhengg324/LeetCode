package _539_findMinDifference;

import java.util.Collections;
import java.util.List;

public class _539_findMinDifference {
}

class Solution {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 1440) {
            return 0;
        }
        Collections.sort(timePoints);
        int firstTime = getMinutes(timePoints.get(0));
        int pre_time = firstTime;
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < timePoints.size(); i++) {
            int temp = getMinutes(timePoints.get(i));
            res = Math.min(res, temp - pre_time);
            pre_time = temp;
        }
        res = Math.min(res, firstTime + 1440 - pre_time);
        return res;
    }

    private int getMinutes(String time) {
        return ((time.charAt(0) - '0') * 10 + (time.charAt(1) - '0')) * 60 + ((time.charAt(3) - '0') * 10 + (time.charAt(4) - '0'));
    }
}