import static org.junit.Assert.assertEquals;
import org.junit.*;

public class FightTest{
  Fight fight;
  Attack attack;
  Defence defence;

  @Before
  public void before() {
    fight = new Fight("Final");
    attack = new Attack();
    defence = new Defence();
  }

  @Test
  public void hasRound() {
    assertEquals( "Final", fight.getRound() );
  }

  @Test
  public void initialScoreIsZero() {
    assertEquals( 0, fight.getScore() );
  }

  @Test
  public void canScorePoint() {
    fight.scorePoint(attack);
    assertEquals( 1, fight.getScore() );
  }

  @Test
  public void canWinFight() {
    for ( int i = 0; i < 15; i++ ) {
      fight.scorePoint(attack);
    }
    assertEquals( 15, fight.getScore() );
    assertEquals( true, fight.fightWon() );
  }

  @Test
  public void cantScoreMoreThan15() {
    for ( int i = 0; i < 20; i++ ) {
      fight.scorePoint(attack);
    }
    assertEquals( 15, fight.getScore() );
    assertEquals( true, fight.fightWon() );
  }

  @Test
  public void countPointsFromAttacks() {
    for ( int i = 0; i < 8; i++ ) {
      fight.scorePoint(attack);
    }
    for ( int i = 0; i < 7; i++ ) {
      fight.scorePoint(defence);
    }
    assertEquals( 8, fight.pointsFromAttacks() );
  }

  @Test
  public void countPointsFromDefence() {
    for ( int i = 0; i < 6; i++ ) {
      fight.scorePoint(defence);
    }
    assertEquals( 6, fight.pointsFromDefence() );
  }

  @Test
  public void givesAttackPercentage() 
  {
    for ( int i = 0; i < 10; i++ ) 
    {
      fight.scorePoint(attack);
    }
    for ( int i = 0; i < 5; i++ ) 
    {
      fight.scorePoint(defence);
    }
    assertEquals( 10, fight.pointsFromAttacks() );
    assertEquals( 5, fight.pointsFromDefence() );
    assertEquals( 15, fight.getScore() );
    assertEquals( true, fight.fightWon() );
    assertEquals( 66.67, (fight.percentagePointsFromAttacks()), 1 );
  }

}