package com.company;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Player> players = new LinkedList<>();
        //объявление и добавление игроков в список
        players.add(new Computer(new LimitIntellect(14), "Comp1"));
        players.add(new Computer(new LimitIntellect(20), "Comp2"));
        players.add(new Human(new ConsileIntellect(), "Player1"));
        Dealer dealer = new Dealer();
        players.add(dealer);
        //диллер сдает две карты
        for (Player player : players) {
            //из колоды диллеру, диллер игроку, игрок в руку;\
            //System.out.println(player.hand);
            dealer.deal(player);
            dealer.deal(player);
            //System.out.println(player.hand);
        }
        //процесс игры; диллер спрашивает игроков;
        for (Player player: players) {

            while(true){
                System.out.println(player.name + " " + player.hand.getScore() + ": "+ player.hand);
                Command command = player.decision();
                System.out.println(command);
                if (command == Command.STAND)
                    break;
                if (command == Command.HIT)
                    dealer.deal(player);
            }
        }
        for(Player player: players) {
            if (player != dealer) {
                if (player.hand.getScore() > 21)
                player.condition = Condition.LOSS;
                else if (dealer.hand.getScore() < player.hand.getScore())
                player.condition = Condition.WIN;
                else if (dealer.hand.getScore() > player.hand.getScore())
                    player.condition = Condition.LOSS;
                else if (dealer.hand.getScore() == player.hand.getScore())
                    player.condition = Condition.DRAW;
                else
                    player.condition = Condition.WIN;
                System.out.println(player.name + " " + player.condition);
            }
        }
    }
}
