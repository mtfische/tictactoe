package cs.ualberta.cmput402.tictactoe;

import cs.ualberta.cmput402.tictactoe.board.Board;
import cs.ualberta.cmput402.tictactoe.board.Board.Player;
import cs.ualberta.cmput402.tictactoe.board.exceptions.InvalidMoveException;

import java.util.Scanner;

/**
 * Created by snadi on 2018-07-18.
 */
public class TicTacToeGame {

    static private Board board;

    public TicTacToeGame(){
        board = new Board();
    }

    public void promptNextPlayer(){
        switch(board.getCurrentPlayer()){
            case X:
                System.out.println("It's player " + board.getSymbol(board.getCurrentPlayer()) + "'s turn. Please enter the coordinates of your next move as x,y: ");
                break;
            case O:
                System.out.println("It's player " + board.getSymbol(board.getCurrentPlayer()) + "'s turn. Please enter the coordinates of your next move as x,y: ");
                break;

        }
    }

    public void playGame(){
        Scanner keyboardScanner = new Scanner(System.in);
        board.initBoard();

        while (board.getWinner() == null && board.getDraw() == false){
            board.printBoard();
            promptNextPlayer();
            String line = keyboardScanner.nextLine();
            String input[] = line.split(",");
            try {
                board.playMove(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            } catch (InvalidMoveException e) {
                System.out.println("Invalid coordinates. Try again");
                promptNextPlayer();
            }
        }

        board.printBoard();
        if (board.getDraw()){
        		this.board.incDraw(0);
        		this.board.incDraw(1);
            System.out.println("draw");
        }
        else{
        		if(board.getWinner() == Board.Player.X) {
        			this.board.incWin(0);
        			this.board.incLose(1);
        		}
        		if(board.getWinner() == Board.Player.O) {
        			this.board.incWin(1);
        			this.board.incLose(0);
        		}
            System.out.println("Player " + board.getWinner() + " has won the game!");
        }
    }

    public void playGameMultiTime(){
        boolean stopGame = false;
        do{
            playGame();
            Scanner newscan = new Scanner(System.in);
            System.out.println("do you want to play again?\n"+"y for yes and n for no");
            String userInputForNextGame = newscan.nextLine();
            boolean accept = false;
            while(!accept){
                char inputchoice = userInputForNextGame.charAt(0);
                if(inputchoice == 'y'){
                    stopGame = false;
                    accept = true;
                }
                else if(inputchoice == 'n'){
                    board.printScore();
                    stopGame = true;
                    accept = true;
                }
                else{
                    accept = false;
                    System.out.println("invalid input for play again or not, please try again.");
                    userInputForNextGame = newscan.nextLine();
                }
            }
        } while(!stopGame);
    }

    public static void main(String args[]){
        TicTacToeGame game = new TicTacToeGame();
        game.playGameMultiTime();
    }
}
