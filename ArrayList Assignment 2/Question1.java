import java.util.ArrayList;

class Question1 {
    
    static int p = 2;
    
    public static void main (String[] args) {
        findPrime(100);
    } 
    
    public static ArrayList<Integer> findPrime(int n) {
        ArrayList<Integer> nums = new ArrayList<Integer>(n - 1);
        int y = 0;
        for(int i = 0; i < n-1; i++) {
            nums.add(i+2);
        }  
        
        for(int x = 0; x < nums.size(); x++) {
            p = nums.get(x);
            for(int i = 1; i < nums.size(); i++) {
                if(nums.get(i) % p == 0 && nums.get(i) > p) {
                    nums.remove(i);
                }
            }
        }
        //System.out.println(nums);
        return nums;
    }
}  
    