
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (37.62%)
 * Likes:    43187
 * Dislikes: 2111
 * Total Accepted:    8.2M
 * Total Submissions: 21.8M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string s, find the length of the longest substring without duplicate
 * characters.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not
 * a substring.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= s.length <= 5 * 10^4
 * s consists of English letters, digits, symbols and spaces.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result=0;
        if(s.length()==0){
            return result=0;
        }
        result=1;
        int right=1;
        for(int i=0;i<s.length()-1;i++){
            for(int j=right;j<s.length();j++){
                //判断是否为无重复子串
                boolean isSubString=subJudge(i,j,s);
                if(isSubString){
                    result=Math.max(result,j-i+1);
                    right=j;
                }else{
                    break;
                }
            }
        }
        return result;
    }
    public boolean subJudge(int i,int j,String s) {
        Set<Character> subStrSet=new HashSet<>();
        for(int tmp=i;tmp<=j;tmp++){
            if(!subStrSet.contains(s.charAt(tmp))){
                subStrSet.add(s.charAt(tmp));
            }else{
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

