package GUITicTacToe;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GUITicTacToe {

	JFrame frame = new JFrame();
	JButton[][] button = new JButton[3][3];
	Container center = new Container();
	
	public GUITicTacToe() { 
		frame.setSize(400,400);
		
		frame.setLayout(new BorderLayout());
		center.setLayout(new GridLayout(3,3));
		for (int i = 0; i < button.length; i++) {
			for (int j = 0; j < button[0].length; j++) {
				button[j][i]= new JButton(j+""+i);
				center.add(button[j][i]);
			}
		}
		frame.add(center, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new GUITicTacToe();

	}

}
