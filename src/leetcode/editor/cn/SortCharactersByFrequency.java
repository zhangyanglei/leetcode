//给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
//
// 示例 1: 
//
// 
//输入:
//"tree"
//
//输出:
//"eert"
//
//解释:
//'e'出现两次，'r'和't'都只出现一次。
//因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
// 
//
// 示例 2: 
//
// 
//输入:
//"cccaaa"
//
//输出:
//"cccaaa"
//
//解释:
//'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
//注意"cacaca"是不正确的，因为相同的字母必须放在一起。
// 
//
// 示例 3: 
//
// 
//输入:
//"Aabb"
//
//输出:
//"bbAa"
//
//解释:
//此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
//注意'A'和'a'被认为是两种不同的字符。
// 
// Related Topics 哈希表 字符串 桶排序 计数 排序 堆（优先队列） 👍 339 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        Solution solution = new SortCharactersByFrequency().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String frequencySort(String s) {
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            int length = s.length();
            for (int i = 0; i < length; i++) {
                char c = s.charAt(i);
                int frequency = map.getOrDefault(c, 0) + 1;
                map.put(c, frequency);
            }
            List<Character> list = new ArrayList<Character>(map.keySet());
            Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
            StringBuffer sb = new StringBuffer();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                char c = list.get(i);
                int frequency = map.get(c);
                for (int j = 0; j < frequency; j++) {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}
