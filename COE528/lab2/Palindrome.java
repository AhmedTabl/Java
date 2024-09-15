    package coe528.lab2;

    /**
     *
     * @author ahmed
     */
    public class Palindrome {

    //Requires: The functions requires a non-null String a.
    //Modifies: None
    //Effects: returns true if the string is a palindrome,and false otherwise.If the input string is null or an empty string, returns false.
    public static boolean isPalindrome(String a) {
        
        String backwardStr = "";

        if(a != null && !(a.equals(""))){
        for(int i = a.length()-1; i >= 0; i--){
        
            
            backwardStr += String.valueOf(a.charAt(i));
        }
        
        if(a.equals(backwardStr)){
            
            return true;
        
        }else{
        
            return false;
        }
        
    }else{
        
            return false;
        }
    }
    
    public static void main(String[] args) {
     
        
    if(args.length == 1) {
        if (args[0].equals("1"))
        System.out.println(isPalindrome(null));
        
        else if (args[0].equals("2"))
        System.out.println(isPalindrome(""));
        
        else if (args[0].equals("3"))
        System.out.println(isPalindrome("deed"));
        
        else if (args[0].equals("4"))
        System.out.println(isPalindrome("abcd"));
    }
   }
}
