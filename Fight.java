public class Fight {

  private String round;
  private Point[] score; 

  public Fight(String round) {
    this.round = round;
    this.score = new Point[15];
  }

  public String getRound() {
    return this.round;
  }

  public int getScore() {
    int totalPoints = 0;
    for ( int i = 0; i < 15; i++ ) {
      if (score[i] != null){
        totalPoints++;
      }
    }
    return totalPoints;
  }

  public void scorePoint(Point point) {
    if(fightWon()) return;
    int totalPoints = getScore();
    score[totalPoints] = point;
  }

  public boolean fightWon() {
    return getScore() >= score.length;
  }

  public int pointsFromAttacks() {
    int pointsFromAttacks = 0;
    for ( int i = 0; i < 15; i++ ) {
      if (score[i].getType() == "attack") {
        pointsFromAttacks++;
      }
    }
    return pointsFromAttacks;
  }

  public int pointsFromDefence() {
    int pointsFromDefence = 0;
    for ( int i = 0; i < 15; i++ ) {
      if (score[i].getType() == "defence") {
        pointsFromDefence++;
      }
    }
    return pointsFromDefence;
  }

  public int percentagePointsFromAttacks() {
    int attackPercentage = (int) Math.round((pointsFromAttacks() / getScore()) * 100.00);
    return attackPercentage;
  }

}