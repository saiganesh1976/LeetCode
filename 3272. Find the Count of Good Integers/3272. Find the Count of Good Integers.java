class Solution {

    public long countGoodIntegers(int n, int k) {
        Set<String> set = new HashSet<>();
        int base = (int) Math.pow(10, (n - 1) / 2);
        int skip = n & 1;
        for (int i = base; i < base * 10; i++) {
            String str = Integer.toString(i);
            str += new StringBuilder(str).reverse().substring(skip);
            long palindromicInteger = Long.parseLong(str);
            if (palindromicInteger % k == 0) {
                char[] ch = str.toCharArray();
                Arrays.sort(ch);
                set.add(new String(ch));
            }
        }

        long[] fact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
        }
        long ans = 0;
        for (String s : set) {
            int[] cnt = new int[10];
            for (char c : s.toCharArray()) {
                cnt[c - '0']++;
            }
            long tot = (n - cnt[0]) * fact[n - 1];
            for (int x : cnt) {
                tot /= fact[x];
            }
            ans += tot;
        }

        return ans;
    }
}
