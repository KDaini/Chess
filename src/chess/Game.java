package chess;

import piece.Piece;
import piece.Piece.Rook;
import piece.Space;
import java.util.ArrayList;

/**
*@author Kevin Daini & James DiPierro:
*Creates a game of chess and populates an ArrayList of spaces with the necessary pieces for chess.
*
**/
public class Game {
	public static ArrayList<Space> spaces = new ArrayList<Space>();
	public Game() {
		this.spaces = new ArrayList<Space>();

		char [] h = {'a','b','c','d','e','f','g','h'};
		boolean c = true;
		for(int i = 0; i<8; i++){
			spaces.add(new Space(h[i],8));
		}
		for(int i = 0; i<8; i++){
			spaces.add(new Space(h[i],7));
		}
		for(int i = 0; i<8; i++){
			spaces.add(new Space(h[i],6));
		}
		for(int i = 0; i<8; i++){
			spaces.add(new Space(h[i],5));
		}
		for(int i = 0; i<8; i++){
			spaces.add(new Space(h[i],4));
		}
		for(int i = 0; i<8; i++){
			spaces.add(new Space(h[i],3));
		}
		for(int i = 0; i<8; i++){
			spaces.add(new Space(h[i],2));
		}
		for(int i = 0; i<8; i++){
			spaces.add(new Space(h[i],1));
		}
		populateBoard(spaces);
	}
	/**
	 *
	 * @param p The 'Board' of the game is simply an array list of Space objects that have a set coordinate and Piece
	 * field. Each space has a letter and number which corresponds to its position on the "Board". The arrayList is sorted in order from left to right. So
	 * p[0] = a8 and p[64] = h1. e.g. The first 8 indexes are a8, b8, c8, d8, e8, f8, g8, and h8.
	 */
	private void populateBoard(ArrayList<Space> p){
		Piece a = new Piece();

				//Black Pieces ARRAYLIST
		spaces.get(0).p = a.new Rook(false, 'a', 1);
		spaces.get(1).p = a.new Knight(false, 'b', 1);
		spaces.get(2).p = a.new Bishop(false, 'c', 1);
		spaces.get(3).p = a.new Queen(false, 'd', 1);
		spaces.get(4).p = a.new King(false, 'e', 1);
		spaces.get(5).p = a.new Bishop(false, 'f', 1);
		spaces.get(6).p = a.new Knight(false, 'g', 1);
		spaces.get(7).p = a.new Rook(false, 'h', 1);
		spaces.get(8).p = a.new Pawn(false, 'a', 2);
		spaces.get(9).p = a.new Pawn(false, 'b', 2);
		spaces.get(10).p = a.new Pawn(false, 'c', 2);
		spaces.get(11).p = a.new Pawn(false, 'd', 2);
		spaces.get(12).p = a.new Pawn(false, 'e', 2);
		spaces.get(13).p = a.new Pawn(false, 'f', 2);
		spaces.get(14).p = a.new Pawn(false, 'g', 2);
		spaces.get(15).p = a.new Pawn(false, 'h', 2);


				//White Pieces ARRAYLIST
		spaces.get(63).p = a.new Rook(true, 'a', 8);
		spaces.get(62).p = a.new Knight(true, 'b', 8);
		spaces.get(61).p = a.new Bishop(true, 'c', 8);
		spaces.get(60).p = a.new King(true, 'd', 8);
		spaces.get(59).p = a.new Queen(true, 'e', 8);
		spaces.get(58).p = a.new Bishop(true, 'f', 8);
		spaces.get(57).p = a.new Knight(true, 'g', 8);
		spaces.get(56).p = a.new Rook(true, 'h', 8);
		spaces.get(55).p = a.new Pawn(true, 'a', 7);
		spaces.get(54).p = a.new Pawn(true, 'b', 7);
		spaces.get(53).p = a.new Pawn(true, 'c', 7);
		spaces.get(52).p = a.new Pawn(true, 'd', 7);
		spaces.get(51).p = a.new Pawn(true, 'e', 7);
		spaces.get(50).p = a.new Pawn(true, 'f', 7);
		spaces.get(49).p = a.new Pawn(true, 'g', 7);
		spaces.get(48).p = a.new Pawn(true, 'h', 7);
	}
	/**
	 * This method parses the users input to a space object that can be used by the program
	 * @param a The input String from the user
	 * @return returns a Space object Array corresponding to the input given e.g. 'e2' => new space object with appropriate fields  with e and 2 in the array
	 */
	public static int index(String a) throws IllegalArgumentException{
		String s = a.toLowerCase();
		switch(s){
		case "a1":return 56;
		case "a2":return 48;
		case "a3":return 40;
		case "a4":return 32;
		case "a5":return 24;
		case "a6":return 16;
		case "a7":return 8;
		case "a8":return 0;
		case "b1":return 57;
		case "b2":return 49;
		case "b3":return 41;
		case "b4":return 33;
		case "b5":return 25;
		case "b6":return 17;
		case "b7":return 9;
		case "b8":return 1;
		case "c1":return 58;
		case "c2":return 50;
		case "c3":return 42;
		case "c4":return 34;
		case "c5":return 26;
		case "c6":return 18;
		case "c7":return 10;
		case "c8":return 2;
		case "d1":return 59;
		case "d2":return 51;
		case "d3":return 43;
		case "d4":return 35;
		case "d5":return 27;
		case "d6":return 19;
		case "d7":return 11;
		case "d8":return 3;
		case "e1":return 60;
		case "e2":return 52;
		case "e3":return 44;
		case "e4":return 36;
		case "e5":return 28;
		case "e6":return 20;
		case "e7":return 12;
		case "e8":return 4;
		case "f1":return 61;
		case "f2":return 53;
		case "f3":return 45;
		case "f4":return 37;
		case "f5":return 29;
		case "f6":return 21;
		case "f7":return 13;
		case "f8":return 5;
		case "g1":return 62;
		case "g2":return 54;
		case "g3":return 46;
		case "g4":return 38;
		case "g5":return 30;
		case "g6":return 22;
		case "g7":return 14;
		case "g8":return 6;
		case "h1":return 63;
		case "h2":return 55;
		case "h3":return 47;
		case "h4":return 39;
		case "h5":return 31;
		case "h6":return 23;
		case "h7":return 15;
		case "h8":return 7;

		default: throw new IllegalArgumentException();
		}
	}
	/**
	 * Prints the game to the console in the correct format (resembling a 2D array).
	 */
	public void printGame(){

		System.out.println("");
		System.out.println("_________________________________________");
		int count = 0;
		int y = 0;
		char [] h = {'8','7','6','5','4','3','2','1'};
		for (Space s : spaces){
			if (s.p==null){
				if(spaces.indexOf(s)<=7 || (spaces.indexOf(s)>=16 && spaces.indexOf(s)<=23)||
						(spaces.indexOf(s)>=32 && spaces.indexOf(s)<=39) || (spaces.indexOf(s)>=48 && spaces.indexOf(s)<=55)){
					if(spaces.indexOf(s)%2==0){
						System.out.print("   ");
						}
						if(spaces.indexOf(s)%2!=0){
							System.out.print("## ");
						}
				}else
				if((spaces.indexOf(s)>=8 && spaces.indexOf(s)<=15)||
						(spaces.indexOf(s)>=24 && spaces.indexOf(s)<=31) || (spaces.indexOf(s)>=40 && spaces.indexOf(s)<=47) ||
						(spaces.indexOf(s)>=56 && spaces.indexOf(s)<=63)){
					if(spaces.indexOf(s)%2!=0){
						System.out.print("   ");
						}
						if(spaces.indexOf(s)%2==0){
							System.out.print("## ");
						}
				}else System.out.print("ss ");
			}
			else{
			System.out.print(s.p +" ");
			}
			count ++;
			if (count>=8){
				System.out.println(h[y]);
				y++;
				count = 0;
			}
		}
		System.out.println(" a  b  c  d  e  f  g  h");

		System.out.println("_________________________________________");
	}

