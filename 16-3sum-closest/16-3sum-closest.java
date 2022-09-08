class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int size = nums.length;
        Arrays.sort(nums);
        for(int i =0; i < size && diff != 0; i++){
            for(int j= i+1; j < size -1; ++j){
                int complement = target - nums[i] - nums[j];
                var idx = Arrays.binarySearch(nums,j+1,size-1,complement);
                int big = idx >= 0? idx :~idx, small = big -1;
                if(small < big && Math.abs(complement - nums[big]) < Math.abs(diff))
                    diff = complement - nums[big];
                if(small > big && Math.abs(complement - nums[small]) < Math.abs(diff))
                    diff = complement - nums[small];
            }
        }
        return target - diff;
    }
}