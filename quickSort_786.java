import java.util.Scanner;
public class quickSort_786{
    public static void main(String[] args){
        Scanner s  =  new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i < arr.length;i++)
            arr[i] = s.nextInt();

        int result = quickSort(arr,0,n-1,k);
        System.out.print(arr[result]);
    }
    public static int quickSort(int[] arr,int left,int right,int k){
        if(left >= right) return left;
        int x = arr[(left + right) / 2],i = left - 1,j = right + 1;
        while(i < j){
            while(arr[++i] < x);
            while(arr[--j] > x);
            if(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int sl = j - left + 1;
        if(k <= sl) return quickSort(arr,left,j,k);
        else return quickSort(arr,j+1,right,(k-sl));
    }
}

