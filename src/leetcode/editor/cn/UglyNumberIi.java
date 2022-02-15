//给你一个整数 n ，请你找出并返回第 n 个 丑数 。
//
// 丑数 就是只包含质因数 2、3 和/或 5 的正整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：12
//解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
//解释：1 通常被视为丑数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1690 
// 
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 839 👎 0


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class UglyNumberIi {
    public static void main(String[] args) {
        Solution solution = new UglyNumberIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] nums = new int[] {2, 3, 5};

        public int nthUglyNumber(int n) {
            Set<Long> set = new HashSet<>();
            Queue<Long> pq = new PriorityQueue<>();
            set.add(1L);
            pq.add(1L);
            for (int i = 1; i <= n; i++) {
                long x = pq.poll();
                if (i == n) {
                    return (int) x;
                }
                for (int num : nums) {
                    long t = num * x;
                    if (!set.contains(t)) {
                        set.add(t);
                        pq.add(t);
                    }
                }
            }
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
