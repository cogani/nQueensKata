import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class QueenTest {
	Queen centerQueen;
	
	@Before
	public void setup(){
		Square centeredSquare = new Square(2,3);
		centerQueen = new Queen(centeredSquare);
	}

	@Test
	public void testingMenacingSameRank() {
		Square square2 = new Square(2,5);
		
		assertTrue(centerQueen.isSquareReached(square2));	
	}
	
	@Test
	public void testingMenacingSameFile() {	
		Square square2 = new Square(5,3);
		
		assertTrue(centerQueen.isSquareReached(square2));	
	}
	
	@Test
	public void testingMenacingSameDiagonal() {
		Square square2 = new Square(3,4);
		
		assertTrue(centerQueen.isSquareReached(square2));	
	}
	
	
	@Test
	public void testingNoMenacingSquare() {
		Square square2 = new Square(3,1);
		
		assertFalse(centerQueen.isSquareReached(square2));	
	}
	

}
