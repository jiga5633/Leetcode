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