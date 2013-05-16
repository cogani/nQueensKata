import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class SquareTest {
	Square squareCentro;
	Square squareSO, squareNE, squareNO, squareSE;
	
	@Before
	public void setup() {
		squareCentro = new Square(2,3);
		squareSE = new Square(3,4);
		squareSO = new Square(3,2);
		squareNE = new Square(1,4);
		squareNO = new Square(1,2);
	}

	@Test
	public void testingSameRank() {
		Square square1 = new Square(0,0);
		Square square2 = new Square(0,1);
		assertTrue(square1.inSameRank(square2));
	}
	
	@Test
	public void testingNoSameRank() {
		Square square1 = new Square(0,0);
		Square square2 = new Square(1,1);
		assertFalse(square1.inSameRank(square2));
	}
	
	@Test
	public void testingSameFile() {
		Square square1 = new Square(0,1);
		Square square2 = new Square(1,1);
		assertTrue(square1.inSameFile(square2));
	}
	
	@Test
	public void testingNoSameFile() {
		Square square1 = new Square(0,0);
		Square square2 = new Square(1,1);
		assertFalse(square1.inSameFile(square2));
	}	
	
	@Test
	public void testingSameMajorDiagonalSE() {
		assertTrue(squareCentro.inMajorDiagonal(squareSE));
	}
	
	@Test
	public void testingSameMajorDiagonalNO() {
		assertTrue(squareCentro.inMajorDiagonal(squareNO));
	}
	
	@Test
	public void testingSameMinorDiagonalNE() {
		assertTrue(squareCentro.inMinorDiagonal(squareNE));
	}
	
	@Test
	public void testingSameMinorDiagonalSO() {
		assertTrue(squareCentro.inMinorDiagonal(squareSO));
	}
	
/*
 * Probando diagonales con el metodo unificado 'inDiagonal'
 */
	
	@Test
	public void testingSameDiagonalCentroSE() {

		assertTrue(squareCentro.inDiagonal(squareSE));
	}
	
	@Test
	public void testingSameDiagonalCentroNO() {

		assertTrue(squareCentro.inDiagonal(squareNO));
	}
	
	@Test
	public void testingSameDiagonalCentroNE() {

		assertTrue(squareCentro.inDiagonal(squareNE));
	}
	
	@Test
	public void testingSameDiagonalCentroSO() {
		assertTrue(squareCentro.inDiagonal(squareSO));
	}
	
	@Test
	public void testingNoInTheSameDiagonal() {
		Square otherSquare = new Square(0,0);
		assertFalse(squareCentro.inDiagonal(otherSquare));
	}
}
