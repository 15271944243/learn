package xxx.queue.usePriorityBlockingQueue;

import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;

public class UsePriorityBlockingQueue {

    public static void main(String[] args) {
        PriorityBlockingQueue<Task> q = new PriorityBlockingQueue<Task>();
        Task task01 = new Task();
        task01.setId(2);
        task01.setName("任务1");
        Task task02 = new Task();
        task02.setId(3);
        task02.setName("任务2");
        Task task03 = new Task();
        task03.setId(1);
        task03.setName("任务3");
        q.add(task01);
        q.add(task02);
        q.add(task03);
        //下面这样的循环是没有排序的,只有用到take方法的时候,才是按顺序取出来的
        for(Iterator iterator = q.iterator();iterator.hasNext();){
            Task task = (Task)iterator.next();
            System.out.println(task.getName());
        }
        System.out.println("---------------");
        try {
            System.out.println(q.take().getName());
            System.out.println(q.take().getName());
            System.out.println(q.take().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
