package com.company;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Player> players = new LinkedList<>();
        //объявление и добавление игроков в список
        players.add(new Computer(new LimitIntellect(14)));
        players.add(new Computer(new LimitIntellect(20)));
        players.add(new Human(new ConsileIntellect()));
        Dealer dealer = new Dealer();
        players.add(dealer);
        //диллер сдает две карты
        for (Player player : players) {
            //из колоды диллеру, диллер игроку, игрок в руку;
            dealer.deal(player);
            dealer.deal(player);
            System.out.println(player.hand);
        }
        //процесс игры; диллер спрашивает игроков;
        for (Player player: players) {
            while(true){
                Command command = player.decision();
                System.out.println(player.hand.getScore()+ " : "+ player.hand + ":" + command);
                if (command == Command.STAND)
                    break;
                if (command == Command.HIT)
                    dealer.deal(player);
            }
        }
    }
}
