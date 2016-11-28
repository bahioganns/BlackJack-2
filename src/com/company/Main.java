package com.company;

import java.util.LinkedList;
import java.util.List;

import static com.company.Table.dealer;
import static com.company.Table.players;

public class Main {

    public static void main(String[] args) {
        while(true) {
            Table table = new Table();

            Table.distribute();

            Table.game();

            Table.end();

            Table.again();
        }
    }
}
