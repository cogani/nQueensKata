import java.util.ArrayList;

public class NQuennsBoardsFactory {
	private NQuennsBoardsFactory() {

	}

	public static ArrayList<Board> generate(final int dim) {
		if (dim == 0 || dim == 2 || dim == 3)
			throw new NQueensBoardsException("No possible boards for N=" + dim);
		else {
			return boardsGenerator(dim);
		}
	}

	private static ArrayList<Board> boardsGenerator(int dim) {
		ArrayList<Board> generatedBoards = new ArrayList<Board>();
		Piece[] queens = new Queen[dim];
		int initialDimension = 0;

		searchingBoards(generatedBoards, queens, initialDimension);

		return generatedBoards;
	}

	private static void searchingBoards(final ArrayList<Board> generatedBoards,
			final Piece[] queens, final int rank) {
		final int finalDimension = queens.length;

		if (rank == finalDimension) {
			Board board = new Board(queens);
			generatedBoards.add(board);
		} else {
			for (int file = 0; file < finalDimension; file++) {
				Queen newQueen = new Queen(new Square(rank, file));
				queens[rank] = newQueen;
				if (isSafe(queens, rank))
					searchingBoards(generatedBoards, queens, rank + 1);
			}
		}
	}

	private static boolean isSafe(final Piece[] queens, final int index) {
		Piece targetQueen = queens[index];

		for (int i = 0; i < index; i++) {
			if (queens[i].isThreateningTo(targetQueen))
				return false;
		}
		return true;
	}
}
