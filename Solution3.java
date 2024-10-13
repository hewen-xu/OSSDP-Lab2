import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution3 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);

        // 第 1 步：动态规划找出最大子集的个数、最大子集中的最大整数
        int[] dp = new int[len];
        Arrays.fill(dp, 1);  // 每个元素自身是一个子集
        int maxSize = 1;  // 记录最大子集的大小
        int maxValIndex = 0;  // 记录最大子集最后一个元素的索引

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                // 题目中说「没有重复元素」很重要
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxValIndex = i;
            }
        }

        // 第 2 步：倒推获得最大子集
        List<Integer> res = new ArrayList<>();
        int currentMaxVal = nums[maxValIndex];
        int currentSize = maxSize;

        for (int i = maxValIndex; i >= 0; i--) {
            if (dp[i] == currentSize && currentMaxVal % nums[i] == 0) {
                res.add(nums[i]);
                currentMaxVal = nums[i];
                currentSize--;
            }
        }

        return res;
    }

}

