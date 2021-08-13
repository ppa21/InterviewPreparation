// Solution SIMILAR to 207. Course Schedule (Topological Sorting solution) WITH couple lines ADDED

// SAME Time Complexity & Space Complexity as 207. Course Schedule
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] degreeOfNodes = new int[numCourses];
        for(int[] pre : prerequisites) {
            /*
             * pre = [2, 3]
             * degreeOfNodes[2] = 1
             * Course 2 DEPENDS on ONE Course
             * Course 2 DEPENDS on Course 3
             */
            degreeOfNodes[pre[0]]++;
        }

        Set<Integer> noPrereqCourses = new HashSet();
        for(int i = 0; i < numCourses; i++) {
            if(degreeOfNodes[i] == 0) {
                noPrereqCourses.add(i);
            }
        }

        if(noPrereqCourses.isEmpty()) {
            return new int[]{};
        }

        int[] order = new int[numCourses];
        int index = 0;

        while(!noPrereqCourses.isEmpty()) {
            Iterator<Integer> it = noPrereqCourses.iterator();
            int course = it.next();
            noPrereqCourses.remove(course);
            order[index] = course;
            index++;

            for(int[] pre : prerequisites) {
                if(course == pre[1]) {
                    degreeOfNodes[pre[0]]--;

                    if(degreeOfNodes[pre[0]] == 0) {
                        noPrereqCourses.add(pre[0]);
                    }
                }
            }
        }

        for(int degree : degreeOfNodes) {
            if(degree != 0) {
                return new int[]{};
            }
        }

        return order;
    }
}