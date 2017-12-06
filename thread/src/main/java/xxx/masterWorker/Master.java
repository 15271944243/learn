package xxx.masterWorker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Master {

    // 1.有一个承装任务的集合
    private ConcurrentLinkedQueue<Task> taskQueue = new ConcurrentLinkedQueue<>();

    // 2.有一个承装worker对象的集合
    private HashMap<String,Thread> workers = new HashMap<>();

    // 3.有一个容器承装每一个worker执行任务的结果集
    private ConcurrentHashMap<String,Object> resultMap = new ConcurrentHashMap<>();

    // 4.构造方法
    public Master(Worker worker,int workerCount) {
        worker.setTaskQueue(this.taskQueue);
        worker.setResultMap(this.resultMap);
        for (int i=0;i<workerCount;i++){
            // key 表示worker的名字,value表示线程的执行对象
            workers.put("sub"+i,new Thread(worker));
        }
    }

    // 5.外部程序向Mater里添加任务
    public void addTask(Task task){
        this.taskQueue.add(task);
    }

    // 6.需要一个执行方法,启动Master,让所有Worker工作
    public void execute(){
        for(Map.Entry<String,Thread> entry : workers.entrySet()){
            entry.getValue().start();
        }
    }

    // 7.判断所有线程是否执行完毕
    public boolean isComplete(){
        for(Map.Entry<String,Thread> entry : workers.entrySet()){
            if(entry.getValue().getState() != Thread.State.TERMINATED){
                return false;
            }
        }
        return true;
    }

    // 8.向外部程序返回结果集
    public long getResult(){
        int result = 0;
        for(Map.Entry<String,Object> entry : resultMap.entrySet()){
            result += (int)entry.getValue();
        }
        return result;
    }
}
