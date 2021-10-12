class Solution {
    /*
            Time Complexity: O(n)
            Space Complexity: O(n)
     */
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        int maxUnits = 0;

        for(int[] box : boxTypes) {
            int numOfBoxes = box[0];
            int numOfUnitsPerBox = box[1];

            if(truckSize >= numOfBoxes) {
                maxUnits += (numOfBoxes * numOfUnitsPerBox);
                truckSize -= numOfBoxes;
            } else {
                maxUnits += (truckSize * numOfUnitsPerBox);
                break;
            }
        }

        return maxUnits;
    }
}