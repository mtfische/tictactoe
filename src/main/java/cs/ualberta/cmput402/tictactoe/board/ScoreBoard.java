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
	
}
