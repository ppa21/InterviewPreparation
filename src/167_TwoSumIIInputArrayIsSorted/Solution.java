/*
 * time complexity =  O(n)
 * space complexity = O(1)
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            if (numbers[left] + numbers[right] > target) {
                right--;
                continue;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
                continue;
            } else {
                break;
            }
        }

        return new int[]{left + 1, right + 1};
    }
}
