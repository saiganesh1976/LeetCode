class Solution {
    static class BIT {
        int[] tree;

        BIT(int size) {
            tree = new int[size + 2];
        }

        void update(int index, int value) {
            index++;
            while (index < tree.length) {
                tree[index] += value;
                index += index & -index;
            }
        }

        int query(int index) {
            index++;
            int sum = 0;
            while (index > 0) {
                sum += tree[index];
                index -= index & -index;
            }
            return sum;
        }

        int queryRange(int left, int right) {
            return query(right) - query(left - 1);
        }
    }

    public long optimize(int[] nums1, int[] nums2) {
        int n = nums1.length;

        int[] pos2 = new int[n];
        for (int i = 0; i < n; i++) {
            pos2[nums2[i]] = i;
        }

        int[] mapped = new int[n];
        for (int i = 0; i < n; i++) {
            mapped[i] = pos2[nums1[i]];
        }

        long[] leftSmaller = new long[n];
        BIT bit1 = new BIT(n);
        for (int i = 0; i < n; i++) {
            leftSmaller[i] = bit1.query(mapped[i] - 1); // count of values < mapped[i]
            bit1.update(mapped[i], 1);
        }

        long[] rightGreater = new long[n];
        BIT bit2 = new BIT(n);
        for (int i = n - 1; i >= 0; i--) {
            rightGreater[i] = bit2.query(n - 1) - bit2.query(mapped[i]); // count of values > mapped[i]
            bit2.update(mapped[i], 1);
        }

        long count = 0;
        for (int i = 0; i < n; i++) {
            count += leftSmaller[i] * rightGreater[i];
        }

        return count;
    }

    public static long BruteForce(int[] nums1, int[] nums2) {
        int count = 0;
        int[] pos2 = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            pos2[nums2[i]] = i;
        }
        for (int i = 0; i < nums1.length; i++) {
            int x = nums1[i];
            for (int j = i + 1; j < nums1.length; j++) {
                int y = nums1[j];
                for (int k = j + 1; k < nums1.length; k++) {
                    int z = nums1[k];
                    if (pos2[x] < pos2[y] && pos2[y] < pos2[z]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public long goodTriplets(int[] nums1, int[] nums2) {
        //  return BruteForce(nums1, nums2);
        return optimize(nums1, nums2);
    }
}
