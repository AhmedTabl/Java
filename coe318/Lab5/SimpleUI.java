

import java.util.Scanner;

public class SimpleUI implements UserInterface {
    private BlackjackGame game;
    private Scanner user = new Scanner(System.in);

  @Override
    public void setGame(BlackjackGame game) {
        this.game = game;
    }

  @Override
    public void display() {
        
        System.out.println("House Holds:\n");
        for(int i =0; i<game.getHouseCards().getCards().size()-1; i++){
            
            System.out.println(game.getHouseCards().getCards().get(i));
        }
            
        System.out.println("You Hold:\n");
        for(int i =0; i<game.getYourCards().getCards().size()-1; i++){
            
            System.out.println(game.getYourCards().getCards().get(i));
        } 
        
    }

  @Override
    public boolean hitMe() {
        
        System.out.println("Do you want another card?");
        String ans = user.nextLine();
        
        if(ans.equals("y") || ans.equals("Y") || ans.equals("yes") || ans.equals("Yes")){
            
            return true;
            
        }else{
            
            return false;
            
        }
        
    }

  @Override
    public void gameOver() {
        
        int yourScore = game.score(game.getYourCards());
        int houseScore = game.score(game.getHouseCards());
        
        display();
        
        if(yourScore == 21 || yourScore == houseScore){
            
            System.out.println("You lose!");
            
        }else if((yourScore <= 21 && houseScore > 21) || ((yourScore > houseScore) && (yourScore <21 && houseScore<21))){
            
            System.out.println("You Win!");
        }
        
    }

}