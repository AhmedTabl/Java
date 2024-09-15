package coe528.lab2;

/**
 *
 * @author ahmed
 */
public class AnagramChecker {
    
    
    // Requires: Two non-null input strings, str1 and str2, representing the words to be checked for anagrams.
    // Modifies: None
    // Effects: Returns true if the input strings are anagrams,
    //          and false otherwise. If the lengths of the input strings are different, returns false. 
    public static boolean areAnagrams(String str1 , String str2){
        
        String str1Cut = str1.replaceAll("\\s+","").toLowerCase();
        String str2Cut = str2.replaceAll("\\s+","").toLowerCase();
        
        String[] str1Arr = str1Cut.split("");
        String[] str2Arr = str2Cut.split("");
        
        int counter = 0;
        
        if(str1Cut.length() == str2Cut.length()){
            
            for(int i = 0; i < str1Cut.length(); i++){
                
                for(int j = 0; j < str2Cut.length(); j++){
                    
                    if(str1Arr[i].equals(str2Arr[j])){
                        
                        counter++;
                        str2Arr[j] = "";
                    
                    }
                
                }
            
            }
            
            if(counter == str1Cut.length()){
                
                return true;
            
            }else{
                
                return false;
            }
            
        
        }else{
        
            return false;
            
        }
    
    }
    
    public static void main(String[] args) {
     
        System.out.println(areAnagrams(args[0],args[1]));
    
   }
    
}
