class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size1 = nums1.length;
        int size2 = nums2.length;
        double median = 0.0;
        int[] ans = new int[size1 + size2];
        int arr1_ele =0,arr2_ele =0,arr_ans =0;
        while(arr1_ele < size1 && arr2_ele < size2 ){// address
            
            
            if(nums1[arr1_ele] <= nums2[arr2_ele]){
                ans[arr_ans] = nums1[arr1_ele]; // copy and sort the element
                arr_ans ++;
                arr1_ele++;
            }else{
                ans[arr_ans] = nums2[arr2_ele];
                arr_ans ++;
                arr2_ele ++;
            }
        }
        
        if(arr1_ele == size1 && arr2_ele < size2){
            while(arr2_ele <size2){
                ans[arr_ans] = nums2[arr2_ele];
                arr_ans++;
                arr2_ele++;
            }
        }
        else if(arr2_ele == size2 && arr1_ele < size1){
            while(arr1_ele < size1){
                ans[arr_ans] = nums1[arr1_ele];
                arr_ans++;
                arr1_ele++;
            }
        }
        
        if ((size1 +size2) % 2 == 0){
            median = (double)(ans[ ( (size1 +size2) / 2)-1 ] + ans[ (size1+size2)/2 ] )/2; 
            // the arr has even element
            
        }else{
            median = (double)(ans[(size1+size2)/2]);
        }
        
        return median;
    }
}

/*class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double b;
        
    int left  = nums1.length;
    int right = nums2.length;
    int[] res = new int[left+ right];
    for(int i=0; i< left; i++){
        res[i] = nums1[i];
    }
    for(int i=left, j=0; i< res.length;i++, j++){
        res[i] = nums2[j];
    }
    Arrays.sort(res);
    int mid = res.length / 2 ;
    if(res.length % 2 ==0){

       b = (res[mid-1] + res[mid])/2.0;

    }else b  =(double) res[mid];
   return b;
}
}
*/
