public abstract class Piece {
	protected Square square;
	
	public Piece(Square square) {
		this.square = square;
	}

	public boolean isThreateningTo(Piece piece) {
		return isSquareReached(piece.getSquare());
	}
	protected abstract boolean isSquareReached(Square square);
	
	public Square getSquare() {
		return square;
	}

	public String toString() {
		return square.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((square == null) ? 0 : square.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Piece other = (Piece) obj;
		if (square == null) {
			if (other.square != null)
				return false;
		} else if (!square.equals(other.square))
			return false;
		return true;
	}
}
