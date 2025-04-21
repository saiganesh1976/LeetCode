class Solution {
    public static long lowerBond(int[] nums, int limit) {
        int left = 0;
        int right = nums.length - 1;
        long result = 0;
        while (left <= right) {
            int sum = nums[left] + nums[right];
            if (sum < limit) {
                result += (right - left);
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return lowerBond(nums, upper + 1) - lowerBond(nums, lower);

        // int count = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     int sum = 0;
        //     for (int j = 0; j < nums.length; j++) {
        //         if (i < j) {
        //             sum = nums[i] + nums[j];
        //             if (lower <= sum && sum <= upper) {
        //                 count++;
        //             }
        //         }
        //     }
        // }
        // return count;
    }
}
