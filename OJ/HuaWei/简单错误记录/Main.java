
/**
 * Source:
 * https://www.nowcoder.com/practice/2baa6aba39214d6ea91a2e03dff3fbeb?tpId=37&tqId=21242&tPage=1&rp=&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * Author: cloudy
 * Date : 2018-7-17
 */

/*
 * 题目描述 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。 处理：
 *  1、记录最多8条错误记录，循环记录，对相同的错误记录（净文件名称和行号完全匹配）只记录一条，错误计数增加； 
 * 2、超过16个字符的文件名称，只记录文件的最后有效16个字符；
 * 3、 输入的文件可能带路径，记录文件名称不能带路径。
 * 
 * 输入描述: 一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。
 * 
 * 输出描述: 将所有的记录统计并将结果输出，格式：文件名 代码行数 数目，一个空格隔开，如：
 * 
 * 示例1 输入 复制 E:\V1R2\product\fpgadrive.c 1325 输出 复制 fpgadrive.c 1325 1
 */

/**
 * Solution:
循环记录的意思是，取最后8条记录。
每个记录可以用一个 map 存储，key为文件名(超过16个截断）+行号，value为值
使用LinkedHashMap 因为需要保证输出顺序（取后面8个记录）
 */
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        while (sc.hasNext()) {
            // for (int i = 0; i < 2; i++) {
            String[] input = sc.nextLine().split("\\s+");
            String fileFullPath = input[0];
            int lastIndex = fileFullPath.lastIndexOf("\\");
            String fileName = fileFullPath;
            if (lastIndex != -1) {
                fileName = fileFullPath.substring(lastIndex + 1);
            }
            if (fileName.length() > 16) {
                fileName = fileName.substring(fileName.length() - 16);
            }
            String key = fileName + " " + input[1];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        int count = 0;
        for (String s : map.keySet()) {
            ++count;
            if (count > map.size() - 8) {
                System.out.println(s + " " + map.get(s));
            }
        }
        sc.close();
    }
}