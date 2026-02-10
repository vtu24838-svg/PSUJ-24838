class W5_S1_T1 {//MAXIMUM SUB ARRAY --> LEETCODE - 53
    public int maxSubArray(int[] nums) {
        int curr = nums[0];
        int max = nums[0];
        for(int i=1; i<nums.length; i++){
            curr = Math.max(curr + nums[i], nums[i]);
            max = Math.max(curr, max);
        }
        return max;
    }
}