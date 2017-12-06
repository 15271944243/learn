package xxx.queue.usePriorityBlockingQueue;

public class Task implements Comparable<Task>{
    private int id;
    private String name;

    @Override
    public int compareTo(Task o) {
        return this.id > o.id ? 1 : (this.id < o.id ? -1 : 0);
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
