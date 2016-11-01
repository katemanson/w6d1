import java.util.*;

public class Fight {

  private String round;
  private ArrayList<Point> score; 

  public Fight(String round) {
    this.round = round;
    this.score = new ArrayList<Point>();
  }

  public String getRound() {
    return this.round;
  }

  public int getScore() {
    return this.score.size();
  }

  public void scorePoint(Point point) {
    if ( fightWon() ) return;
    this.score.add(point);
  }

  public boolean fightWon() {
    return getScore() >= 15;
  }

  public int pointsFromAttacks() {
    int total = 0;
    for ( int i = 0; i < getScore(); i++ ) {
      if ( score.get(i) instanceof Attack ) {
        total += 1;
      }
    }
    return total; 
  }

  public int pointsFromDefence() {
    int total = 0;
    for ( int i = 0; i < getScore(); i++ ) {
      if ( score.get(i) instanceof Defence ) {
        total += 1;
      }
    }
    return total;
  }

  public double percentagePointsFromAttacks() {
    double percentage = (double) (pointsFromAttacks() * 100) / getScore();
    return percentage;
  }

}