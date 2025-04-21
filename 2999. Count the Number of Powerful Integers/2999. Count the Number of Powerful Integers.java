class Solution {

    public long numberOfPowerfulInt(long start,long finish,int limit,String s) {
        String startStr = Long.toString(start - 1);
        String finishStr= Long.toString(finish);
        return find(finishStr, s, limit) - find(startStr, s, limit);
    }

    public long find(String x, String suffix, int limit) {
        if (x.length() < suffix.length()) {
            return 0;
        }
        if (x.length() == suffix.length()) {
            return x.compareTo(suffix) >= 0 ? 1 : 0;
        }

        String suffixStr = x.substring(x.length() - suffix.length());
        long count = 0;
        int preLen = x.length() - suffix.length();

        for (int i = 0; i < preLen; i++) {
            int digit = x.charAt(i) - '0';
            if (limit < digit) {
                count += (long) Math.pow(limit + 1, preLen - i);
                return count;
            }
            count += (long) (digit) * (long) Math.pow(limit + 1, preLen - 1 - i);
        }
        if (suffixStr.compareTo(suffix) >= 0) {
            count++;
        }
        return count;
    }

    // Brute Force Approach

    // public boolean isValid(String str, int limit, String suffix) {
    //     if (!str.endsWith(suffix))
    //         return false;
    //     for (char ch : str.toCharArray()) {
    //         if ((ch - '0') > limit)
    //             return false;
    //     }
    //     return true;
    // }

    // public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
    //     long count = 0;

    //     for (long i = start; i <= finish; i++) {
    //         String newStr = Long.toString(i);
    //         if (isValid(newStr, limit, s)) {
    //             count++;
    //         }
    //     }
    //     return count;
    // }

}
