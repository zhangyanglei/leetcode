//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
// 
// 
// Related Topics 位运算 数组 回溯 👍 728 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetsIi {
    public static void main(String[] args) {
        Solution solution = new SubsetsIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            Set<List<Integer>> ans = new HashSet<>();
            List<Integer> cur = new ArrayList<>();
            dfs(nums, 0, cur, ans);
            return new ArrayList<>(ans);
        }

        /**
         * @param nums 原输入数组
         * @param u 当前决策到原输入数组中的哪一位
         * @param cur 当前方案
         * @param ans 最终结果集
         */
        void dfs(int[] nums, int u, List<Integer> cur, Set<List<Integer>> ans) {            // 所有位置都决策完成，将当前方案放入结果集
            if (nums.length == u) {
                ans.add(new ArrayList<>(cur));
                return;
            }

            // 选择当前位置的元素，往下决策
            cur.add(nums[u]);
            dfs(nums, u + 1, cur, ans);

            // 不选当前位置的元素（回溯），往下决策
            cur.remove(cur.size() - 1);
            dfs(nums, u + 1, cur, ans);

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
