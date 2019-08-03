package math;

/**
 * leetcode 29 两数相除
 * 不使用除法，计算两个数的商
 * tags: [数学], [二分查找]
 */
public class lc_29_divide {

    public int divide(int dividend, int divisor){
        if((dividend == Integer.MAX_VALUE && divisor == -1) || (dividend == Integer.MIN_VALUE && divisor == -1))
            return Integer.MAX_VALUE;
        boolean notSame = false;
        if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)){
            notSame = true;
        }
        long dividend1 = Math.abs((long)dividend);
        long divisor1 = Math.abs((long)divisor);
        //find biggest number n which is nearest with dividend >> n
        int res = 0;
        while(dividend1 >= divisor1){
            int cnt = findBiggest(dividend1, divisor1);
            res += 1<<cnt;
            dividend1 = dividend1 - (divisor1<<cnt);
        }
        return notSame ? -res : res;
    }

    int findBiggest(long dividend, long divisor){
        int n = 31;
        while(n >= 0){
            if( (dividend >> (n)) < divisor){
                n--;
            }
            else
                break;
        }
        return n;
    }

    public static void main(String[] args){

        int a = Integer.MIN_VALUE, b = 1;
        System.out.println(new lc_29_divide().divide(a, b));
    }
}
