package xxx.lambda;


import java.util.*;
import java.util.stream.Stream;

/**
 * @description: Lambda表达式
 * http://www.cnblogs.com/WJ5888/p/4618465.html
 * http://www.cnblogs.com/WJ5888/p/4667086.html
 * http://www.importnew.com/16436.html
 * @author: xxx.
 * @createDate: 2018/1/19
 */
public class LearnLambda {


    public static void main(String[] args) {
        // new Thread(() -> System.out.println("hello!")).start();
        String[] strArray = new String[]{"abcdefg","hijk","lmn"};
        Arrays.sort(strArray,(v1,v2) -> Integer.compare(v1.length(),v2.length()));
        Stream.of(strArray).forEach(param -> System.out.println(param));
        List<String> strList = new ArrayList<String>();
        strList.add("qwer");
        strList.add("tyuio");
        strList.add("asd");
        /*Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }

        };*/
        Comparator<String> comparator2 = ((o1, o2) -> o1.compareToIgnoreCase(o2));
        Comparator<String> comparator3 = ((o1, o2) -> {
            if(o1.length() > o2.length()){
                return 1;
            }else if(o1.length() == o2.length()){
                return 0;
            }else{
                return -1;
            }
        });
        Collections.sort(strList,comparator3);
        System.out.println(strList);
        strList.forEach((t) -> System.out.println(t));
    }
}
