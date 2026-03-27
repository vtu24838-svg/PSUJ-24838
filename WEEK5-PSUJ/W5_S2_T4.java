import java.util.HashSet;

class W5_S2_T4 {//Task4:https://leetcode.com/problems/contains-duplicate
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int n : nums) {
            if (set.contains(n)) return true;
            set.add(n);
        }

        return false;
    }
}
