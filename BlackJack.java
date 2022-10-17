package blackjack;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author Andrew
 */
public class BlackJack {
    Game game=new Game();
    public static void main(String[] args){
        GUI gui = new GUI();
        BlackJack object=new BlackJack();
        object.game.Generate();
        object.game.Get();
        gui.runGUI(object.game.card_deck,object.game.player[0].arr,object.game.player[1].arr,object.game.player[2].arr,object.game.player[3].arr);
        object.start(gui);
        object.dealer_turn(gui);
        object.winner_player();
    }
   public void start(GUI gui)
    {
       Scanner scanner =new Scanner(System.in);

       for(int i=0;i<3;i++){
          int counter=2;
          game.update_score(game.player[i]);


            while(true){
                System.out.print(game.player[i].Name+" score is: "+ game.player[i].Score+" if you want to hit press 1, 2 for stand: ");
                int input = scanner.nextInt();
                if(input==1){
                        game.player[i].arr[counter]=game.return_card();
                        gui.updatePlayerHand(game.player[i].arr[counter], i);
                        game.update_score(game.player[i]);
                        ++counter;

                    if(game.player[i].Score>21){
                        System.out.println("Busted his score: "+ game.player[i].Score);
                        break;
                    }
                    if(game.player[i].Score==21){
                        game.update_score(game.player[i]);
                        System.out.println(game.player[i].Name+" have Black Jack");
                        break;
                    }
                }
                else{
                    game.maximum(game.player[i]);
                    break;
                }
       }
       }
    }
  public void dealer_turn(GUI gui){
      int counter=2;
      while(Game.high_score>game.player[3].Score){
          game.player[3].arr[counter]=game.return_card();
          gui.updateDealerHand(game.player[3].arr[counter], game.card_deck);
          game.update_score(game.player[3]);
          counter++;
     
          if(game.player[3].Score==21){
              System.out.println(game.player[3].Name +" have Black Jack");
          }
          else if(game.player[3].Score>21){
              System.out.println(game.player[3].Name+" is Busted");
          }
          }
          game.maximum(game.player[3]);
    }
  public void winner_player(){
      System.out.println("high score is "+Game.high_score);
      int tie=0;
      for(int i=0;i<4;i++){
      if(game.player[i].Score <= 21 && Game.high_score==game.player[i].Score){
          tie++;
      }
  }
      if(tie==1){
          for(int i=0;i<4;i++){
              if(Game.high_score == game.player[i].Score){
                  System.out.println(game.player[i].Name+" is the winner");
              }
          }
      }
      else{
          System.out.println("\nPush");
      }
  }
}
