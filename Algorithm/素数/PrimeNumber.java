import java.util.Arrays;

/**Source: 
 * 质数（素数）就是指只能被1或者自身整除的数。也就是构成所有的基数。任何数字是由质数相乘构成。
 * https://zh.wikipedia.org/wiki/%E7%B4%A0%E6%95%B0
 * Author: cloudy
 * Date  : 2018-7-7
 */

public class PrimeNumber {

    /**
     * Solution1：最基本的定义法  质数 数整数 效率低
     */
    public static boolean isPrimeSolution1(int n) {
        if (n == 0 || n == 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Solution2: 定义法改进 思路： 不必判断该数 是否能整除 2~n-1。可
     * 小范围。2~sqrt(n)。因为若一个数是合数
     * （也就是由其他两个数乘积得到），那么其中一个必然小于它的开方数，另一个必然大于（反证法证明，
     * 如果两个都小于开方数，那么乘积就会小于该数，不符合）
     */
    public static boolean isPrimeSolution2(int n) {
        if (n == 0 || n == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /***
     * Solution3: 筛选法： 思路：假定求取 20 以内的素数。那么先初始化一个30boolean 类型数组，都初始化为t
     * ue, 数组索引都对应该数字，里面的值表示是否是质数。如 primeArray[
     * ]=false, 表示 0不是质数。 筛的原理为，逐一去掉倍数的值，也就是能整除的值。
     * 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20 0,1 索引处，初始化为 false. 从2开
     *  那么2的2倍，3倍，4倍..直到数值超出。筛选一次后，2,3,5,7,11,13,15,17,19
     * 那么在接着3开始，3也是质数。3的2倍，3倍。。直到超过。筛选后，2,3,5,7,11,13,17,19
     * 接着从索引为4，4不是质数，跳过，依次类推。
     * 
     * 这样可以存储指定大小的质数数组，查找就直接获取值
     */
    public static boolean[] primeArray = new boolean[100];

    public static void initPrimeArray(int n) {
        Arrays.fill(primeArray, true);
        primeArray[0] = primeArray[1] = false;
        for (int i = 2; i < n; i++) {
            if (primeArray[i]) {
                for (int j = 2; i * j < primeArray.length; j++) {
                    primeArray[i * j] = false;
                }
            }
        }
    }

    public static boolean isPrimeSolution4(int n) {
        return primeArray[n];
    }

    public static boolean isPrimeSolution3(int n) {
        if (n == 0 || n == 1) {
            return false;
        }
        if (n > 2 && n % 2 == 0) {// 排除偶数
            return false;
        }
        int sqrtValue = (int) Math.sqrt(n);
        for (int i = 3; i <= sqrtValue; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int maxValue = 30;
        System.out.println("solution 1 -->");
        for (int i = 0; i < maxValue; i++) {
            if (isPrimeSolution1(i)) {
                System.out.println(i);
            }
        }
        System.out.println("solution 2 -->");
        for (int i = 0; i < maxValue; i++) {
            if (isPrimeSolution2(i)) {
                System.out.println(i);
            }
        }
        System.out.println("solution 3 -->");
        for (int i = 0; i < maxValue; i++) {
            if (isPrimeSolution3(i)) {
                System.out.println(i);
            }
        }
        System.out.println("solution 4 -->");
        initPrimeArray(maxValue);
        for (int i = 0; i < maxValue; i++) {
            if (isPrimeSolution4(i)) {
                System.out.println(i);
            }
        }
    }
}