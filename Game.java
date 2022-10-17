package blackjack;

import java.util.Random;
import java.util.Scanner;

public class Game 
{
    Player []player=new Player[4];
    Card []card_deck=new Card[52];
    static int high_score=0;
   Scanner input=new Scanner(System.in); 
   public void Generate()
   {
       int index=0;
       for(int suit=0;suit<4;suit++){
           int value=1;
           for(int rank=0;rank<13;rank++){
               if(rank<10){
                   value=rank+1;
                   card_deck[index] =new Card(suit , rank , value);
               }
               else{
                   value=10;
                   card_deck[index] =new Card(suit , rank , value);
               }
              // System.out.println(card_deck[index].getSuit()+"  "+card_deck[index].getRank()+"  "+card_deck[index].getValue()); 
              index++;
           }
          
        }
    }
   public Card return_card(){
   Random rand =new Random();
   int randomchoice = rand.nextInt(52);
   Card new_card;
   if(card_deck[randomchoice]!=null)
   {
       new_card=new Card(card_deck[randomchoice]);
       card_deck[randomchoice]=null;
   }
   else{
     do{
         randomchoice = rand.nextInt(52);
         
     }while(card_deck[randomchoice]==null);
     new_card=new Card(card_deck[randomchoice]);
      card_deck[randomchoice]=null;
   }
   return new_card;
   
   }
   public void Get(){
      // String Name;
       //Player (Name);
        for(int i=0;i<4;i++){
            System.out.print("enter the name of the player"+(i+1)+" : ");
            
            player[i]=new Player();
            player[i].Name=input.nextLine();
           // player[i].setArr(return_card());
           player[i].arr[0]=return_card();
           player[i].arr[1]=return_card();
        }
       
   }
   public void update_score(Player p_turn){
       p_turn.Score=0;
       for(int i=0;i<11;i++){
           if(p_turn.arr[i]==null){
               break;
           }
           else{
               p_turn.Score+=p_turn.arr[i].getValue();
           }
       }
   }
   public void maximum(Player max_score){
       if(max_score.Score > high_score && max_score.Score<=21){
           high_score=max_score.Score;
       }
   }
}
