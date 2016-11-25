package com.company;

import java.util.Scanner;

/**
 * Created by student2 on 21.11.16.
 */
public class ConsileIntellect extends Intellect {

    private Scanner in = new Scanner(System.in);

    @Override
    public Command decide(int score) {
        while (true) {
            System.out.println("HIT/STAND? ");
            String c = in.nextLine();

            //startsWith - похожее начало;
            if ("hit".startsWith(c.toLowerCase()))
                return Command.HIT;
            if ("stand".startsWith(c.toLowerCase()))
                return Command.STAND;

            System.out.println("Can't understand, pleas repeat");
        }
    }
}
