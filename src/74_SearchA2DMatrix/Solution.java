class Solution {
    /*
        * similar to binary search problem, but modified to work in 2D matrix

        * time complexity  = O(logmn)
        * space complexity = O(1)

        matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]] -> [1, 3, 5, 7, 10, 11, 16, 20, 23, 30, 34, 60]
    */
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length; // 3
        int cols = matrix[0].length; // 4
        int left = 0;
        int right = (rows * cols) - 1; // index 11

        while (left <= right) {
            int mid = left + (right - left) / 2;

            /*
             * to convert 2d array into 1d array
                * rows * cols - 1
             * to convert 1d array into 2d array
                * we do the opposite
                    * we divide the index by cols to get row value
                * whatever is remaining will be the column value
                * hence:
                    * [mid / cols][mid % cols]
             */
            int midValue = matrix[mid / cols][mid % cols];

            if (midValue == target) {
                return true;
            } else if (midValue > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }
}