package xxx.decorator;

/**
 * @description: 页脚打印,与页眉打印类似
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/5/8
 */
public class FooterDecorator extends PrintDecorator{

    // 被修饰的打印组件
    private PrintComponent printComponent;
    // 打印内容
    private String text;

    public FooterDecorator(PrintComponent printComponent, String text) {
        this.printComponent = printComponent;
        this.text = text;
    }

    @Override
    public void print() {
        System.out.println("FooterDecorator打印内容:" + this.text);
        printComponent.print();
    }
}
