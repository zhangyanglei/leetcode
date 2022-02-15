//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 👍 1975 👎 0


package leetcode.editor.cn;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        solution.longestCommonPrefix(new String[] {"flower", "flow", "flight"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            String ans = "";
            if (strs.length == 0) {
                return ans;
            }
            for (int i = 0; i < 200; i++) {
                String str = strs[0];
                if (i >= str.length()) {
                    return ans;
                }
                char c = str.charAt(i);
                for (String s : strs) {
                    if (i >= s.length() || s.charAt(i) != c) {
                        return ans;
                    }
                }
                ans += c;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
