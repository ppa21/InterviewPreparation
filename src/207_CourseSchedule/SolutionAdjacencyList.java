class Solution {

    /*
            * ----- IMPORTANT -----
                * RULE:
                    * CYCLE IF visited BUT NOT explored
     */

    private List<Integer>[] adj;
    private boolean[] visited;
    private boolean[] explored;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0 || prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        // Initialize
        visited = new boolean[numCourses];
        explored = new boolean[numCourses];
        adj = new ArrayList[numCourses];            // num of VERTICES == num of COURSES
        for(int i = 0; i < adj.length; i++) {       // adj.length == numCourses -----> INTERCHANGEABLE
            adj[i] = new ArrayList();
        }

        // FILL the Adjacency list, adj
        for(int i = 0; i < prerequisites.length; i++) {
            adj[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        for(int i = 0; i < numCourses; i++) {
            if(!visited[i]) {
                if(isCyclic(i)) {
                    return false;
                }
            }
        }

        return true;
    }

    // DFS algorithm
    private boolean isCyclic(int i) {
        visited[i] = true;

        for(Integer j : adj[i]) {
            if(!visited[j]) {
                if(isCyclic(j)) {
                    return true;
                }
            } else if(!explored[j]) {
                return true;
            }
        }

        explored[i] = true;

        return false;
    }
}