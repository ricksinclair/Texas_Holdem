package com.ulrictodman.texas_holdem.service.strategies;
import com.ulrictodman.texas_holdem.constants.HandRanking;
import com.ulrictodman.texas_holdem.model.Card;
import com.ulrictodman.texas_holdem.model.Dealer;
import com.ulrictodman.texas_holdem.model.HandRankingResult;
import com.ulrictodman.texas_holdem.model.Player;

import java.util.List;

public interface HandRankingStrategy {

       HandRankingResult evaluateHand( Player player, Dealer dealer );

      List<Card> getBestHand( Player player, Dealer dealer );

}
