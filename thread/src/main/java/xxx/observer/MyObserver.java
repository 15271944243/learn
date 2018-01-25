package xxx.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @description: 实现观察者
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/1/25
 */
public class MyObserver implements Observer{

    @Override
    public void update(Observable o, Object arg) {
        int state = ((ConcreteSubject)o).getState();
        System.out.println("state:"+state);
    }
}
