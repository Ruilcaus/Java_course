package package_lecture1p1;

import org.testng.annotations.Test;

public class SquareTests {

  @Test
  public void testArea(){
    Square s = new Square(5);
   assert s.area() == 25;
  }

}