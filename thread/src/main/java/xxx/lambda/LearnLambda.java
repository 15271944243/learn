package xxx.lambda;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @description: Lambda表达式
 * @author: xxx.
 * @createDate: 2018/1/19
 */
public class LearnLambda {


    public static void main(String[] args) {
        new Thread(() -> System.out.println("hello!")).start();
        String[] strArray = new String[]{"abcdefg","hijk","lmn"};
        Arrays.sort(strArray,(v1,v2) -> Integer.compare(v1.length(),v2.length()));
        Stream.of(strArray).forEach(param -> System.out.println(param));
    }
}
