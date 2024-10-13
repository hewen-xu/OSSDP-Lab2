import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

/**
 * 测试类命名规则：L2022211822_solution3_Test.java
 *
 * 测试用例设计原则：
 * 1. **等价类划分**：将输入划分为不同的等价类，确保每个等价类至少有一个测试用例。例如，输入较小、较大的整除子集情况。
 * 2. **边界值分析**：测试集合的最小和最大值，例如空数组或包含一个元素的数组。
 * 3. **功能覆盖**：确保对 `largestDivisibleSubset` 方法的功能逻辑有充分的覆盖。
 *
 * 测试目标：测试 `Solution3` 类的 `largestDivisibleSubset` 方法的正确性，确保其能返回最大整除子集。
 */
public class L2022211822_solution3_Test {

    /**
     * 测试目的：验证基础功能，输入包含常规的整除关系。
     * 用例：nums = [1, 2, 3]
     */
    @Test
    public void testBasicCase() {
        Solution3 solution = new Solution3();
        int[] nums = {1, 2, 3};
        List<Integer> result = solution.largestDivisibleSubset(nums);
        // 预期结果可能是 [1, 2] 或 [1, 3]
        assertTrue(result.contains(1) && (result.contains(2) || result.contains(3)));
    }

    /**
     * 测试目的：验证极限情况，输入为所有元素可以整除的最大子集。
     * 用例：nums = [1, 2, 4, 8]
     */
    @Test
    public void testMaxDivisibleSubset() {
        Solution3 solution = new Solution3();
        int[] nums = {1, 2, 4, 8};
        List<Integer> result = solution.largestDivisibleSubset(nums);
        // 预期结果为 [1, 2, 4, 8]
        assertEquals(List.of(1, 2, 4, 8), result);
    }

    /**
     * 测试目的：验证边界值情况，输入仅包含一个元素。
     * 用例：nums = [7]
     */
    @Test
    public void testSingleElement() {
        Solution3 solution = new Solution3();
        int[] nums = {7};
        List<Integer> result = solution.largestDivisibleSubset(nums);
        // 预期结果为 [7]
        assertEquals(List.of(7), result);
    }

    /**
     * 测试目的：验证空数组情况。
     * 用例：nums = []
     */
    @Test
    public void testEmptyArray() {
        Solution3 solution = new Solution3();
        int[] nums = {};
        List<Integer> result = solution.largestDivisibleSubset(nums);
        // 预期结果为空数组
        assertTrue(result.isEmpty());
    }

    /**
     * 测试目的：验证无整除关系的输入集合。
     * 用例：nums = [5, 7, 11]
     */
    @Test
    public void testNoDivisibleSubset() {
        Solution3 solution = new Solution3();
        int[] nums = {5, 7, 11};
        List<Integer> result = solution.largestDivisibleSubset(nums);
        // 预期结果可以是任意单个元素 [5] 或 [7] 或 [11]
        assertTrue(result.size() == 1 && (result.contains(5) || result.contains(7) || result.contains(11)));
    }
}
