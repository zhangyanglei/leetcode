//给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
//
// graph[i] 是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点 graph[i][j]存在一条有向边）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：graph = [[1,2],[3],[3],[]]
//输出：[[0,1,3],[0,2,3]]
//解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
// 
//
// 示例 2： 
//
// 
//
// 
//输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
//输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
// 
//
// 
//
// 提示： 
//
// 
// n == graph.length 
// 2 <= n <= 15 
// 0 <= graph[i][j] < n 
// graph[i][j] != i（即不存在自环） 
// graph[i] 中的所有元素 互不相同 
// 保证输入为 有向无环图（DAG） 
// 
//
// 
// Related Topics 深度优先搜索 广度优先搜索 图 回溯 👍 245 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public static void main(String[] args) {
        Solution solution = new AllPathsFromSourceToTarget().new Solution();
        int[][] graph = new int[][] {{1, 2}, {3}, {3}, {}};
        solution.allPathsSourceTarget(graph);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<Integer> curPath = new ArrayList<>();
        List<List<Integer>> path = new ArrayList<>();

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            curPath.add(0);
            dfs(graph, graph.length, 0);
            return path;
        }

        private void dfs(int[][] graph, int length, int curIndex) {
            if (curIndex == length - 1) {
                path.add(new ArrayList<>(curPath));
                return;
            }
            for (int i : graph[curIndex]) {
                curPath.add(i);
                dfs(graph, length, i);
                curPath.remove(curPath.size() - 1);
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}
