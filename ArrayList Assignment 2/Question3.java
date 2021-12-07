import java.util.ArrayList;
import java.util.List;

class Question3{
    
    public static void main (String[] args) {
    addBigInts(Integer.MAX_VALUE, Integer.MAX_VALUE);
    } 
    
    public static ArrayList<Integer> addBigInts(int first, int sec) {
        ArrayList<Integer> numsOne = new ArrayList<Integer>();
        ArrayList<Integer> numsTwo = new ArrayList<Integer>();
        
        int arrSize = 0;
        int currNum = 0;
        int carry = 0;
        
        String firstStr = String.valueOf(first);
        String secStr = String.valueOf(sec);
        
        int firstDig = firstStr.length();
        int secDig = secStr.length();
        
        for(int i = 0; i < firstDig; i++) {
            numsOne.add(i, Integer.parseInt(firstStr.substring(i,i+1)));
        }
        
        for(int i = 0; i < secDig; i++) {
            numsTwo.add(i, Integer.parseInt(secStr.substring(i,i+1)));
        }
        
        if(first > sec) {
            arrSize = numsOne.size() + 1;
        } else arrSize = numsTwo.size() +1;
        
        System.out.println(arrSize);
        ArrayList<Integer> finalArr = new ArrayList<Integer>(arrSize);
        
        for(int i = 0; i < arrSize; i++) {
            finalArr.add(i, 0);
        }
        
        ArrayList<Integer> bigger;
        ArrayList<Integer> smaller;
        
        if (numsOne.size() < numsTwo.size()) {
            bigger = numsTwo;
            smaller = numsOne;
        } else {
            bigger = numsOne;
            smaller = numsTwo;
        }
        
        int dif = bigger.size() - smaller.size();
        for (int x = smaller.size()-1; x >= 0 ; x--){
            currNum = smaller.get(x) + bigger.get(x+dif) + carry;
            carry = currNum/10;
            finalArr.set(x + dif + 1, currNum % 10);
        }
        
        for (int i = dif; i > 0; i--) {
            currNum = bigger.get(i-1) + carry;
            carry = currNum/10;
            finalArr.set(i, currNum%10);
        }
            
        finalArr.set(0, carry);
        
        int carry2 = numsOne.get(0) + numsTwo.get(0);
        if(numsOne.size() == numsTwo.size() && carry2 > 9) finalArr.set(0, carry2 / 10);
        
        if(finalArr.get(0) == 0) {
            ArrayList<Integer> withoutZero = new ArrayList<Integer>(finalArr.subList(1, finalArr.size())); 
            //System.out.println(withoutZero);
            return withoutZero;
        }else{
            //System.out.println(finalArr);
            return finalArr;
        }
    }
    
}