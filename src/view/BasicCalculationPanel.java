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

public class BasicCalculationPanel extends JPanel implements Resetable {

	private JLabel mainLabel;
	private JLabel operatorLabel;
	private JLabel resultLabel;
	
	private JTextField firstInput;
	private JTextField secondInput;
	
	private JPanel radioButtonsPanel;
	private JPanel expressionPanel;
	
	private ButtonGroup group;
	
	private JRadioButton sumButton;
	private JRadioButton differenceButton;
	private JRadioButton productButton;
	private JRadioButton quotientButton;
	
	private JButton calculateButton;

	public BasicCalculationPanel() {
		setupPanel();
	}
	
	public String getFirstInputText() {
		return firstInput.getText();
	}
	
	public String getSecondInputText() {
		return secondInput.getText();
	}
	
	public void setSumButtonActive() {
		sumButton.setSelected(true);
	}
	
	public void setOperatorLabelText(String text) {
		operatorLabel.setText(text);
	}
	
	public void setResultLabelText(String text) {
		resultLabel.setText(text);
	}
	
	public void addSumButtonListener(ActionListener listener) {
		sumButton.addActionListener(listener);
	}
	
	public void addDifferenceButtonListener(ActionListener listener) {
		differenceButton.addActionListener(listener);
	}
	
	public void addProductButtonListener(ActionListener listener) {
		productButton.addActionListener(listener);
	}
	
	public void addQuotientButtonListener(ActionListener listener) {
		quotientButton.addActionListener(listener);
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

		mainLabel = new JLabel("Basic Calculations");
		mainLabel.setFont(new Font(mainLabel.getFont().getFontName(), mainLabel.getFont().getStyle(), 20));
		
		operatorLabel = new JLabel("_");
		resultLabel = new JLabel("= _");
		calculateButton = new JButton("Calculate");
		firstInput = new JTextField();
		secondInput = new JTextField();
		
		firstInput.setMaximumSize(new Dimension(100,20));
		secondInput.setMaximumSize(new Dimension(100,20));
		
		// Setting up radioButtons
		sumButton = new JRadioButton("sum");
		differenceButton = new JRadioButton("difference");
		productButton = new JRadioButton("product");
		quotientButton = new JRadioButton("quotient");
		
		// Setting up group
		group = new ButtonGroup();
		group.add(sumButton);
		group.add(differenceButton);
		group.add(productButton);
		group.add(quotientButton);
		
		// Setting up radioButtonsPanel
		radioButtonsPanel = new JPanel();
		radioButtonsPanel.setLayout(new BoxLayout(radioButtonsPanel, BoxLayout.X_AXIS));
		radioButtonsPanel.setAlignmentX(LEFT_ALIGNMENT);

		radioButtonsPanel.add(sumButton);
		radioButtonsPanel.add(differenceButton);
		radioButtonsPanel.add(productButton);
		radioButtonsPanel.add(quotientButton);

		//Setting up expression Panel
		expressionPanel = new JPanel();
		expressionPanel.setLayout(new BoxLayout(expressionPanel, BoxLayout.X_AXIS));
		expressionPanel.setAlignmentX(LEFT_ALIGNMENT);
		
		expressionPanel.add(firstInput);
		expressionPanel.add(operatorLabel);
		expressionPanel.add(secondInput);
		expressionPanel.add(resultLabel);
		expressionPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		expressionPanel.add(calculateButton);
		
		//adding all elements to this panel
		this.add(mainLabel);
		this.add(Box.createGlue());
		this.add(radioButtonsPanel);
		this.add(expressionPanel);
		this.add(Box.createGlue());
	}

	@Override
	public void reset() {
		group.clearSelection();
		operatorLabel.setText("_");
		resultLabel.setText("= _");
		firstInput.setText("");
		secondInput.setText("");
	}
}