	/**
	 *
	 * @param piece Piece to be moved
	 * @param dest Space where piece is to be moved to
	 * @param g The current game
	 */public boolean movePiece(Space piece, Space dest, boolean turn)throws IllegalArgumentException{
		if (piece.p.isWhite != turn){throw new IllegalArgumentException();}
			String pc = piece.p.name;
			int ip  = this.spaces.indexOf(piece);
			int id = this.spaces.indexOf(dest);
			ArrayList<Space> moves = piece.p.moves;

			//check if piece and destination have same color pieces
			if(piece.p.isWhite && dest.p != null){
				if(dest.p.isWhite){
					return false;
				}
			}

			if(!piece.p.isWhite && dest.p != null){
				if(!dest.p.isWhite){
					return false;
				}
			}

			//check if destination is a valid move for that piece
			if(!piece.p.isValid(piece, dest)){
				return false;
			}

			piece.p.moves.add(dest);
			for(int i = 0; i<moves.size(); i++){
				if (moves.get(i).compare(dest)){
					this.spaces.indexOf(moves.get(i).p=piece.p);
					piece.p = null;
					check(dest);
					return true;
				}
			}

			throw new IllegalArgumentException();

	}

	public static Space getSpace(char x, int y){
		if(x >= 'a' && x <= 'h'){
			if(y >= 1 && y <= 8){
				String string = x + Integer.toString(y);
				return spaces.get(index(string));
			}
		}
		return null;
	}

