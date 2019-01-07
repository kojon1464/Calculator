package view;

import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicTextUI.BasicCaret;

public class CalculatorFrame extends JFrame {

	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem basicCalculation;
	private JMenuItem trigonometryCalculation;
	private JMenuItem powerCalculation;
	private JMenuItem logarithmCalculation;
	private JMenuItem quadraticEquationCalculation;

	public CalculatorFrame() {

		setupMenuBar();
		setupFrame();
	}

	public void addBasicCalculationListener(ActionListener listener) {
		basicCalculation.addActionListener(listener);
	}

	public void addTrigonometryCalculationListener(ActionListener listener) {
		trigonometryCalculation.addActionListener(listener);
	}

	public void addPowerCalculationListener(ActionListener listener) {
		powerCalculation.addActionListener(listener);
	}

	public void addlogarithmCalculationListener(ActionListener listener) {
		logarithmCalculation.addActionListener(listener);
	}

	public void addQuadraticEquationCalculationListener(ActionListener listener) {
		quadraticEquationCalculation.addActionListener(listener);
	}

	public void dialogMessage(String message) {
		JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
	}

	public void setPanel(JPanel newPanel) {

		this.getContentPane().removeAll();
		this.getContentPane().add(newPanel);
		this.getContentPane().revalidate();
		this.getContentPane().repaint();
	}

	private void setupMenuBar() {

		menuBar = new JMenuBar();
		menu = new JMenu("Calculations");
		basicCalculation = new JMenuItem("Basic Calculations");
		trigonometryCalculation = new JMenuItem("Trigonometry");
		powerCalculation = new JMenuItem("Powers and Roots");
		logarithmCalculation = new JMenuItem("Logarithms");
		quadraticEquationCalculation = new JMenuItem("Quadratic Equation");

		menu.add(basicCalculation);
		menu.add(logarithmCalculation);
		menu.add(powerCalculation);
		menu.add(trigonometryCalculation);
		menu.add(quadraticEquationCalculation);

		menuBar.add(menu);

		this.setJMenuBar(menuBar);
	}

	private void setupFrame() {

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(400, 200);
		this.setVisible(true);
	}

}
