package _2215_findDifference;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class _2215_findDifference {
}

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set_1 = new HashSet<>();
        Set<Integer> set_2 = new HashSet<>();

        for (int j : nums1) {
            set_1.add(j);
        }

        for (int j : nums2) {
            set_2.add(j);
        }

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for (int i : set_1) {
            if (!set_2.contains(i)) {
                list1.add(i);
            }
        }

        for (int i : set_2) {
            if (!set_1.contains(i)) {
                list2.add(i);
            }
        }
        return new ArrayList<List<Integer>>(){{add(list1); add(list2);}};
    }
}