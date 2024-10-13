public class Test {
    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {1, 2, 4, 8};

        System.out.println(solution.largestDivisibleSubset(nums1)); // 输出 [1, 2] 或 [1, 3]
        System.out.println(solution.largestDivisibleSubset(nums2)); // 输出 [1, 2, 4, 8]
    }
}
