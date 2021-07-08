class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList();
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int size = matrix.length * matrix[0].length;

        while(result.size() < size) {
            // get every i in the top row
            for(int i = left; i <= right && result.size() < size; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // get every i in the right col
            for(int i = top; i <= bottom && result.size() < size; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // get every i in the bottom row
            for(int i = right; i >= left && result.size() < size; i--) {
                result.add(matrix[bottom][i]);
            }
            bottom--;

            // get every i in the left col
            for(int i = bottom; i >= top && result.size() < size; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }

        return result;
    }
}