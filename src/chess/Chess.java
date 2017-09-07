package chess;
import java.io.*;
import piece.Space;
import piece.Piece;

/**
 *@author Kevin Daini and James DiPierro
 **/
public class Chess {

	public static BufferedReader input = new BufferedReader(new InputStreamReader (System.in),5);
	public static BufferedReader draw = new BufferedReader(new InputStreamReader (System.in),5);
	public static void main(String[] args) throws IOException{
		Game g = new Game();
		String inputS;
		g.printGame();
		//game is finished if variable is 1.
		int finished = 0;
		while (true){
			try{
			finished = whiteMove(g);
			if(finished == 1){
				return;
			}
			} catch(Exception e){
				System.out.println("ERROR.IOException");
				continue;
			}
			try{
			finished = blackMove(g);
			if(finished == 1){
				return;
			}
				} catch(Exception e){
					System.out.println("ERROR.IOException");
					continue;
				}
			}
	}

	/**
	 * This allows the user in control of the white pieces to carry out his or her move
	 * @param g The current game
	 * @throws IOException
	 * @throws IllegalArgumentException
	 */
	public static int whiteMove(Game g) throws IOException, IllegalArgumentException{
		String [] spaces;
		Space [] move = new Space[2];
		String inputS;
			System.out.println("White Move: ");
			inputS = input.readLine();

			if(inputS.equalsIgnoreCase("resign")){
				System.out.println("White has resigned, Black wins!");
				return 1;
			}

			spaces = inputS.trim().split(" +");

			try{
			Space piece = g.spaces.get(Game.index(spaces[0]));
			Space dest = g.spaces.get(Game.index(spaces[1]));
			move[0]= piece;
			move[1]= dest;
			} catch (Exception e){
				System.out.println("Illegal Move. Retry: ");
				whiteMove(g);
				return 0;
			}
			try{
				//either to declare a draw
				if(spaces.length == 3){
					//draw
					if (spaces[2].equalsIgnoreCase("draw?")){
						if(draw()){
							System.out.println("Draw.");
							return 1;
						}
						return 0;
					}
				}
				if(move[0].equals(move[1])){
					System.out.println("Illegal Move. Retry: ");
					whiteMove(g);
					return 0;
				}
				if(g.movePiece(move[0], move[1], true) == false){
					System.out.println("Illegal Move. Retry: ");
					whiteMove(g);

					return 0;
				}
				} catch (Exception e){
					System.out.println("Illegal Move. Retry: ");
					whiteMove(g);
					return 0;

				}
			g.printGame();

			//checkmate check 0 if white is in checkmate, 1 if black is in checkmate
			if(Game.checkMate(1) == 1){
				System.out.println("White wins");
				return 1;
			}
			return 0;
	}
	/**
	 * This allows the user in control of the black pieces to carry out his or her move
	 * @param g The current game
	 * @throws IOException
	 * @throws IllegalArgumentException
	 */

	public static int blackMove(Game g) throws IOException, IllegalArgumentException{
		String [] spaces;
		Space [] move = new Space[2];
		String inputS;
		System.out.println("Black Move: ");
		inputS = input.readLine();

		if(inputS.equalsIgnoreCase("resign")){
			System.out.println("Black has resigned, White wins!");
			return 1;
		}
		spaces = inputS.trim().split(" ");
		try{
		Space piece = g.spaces.get(Game.index(spaces[0]));
		Space dest = g.spaces.get(Game.index(spaces[1]));
		move[0]= piece;
		move[1]=dest;

		} catch (Exception e){
			System.out.println("Illegal Move. Retry: ");
			blackMove(g);
			return 0;
		}
		try{
			//either to draw
			if(spaces.length == 3){
				//draw
				if(spaces[2].equalsIgnoreCase("draw?")){
					if(draw()){
						System.out.println("Draw.");
						return 1;
					}
					return 0;
				}

			}
			if(move[0].equals(move[1])){
				System.out.println("Illegal Move. Retry: ");
				blackMove(g);
				return 0;
			}
			if(g.movePiece(move[0], move[1], false) == false){
				System.out.println("Illegal Move. Retry: ");
				blackMove(g);
				return 0;
			}
		} catch (Exception e){
			System.out.println("Illegal Move. Retry: ");
			blackMove(g);
			return 0;

		}
		g.printGame();

		//checkmate check 0 if white is in checkmate, 1 if black is in checkmate
		if(Game.checkMate(0) == 1){
			System.out.print("Black wins");
			return 1;
		}
		return 0;
	}

	/**
	 * This checks for draw acceptance after one user inputs the string "draw?"
	 * Ends game if accepted.
	 * @return This returns true if other user enters 'draw' and returns false if anything else
	 */
	public static boolean draw(){
		System.out.println("Draw has been offered. Type 'draw' to accept: ");
		try{
		String g = draw.readLine();
		if (g.equalsIgnoreCase("draw")){
			return true;
		}
		} catch(Exception e){

		}
		return false;
	}

}