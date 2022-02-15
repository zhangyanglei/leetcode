//给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定不同的子数组为好子数组。
//
// （例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。） 
//
// 返回 A 中好子数组的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：A = [1,2,1,2,3], K = 2
//输出：7
//解释：恰好由 2 个不同整数组成的子数组：[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
// 
//
// 示例 2： 
//
// 
//输入：A = [1,2,1,3,4], K = 3
//输出：3
//解释：恰好由 3 个不同整数组成的子数组：[1,2,1,3], [2,1,3], [1,3,4].
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 20000 
// 1 <= A[i] <= A.length 
// 1 <= K <= A.length 
// 
// Related Topics 数组 哈希表 计数 滑动窗口 👍 317 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDifferentIntegers {
    public static void main(String[] args) {
        Solution solution = new SubarraysWithKDifferentIntegers().new Solution();
        int[] nums = new int[] {1, 2, 1, 2, 3};
        int result = solution.subarraysWithKDistinct(nums, 2);
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int subarraysWithKDistinct(int[] nums, int k) {
            int n = nums.length;
            int[] lower = new int[n], upper = new int[n];
            find(lower, nums, k);
            find(upper, nums, k - 1);
            System.out.println(Arrays.toString(lower));
            System.out.println(Arrays.toString(upper));
            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans += upper[i] - lower[i];
            }
            return ans;
        }

        void find(int[] arr, int[] nums, int k) {
            int n = nums.length;
            int[] cnt = new int[n + 1];
            for (int i = 0, j = 0, sum = 0; i < n; i++) {
                int right = nums[i];
                if (cnt[right] == 0) {
                    sum++;
                }
                cnt[right]++;
                while (sum > k) {
                    int left = nums[j++];
                    cnt[left]--;
                    if (cnt[left] == 0) {
                        sum--;
                    }
                }
                arr[i] = j;
            }
        }

        /**
         * 超时
         */
        public int subarraysWithKDistinct2(int[] nums, int k) {
            int result = 0;
            for (int i = 0; i <= nums.length - k; i++) {
                for (int j = k; j <= nums.length - i; j++) {
                    Map<Integer, Integer> countMap = new HashMap<>();
                    int[] windows = Arrays.stream(nums)
                            .skip(i)
                            .limit(j)
                            .toArray();
                    // System.out.println("i=" + i + ",j=" + j + ",array=" + Arrays.toString(windows));
                    for (int window : windows) {
                        Integer count = countMap.getOrDefault(window, 0) + 1;
                        countMap.put(window, count);
                    }
                    if (countMap.keySet().size() == k) {
                        result++;
                    }
                }
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
