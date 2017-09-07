package piece;

public class Space{
	public char letter;
	public int y;
	public Piece p;
	public Space(char x, int y) {
		this.letter = x;
		this.p = null;
		this.y = y;
	}
	public String toString(){
		String s = this.letter + "";
		return s+(this.y);
	}
	
	public boolean compare(Space a){
		if (a == null){
			return false;
		}
		if ((this.letter == a.letter)&&(this.y == a.y)){
			return true;
		}
		return false;
	}
}