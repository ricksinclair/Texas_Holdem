package com.ulrictodman.texas_holdem.model;

import com.ulrictodman.texas_holdem.constants.Rank;
import com.ulrictodman.texas_holdem.constants.Suit;

public class Card {
     Rank rank;
     Suit suit;

        public Card(Rank rank, Suit suit){
            this.rank = rank;
            this.suit = suit;
        }

        public Rank getRank(){
            return rank;
        }

        public Suit getSuit(){
            return suit;
        }

        //hash code, equals, and toString methods
        @Override
        public int hashCode() {
            int hash = 7;
            hash = 97 * hash + this.rank.ordinal();
            hash = 97 * hash + this.suit.ordinal();
            return hash;
        }

        @Override
        public String toString(){
            return rank + " of " + suit;
        }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( !( o instanceof Card card ) ) return false;
        return getRank () == card.getRank () && getSuit () == card.getSuit ();
    }
}
