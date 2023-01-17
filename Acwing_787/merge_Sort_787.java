/*Problem-solving ideas:
1. Find the midpoint of the interval mid
2. Sort [l, mid] and [mid+1, r]
3. Merge [l, mid] and [mid+1, r]

Time complexity analysis:
The time complexity of merge sort is O(nlogn2)

*/
import java.io.*;

public class merge_Sort_787{
    static int N = 100010;
    static int[] a = new int[N];
    static void merge_sort(int l,int r){
        if(l==r) return;

        int mid=l+r>>1;
        merge_sort(l,mid);
        merge_sort(mid+1,r);

        int[] h=new int[r-l+1];
        int idx=0;
        int i=l;
        int j=mid+1;
        while(i<=mid&&j<=r){
            if(a[i]<=a[j]) h[idx++]=a[i++];
            else h[idx++]=a[j++];
        }

        while(i<=mid) h[idx++]=a[i++];
        while(j<=r) h[idx++]=a[j++];

        for(int k=0;k<idx;k++){
            a[k+l]=h[k];
        }
    }

    public static void main(String[]args)throws IOException{
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());

        String[]arr=in.readLine().split(" ");
        for(int i=0;i<n;i++) a[i]=Integer.parseInt(arr[i]);

        merge_sort(0,n-1);
        for(int i=0;i<n;i++) System.out.print(a[i]+" ");
    }
}

