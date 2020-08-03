package daily.challenge.leetcode;

public class DetectCapital {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println(solution.detectCapitalUse("Flag"));
		System.out.println(solution.detectCapitalUse("USA"));
		System.out.println(solution.detectCapitalUse("small"));
		System.out.println(solution.detectCapitalUse("TaG"));
		System.out.println(solution.detectCapitalUse("largE"));
	}

}
class Solution {
    public boolean detectCapitalUse(String word) {
        //non-empty latin letters
        char[] characterArray = word.toCharArray();
        if(isUpperCase(characterArray)) return true;
        else if(isAllLowerCase(characterArray, 0)) return true;
        return false;
    }
    
    private boolean isUpperCase(char[] characterArray){
        for(int i=0; i < characterArray.length; i++){
            if(!Character.isUpperCase(characterArray[i])){
                if(i == 1){
                    return isAllLowerCase(characterArray, 1);
                }
                return false;
        }
               }
               return true;
    }
               
               
               private boolean isAllLowerCase(char[] characterArray, int index){
                   for(int i=index; i < characterArray.length; i++){
                       if(Character.isUpperCase(characterArray[i])) return false;
                   }
                          return true;
               }
               
               
               }
