package xxx.observer;

import java.util.Observable;

/**
 * @description: 继承jdk的Observable来实现主题信息
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/1/25
 */
public class ConcreteSubject extends Observable{

    private int state;

    public void set(int state) {
        //状态切换，广播信息
        this.state = state;
        setChanged();
        notifyObservers();
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
