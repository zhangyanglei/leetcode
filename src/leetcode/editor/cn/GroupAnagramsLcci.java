//编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
//
// 注意：本题相对原题稍作修改 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 排序 
// 👍 64 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagramsLcci {
    public static void main(String[] args) {
        Solution solution = new GroupAnagramsLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> result = new HashMap<>();
            for (String str : strs) {
                byte[] strBytes = str.getBytes();
                Arrays.sort(strBytes);
                String target = new String(strBytes);
                List<String> targetList = result.getOrDefault(target, new ArrayList<>());
                targetList.add(str);
                result.put(target, targetList);
            }
            List<List<String>> resultList = new ArrayList<>();
            result.forEach((k, v) -> {
                resultList.add(v);
            });
            return resultList;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
