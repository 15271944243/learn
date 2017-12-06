package xxx.masterWorker;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        Master master = new Master(new Worker(),Runtime.getRuntime().availableProcessors());
        Random random = new Random();
        for(int i=0;i<100;i++){
            Task task = new Task();
            task.setId(i);
            task.setName("任务"+i);
            task.setPrice(random.nextInt(1000));
            master.addTask(task);
        }
        master.execute();
        long startTime = System.currentTimeMillis();
        while (true){
            if(master.isComplete()){
                long endTime = System.currentTimeMillis() - startTime;
                System.out.println("最终结果:" +master.getResult() + "运行时间:" + endTime);
                break;
            }
        }
    }
}
