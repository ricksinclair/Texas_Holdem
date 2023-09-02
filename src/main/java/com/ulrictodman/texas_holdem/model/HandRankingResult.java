package com.ulrictodman.texas_holdem.model;

import com.ulrictodman.texas_holdem.constants.HandRanking;

import java.util.List;
import java.util.Objects;

public class HandRankingResult {

    private boolean isHandRanking;
    private HandRanking ranking;
    private List<Card> bestHand;
    private Card kicker;

    private Card highCard;



    public HandRankingResult( HandRanking handranking ) {
        this.ranking = handranking;

    }

    public Card getHighCard() {
        return highCard;
    }

    public void setHighCard( Card highCard ) {
        this.highCard = highCard;
    }

    public boolean getRanking() {
        return isHandRanking;
    }


    public void setIsHandRanking( boolean handRanking ) {
        isHandRanking = handRanking;
    }

    public HandRanking getHandRanking() {
        return ranking;
    }

    public void setRanking( HandRanking ranking ) {
        this.ranking = ranking;
    }

    public List<Card> getBestHand() {
        return bestHand;
    }

    public void setBestHand( List<Card> bestHand ) {
        this.bestHand = bestHand;
    }

    public Card getKicker() {
        return kicker;
    }

    public void setKicker( Card kicker ) {
        this.kicker = kicker;
    }

    // equals Method


    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( !( o instanceof HandRankingResult that ) ) return false;
        return getHandRanking () == that.getHandRanking () && getRanking () == that.getRanking () && Objects.equals ( getBestHand (), that.getBestHand () ) && Objects.equals ( getKicker (), that.getKicker () ) && Objects.equals ( getHighCard (), that.getHighCard () );
    }

    @Override
    public int hashCode() {
        return Objects.hash ( getHandRanking (), getRanking (), getBestHand (), getKicker (), getHighCard () );
    }

    @Override
    public String toString() {
        return "HandRankingResult{" +
                "isHandRanking=" + isHandRanking +
                ", ranking=" + ranking +
                ", bestHand=" + bestHand +
                ", kicker=" + kicker +
                ", highCard=" + highCard +
                '}';
    }
}
