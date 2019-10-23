package xxx.initializeSort;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @Description:
 * @Auther: xiaoxiaoxiang
 * @Date: 2018/10/8 18:24
 */
public class Test {

    public static void main(String[] args) {
        // Parent parent = new Child(5);
        // new Parent();

        /*LinkedHashMap<String, String> tradeCheckingResultMap = new LinkedHashMap<String, String>(4);
        tradeCheckingResultMap.put("1","1");
        tradeCheckingResultMap.put("2","2");
        tradeCheckingResultMap.put("3","3");
        System.out.println(111);*/

        Integer t1 = 0;
        BigDecimal t2 = BigDecimal.ZERO;
        calculate(t1, t2);
        System.out.println(t1);
        System.out.println(t2);

        List<String> aaa = new ArrayList<>();
        aaa.add("1");
        aaa.add("2");
        aaa.add("3");
        aaa.add("4");
        aaa.add("5");

        /*for (int i = 0;i< aaa.size();i++) {
            if (i == 3) {
                aaa.remove(aaa.get(i));
            }
        }*/
        for (String a : aaa) {
            aaa.remove(a);
        }
        System.out.println(111);
    }

    private static void calculate(Integer t1, BigDecimal t2) {
        t1++;
        t2 = t2.add(BigDecimal.TEN);

    }
}
