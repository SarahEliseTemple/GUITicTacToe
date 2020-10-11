package GUITicTacToe;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class GUITicTacToe implements ActionListener{

	JFrame frame = new JFrame();
	JButton[][] button = new JButton[3][3];
	int[][] board = new int[3][3];
	final int BLANK = 0; 
	final int X_MOVE = 1;
	final int O_MOVE =2;
	final int X_TURN = 0;
	final int O_TURN = 1;
	int turn = X_TURN;
	Container center = new Container();
	JLabel xName = new JLabel("X Win's: 0");
	JLabel oName = new JLabel("O Win's: 0");
	JButton xChangeName = new JButton("Change X's Name.");
	JButton oChangeName = new JButton("Change O's Name.");
	JTextField xChangeField = new JTextField();
	JTextField oChangeField = new JTextField();
	Container north = new Container();
	
	
	public GUITicTacToe() { 
		frame.setSize(400,400);
		//Center 
		frame.setLayout(new BorderLayout());
		center.setLayout(new GridLayout(3,3));
		for (int i = 0; i < button.length; i++) {
			for (int j = 0; j < button[0].length; j++) {
				button[j][i]= new JButton(j+""+i);
				center.add(button[j][i]);
				button[j][i].addActionListener(this);
			}
		}
		frame.add(center, BorderLayout.CENTER);
		// North Container'
		north.setLayout(new GridLayout(3,2));
		north.add(xName);
		north.add(oName);
		north.add(xChangeName);
		xChangeName.addActionListener(this);
		north.add(oChangeName);
		oChangeName.addActionListener(this);
		north.add(xChangeField);
		north.add(oChangeField);
		frame.add(north, BorderLayout.NORTH);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new GUITicTacToe();

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JButton current;
		boolean gridButton = false;
		for (int i = 0; i < button.length; i++) {
			for (int j = 0; j < button.length; j++) {
				if (event.getSource().equals(button[j][i])) {
					gridButton = true;
					current = button[j][i];
					if(board[j][i] == BLANK ) {
						if (turn == X_TURN) {
							current.setText("X");
							board[j][i] = X_MOVE;
							turn = O_TURN;
						}
						else if(turn == O_TURN) {
							current.setText("O");
							board[j][i] = O_MOVE;
							turn = X_TURN;
						}
						//check for wins and ties
						if (checkWin(X_MOVE) == true) {
							//X wins
							System.out.println("X Won");
						}
						else if (checkWin(O_MOVE)==true) {
							//O wins
							System.out.println("O Won");
						}
						else if (checkTie() == true) {
							//Its a tie
						}
						
					}
				}
			}
		}
		if (gridButton == false) {
			if (event.getSource().equals(xChangeName)== true) {
				xChangeField.setText("X Change");
			}
			else if (event.getSource().equals(oChangeName)== true) {
				oChangeField.setText("O Change.");
			}
		}
		
	}
	
	public boolean checkWin(int player) {//this is to check if someone won.
		if (board[0][0] == player && board[1][0] == player && board[2][0] == player) {
			return true;
		}
		if (board[0][1] == player && board[1][1] == player && board[2][1] == player) {
			return true;
		}
		if (board[0][2] == player && board[1][2] == player && board[2][2] == player) {
			return true;
		}
		if (board[0][0] == player && board[0][1] == player && board[0][2] == player) {
			return true;
		}
		if (board[1][0] == player && board[1][1] == player && board[1][2] == player) {
			return true;
		}
		if (board[2][0] == player && board[2][1] == player && board[2][2] == player) {
			return true;
		}
		if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
			return true;
		}
		if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
			return true;
		}
		
		return false;
	}
	public boolean checkTie() {// This part is to check for a tie.
		for(int row = 0; row < board.length; row++) {
			for (int column = 0; column < board.length; column++) {
				if (board[row][column] == BLANK) {
					return false;
				}
			}
		}
		return true;
	}

}
