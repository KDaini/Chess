package piece;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * @author Kevin DAini & James DiPierro
 */
import java.util.ArrayList;

import chess.Game;

public class Piece {

	public boolean moved;
	public String name;
	public boolean isWhite;
	public ArrayList<Space> moves;
	Space current;

	public boolean isValid(Space piece, Space dest) {
		return false;
	}

//UNIQUE: Only moves in straight lines, either board letter or board number must match for valid move.
public class Rook extends Piece{
		public Rook(boolean a, char x, int y){
			super();
			this.isWhite = a;
			this.current = new Space(x,y);
			this.name = "Rook";
			this.moved = false;
			this.moves = new ArrayList<Space>();
		}

		public String toString(){
			if(this.isWhite){
				return "wR";
			} else{
				return "bR";
			}
		}

		public boolean isValid(Space piece, Space dest){
			Space space = piece;
			if(piece.letter == dest.letter){
				if(piece.y - dest.y < 0)
					for(int i = 1; space.y != dest.y-1; i++){
						space = Game.getSpace((char)(piece.letter),piece.y+i);
						if(space.p != null){
							return false;
						}
					}
				else if(piece.y - dest.y > 0){
					for(int i = 1; space.y != dest.y+1; i++){
						space = Game.getSpace((char)(piece.letter),piece.y-i);
						if(space.p != null){
							return false;
						}
					}
				}
				return true;
			}
			if(piece.y == dest.y){
				if(piece.letter - dest.letter < 0)
					for(int i = 1; space.letter != dest.letter-1; i++){
						space = Game.getSpace((char)(piece.letter + i),piece.y);
						if(space.p != null){
							return false;
						}
					}
				else if(piece.letter - dest.letter > 0){
					for(int i = 1; space.letter != dest.letter+1; i++){
						space = Game.getSpace((char)(piece.letter - i),piece.y);
						if(space.p != null){
							return false;
						}
					}
				}
				return true;
			}
			return false;
		}
}

//UNIQUE: Pawn can only move 2 spaces forward on opener and one space forward after.  Can only attack diagonally forward.
public class Pawn extends Piece{
		public boolean opener;
		public Pawn(boolean a, char x, int y){
			super();
			this.isWhite = a;
			this.current = new Space(x,y);
			this.name = "Pawn";
			this.opener = true;
			this.moves = new ArrayList<Space>();
			this.moved = false;

		}
		//FIX
		public void promotion(Space piece){

		}

		public String toString(){
			if(this.isWhite){
				return "wp";
			} else{
				return "bp";
			}
		}

		public boolean isValid(Space piece, Space dest){
			Space space = piece;
			//check if black or white
			if(piece.p.isWhite){
				//check if attacking
				if(Math.abs(piece.letter - dest.letter) == 1 && piece.y - dest.y == -1){
					if(!dest.p.isWhite){
						return true;
					}
				}
				if(piece.letter == dest.letter && piece.y - dest.y == -2 && this.opener == true){
					for(int i = 1; space.y != dest.y-1; i++){
						space = Game.getSpace((char)(piece.letter),piece.y+i);
						if(space.p != null){
							return false;
						}
					}
					this.opener = false;
					return true;
				}
				else if(piece.letter == dest.letter && piece.y - dest.y == -1){
					space = Game.getSpace((char)(piece.letter),piece.y+1);
					if(space.p !=null){
						return false;
					}
					if(this.opener == true){
						this.opener = false;
					}

					return true;
				}
			}
			else{
				//check if attacking
				if(Math.abs(piece.letter - dest.letter) == 1 && piece.y - dest.y == 1){
					if(dest.p.isWhite){
						return true;
					}
				}
				if(piece.letter == dest.letter && piece.y - dest.y == 2 && this.opener == true){
					space = piece;
					for(int i = 1; space.y != dest.y+1; i++){
						space = Game.getSpace((char)(piece.letter),piece.y-i);
						if(space.p != null){
							return false;
						}
					}
					this.opener = false;
					return true;
				}

				else if(piece.letter == dest.letter && piece.y - dest.y == 1){
					space = Game.getSpace((char)(piece.letter),piece.y-1);
					if(this.opener == true){
						this.opener = false;
					}
					return true;
				}
			}
			return false;

		}

}
//UNIQUE: Can move two blocks in one direction and one block adjacently.  Is not affected by collision.
public class Knight extends Piece{
	public Knight(boolean a, char x, int y){
		super();
		this.current = new Space(x,y);
		this.isWhite = a;
		this.name = "Knight";
		this.moves = new ArrayList<Space>();
		this.moved = false;
	}

	public String toString(){
		if(this.isWhite){
			return "wN";
		} else{
			return "bN";
		}
	}

	public boolean isValid(Space piece, Space dest){
		//check vertical or horizontal
		if(Math.abs(piece.letter - dest.letter) == 2 && Math.abs(piece.y - dest.y) == 1){
			return true;
		}
		if(Math.abs(piece.y - dest.y) == 2 && Math.abs(piece.letter - dest.letter) == 1){
			return true;
		}
		return false;
	}
}
//UNIQUE:  Can move any direction for one space.  Can castle.
public class King extends Piece{
	public King(boolean a, char x, int y){
		super();
		this.isWhite = a;
		this.current = new Space(x,y);
		this.name = "King";
		this.moved = false;
		this.moves = new ArrayList<Space>();
	}

	public String toString(){
		if(this.isWhite){
			return "wK";
		} else{
			return "bK";
		}
	}

