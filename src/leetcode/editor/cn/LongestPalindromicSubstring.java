//给你一个字符串 s，找到 s 中最长的回文子串。
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 👍 4506 👎 0


package leetcode.editor.cn;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        solution.longestPalindrome("babad");
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome2(String s) {
            String ans = "";
            // 偶数
            for (int i = 0; i < s.length(); i++) {
                int l = i - 1;
                int r = i + 1 - 1;
                String str = genStr(s, l, r);
                if (str.length() > ans.length()) {
                    ans = str;
                }
                l = i - 1;
                r = i + 1;
                str = genStr(s, l, r);
                if (str.length() > ans.length()) {
                    ans = str;
                }
            }
            return ans;
        }

        public String longestPalindrome(String s) {
            if (s.length() == 1) {
                return s;
            }
            char[] chars = manacherString(s);
            int n = chars.length;
            int[] pArr = new int[n];
            int C = -1;
            int R = -1;
            int pos = -1;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                pArr[i] = i < R ? Math.min(pArr[C * 2 - i], R-i) : 1;
                while (i + pArr[i] < n && i - pArr[i] > -1) {
                    if (chars[i + pArr[i]] == chars[i - pArr[i]]) {
                        pArr[i]++;
                    } else {
                        break;
                    }
                }
                if (i + pArr[i] > R) {
                    R = i + pArr[i];
                    C = i;
                }
                if (pArr[i] > max) {
                    max = pArr[i];
                    pos = i;
                }
            }
            StringBuilder sb = new StringBuilder();
            int offset = pArr[pos];
            for (int i = pos - offset + 1; i <= pos + offset - 1; i++) {
                if (chars[i] != '#') {
                    sb.append(chars[i]);
                }
            }
            return sb.toString();
        }

        private String genStr(String s, int l, int r) {
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            return s.substring(l + 1, r);
        }

        private char[] manacherString(String s) {
            char[] chars = new char[s.length() * 2 + 1];
            for (int i = 0, idx = 0; i < chars.length; i++) {
                chars[i] = (i % 2 == 0) ? '#' : s.charAt(idx++);
            }
            return chars;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
