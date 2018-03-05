package com.mypieceofcode.recommendation.correlation;

import com.mypieceofcode.recommendation.model.Profile;
import com.mypieceofcode.recommendation.model.ProfileBuilder;
import org.junit.Assert;
import org.junit.Test;

import static com.mypieceofcode.recommendation.utils.Const.*;

public class CorrelationTest {

  private static final double MAX_VALUE = 1;
  private static final double MIN_VALUE = 0;

  private final Profile USER_PROFILE = new ProfileBuilder().builder()
          .setValue(S_FOOTBALL, 3)
          .setValue(M_ROCK, 6)
          .setValue(M_FILM, 6)
          .setValue(A_FOOTBALL, 6)
          .setValue(A_RUNNING, 4)
          .build();

  private final Profile ROCK_EVENT = new ProfileBuilder().builder()
          .setValue(M_ROCK, 6).build();

  private final Profile DISCO_POLO_EVENT = new ProfileBuilder().builder()
          .setValue(M_DISCO_POLO, 6).build();

  private final Profile RUNNING_EVENT = new ProfileBuilder().builder()
          .setValue(A_RUNNING, 6).build();


  @Test
  public void expectRockEventMoreSimilarToUserProfile(){

      double result = Correlation.measure(USER_PROFILE.getProfile(), ROCK_EVENT.getProfile());

      Assert.assertTrue("Result should be between 0-1. Actual: " + result,result >= MIN_VALUE);
      Assert.assertTrue("Result should be between 0-1. Actual: " + result,result <= MAX_VALUE);
  }

  @Test
  public void expectRockIsMoreSimilarThanDisco(){
      double rockMeasure = Correlation.measure(USER_PROFILE.getProfile(), ROCK_EVENT.getProfile());
      double discoMeasure = Correlation.measure(USER_PROFILE.getProfile(), DISCO_POLO_EVENT.getProfile());

      Assert.assertTrue("Rock should have bigger correlation than disco-polo: \n" +
              "Rock: " +rockMeasure +" disco: "+ discoMeasure, rockMeasure > discoMeasure);
  }

  @Test
    public void expectRockMusicShouldBiggestValue(){
      double rockMeasure = Correlation.measure(USER_PROFILE.getProfile(), ROCK_EVENT.getProfile());
      double discoMeasure = Correlation.measure(USER_PROFILE.getProfile(), DISCO_POLO_EVENT.getProfile());
      double runningMeasure = Correlation.measure(USER_PROFILE.getProfile(), RUNNING_EVENT.getProfile());

      Assert.assertTrue("Running should have bigger correlation than disco-polo: \n" +
              "Rock: " +rockMeasure +" disco: "+ discoMeasure, runningMeasure > discoMeasure);
      Assert.assertTrue("Running should have less correlation than rock: \n" +
              "Rock: " +rockMeasure +" disco: "+ discoMeasure, runningMeasure < rockMeasure);
  }


}