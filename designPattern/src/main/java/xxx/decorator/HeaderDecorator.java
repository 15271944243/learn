package xxx.decorator;

/**
 * @description: 页眉打印
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/5/8
 */
public class HeaderDecorator extends PrintDecorator{

    // 被修饰的打印组件
    private PrintComponent printComponent;
    // 打印内容
    private String text;

    /**
     * 初始化的时候，必须包含其它打印组件comp，这是实现Decorator模式的前提
     * 同时也需要指定当前组件所需的参数，不能在print函数的参数中指定，
     * 因为每个Decorator所需的参数是不一样的
     * @param printComponent
     * @param text
     */
    public HeaderDecorator(PrintComponent printComponent, String text) {
        this.printComponent = printComponent;
        this.text = text;
    }

    @Override
    public void print() {
        // 打印的时候将当前Decorator和被修饰的Component分开，这是Decorator模式的关键
        System.out.println("HeaderDecorator打印内容:" + this.text);
        // printComponent本身如果是Decorator，就会嵌套打印下去
        // printComponent本身如果不是Decorator，而是ConcreteComponent，则打印任务到此结束
        printComponent.print();
    }
}
