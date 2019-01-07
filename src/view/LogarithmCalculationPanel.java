package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class LogarithmCalculationPanel extends JPanel {

	private JLabel mainLabel;
	private JLabel logarithmLabel;
	private JLabel resultLabel;
	private JTextField firstInput;

	private JPanel expressionPanel;

	private JButton calculateButton;

	public LogarithmCalculationPanel() {

		setupPanel();
	}
	
	public String getFirstInputText() {
		return firstInput.getText();
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

		mainLabel = new JLabel("Logarithm Calculations");
		mainLabel.setFont(new Font(mainLabel.getFont().getFontName(), mainLabel.getFont().getStyle(), 20));
		
		logarithmLabel = new JLabel("ln");
		resultLabel = new JLabel("= _");
		calculateButton = new JButton("Calculate");
		firstInput = new JTextField();
		
		firstInput.setMaximumSize(new Dimension(100,20));

		//Setting up expression Panel
		expressionPanel = new JPanel();
		expressionPanel.setLayout(new BoxLayout(expressionPanel, BoxLayout.X_AXIS));
		expressionPanel.setAlignmentX(LEFT_ALIGNMENT);
		
		expressionPanel.add(logarithmLabel);
		expressionPanel.add(firstInput);
		expressionPanel.add(resultLabel);
		expressionPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		expressionPanel.add(calculateButton);
		
		//adding all elements to this panel
		this.add(mainLabel);
		this.add(Box.createGlue());
		this.add(expressionPanel);
		this.add(Box.createGlue());
		
	}
}
