package xxx.queue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

public class UseQueue01 {

    public static void main(String[] args) throws Exception{
        /**
         * ConcurrentLinkedQueue:是一个适用于高并发场景下的队列,通过无锁的方式,实现了高并发状态下的高兴能。
         * 通常ConcurrentLinkedQueue性能要好于BlockingQueue
         * 它是一个基于链接节点的无界线程安全队列,该队列不允许null元素
         * add()和offer()都是加入元素的方法(在ConcurrentLinkedQueue里,这两个方法没有任何区别)
         * poll()和peek()都是取头元素,区别在于前者会删除元素而后者不会
         * */
        ConcurrentLinkedQueue<String> q = new ConcurrentLinkedQueue<String>();
        q.add("a");
        q.add("b");
        q.add("c");
        q.offer("d");
        q.offer("e");
        q.offer("f");
        System.out.println(q.size());
        System.out.println(q.poll());
        System.out.println(q.size());
        System.out.println(q.peek());
        System.out.println(q.peek());
        System.out.println(q.size());
        System.out.println("-----------------------------------");
        //BlockingQueue
        /**
         * ArrayBlockingQueue:基于数组的阻塞队列,在ArrayBlockingQueue内部,维护者一个定长数组,
         * 以便缓存队列中的数据对象,其内部没有实现读写分离,也就意味着生产和消费不能完全并行,
         * 长度是需要定义的,可以指定是先进先出还是先进后出。
         * 它是一个有界队列
         */
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(5);
        arrayBlockingQueue.put("a");
        arrayBlockingQueue.put("ab");
        arrayBlockingQueue.add("c");
        arrayBlockingQueue.add("d");
        arrayBlockingQueue.offer("e",2,TimeUnit.SECONDS);
        //System.out.println(arrayBlockingQueue.offer("f",2,TimeUnit.SECONDS));
        System.out.println("-----------------------------------");

        /**
         * LinkedBlockingQueue:基于链表的阻塞队列,同ArrayBlockingQueue类似,
         * 其内部也维持者一个数据缓冲队列(该队列由一个链表构成)
         * LinkedBlockingQueue之所以能高效地处理并发数据,是因为其内部实现采用分离锁(读写分离两个锁),
         * 从而实现生产者和消费者操作的完全并行运行。
         * 它是一个无界队列
         */
        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<String>(5);
        linkedBlockingQueue.offer("a");
        linkedBlockingQueue.offer("b");
        linkedBlockingQueue.offer("c");
        linkedBlockingQueue.offer("d");
        linkedBlockingQueue.offer("e");
        /**
         * 注意:LinkedBlockingQueue虽然是一个是一个无界队列,但如果当它初始化时指定了容量大小(比如上面的5)
         * 当队列大小超过初始化时指定的容量,继续添加元素是添加不进去的,
         * 初始化时不指定容量大小,则可以一直添加,直到达到容量最大值:Integer.MAX_VALUE
         */
        /*linkedBlockingQueue.offer("f");
        for(Iterator i = linkedBlockingQueue.iterator(); i.hasNext();){
            String str = (String)i.next();
            System.out.println(str);
        }*/
        List<String> list = new ArrayList<String>();
        // 从队列中取出3个元素放入到list中
        System.out.println(linkedBlockingQueue.drainTo(list,3));
        System.out.println(list.size());
        for(String str : list){
            System.out.println(str);
        }

        System.out.println("-----------------------------------");

        /**
         * SynchronousQueue:一种没有缓冲的队列,生产者生产的数据会直接被消费者获取并消费
         * 它不能直接添加元素
         */
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<String>();
        synchronousQueue.add("a");

        /**
         * PriorityBlockingQueue:基于优先级的阻塞队列(优先级的判断通过构造函数传入的Comparator对象来决定
         * 也就是说队列中的元素必须实现Comparable接口),它内部控制线程同步的锁是公平锁。
         * 它是一个无界队列
         */
        //PriorityBlockingQueue
        /**
         * DelayQueue:带有延迟时间的队列,队列中的元素只有当其指定的延迟时间到了,才能够从队列中获取该元素
         * 队列中的元素必须实现Delayed接口
         * 它是一个无界队列,应用场景很多,比如对缓存超时的数据进行移除、任务超时处理、空闲连接关闭等待
         */
        //DelayQueue



    }
}