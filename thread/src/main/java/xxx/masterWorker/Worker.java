package xxx.masterWorker;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Worker implements Runnable{

    // 1.worker需要有master的taskQueue的引用
    private ConcurrentLinkedQueue<Task> taskQueue = new ConcurrentLinkedQueue<>();

    // 2.worker需要有master的resultMap的引用
    private ConcurrentHashMap<String,Object> resultMap = new ConcurrentHashMap<>();

    @Override
    public void run() {
        while (true){
            Task task = taskQueue.poll();
            if(task == null) break;
            Object output = handle(task);
            resultMap.put(String.valueOf(task.getId()),output);
        }
    }

    public Object handle(Task task){
        Object output = null;
        try {
            // 表示处理任务的耗时
            Thread.sleep(500);
            int num = (int) (Math.random() * 100);
            output = num;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return output;
    }

    public void setTaskQueue(ConcurrentLinkedQueue<Task> taskQueue) {
        this.taskQueue = taskQueue;
    }

    public void setResultMap(ConcurrentHashMap<String, Object> resultMap) {
        this.resultMap = resultMap;
    }
}
