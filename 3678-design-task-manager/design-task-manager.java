class TaskManager {
    private HashMap<Integer,int[]> taskmap = new HashMap<>();
    private PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
        if(a[0]==b[0]) return b[1]-a[1];
        return b[0]-a[0];
    });
    public TaskManager(List<List<Integer>> tasks) {
        for(List<Integer> item:tasks) {
            taskmap.put(item.get(1),new int[]{item.get(0),item.get(2)});
            pq.add(new int[]{item.get(2),item.get(1)});
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        taskmap.put(taskId,new int[]{userId,priority});
        pq.add(new int[]{priority,taskId});
    }
    
    public void edit(int taskId, int newPriority) {
        int[] arr = taskmap.get(taskId);
        arr[1] = newPriority;
        pq.add(new int[]{newPriority, taskId});
    }
    
    public void rmv(int taskId) {
        taskmap.remove(taskId);
    }
    
    public int execTop() {
        while(!pq.isEmpty()) {
            int[] a = pq.poll();
            int t = a[1];
            int p = a[0];
            if(taskmap.containsKey(t) && taskmap.get(t)[1]==p) {
                int ans = taskmap.get(t)[0];
                taskmap.remove(t);
                return ans;
            }
        }
        return -1;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */