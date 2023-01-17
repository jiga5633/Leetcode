import java.util.Scanner;
public class merge_sort_788{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr =  new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = scanner.nextInt();
        }
        long result = mergeSort(arr,0,n-1);
        System.out.println(result);
    }
    public static long mergeSort(int[] arr,int left,int right){
        if(left >= right) return 0;

        int mid = (left + right) / 2 ;
        long result = mergeSort(arr,left,mid) + mergeSort(arr,mid + 1,right);

        int[] temp = new int[right - left + 1];
        int k = 0,i = left,j = mid + 1;
        while(i <= mid && j <= right){
            if(arr[i] <= arr[j]) temp[k ++ ] = arr[i ++ ];
            else{
                temp[k ++ ] = arr[j ++ ];
                result += mid - i + 1;
            }
        }
        while(i <= mid) temp[k ++ ] = arr[i ++ ];
        while(j <= right) temp[k ++ ] = arr[j ++ ];

        for(i = left,j = 0;i <= right;i++,j++){
            arr[i] = temp[j];
        }
        return result;
    }
}

