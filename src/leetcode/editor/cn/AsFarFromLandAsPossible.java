//你现在手里有一份大小为 n x n 的 网格 grid，上面的每个 单元格 都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，请你找出一个海洋单
//元格，这个海洋单元格到离它最近的陆地单元格的距离是最大的。如果网格上只有陆地或者海洋，请返回 -1。 
//
// 我们这里说的距离是「曼哈顿距离」（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个单元格之间的距离是 |x0 - 
//x1| + |y0 - y1| 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[1,0,1],[0,0,0],[1,0,1]]
//输出：2
//解释： 
//海洋单元格 (1, 1) 和所有陆地单元格之间的距离都达到最大，最大距离为 2。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：grid = [[1,0,0],[0,0,0],[0,0,0]]
//输出：4
//解释： 
//海洋单元格 (2, 2) 和所有陆地单元格之间的距离都达到最大，最大距离为 4。
// 
//
// 
//
// 提示： 
//
// 
//
// 
// n == grid.length 
// n == grid[i].length 
// 1 <= n <= 100 
// grid[i][j] 不是 0 就是 1 
// 
// Related Topics 广度优先搜索 数组 动态规划 矩阵 👍 241 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class AsFarFromLandAsPossible {
    public static void main(String[] args) {
        Solution solution = new AsFarFromLandAsPossible().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int n;
        int[][] g;

        public int maxDistance(int[][] grid) {
            n = grid.length;
            g = grid;
            int ans = -1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (g[i][j] == 0) {
                        ans = Math.max(ans, bfs(i, j));
                    }
                }
            }
            return ans;
        }

        private int bfs(int i, int j) {
            int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            Deque<int[]> deque = new ArrayDeque<>();
            Map<Integer, Integer> map = new HashMap<>();
            deque.add(new int[] {i, j});
            map.put(i * n + j, 0);
            while (!deque.isEmpty()) {
                int[] poll = deque.pollFirst();
                int x = poll[0];
                int y = poll[1];
                int step = map.get(x * n + y);
                if (g[x][y] == 1) {
                    return step;
                }
                for (int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                        continue;
                    }
                    int key = nx * n + ny;
                    if (map.containsKey(key)) {
                        continue;
                    }
                    deque.addLast(new int[] {nx, ny});
                    map.put(key, step + 1);
                }
            }
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
