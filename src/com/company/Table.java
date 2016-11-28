package com.company;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by student2 on 28.11.16.
 */
public class Table {


        static List<Player> players = new LinkedList<>();
        String[] names = {"Степа", "Лиза", "Лера", "Маша", "Вероника", "Саша", "Анон", "Наташа", "Ксюша", "Соня", ""};
        static Dealer dealer = new Dealer();
    public Table() {
        players.add(new Computer(new LimitIntellect(14), names[(int)(Math.random()*10)]));
        players.add(new Computer(new LimitIntellect(20), names[(int)(Math.random()*10)]));
        names[10] = "ты сам";//добавить возможность выбирать имя самому.
        players.add(new Human(new ConsileIntellect(), names[10]));
        players.add(dealer);
    }


    public static void distribute() {
        for (Player player : players) {
            //из колоды диллеру, диллер игроку, игрок в руку;\
            dealer.deal(player);
            dealer.deal(player);

        }
    }

    public static void game() {
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
    }

    public static void end() {
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

    public static void again() {
        for(Player player: players){
            player.hand.clean();
        }
    }
}
