package xxx.decorator;

/**
 * @description: 文本打印，对应Decorator模式中的ConcreteComponent
 * 打印任务到ConcreteComponent就算真正完成了
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/5/8
 */
public class TextComponent extends PrintComponent{

    // 要打印的文本内容
    private String text;

    public TextComponent(String text) {
        this.text = text;
    }

    @Override
    public void print() {
        System.out.println("TextComponent打印内容:" + this.text);
    }
}
