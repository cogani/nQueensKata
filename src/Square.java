public class Square {
	final int rank;
	final int file;
	Piece piece;

	public Square(int rank, int file) {
		this.rank = rank;
		this.file = file;
	}

	public boolean inSameRank(Square otherSquare) {
		return rank == otherSquare.getRank();
	}

	public boolean inSameFile(Square otherSquare) {
		return file == otherSquare.getFile();
	}
	
	public boolean inDiagonal(Square otherSquare) {
		return(inMajorDiagonal(otherSquare) || inMinorDiagonal(otherSquare));
	}

	public boolean inMajorDiagonal(Square otherSquare) {
		return file - otherSquare.getFile() == rank - otherSquare.getRank();

	}

	public boolean inMinorDiagonal(Square otherSquare) {
		return otherSquare.getFile() - file == rank - otherSquare.getRank();
	}

	public int getRank() {
		return rank;
	}

	public int getFile() {
		return file;
	}
	
	public String toString(){
		return "("+rank+","+file+")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + file;
		result = prime * result + rank;
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
		Square other = (Square) obj;
		if (file != other.file)
			return false;
		if (rank != other.rank)
			return false;
		return true;
	}
	
	

}
