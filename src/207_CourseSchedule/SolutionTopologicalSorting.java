/*
        * Topological Sorting
            * Linear ordering of its vertices such that for every DIRECTED edge uv, u comes before v in the ordering
            * Can only be applied to DAG

        * Kahn's Algorithm
 */

/*
        * Time Complexity: O(V + E) ---> V = # of vertices, E = # of edges
        * Space Complexity: O(V + E)
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
            return false;
        }

        while(!noPrereqCourses.isEmpty()) {
            Iterator<Integer> it = noPrereqCourses.iterator();
            int course = it.next();
            noPrereqCourses.remove(course);

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
                return false;
            }
        }

        return true;
    }
}