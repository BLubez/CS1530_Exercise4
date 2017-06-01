import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;


public class TicTacToe {
	JFrame frame;
	JButton[] _buttons;
	boolean playerOneTurn;

	public static void main(String[] args) {
		new TicTacToe();
	}

	public TicTacToe() {
		frame = new JFrame("Tic-Tac-Toe");
		playerOneTurn = true;

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel tttGrid = new JPanel();
		JPanel _newPanel = new JPanel();
		//_newPanel.setBackground(Color.black);

		tttGrid.setLayout(new GridLayout(3, 3));
		//_newPanel.setLayout(new FlowLayout());

		// This will place the tic-tac-toe panel at the top of
		// the frame and the newPanel panel at the bottom
		frame.add(tttGrid, BorderLayout.NORTH);
		frame.add(_newPanel, BorderLayout.CENTER);

		_buttons = new JButton[9];
		for (int j=0; j<9; j++) {
	    	 // Make a new button in the array location with text "_"
			_buttons[j] = new JButton("_");
	    	 // Associate a new ButtonListener to the button (see below)
			ActionListener buttonListener = new ButtonListener();
			_buttons[j].addActionListener(buttonListener);
	    	 // Set the font on the button
			_buttons[j].setFont(new Font("Courier", Font.PLAIN, 48));
	    	 // Add this button to the tttGrid panel
			tttGrid.add(_buttons[j]);
		}
		JButton newGame = new JButton("New Game");
		ActionListener buttonListener = new ButtonListener();
		newGame.addActionListener(buttonListener);
		newGame.setFont(new Font("Courier", Font.PLAIN, 36));
		_newPanel.add(newGame);
		//_newPanel.setBackground(Color.black);



		frame.setSize(400, 300);

		// Refresh window - otherwise we will not be able to see it
		// THIS IS A COMMON SOURCE OF BUGS!
		frame.setVisible(true);
	}


	private class ButtonListener implements ActionListener {

	// Every time we click the button, it will perform
	// the following action.

		public void actionPerformed(ActionEvent e) {

			JButton source = (JButton) e.getSource();
			String currentText = source.getText();
			if (currentText.equals("_")) {
				if (playerOneTurn) {
					source.setText("X");
					playerOneTurn = !playerOneTurn;
					source.setEnabled(false);
				} else {
					source.setText("O");
					playerOneTurn = !playerOneTurn;
					source.setEnabled(false);
				}	
			} else if (currentText.equals("New Game")) {
				for (int i = 0; i < 9; i++) {
					_buttons[i].setText("_");
					_buttons[i].setEnabled(true);
					playerOneTurn = true;
				}
			} else {
				source.setText("_");
			}
		}

	}

}