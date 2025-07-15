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

            // i just took 'course', so unlock any courses that were waiting for it
            for(int[] pre : prerequisites) {
                   
                // pre = [2, 3] means course 2 depends on course 3, so you have to finish course 3 first
                if(course == pre[1]) {                     // just finished course 3
                    degreeOfNodes[pre[0]]--;               // course 2 has one less dependency

                    if(degreeOfNodes[pre[0]] == 0) {       // course 2 has no dependency 
                        noPrereqCourses.add(pre[0]);       // course 2 can now be taken
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
