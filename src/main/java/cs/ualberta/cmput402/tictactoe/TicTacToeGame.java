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

        while (board.getWinner() == null && board.isDraw() == false){
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
        if (board.isDraw()){
            board.incrementNumOfDraws(Board.Player.X);
            board.incrementNumOfDraws(Board.Player.O);
            System.out.println("The game end in a draw.");
        }
        else{
            if(board.getWinner() == Board.Player.X) {
                board.incrementNumOfWin(Board.Player.X);
                board.incrementNumOfLoses(Board.Player.O);
            }
            if(board.getWinner() == Board.Player.O) {
                board.incrementNumOfWin(Board.Player.O);
                board.incrementNumOfLoses(Board.Player.X);
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
                    board.printScoreBoard();
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
