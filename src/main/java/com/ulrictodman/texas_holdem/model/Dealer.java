package com.ulrictodman.texas_holdem.model;

import com.ulrictodman.texas_holdem.constants.Rank;
import com.ulrictodman.texas_holdem.constants.Suit;

import java.util.ArrayList;
import java.util.List;

public class Dealer {

    private List<Card> deck;

    private List<Card> flop;

    private Card turn;

    private Card river;


    public Dealer() {
        this.deck = shuffleDeck ();
        this.flop = new ArrayList<> ();
        this.turn = null;
        this.river = null;
        dealAllCards ();
    }



    public List<Card> shuffleDeck() {
        List<Card> freshDeck = new ArrayList<Card> ();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                freshDeck.add(new Card(rank, suit));
            }
        }

        //shuffle the deck
        for (int i = 0; i < freshDeck.size(); i++) {
            int randomIndex = (int) (Math.random() * freshDeck.size());
            Card temp = freshDeck.get(i);
            freshDeck.set(i, freshDeck.get(randomIndex));
            freshDeck.set(randomIndex, temp);
        }

        return freshDeck;
    }

    public void dealFlop() {
        deck.remove ( 0 );

        for (int i = 0; i < 3; i++) {
            flop.add(deck.remove(0));
        }
    }

    public void dealTurn() {
        deck.remove ( 0 );
        turn = deck.remove(0);
    }

    public void dealRiver() {
        deck.remove ( 0 );

        river = deck.remove(0);
    }

    public void dealAllCards() {
        dealFlop();
        dealTurn();
        dealRiver();
    }
    public List<Card> getCommunityCards() {
        List<Card> communityCards = new ArrayList<> ( flop );
        communityCards.add(turn);
        communityCards.add(river);
        return communityCards;
    }



    public Card getTurn() {
        return turn;
    }

    public void setTurn(Card turn) {
        this.turn = turn;
    }

    public Card getRiver() {
        return river;
    }

    public void setRiver(Card river) {
        this.river = river;
    }


    public void dealCard(Player player) {

        //check if the player has less than 2 cards
        if ( player.getHand ().size () < 2 ) {
            //deal the player a card
            Card card = deck.remove ( 0 );
            player.getHand ().add ( card );
        } else {
            player.clearHand ();
            Card card = deck.remove ( 0 );
            player.getHand ().add ( card );

        }

    }








}