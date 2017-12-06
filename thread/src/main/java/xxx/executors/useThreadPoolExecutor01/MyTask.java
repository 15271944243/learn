package xxx.executors.useThreadPoolExecutor01;

public class MyTask implements Runnable{

    private int id;
    private String name;

    @Override
    public void run() {
        try {
            System.out.println("run taskId = " + this.id);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public MyTask(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
