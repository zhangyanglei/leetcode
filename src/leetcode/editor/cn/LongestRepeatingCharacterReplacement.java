//给定一个字符串 s 和一个整数 k 。您可以选择字符串中的任意字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。
//
// 在执行上述操作后，返回 包含相同字母的最长子字符串的长度 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ABAB", k = 2
//输出：4
//解释：用两个'A'替换为两个'B',反之亦然。
// 
//
// 示例 2： 
//
// 
//输入：s = "AABABBA", k = 1
//输出：4
//解释：
//将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
//子串 "BBBB" 有最长重复字母, 答案为 4。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s 由小写英文字母组成 
// 0 <= k <= s.length 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 551 👎 0


package leetcode.editor.cn;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        Solution solution = new LongestRepeatingCharacterReplacement().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int characterReplacement(String s, int k) {
            char[] cs = s.toCharArray();
            int[] cnt = new int[26];
            int ans = 0;
            for (int l = 0, r = 0; r < s.length(); r++) {
                cnt[cs[r] - 'A']++;
                while (!check(cnt, k)) {
                    cnt[cs[l++] - 'A']--;
                }
                ans = Math.max(ans, r - l + 1);
            }
            return ans;
        }

        boolean check(int[] cnt, int k) {
            int max = 0, sum = 0;
            for (int i = 0; i < 26; i++) {
                max = Math.max(max, cnt[i]);
                sum += cnt[i];
            }
            return sum - max <= k;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
