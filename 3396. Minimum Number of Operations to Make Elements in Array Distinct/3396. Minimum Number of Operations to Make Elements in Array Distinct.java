class Solution {
    public static boolean isNumbersRepeated(int nums[], int start) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

    public int minimumOperations(int[] nums) {
        int count = 0;
        int start = 0;
        while (start < nums.length) {
            if (!isNumbersRepeated(nums, start)) {
                return count;
            }
            count++;
            start += 3;
        }
        return count;
    }
}
