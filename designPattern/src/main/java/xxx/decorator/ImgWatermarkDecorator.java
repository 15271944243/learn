package xxx.decorator;

/**
 * @description: 图片水印打印,与页眉打印类似
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/5/8
 */
public class ImgWatermarkDecorator extends PrintDecorator{

    // 被修饰的打印组件
    private PrintComponent printComponent;

    public ImgWatermarkDecorator(PrintComponent printComponent) {
        this.printComponent = printComponent;
    }

    @Override
    public void print() {
        System.out.println("ImgWatermarkDecorator打印图片水印");
        printComponent.print();
    }
}
