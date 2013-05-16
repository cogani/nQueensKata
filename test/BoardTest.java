import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class BoardTest {
	
	Board board;
	Queen centralQueen23, diagonalSEQueen;
	
	@Before
	public void setup(){
		/* No olvidad que el setup se ejecuta PREVIAMENTE PARA CADA TEST
		 * 
		 */
		board = new Board();
		Square square23 = new Square(2,3);
		centralQueen23 = new Queen(square23);
		
		Square square34 = new Square(3,4);
		diagonalSEQueen = new Queen(square34);
		
	}

	@Test
	public void checkContainsAddedPiece() {
		board.addPiece(centralQueen23);
		
		assertTrue(board.contains(centralQueen23));
	}
	
	@Test
	public void checkNotContainsNotAddedPiece() {
		board.addPiece(centralQueen23);
		assertFalse(board.contains(diagonalSEQueen));
	}
	
	@Test
	public void checkAddedPiecesNumber() {
		board.addPiece(centralQueen23);
		board.addPiece(diagonalSEQueen);
		
		assertEquals(2, board.piecesNumber());
	}
	
	@Test
	public void checkContains2AddedPiece() {
		board.addPiece(centralQueen23);
		board.addPiece(diagonalSEQueen);
		
		assertTrue(board.contains(centralQueen23));
		assertTrue(board.contains(diagonalSEQueen));
	}
	
	@Test
	public void isNotSafeAdd2QueenInSameRank() {
		board.addPiece(centralQueen23);
		
		Square square24 = new Square(2,4);
		Queen threatenedQueen = new Queen(square24);
		
		assertFalse(board.isSafe(threatenedQueen));
	}
	
	@Test
	public void isNotSafeAdd2QueenInSameFile() {
		board.addPiece(centralQueen23);
		
		Square square03 = new Square(0,3);
		Queen threatenedQueen = new Queen(square03);
		
		assertFalse(board.isSafe(threatenedQueen));
	}	
	
	@Test
	public void isNotSafe2QueensInDiagonal() {
		board.addPiece(centralQueen23);
		
		assertFalse(board.isSafe(diagonalSEQueen));
	}
	
	@Test
	public void isSafeAddQueenNotThreatened() {
		board.addPiece(centralQueen23);
		
		Square square00 = new Square(0,0);
		Queen notThreatenedQueen = new Queen(square00);
		
		assertTrue(board.isSafe(notThreatenedQueen));
	}	
}
