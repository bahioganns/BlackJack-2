package com.company;

/**
 * Created by student2 on 14.11.16.
 */
public abstract class Player {
    Hand hand = new Hand();
    Condition condition = Condition.IN_GAME;
    String name;
    private Intellect intrllect;

    public Player(Intellect intrllect, String name) {
        this.intrllect = intrllect;
        this.name =name;
    }

    public void take(Card current) {
        hand.add(current);
    }

    public Command decision() {
        int score = hand.getScore();
        if (score > 21)
            return Command.STAND;
        return intrllect.decide(score);
    }
}
