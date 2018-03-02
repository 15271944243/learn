package xxx;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test4 {
    public static void main(String[] args) {
        String fileName = "E:\\monitor.log";
        File file = new File(fileName);
        BufferedReader reader = null;
        List<String> list = new ArrayList<>();
        try {
            // System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                System.out.println("line " + line + ": " + tempString);
                if(line%2 == 0){
                    list.add(tempString);
                }
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {

                }
            }
        }
        int total = 0;
        int enterSimnt = 0;
        int unEnterSimnt = 0;
        int match = 0;
        int unMatch = 0;
        List<String> matchMsgList = new ArrayList<>();
        for(String s : list){
            if(s.trim().length() != 0){
                String[] arr = s.split(",");
                if(arr[0].contains("zzz")){
                    double score = arr[4].equals("null")?0:Double.parseDouble(arr[4]);
                    double variance = arr[8].equals("null")?0:Double.parseDouble(arr[8]);
                    if(score >= 0.6 && variance >= 0.01){
                        match++;
                        StringBuffer sb = new StringBuffer();
                        sb.append("消息:").append(arr[2]).append(",得分:").append(score).append(",匹配上的关键字:").append(arr[6]);
                        matchMsgList.add(sb.toString());
                    }else{
                        unMatch++;
                    }
                }else if(arr[0].contains("xxx")){
                    total++;
                    if("1".equals(arr[3])){
                        enterSimnt++;
                    }else if("0".equals(arr[3])){
                        unEnterSimnt++;
                    }
                }
            }
        }
        DecimalFormat df = new DecimalFormat("0.0000");//格式化小数
        /*System.out.println("用户输入的总消息数:" + total);
        System.out.println("进入相似度匹配的消息数:" + enterSimnt + ",占总数的:" + df.format((float)enterSimnt/total));
        System.out.println("未进入相似度匹配的消息数:" + unEnterSimnt + ",占总数的:" + df.format((float)unEnterSimnt/total));
        System.out.println("相似度匹配成功的消息数(得分高于0.6,方差高于0.01):" + match + ",占进入相似度匹配总数的:" + df.format((float)match/enterSimnt));
        System.out.println("相似度匹配未成功的消息数:" + unMatch + ",占进入相似度匹配总数的:" + df.format((float)unMatch/enterSimnt));
        System.out.println("相似度匹配成功的消息如下:");
        for(String s : matchMsgList){
            System.out.println(s);
        }*/
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("E:\\logResult.txt"));
            pw.println("用户输入的总消息数:" + total);
            pw.println("进入相似度匹配的消息数:" + enterSimnt + ",占总数的:" + df.format((float)enterSimnt/total));
            pw.println("未进入相似度匹配的消息数:" + unEnterSimnt + ",占总数的:" + df.format((float)unEnterSimnt/total));
            pw.println("相似度匹配成功的消息数(得分高于0.6,方差高于0.01):" + match + ",占进入相似度匹配总数的:" + df.format((float)match/enterSimnt));
            pw.println("相似度匹配未成功的消息数:" + unMatch + ",占进入相似度匹配总数的:" + df.format((float)unMatch/enterSimnt));
            pw.println("相似度匹配成功的消息如下:");
            for(String s : matchMsgList){
                pw.println(s);
            }
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
