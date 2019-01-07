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

public class TrygonometryCalculationPanel extends JPanel implements Resetable {

	private JLabel mainLabel;
	private JLabel operatorLabel;
	private JLabel resultLabel;
	
	private JTextField firstInput;
	
	private JPanel radioButtonsPanel;
	private JPanel expressionPanel;
	
	private ButtonGroup group;
	
	private JRadioButton tanButton;
	private JRadioButton ctanButton;
	private JRadioButton sinButton;
	private JRadioButton cosButton;
	
	private JButton calculateButton;

	public TrygonometryCalculationPanel() {
		setupPanel();
	}
	
	public String getFirstInputText() {
		return firstInput.getText();
	}
	
	public void setTanButtonActive() {
		tanButton.setSelected(true);
	}
	
	public void setOperatorLabelText(String text) {
		operatorLabel.setText(text);
	}
	
	public void setResultLabelText(String text) {
		resultLabel.setText(text);
	}
	
	public void addTanButtonListener(ActionListener listener) {
		tanButton.addActionListener(listener);
	}
	
	public void addCtanButtonListener(ActionListener listener) {
		ctanButton.addActionListener(listener);
	}
	
	public void addSinButtonListener(ActionListener listener) {
		sinButton.addActionListener(listener);
	}
	
	public void addCosButtonListener(ActionListener listener) {
		cosButton.addActionListener(listener);
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

		mainLabel = new JLabel("Trygonometry Calculations");
		mainLabel.setFont(new Font(mainLabel.getFont().getFontName(), mainLabel.getFont().getStyle(), 20));
		
		operatorLabel = new JLabel("tan");
		resultLabel = new JLabel("= _");
		calculateButton = new JButton("Calculate");
		firstInput = new JTextField();
		
		firstInput.setMaximumSize(new Dimension(100,20));
		
		// Setting up radioButtons
		tanButton = new JRadioButton("tangent");
		ctanButton = new JRadioButton("cotangent");
		sinButton = new JRadioButton("sine");
		cosButton = new JRadioButton("cosine");
		
		// Setting up group
		group = new ButtonGroup();
		group.add(tanButton);
		group.add(ctanButton);
		group.add(sinButton);
		group.add(cosButton);
		
		// Setting up radioButtonsPanel
		radioButtonsPanel = new JPanel();
		radioButtonsPanel.setLayout(new BoxLayout(radioButtonsPanel, BoxLayout.X_AXIS));
		radioButtonsPanel.setAlignmentX(LEFT_ALIGNMENT);

		radioButtonsPanel.add(tanButton);
		radioButtonsPanel.add(ctanButton);
		radioButtonsPanel.add(sinButton);
		radioButtonsPanel.add(cosButton);

		//Setting up expression Panel
		expressionPanel = new JPanel();
		expressionPanel.setLayout(new BoxLayout(expressionPanel, BoxLayout.X_AXIS));
		expressionPanel.setAlignmentX(LEFT_ALIGNMENT);
		
		expressionPanel.add(operatorLabel);
		expressionPanel.add(firstInput);
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
	}
}
