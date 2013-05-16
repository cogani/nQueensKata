public class Queen extends Piece {

	public Queen(Square square) {
		super(square);
	}

	@Override
	protected boolean isSquareReached(Square otherSquare) {
		return (square.inSameFile(otherSquare)
				|| square.inSameRank(otherSquare) || square
					.inDiagonal(otherSquare));
	}
}
