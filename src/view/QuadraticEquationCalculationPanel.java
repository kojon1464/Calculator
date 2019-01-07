package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class QuadraticEquationCalculationPanel extends JPanel implements Resetable {

	private JLabel mainLabel;
	private JLabel firstLabel;
	private JLabel secondLabel;
	private JLabel resultLabel;
	
	private JTextField firstInput;
	private JTextField secondInput;
	private JTextField thirdInput;
	
	private JPanel expressionPanel;
	
	private JButton calculateButton;

	public QuadraticEquationCalculationPanel() {
		setupPanel();
	}
	
	public String getFirstInputText() {
		return firstInput.getText();
	}
	
	public String getSecondInputText() {
		return secondInput.getText();
	}
	
	public String getThirdInputText() {
		return thirdInput.getText();
	}
	
	public void setResultLabelText(String text) {
		resultLabel.setText(text);
	}
	
	public void addCalculateButtonListener(ActionListener listener) {
		calculateButton.addActionListener(listener);
	}

	private void setupPanel() {

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		setupComponents();
		
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.setVisible(true);
	}

	private void setupComponents() {

		mainLabel = new JLabel("Quadraric Equation Calculations");
		mainLabel.setFont(new Font(mainLabel.getFont().getFontName(), mainLabel.getFont().getStyle(), 20));
		
		firstLabel = new JLabel("x^2 +");
		secondLabel = new JLabel("x + ");
		resultLabel = new JLabel("x= _ and x= _");
		calculateButton = new JButton("Calculate");
		firstInput = new JTextField();
		secondInput = new JTextField();
		thirdInput = new JTextField();
		
		firstInput.setMaximumSize(new Dimension(100,20));
		secondInput.setMaximumSize(new Dimension(100,20));
		thirdInput.setMaximumSize(new Dimension(100,20));
		
		//Setting up expression Panel
		expressionPanel = new JPanel();
		expressionPanel.setLayout(new BoxLayout(expressionPanel, BoxLayout.X_AXIS));
		expressionPanel.setAlignmentX(LEFT_ALIGNMENT);
		
		expressionPanel.add(firstInput);
		expressionPanel.add(firstLabel);
		expressionPanel.add(secondInput);
		expressionPanel.add(secondLabel);
		expressionPanel.add(thirdInput);
		expressionPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		expressionPanel.add(calculateButton);
		
		//adding all elements to this panel
		this.add(mainLabel);
		this.add(Box.createGlue());
		this.add(expressionPanel);
		this.add(resultLabel);
		this.add(Box.createGlue());
	}

	@Override
	public void reset() {
		firstInput.setText("");
		secondInput.setText("");
		thirdInput.setText("");
		resultLabel.setText("x = _, x = _");
	}
}
