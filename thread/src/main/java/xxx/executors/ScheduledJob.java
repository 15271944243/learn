package xxx.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledJob {

    public static void main(String[] args) {
        Temp command = new Temp();
        ScheduledExecutorService scheduled = Executors.newScheduledThreadPool(1);
        ScheduledFuture<?> scheduledTask =  scheduled.scheduleWithFixedDelay(command,1,3, TimeUnit.SECONDS);
    }
}

class Temp extends Thread{
    @Override
    public void run() {
        System.out.println("run");
    }
}