class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (total % 2 != 0) {
            return false;
        }
        int target = total / 2;
        boolean dp[] = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[target];
    }
    // Bruteforce
    // public boolean canPartition(int[] nums) {
    //     int totalSum = 0;
    //     for (int num : nums) {
    //         totalSum += num;
    //     }
    //     if (totalSum % 2 != 0) {
    //         return false;
    //     }
    //     int target = totalSum / 2;

    //     int subsetsLength = (1 << nums.length); // 2^n

    //     for (int i = 0; i < subsetsLength; i++) {
    //         int subsetsSum = 0;
    //         for (int j = 0; j < nums.length; j++) {
    //             if ((i & (1 << j)) != 0) {
    //                 subsetsSum += nums[j];
    //             }
    //         }
    //         if (subsetsSum == target) {
    //             return true;
    //         }
    //     }

    //     return false;
    // }
}
