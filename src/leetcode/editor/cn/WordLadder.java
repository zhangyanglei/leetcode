//字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列 beginWord -> s1 ->
//s2 -> ... -> sk： 
//
// 
// 每一对相邻的单词只差一个字母。 
// 对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。 
// sk == endWord 
// 
//
// 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 
//中的 单词数目 。如果不存在这样的转换序列，返回 0 。 
// 
//
// 示例 1： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
//"log","cog"]
//输出：5
//解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
// 
//
// 示例 2： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
//"log"]
//输出：0
//解释：endWord "cog" 不在字典中，所以无法进行转换。 
//
// 
//
// 提示： 
//
// 
// 1 <= beginWord.length <= 10 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord、endWord 和 wordList[i] 由小写英文字母组成 
// beginWord != endWord 
// wordList 中的所有字符串 互不相同 
// 
// Related Topics 广度优先搜索 哈希表 字符串 👍 953 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordLadder {
    public static void main(String[] args) {
        Solution solution = new WordLadder().new Solution();
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        int result = solution.ladderLength("hit", "cog", wordList);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        String s, e;
        Set<String> set = new HashSet<>();

        public int ladderLength(String _s, String _e, List<String> ws) {
            s = _s;
            e = _e;
            // 将所有 word 存入 set，如果目标单词不在 set 中，说明无解
            for (String w : ws) {
                set.add(w);
            }
            if (!set.contains(e)) {
                return 0;
            }
            int ans = bfs();
            return ans == -1 ? 0 : ans + 1;
        }

        int bfs() {
            // d1 代表从起点 beginWord 开始搜索（正向）
            // d2 代表从结尾 endWord 开始搜索（反向）
            Deque<String> d1 = new ArrayDeque<>(), d2 = new ArrayDeque();

            /*
             * m1 和 m2 分别记录两个方向出现的单词是经过多少次转换而来
             * e.g.
             * m1 = {"abc":1} 代表 abc 由 beginWord 替换 1 次字符而来
             * m2 = {"xyz":3} 代表 xyz 由 endWord 替换 3 次字符而来
             */
            Map<String, Integer> m1 = new HashMap<>(), m2 = new HashMap<>();
            d1.add(s);
            m1.put(s, 0);
            d2.add(e);
            m2.put(e, 0);

            /*
             * 只有两个队列都不空，才有必要继续往下搜索
             * 如果其中一个队列空了，说明从某个方向搜到底都搜不到该方向的目标节点
             * e.g.
             * 例如，如果 d1 为空了，说明从 beginWord 搜索到底都搜索不到 endWord，反向搜索也没必要进行了
             */
            while (!d1.isEmpty() && !d2.isEmpty()) {
                int t = -1;
                // 为了让两个方向的搜索尽可能平均，优先拓展队列内元素少的方向
                if (d1.size() <= d2.size()) {
                    t = update(d1, m1, m2);
                } else {
                    t = update(d2, m2, m1);
                }
                if (t != -1) {
                    return t;
                }
            }
            return -1;
        }

        // update 代表从 deque 中取出一个单词进行扩展，
        // cur 为当前方向的距离字典；other 为另外一个方向的距离字典
        int update(Deque<String> deque, Map<String, Integer> cur, Map<String, Integer> other) {
            int m = deque.size();
            while (m-- > 0) {
                // 获取当前需要扩展的原字符串
                String poll = deque.pollFirst();
                int n = poll.length();

                // 枚举替换原字符串的哪个字符 i
                for (int i = 0; i < n; i++) {
                    // 枚举将 i 替换成哪个小写字母
                    for (int j = 0; j < 26; j++) {
                        // 替换后的字符串
                        String sub = poll.substring(0, i) + String.valueOf((char) ('a' + j)) + poll.substring(i + 1);
                        if (set.contains(sub)) {
                            // 如果该字符串在「当前方向」被记录过（拓展过），跳过即可
                            if (cur.containsKey(sub) && cur.get(sub) <= cur.get(poll) + 1) {
                                continue;
                            }

                            // 如果该字符串在「另一方向」出现过，说明找到了联通两个方向的最短路
                            if (other.containsKey(sub)) {
                                return cur.get(poll) + 1 + other.get(sub);
                            } else {
                                // 否则加入 deque 队列
                                deque.addLast(sub);
                                cur.put(sub, cur.get(poll) + 1);
                            }
                        }
                    }
                }
            }
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
