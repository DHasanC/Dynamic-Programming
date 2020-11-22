class Solution {
    public int maxProduct(int[] nums) {
        
        if(nums.length == 1) return nums[0];
        
        int maxProd = nums[0];
        
        int minProd = nums[0];
        
        int max = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            int temp = maxProd;
            maxProd = Math.max(Math.max(maxProd * nums[i], minProd * nums[i]), nums[i]);
            minProd = Math.min(Math.min(temp * nums[i], minProd * nums[i]), nums[i]);
            //maxProd = Math.max(maxProd, nums[i]);
            //minProd = Math.min(minProd, nums[i]);
            max = Math.max(maxProd, max);
        }
        
        return max;
        
    }
}
