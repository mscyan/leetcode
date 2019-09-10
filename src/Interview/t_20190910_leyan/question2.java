package Interview.t_20190910_leyan;

import java.util.Scanner;

public class question2 {

    /**
     * 合并两个有序数组
     * @param args
     */
    public static void main(String[] args){
        int n,m;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr1 = new int[n];
        for(int i=0; i<n; i++){
            arr1[i] = sc.nextInt();
        }
        m = sc.nextInt();
        int[] arr2 = new int[m];
        for(int i=0; i<m; i++){
            arr2[i] = sc.nextInt();
        }

        int[] num = new int[n+m];
        int index = 0;
        int l = 0, r = 0;
        while(l <= n && r <= m){
            if(l < n && r >= m){
                for(int i=l; i<n; i++){
                    num[index] = arr1[i];
                    index++;
                }
                break;
            }
            else if(l >= n && r < m){
                for(int i=r; i<m; i++){
                    num[index] = arr2[i];
                    index++;
                }
                break;
            }
            else{
                if(arr1[l] < arr2[r]){
                    num[index] = arr1[l];
                    l++;
                    index++;
                }
                else{
                    num[index] = arr2[r];
                    r++;
                    index++;
                }
                continue;
            }
        }
        System.out.print("c=[");
        for(int i=0; i<num.length-1; i++){
            System.out.print(num[i]+ ",");
        }
        System.out.print(num[num.length-1] + "]");
    }
}
