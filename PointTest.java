import static org.junit.Assert.assertEquals;
import org.junit.*;

public class PointTest {
  Point point1;
  Point point2;

  @Before 
  public void before() {
    point1 = new Point("attack");
    point2 = new Point("defence");
  }

  @Test
  public void hasType() {
    assertEquals( "attack", point1.getType() );
    assertEquals( "defence", point2.getType() );
  }

}