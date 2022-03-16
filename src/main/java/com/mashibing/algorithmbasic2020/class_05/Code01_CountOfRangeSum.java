package com.mashibing.algorithmbasic2020.class_05;

public class Code01_CountOfRangeSum {

    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        long[] sum = new long[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        return process(sum, 0, sum.length - 1, lower, upper);
    }

    public int process(long[] sum, int l, int r, int lower, int upper) {
        if (l == r) {
            return sum[l] <= upper && sum[l] >= lower ? 1 : 0;
        }
        int mid = l + ((r - l) >> 1);
        return process(sum, l, mid, lower, upper) + process(sum, mid + 1, r, lower, upper)
                + merge(sum, l, mid, r, lower, upper);
    }

    public int merge(long[] sum, int l, int mid, int r, int lower, int upper) {
        int ans = 0;
        int windowL = l;
        int windowR = l;
        for (int i = mid + 1; i <= r; i++) {
            long min = sum[i] - upper;
            long max = sum[i] - lower;
            while (sum[windowR] <= max && windowR <= mid) {
                windowR++;
            }
            while (sum[windowL] < min && windowL <= mid) {
                windowL++;
            }
            ans += windowR - windowL;
        }
        long[] help = new long[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            help[i++] = sum[p1] <= sum[p2] ? sum[p1++] : sum[p2++];
        }
        while (p1 <= mid) {
            help[i++] = sum[p1++];
        }
        while (p2 <= r) {
            help[i++] = sum[p2++];
        }
        for (i = 0; i < help.length; i++) {
            sum[l + i] = help[i];
        }
        return ans;
    }
}
