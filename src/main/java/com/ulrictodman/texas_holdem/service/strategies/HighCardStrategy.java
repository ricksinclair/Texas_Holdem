package com.ulrictodman.texas_holdem.service.strategies;

import com.ulrictodman.texas_holdem.constants.HandRanking;
import com.ulrictodman.texas_holdem.model.Card;
import com.ulrictodman.texas_holdem.model.Dealer;
import com.ulrictodman.texas_holdem.model.HandRankingResult;
import com.ulrictodman.texas_holdem.model.Player;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class HighCardStrategy implements HandRankingStrategy {


    @Override
    public HandRankingResult evaluateHand( Player player, Dealer dealer ) {

        List<Card> fullHand = new ArrayList<> ();
        fullHand.addAll ( player.getHand () );
        fullHand.addAll ( dealer.getCommunityCards () );
        int lastIndex = fullHand.size () - 1;
        int secondToLastIndex = fullHand.size () - 2;
        fullHand.sort ( Comparator.comparing ( Card::getRank ) );
        Card highCard = fullHand.get ( lastIndex );

        if ( areLastCardsIdentical ( fullHand, lastIndex, secondToLastIndex ) ) {
            highCard = isSuitGreater ( fullHand, lastIndex, secondToLastIndex ) ? new Card ( fullHand.get ( lastIndex ).getRank (), fullHand.get ( lastIndex ).getSuit () ) : new Card ( fullHand.get ( secondToLastIndex ).getRank (), fullHand.get ( secondToLastIndex ).getSuit () );
        }
        HandRankingResult result = new HandRankingResult ( HandRanking.HIGH_CARD );
        result.setIsHandRanking ( true );
        result.setBestHand ( getBestHand ( player, dealer ) );
        result.setKicker ( fullHand.get ( 1 ) );
        result.setHighCard ( highCard );
        return result;
    }

    @Override
    public List<Card> getBestHand( Player player, Dealer dealer ) {
        List<Card> fullHand = new ArrayList<> ();
        fullHand.addAll ( player.getHand () );
        fullHand.addAll ( dealer.getCommunityCards () );
        fullHand.sort ( Comparator.comparing ( Card::getRank ));
        return fullHand.subList ( 2, fullHand.size () );
    }

    private static boolean isSuitGreater( List<Card> fullHand, int lastIndex, int secondToLastIndex ) {
        return fullHand.get ( lastIndex ).getSuit ().ordinal () > fullHand.get ( secondToLastIndex ).getSuit ().ordinal ();
    }

    private static boolean areLastCardsIdentical( List<Card> fullHand, int lastIndex, int secondToLastIndex ) {
        return fullHand.get ( lastIndex ).getRank () == fullHand.get ( secondToLastIndex ).getRank ();
    }

    public static void main( String[] args ) {
        HighCardStrategy highCardStrategy = new HighCardStrategy ();
        Player player = new Player ();
        Dealer dealer = new Dealer ();
        dealer.dealCard ( player );
        dealer.dealCard ( player );
        System.out.println ( highCardStrategy.evaluateHand ( player, dealer ) );
    }
}
