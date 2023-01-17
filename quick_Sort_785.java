/*Given you a length n array of integers.

Please use quick sort to sort this list from smallest to largest.

And output the sorted array in order.

input format
Input a total of two lines, the first line contains the integer n
.

The second line contains n
  integers (all integers between 1∼109
  range), representing the entire array.

output format
Output a total of one line, containing n
  An integer representing a sorted array.

data range
1≤n≤100000

Input sample:
5
3 1 2 4 5
Sample output:
1 2 3 4 5
*/

import java.util.*;
public class quick_Sort {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] q = new int[n];
        for(int i=0; i<n; i++){q[i] = sc.nextInt();}

        quickSort(q, 0, n-1);
        for(int i=0; i<n; i++){System.out.print(q[i] + " ");}
    }

    public static void quickSort(int[] q, int l, int r){
        if(l >= r) return;
        int x = q[l + r >> 1], i = l - 1, j = r + 1;
        while(i < j){
            while( q[++i] < x );
            while( q[--j] > x) ;
            if(i < j){
                int t = q[i];
                q[i] = q[j];
                q[j] = t;
            }
        }
        quickSort(q, l, j);
        quickSort(q, j + 1, r);
    }
}

