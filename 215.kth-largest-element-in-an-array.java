
import javax.crypto.KDF;

/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 *
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 *
 * algorithms
 * Medium (68.43%)
 * Likes:    18269
 * Dislikes: 955
 * Total Accepted:    3.2M
 * Total Submissions: 4.7M
 * Testcase Example:  '[3,2,1,5,6,4]\n2'
 *
 * Given an integer array nums and an integer k, return the k^th largest
 * element in the array.
 * 
 * Note that it is the k^th largest element in the sorted order, not the k^th
 * distinct element.
 * 
 * Can you solve it without sorting?
 * 
 * 
 * Example 1:
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * Example 2:
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= k <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        //若数组升序排列，最后一位是最大的数字。第k大的数组再length-k
        int target=nums.length-k;
        int right=nums.length-1;
        int left=0;
        while(left<=right){
            //查找位置
            int tmpSolution=partionSort(left,right,nums);
            if(tmpSolution==target){
                return nums[target];
            }
            else if(tmpSolution<target){
                left=tmpSolution+1;
            }else{
                right=tmpSolution-1;
            }
        }
        return -1;
    }
    public int partionSort(int left,int right,int[] nums){
        int mark=nums[left];
        int i=left+1;
        int j=right;
        while(i<=j){
            //寻找左侧大于等于mark的第一个元素
            while(i<=j&&nums[i]<mark){
                i++;
            }
            //寻找右侧小于等于mark的第一个元素
            while(i<=j&&nums[j]>mark){
                j--;
            }
            //i>j时，j的位置小于target，i的位置大于j
            if(i>=j){
                break;
            }
            int tmp=nums[i];
            nums[i]=nums[j];
            nums[j]=tmp;
            i++;
            j--;
        }
        nums[left]=nums[j];
        nums[j]=mark;
        return j;
    }
}
// @lc code=end

