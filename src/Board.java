import java.util.ArrayList;

public class Board {
	private ArrayList<Piece> pieces = new ArrayList<Piece>();

	public Board() {
		// TODO Auto-generated constructor stub
	}

	public Board(Piece[] pieces) {
		for (Piece piece : pieces) {
			this.addPiece(piece);
		}
	}

	public void addPiece(Piece piece) {
		pieces.add(piece);
	}
	
	public boolean isSafe(Queen queen2) {
		for (Piece piece : pieces) {
			if (piece.isThreateningTo(queen2))
				return false;
		}
		return true;
	}

	public boolean contains(Piece piece) {
		return pieces.contains(piece);
	}

	public int piecesNumber() {
		return pieces.size();
	}

	@Override
	public String toString() {
		return "Board [pieces=" + pieces + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pieces == null) ? 0 : pieces.hashCode());
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
		Board other = (Board) obj;
		if (pieces == null) {
			if (other.pieces != null)
				return false;
		} else if (!pieces.equals(other.pieces))
			return false;
		return true;
	}
}
