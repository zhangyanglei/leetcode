//
//
// 二指输入法定制键盘在 XY 平面上的布局如上图所示，其中每个大写英文字母都位于某个坐标处，例如字母 A 位于坐标 (0,0)，字母 B 位于坐标 (0,1
//)，字母 P 位于坐标 (2,3) 且字母 Z 位于坐标 (4,1)。 
//
// 给你一个待输入字符串 word，请你计算并返回在仅使用两根手指的情况下，键入该字符串需要的最小移动总距离。坐标 (x1,y1) 和 (x2,y2) 之间的
//距离是 |x1 - x2| + |y1 - y2|。 
//
// 注意，两根手指的起始位置是零代价的，不计入移动总距离。你的两根手指的起始位置也不必从首字母或者前两个字母开始。 
//
// 
//
// 示例 1： 
//
// 输入：word = "CAKE"
//输出：3
//解释： 
//使用两根手指输入 "CAKE" 的最佳方案之一是： 
//手指 1 在字母 'C' 上 -> 移动距离 = 0 
//手指 1 在字母 'A' 上 -> 移动距离 = 从字母 'C' 到字母 'A' 的距离 = 2 
//手指 2 在字母 'K' 上 -> 移动距离 = 0 
//手指 2 在字母 'E' 上 -> 移动距离 = 从字母 'K' 到字母 'E' 的距离  = 1 
//总距离 = 3
// 
//
// 示例 2： 
//
// 输入：word = "HAPPY"
//输出：6
//解释： 
//使用两根手指输入 "HAPPY" 的最佳方案之一是：
//手指 1 在字母 'H' 上 -> 移动距离 = 0
//手指 1 在字母 'A' 上 -> 移动距离 = 从字母 'H' 到字母 'A' 的距离 = 2
//手指 2 在字母 'P' 上 -> 移动距离 = 0
//手指 2 在字母 'P' 上 -> 移动距离 = 从字母 'P' 到字母 'P' 的距离 = 0
//手指 1 在字母 'Y' 上 -> 移动距离 = 从字母 'A' 到字母 'Y' 的距离 = 4
//总距离 = 6
// 
//
// 示例 3： 
//
// 输入：word = "NEW"
//输出：3
// 
//
// 示例 4： 
//
// 输入：word = "YEAR"
//输出：7
// 
//
// 
//
// 提示： 
//
// 
// 2 <= word.length <= 300 
// 每个 word[i] 都是一个大写英文字母。 
// 
// Related Topics 字符串 动态规划 👍 69 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class MinimumDistanceToTypeAWordUsingTwoFingers {
    public static void main(String[] args) {
        Solution solution = new MinimumDistanceToTypeAWordUsingTwoFingers().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumDistance(String word) {
            // 初始化
            int[][][] dp = new int[301][26][26];
            for (int i = 1; i <= 300; i++) {
                for (int j = 0; j < 26; j++) {
                    Arrays.fill(dp[i][j], Integer.MAX_VALUE);
                }
            }
            int ans = Integer.MAX_VALUE;
            char[] ca = word.toCharArray();
            // 遍历每个字母
            for (int i = 1; i <= word.length(); i++) {
                int v = ca[i - 1] - 'A';
                // 遍历上一个阶段左指键位
                for (int l = 0; l < 26; l++) {
                    // 遍历上一个阶段右指键位
                    for (int r = 0; r < 26; r++) {
                        // 判断上一个阶段的状态是否存在
                        if (dp[i - 1][l][r] != Integer.MAX_VALUE) {
                            // 移动左指
                            dp[i][v][r] = Math.min(dp[i][v][r], dp[i - 1][l][r] + help(l, v));
                            // 移动右指
                            dp[i][l][v] = Math.min(dp[i][l][v], dp[i - 1][l][r] + help(r, v));
                        }
                        if (i == word.length()) {
                            ans = Math.min(ans, dp[i][v][r]);
                            ans = Math.min(ans, dp[i][l][v]);
                        }
                    }
                }
            }
            return ans;
        }

        // 计算距离
        public int help(int a, int b) {
            int x = a / 6, y = a % 6;
            int x2 = b / 6, y2 = b % 6;
            return Math.abs(x - x2) + Math.abs(y - y2);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
