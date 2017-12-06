package xxx.concurrentUtil;


import java.util.concurrent.*;

public class UseFuture implements Callable<String>{
    /**
     * Future模式非常适合在耗时很长的业务逻辑中使用,
     * 可以有效的减少系统的响应时间,提供系统的吞吐量
     */
    private String para;

    public UseFuture(String para) {
        this.para = para;
    }

    @Override
    public String call() throws Exception {
        // 模拟真实业务,该业务很耗时
        Thread.sleep(3000);
        String result = this.para + "处理完成";
        return result;
    }

    public static void main(String[] args) throws Exception{
        String queryStr = "queryStr";
        // 构造FutureTask,并且传入需要进行业务逻辑处理的类,该类一定是实现了Callable接口的类
        FutureTask<String> futureTask = new FutureTask<String>(new UseFuture(queryStr));
        FutureTask<String> futureTask2 = new FutureTask<String>(new UseFuture(queryStr));
        // 创建一个固定数量的线程池,且线程池的线程数为1
        ExecutorService executor = Executors.newFixedThreadPool(2);
        // submit()和execute()方法的区别:1.submit()可以传入实现Callable接口的实例对象 2.submit()有返回值
        Future f1 = executor.submit(futureTask);
        Future f2 = executor.submit(futureTask2);
        System.out.println("请求完毕...");
        System.out.println("主线程执行其他业务逻辑");
        Thread.sleep(1000);
        // 获取任务处理后的结果,如果call()方法没有完成,则依然会进行等待
        System.out.println("数据:" + futureTask.get());
        System.out.println("数据:" + futureTask2.get());
        executor.shutdown();
    }
}
