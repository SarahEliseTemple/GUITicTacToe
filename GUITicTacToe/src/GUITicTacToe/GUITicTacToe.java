package GUITicTacToe;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class GUITicTacToe implements ActionListener{

	JFrame frame = new JFrame();
	JButton[][] button = new JButton[3][3];
	Container center = new Container();
	JLabel xName = new JLabel("X Win's: 0");
	JLabel oName = new JLabel("O Win's: 0");
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
		north.setLayout(new GridLayout(1,2));
		north.add(xName);
		north.add(oName);
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
		for (int i = 0; i < button.length; i++) {
			for (int j = 0; j < button.length; j++) {
				if (event.getSource().equals(button[j][i])) {
					current = button[j][i];
					current.setText("X");
				}
			}
		}
		
		
	}

}
