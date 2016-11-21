package com.company;

/**
 * Created by student2 on 14.11.16.
 */
public abstract class Player {
    Hand hand = new Hand();
    private Intellect intrllect;

    public Player(Intellect intrllect) {
        this.intrllect = intrllect;
    }

    public void take(Card current) {
        hand.add(current);
    }

    public Command decision() {
        int score = hand.getScore();
        return intrllect.decide(score);
    }
}
