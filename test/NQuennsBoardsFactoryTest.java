import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class NQuennsBoardsFactoryTest {
	private Board boardA, boardB;
	private Queen queenA1, queenA2, queenA3, queenA4;
	private Queen queenB1, queenB2, queenB3, queenB4;

	ArrayList<Board> validBoards = new ArrayList<Board>();

	@Before
	public void setUp() {
		queenA1 = new Queen(new Square(0, 1));
		queenA2 = new Queen(new Square(1, 3));
		queenA3 = new Queen(new Square(2, 0));
		queenA4 = new Queen(new Square(3, 2));

		boardA = new Board();
		boardA.addPiece(queenA1);
		boardA.addPiece(queenA2);
		boardA.addPiece(queenA3);
		boardA.addPiece(queenA4);

		boardB = new Board();
		queenB1 = new Queen(new Square(0, 2));
		queenB2 = new Queen(new Square(1, 0));
		queenB3 = new Queen(new Square(2, 3));
		queenB4 = new Queen(new Square(3, 1));

		boardB.addPiece(queenB1);
		boardB.addPiece(queenB2);
		boardB.addPiece(queenB3);
		boardB.addPiece(queenB4);

		validBoards.add(boardA);
		validBoards.add(boardB);

	}

	@Test(expected = NQueensBoardsException.class)
	public void noHaySolucionParaN0() {
		NQuennsBoardsFactory.generate(0);

	}
	
	@Test(expected = NQueensBoardsException.class)
	public void noHaySolucionParaN2() {
		NQuennsBoardsFactory.generate(2);
	}

	@Test(expected = NQueensBoardsException.class)
	public void noHaySolucionParaN3() {
		NQuennsBoardsFactory.generate(3);
	}
	
	@Test
	public void hay4TablerosDistintosParaN4() {
		ArrayList<Board> boards= NQuennsBoardsFactory.generate(4);
		
		int boardsNumber = boards.size();
		assertEquals("Tableros distintos para N=4", 2, boardsNumber);
	}
	
	@Test
	public void comprobacionTablerosPara4N() {
		ArrayList<Board> boards= NQuennsBoardsFactory.generate(4);
		
		System.out.println(boards);
		
		assertEquals("Comprobacion de 2/2 tablero valido para N=4", true, boards.containsAll(validBoards));
	}
	
	@Test
	public void comprobacionNoContenidoTableroNoValidoPara4N() {
		Board noValidBoard = new Board();
		noValidBoard.addPiece(queenB1);
		noValidBoard.addPiece(queenB2);
		noValidBoard.addPiece(queenB3);
		
		// 'queenB4EstaEnDiagonalConB3' y queenB3 no son seguras entre si
		Queen queenB4EstaEnDiagonalConB3 = new Queen(new Square(3, 2));
		noValidBoard.addPiece(queenB4EstaEnDiagonalConB3);
		
		ArrayList<Board> boards= NQuennsBoardsFactory.generate(4);
		
		assertEquals("Comprobacion de no existencia de tablero invalido en el resultado final para N=4", false, boards.contains(noValidBoard));
	}
	
	@Test
	public void hay92TablerorDistintosParaN8() {
		ArrayList<Board> boards= NQuennsBoardsFactory.generate(8);
		
		int boardsNumber = boards.size();
		assertEquals("Tableros distintos para N=8", 92, boardsNumber);
	}
}
