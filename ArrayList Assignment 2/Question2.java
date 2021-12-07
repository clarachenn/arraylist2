import java.util.ArrayList;

class Question2 {
    
    public static void main (String[] args) {
       sum(120);
    } 
    
    
    public static void sum(int num){
        boolean found = false;
        if (num % 2 == 0 && num > 2) {
            ArrayList<Integer> nums = Question1.findPrime(num);
     
            for(int i = 0; i < nums.size(); i++) {
                int first = nums.get(i);
                for(int x = 0; x < nums.size(); x++) {
                    int sec = nums.get(x);
                    if (first + sec == num && !found){
                        System.out.println(first + " + " + sec);
                        found = true;
                    }
                }
            }
        }
    }
}