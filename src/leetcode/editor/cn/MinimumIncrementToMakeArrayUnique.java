//给你一个整数数组 nums 。每次 move 操作将会选择任意一个满足 0 <= i < nums.length 的下标 i，并将 nums[i] 递增 1
//。 
//
// 返回使 nums 中的每个值都变成唯一的所需要的最少操作次数。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：1
//解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,2,1,7]
//输出：6
//解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
//可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。 
// 
// 
//
// 
//提示：
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁵ 
// 
// Related Topics 贪心 数组 计数 排序 👍 199 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class MinimumIncrementToMakeArrayUnique {
    public static void main(String[] args) {
        Solution solution = new MinimumIncrementToMakeArrayUnique().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minIncrementForUnique(int[] nums) {
            Arrays.sort(nums);
            int ans = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] <= nums[i - 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i - 1] + 1;
                    ans += nums[i] - temp;
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
