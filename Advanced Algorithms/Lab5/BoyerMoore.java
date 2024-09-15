// import java.util.ArrayList;
// import java.util.List;

// public class BoyerMoore {

//     public static void main(String[] args) {
//         //texts overall, followed by strings we're searching for
//         String[] givenText = {"Hello World", "ATAACGGCTAATA"};
//         String[] searchFor = {"World", "ATA"};
        
//         //search through givenText to look for the patterns using boyerMoore
//         for (int i = 0; i < givenText.length; i++) {
//             List<Integer> index = boyerMoore(givenText[i], searchFor[i]);
            
//             //if index isn't empty prints result
//             if (!index.isEmpty()) {
//                 System.out.print("Pattern " + searchFor[i] + " found at index ");

//               //go through each index, prints where pattern found
//                 for (int j = 0; j < index.size(); j++) {
//                     System.out.print(index.get(j));
//                     if(j<index.size() -1){
//                         System.out.print(", ");
//                     }
//                 }
//                 System.out.println(".");
//             } else {
//                 System.out.println("ERROR: there's something wrong here");//testing something's not working?? -FIXED
//             }
//         }
//     }
    
//     //boyer mooore uses given text and pattern
//     public static List<Integer> boyerMoore(String givenText, String searchFor){
//         //mismatches, stores where pattern found in empty list
//         int[] mismatches = mismatchTable(searchFor);
//         List<Integer> foundIt = new ArrayList<>();
//         int x = 0;//keep track of positions
//         //goes through until patern is long enough to fit in text
//         while(x<= givenText.length() - searchFor.length()){
//             int j = searchFor.length() -1;
//             //decrement j if characters match
//             while(j>=0 && searchFor.charAt(j) == givenText.charAt(x+j)){
//                 j--;
//             }
            
//             //pattern found at index, updates 
//             if(j<0){
//                 foundIt.add(x);
//                 //if enough text is remaining to match length of searchFor, keep looking, KEEP TRACK THAT IT ISN'T OUT OF BOUNDS (256 - ascii)
//                 x += (x + givenText.length() < searchFor.length()) ? searchFor.length() - mismatches[givenText.charAt(x+searchFor.length())%256]:1;
                
//             }else{
//                 //incrementing by 1, 
//                 x += Math.max(1,j-mismatches[givenText.charAt(x+j)%256]);
//             }
                
//             }
//         return foundIt;
//         }
        
//     private static int[] mismatchTable(String searchFor){
//         int[] mismatches = new int[256]; //total integers in mismatch table
//         for(int i=0; i< 256; i++){
//             mismatches[i] = -1;
//         }
//         //put as far right as possible position of characters in the pattern being searched for
//         for(int i=0; i<searchFor.length(); i++){
//             mismatches[searchFor.charAt(i)%256]=i;
//         }
//         return mismatches;
//     }
    
// }
