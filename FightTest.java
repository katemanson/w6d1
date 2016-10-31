import static org.junit.Assert.assertEquals;
import org.junit.*;

public class FightTest{
  Fight fight;
  Point point1;
  Point point2;

  @Before
  public void before() {
    fight = new Fight("Final");
    point1 = new Point("attack");
    point2 = new Point("defence");
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
    fight.scorePoint(point1);
    assertEquals( 1, fight.getScore() );
  }

  @Test
  public void canWinFight() {
    for ( int i = 0; i < 15 ; i++ ) {
      fight.scorePoint(point1);
    }
    assertEquals(15, fight.getScore() );
    assertEquals(true, fight.fightWon() );
  }

  @Test
  public void countPointsFromAttacks() {
    for ( int i = 0; i < 8; i++ ) {
      fight.scorePoint(point1);
    }
    for ( int i = 0; i < 7; i++ ) {
      fight.scorePoint(point2);
    }
    assertEquals( 8, fight.pointsFromAttacks() );
  }

  @Test
  public void countPointsFromDefence() {
    for ( int i = 0; i < 6; i++ ) {
      fight.scorePoint(point2);
    }
    for ( int i = 0; i < 9; i++ ) {
      fight.scorePoint(point1);
    }
    assertEquals( 6, fight.pointsFromDefence() );
  }


}