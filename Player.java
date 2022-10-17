/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author Andrew
 */
public class Player {
    String Name;
    int Score=0;
    Card []arr=new Card[11];
    boolean blackjack;
    boolean lost;
    int counter=0;

//    public Player(String Name) {
//        this.Name = Name;
//    }

    public void setArr(Card arr) {
        this.arr[counter] = arr;
        counter++;
        Score+=arr.getValue();
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

}
