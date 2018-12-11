package hw5;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import javax.swing.JMenuBar;
import javax.swing.ButtonGroup;

public class TicTacToe {

	private JFrame frame;
	private final Action action = new SwingAction();
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicTacToe window = new TicTacToe();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TicTacToe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 517, 346);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JRadioButton rdbtnYouFirst = new JRadioButton("You first");
		buttonGroup.add(rdbtnYouFirst);
		rdbtnYouFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player human = new Player('X');
				Player computer = new Player('O');
				Board board = new Board(computer, human);
				
			}
		});
		rdbtnYouFirst.setBackground(Color.WHITE);
		rdbtnYouFirst.setBounds(329, 249, 155, 29);
		frame.getContentPane().add(rdbtnYouFirst);
		
		JRadioButton rdbtnComputerFirst = new JRadioButton("Computer first");
		rdbtnComputerFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player human = new Player('O');
				Player computer = new Player('X');
				Board board = new Board(computer, human);
				
			}
		});
		buttonGroup.add(rdbtnComputerFirst);
		rdbtnComputerFirst.setBackground(Color.WHITE);
		rdbtnComputerFirst.setBounds(43, 249, 155, 29);
		frame.getContentPane().add(rdbtnComputerFirst);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
