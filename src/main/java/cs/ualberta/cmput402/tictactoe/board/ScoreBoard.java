package cs.ualberta.cmput402.tictactoe.board;

public class ScoreBoard {
	
	private int[][] array;
	
	public ScoreBoard() {
		array = new int[2][3];
	}
	
	public void initScoreBoard() {
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 3; j++) {
				this.array[i][j] = 0;
			}
		}
	}
	
	public void incWin(int idx) {
		this.array[idx][0] += 1;
	}
	
	public void incLose(int idx) {
		this.array[idx][1] += 1;
	}
	
	public void incDraw(int idx) {
		this.array[idx][2] += 1;
	}
	
	public void printScore() {
		System.out.println("Score:);
		System.out.println("Wins  (X, 0): " + this.array[0][0] + ", " + this.array[1][0] + "; ");
		System.out.println("Loses (X, 0): " + this.array[0][1] + ", " + this.array[1][1] + "; ");
		System.out.println("Draws (X, 0): " + this.array[0][2] + ", " + this.array[1][2] + ";");
	}
}
