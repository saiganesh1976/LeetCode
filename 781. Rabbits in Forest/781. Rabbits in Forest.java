class Solution {
    public int numRabbits(int[] answers) {

        int result = 0;
        int count[] = new int[1000];

        for (int num : answers) {
            if (++count[num] == 1) {
                result += num + 1;
            }
            if (count[num] == num + 1) {
                count[num] = 0;
            }
        }
        return result;
        // HashMap<Integer, Integer> map = new HashMap<>();

        // for (int num : answers) {
        //     map.put(num, map.getOrDefault(num, 0) + 1);
        // }
        // int totalRabbits = 0;
        // for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        //     int x = entry.getKey();
        //     int count = entry.getValue();

        //     int groupSize = x + 1;
        //     int groups = (count + groupSize - 1) / groupSize;
        //     totalRabbits += groups * groupSize;
        // }
        // return totalRabbits;
    }
}