	public static void check(Space piece){
		Space dest;
		if(piece.p.isWhite){
			for(int i = 0; i<spaces.size(); i++){
				if(spaces.get(i).p != null){
					if(spaces.get(i).p.name == "King" && spaces.get(i).p.isWhite == false){
						dest = spaces.get(i);
						if(piece.p.isValid(piece, dest)){
							System.out.println("Check");
						}
						return;
					}
				}
			}
		}
		else if(!piece.p.isWhite){
			for(int i = 0; i<spaces.size(); i++){
				if(spaces.get(i).p != null){
					if(spaces.get(i).p.name == "King" && spaces.get(i).p.isWhite == true){
						dest = spaces.get(i);
						if(piece.p.isValid(piece, dest)){
							System.out.println("Check");
						}
						return;
					}
				}
			}
		}
		return;
	}

	/*method for calculating whether or not the king is in checkmate.  Called after every piece move and allows the game
	  loop to run if returns -1*/
	public static int checkMate(int color){
		//find locations of white and black king
		Space king = null;

		//marks 0 if safe, 1 if dangerous, and -1 if null.  Count keeps track of indexes.
		int count = 0;
		int[] danger = new int[9];
		for(int i = 0; i<spaces.size(); i ++){
			if(spaces.get(i).p != null){
				if(color == 0){
					if(spaces.get(i).p.name == "King" && spaces.get(i).p.isWhite == true){
					king = spaces.get(i);
					}
				}
				if(color == 1){
					if(spaces.get(i).p.name == "King" && spaces.get(i).p.isWhite == false){
						king = spaces.get(i);
						}
				}
			}
		}

		//first is to check every square of each king and mark which squares are considered "dangerous"

		//white king
		for(int j = -1; j < 2; j++){
			for(int k = -1; k < 2; k++){
				//check if space exists
				if(getSpace((char)(king.letter+j), king.y+k) == null){
					danger[count] = -1;
				}
				else{
					//loops through every opposing piece validMove to see if tile is dangerous.  Will do this for every square surrounding king and king itself
					//if there is no validMove for that square, then the square is safe for king and returns false.
					for(int index = 0; index < spaces.size(); index++){
						if(spaces.get(index).p != null && spaces.get(index).p.isWhite != king.p.isWhite){
							if(spaces.get(index).p.isValid(spaces.get(index), getSpace((char)(king.letter+j), king.y+k))){
								//special check at 0,0 (king itself) to see if player piece can take piece putting king in check
								if(j == 0 && k == 0){
									for(int ally = 0; ally < spaces.size(); ally++){
										if(spaces.get(ally).p != null && spaces.get(ally).p.isWhite == king.p.isWhite){
											if(spaces.get(ally).p.isValid(spaces.get(ally), spaces.get(index))){
												//ally piece can take piece putting king in check and is considered safe
												return 0;
											}
										}
									}
									danger[count] = 1;
									break;
								}
							}
						}
					}
				}
				count++;
			}
		}
		//goes through array and if there is a safe move returns -1 if not then checkmate
		for(int checkM = 0; checkM < danger.length; checkM++){
			if(danger[checkM] == 0){
				return 0;
			}
			if(checkM == 8){
			return 1;
			}
		}
		return 0;
	}

}