	public boolean castle(Space piece, Space dest){
		return false;
	}

	public boolean isValid(Space piece, Space dest){
		if(Math.abs(piece.letter - dest.letter) <= 1 && Math.abs(piece.y - dest.y) <= 1){
				return true;
		}

		return false;
	}
}
//UNIQUE: Can move in any direction any number of spaces.  Combination of rook and bishop.
public class Queen extends Piece{
	public Queen(boolean a, char x, int y){
		super();
		this.isWhite = a;
		this.current = new Space(x,y);
		this.name = "Queen";
		this.moved = false;
		this.moves = new ArrayList<Space>();
	}

	public String toString(){
		if(this.isWhite){
			return "wQ";
		} else{
			return "bQ";
		}
	}

	public boolean isValid(Space piece, Space dest){
		//check horizontal and vertical
		Space space = piece;
		if(piece.letter == dest.letter){
			if(piece.y - dest.y < 0)
				for(int i = 1; space.y != dest.y-1; i++){
					space = Game.getSpace((char)(piece.letter),piece.y+i);
					if(space.p != null){
						return false;
					}
				}
			else if(piece.y - dest.y > 0){
				for(int i = 1; space.y != dest.y+1; i++){
					space = Game.getSpace((char)(piece.letter),piece.y-i);
					if(space.p != null){
						return false;
					}
				}
			}
			return true;
		}
		if(piece.y == dest.y){
			if(piece.letter - dest.letter < 0)
				for(int i = 1; space.letter != dest.letter-1; i++){
					space = Game.getSpace((char)(piece.letter + i),piece.y);
					if(space.p != null){
						return false;
					}
				}
			else if(piece.letter - dest.letter > 0){
				for(int i = 1; space.letter != dest.letter+1; i++){
					space = Game.getSpace((char)(piece.letter - i),piece.y);
					if(space.p != null){
						return false;
					}
				}
			}
			return true;
		}
		//check diagonal
		space = piece;
		if(Math.abs(dest.letter - piece.letter) == Math.abs(dest.y - piece.y)){
			//set up for pathing
			//moving top left
			if(piece.letter - dest.letter > 0 && piece.y - dest.y < 0){
				for(int i = 1; space.letter != dest.letter+1 && space.y != dest.y+1; i++){
					space = Game.getSpace((char)(piece.letter-i),piece.y+i);
					if(space.p != null){
						return false;
					}
				}
			}
			//moving bottom left
			if(piece.letter - dest.letter > 0 && piece.y - dest.y > 0){
				for(int i = 1; space.letter != dest.letter+1 && space.y != dest.y-1; i++){
					space = Game.getSpace((char)(piece.letter-i),piece.y-i);
					if(space.p != null){
						return false;
					}
				}
			}
			//moving top right
			if(piece.letter - dest.letter < 0 && piece.y - dest.y < 0){
				for(int i = 1; space.letter != dest.letter-1 && space.y != dest.y+1; i++){
					space = Game.getSpace((char)(piece.letter+i),piece.y+i);
					if(space.p != null){
						return false;
					}
				}
			}
			//moving bottom right
			if(piece.letter - dest.letter < 0 && piece.y - dest.y > 0){
				for(int i = 1; space.letter != dest.letter-1 && space.y != dest.y-1; i++){
					space = Game.getSpace((char)(piece.letter+i),piece.y-i);
					if(space.p != null){
						return false;
					}
				}
			}
			return true;
		}
		return false;
	}
}
//UNIQUE: Can only move Diagonally
public class Bishop extends Piece{
	public Bishop(boolean a, char x, int y){
		super();
		this.isWhite = a;
		this.current = new Space(x,y);
		this.name = "Bishop";
		this.moved = false;
		this.moves = new ArrayList<Space>();
	}

	public String toString(){
		if(this.isWhite){
			return "wB";
		} else{
			return "bB";
		}
	}

	public boolean isValid(Space piece, Space dest){
		Space space = piece;
		if(Math.abs(dest.letter - piece.letter) == Math.abs(dest.y - piece.y)){
			//set up for pathing
			//moving top left
			if(piece.letter - dest.letter > 0 && piece.y - dest.y < 0){
				for(int i = 1; space.letter != dest.letter+1 && space.y != dest.y+1; i++){
					space = Game.getSpace((char)(piece.letter-i),piece.y+i);
					if(space.p != null){
						return false;
					}
				}
			}
			//moving bottom left
			if(piece.letter - dest.letter > 0 && piece.y - dest.y > 0){
				for(int i = 1; space.letter != dest.letter+1 && space.y != dest.y-1; i++){
					space = Game.getSpace((char)(piece.letter-i),piece.y-i);
					if(space.p != null){
						return false;
					}
				}
			}
			//moving top right
			if(piece.letter - dest.letter < 0 && piece.y - dest.y < 0){
				for(int i = 1; space.letter != dest.letter-1 && space.y != dest.y+1; i++){
					space = Game.getSpace((char)(piece.letter+i),piece.y+i);
					if(space.p != null){
						return false;
					}
				}
			}
			//moving bottom right
			if(piece.letter - dest.letter < 0 && piece.y - dest.y > 0){
				for(int i = 1; space.letter != dest.letter-1 && space.y != dest.y-1; i++){
					space = Game.getSpace((char)(piece.letter+i),piece.y-i);
					if(space.p != null){
						return false;
					}
				}
			}
			return true;
		}
		return false;
	}
}

}