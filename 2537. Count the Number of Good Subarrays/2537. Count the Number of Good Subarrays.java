class Solution {

    // public static int countPairs(HashMap<Integer, Integer> count) {
    //     int pairCount = 0;
    //     for (int freq : count.values()) {
    //         if (freq > 1) {
    //             pairCount += freq * (freq - 1) / 2;
    //         }
    //     }
    //     return pairCount;
    // }

    public long countGood(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int n = nums.length;
        int pair = 0;
        int left = 0;
        long goodPairs = 0;

        for (int right = 0; right < n; right++) {
            int currentFreq = count.getOrDefault(nums[right], 0);
            pair += currentFreq;
            count.put(nums[right], currentFreq + 1);


            //Shrinking the Window
            while (pair >= k) {
                goodPairs += n - right; 
                int leftFreq = count.get(nums[left]);
                pair -= (leftFreq - 1); 
                count.put(nums[left], leftFreq - 1);
                left++;
            }
        }
        return goodPairs;

        // bruteForce
        // long count = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     HashMap<Integer, Integer> map = new HashMap<>();
        //     int pairCount = 0;
        //     for (int j = i; j < nums.length; j++) {
        //         int num = nums[j];
        //         int prevFreq = map.getOrDefault(num, 0);
        //         pairCount += prevFreq;
        //         map.put(num, prevFreq + 1);
        //         if (pairCount >= k) {
        //             count ++;
        //         }
        //     }
        // }
        // return count;
    }
}
