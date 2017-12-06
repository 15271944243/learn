package xxx.executors.useThreadPoolExecutor01;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class MyRejected implements RejectedExecutionHandler{

    /**
     * JDK提供的拒绝策略:
     * AbortPolicy:直接抛出异常,系统还能继续工作
     * CallerRunsPolicy
     * DiscardOldestPolicy:丢弃最老的一个任务,尝试再次提交当前任务
     * DiscardPolicy:丢弃无法处理的任务,并不给于任何处理
     * 如果需要自定义拒绝策略,可以实现RejectedExecutionHandler接口
     */
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("自定义处理");
        System.out.println("当前被拒绝任务为:" + r);
    }
}
