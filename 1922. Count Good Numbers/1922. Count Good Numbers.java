class Solution {
    public static int MOD = 1000000007;

    public static long pow(long base, long exp) {
        long result = 1;
        base = base % MOD;

        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp = exp / 2;
        }
        return result;
    }

    public int countGoodNumbers(long n) {

        long evenPos = (n + 1) / 2;
        long oddPos = n / 2;

        long evenWays = pow(5, evenPos);
        long oddWays = pow(4, oddPos);
        return (int) ((evenWays * oddWays) % MOD);
    }
}
