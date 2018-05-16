package xxx.decorator;

/**
 * @description: 修饰的打印任务，对应Decorator模式中的Decorator
 * Decorator可以聚合ConcreteComponent或者其他Decorator
 * 这样可以使得打印任务能够嵌套执行下去，直到最后完成所有打印任务
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/5/8
 */
public abstract class PrintDecorator extends PrintComponent{

    public abstract void print();
}
