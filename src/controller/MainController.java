package controller;

import javax.swing.JPanel;

import model.Model;
import model.Model.Operator;
import view.BasicCalculationPanel;
import view.CalculatorFrame;
import view.LogarithmCalculationPanel;
import view.PowerCalculationPanel;
import view.QuadraticEquationCalculationPanel;
import view.Resetable;
import view.TrygonometryCalculationPanel;

public class MainController {

	Model model;

	CalculatorFrame appFrame;
	BasicCalculationPanel basicPanel;
	LogarithmCalculationPanel logarthmPanel;
	TrygonometryCalculationPanel trygonometryPanel;
	PowerCalculationPanel powerPanel;
	QuadraticEquationCalculationPanel quadraticEquationPanel;

	public MainController() {

		model = new Model();
		setupPanels();
		setupClalculatorFrameListeners();
		setupPanelsListeners();
	}

	private void setPanel(Resetable panel) {

		model.setOperator(Operator.NONE);
		panel.reset();
		appFrame.setPanel((JPanel) panel);
	}

	private void quadraticEquationCalculation(String firstInputText, String secondInputText, String thirdInputText) {

		if (!model.validateDouble(firstInputText) || !model.validateDouble(secondInputText)
				|| !model.validateDouble(thirdInputText)) {
			appFrame.dialogMessage("Please enter numbers!");
			return;
		}
		if (model.quadraticEquationCalculation(Double.parseDouble(firstInputText), Double.parseDouble(secondInputText),
				Double.parseDouble(thirdInputText)))
			quadraticEquationPanel.setResultLabelText("No results!");
		else
			quadraticEquationPanel.setResultLabelText("x = " + model.getResult() + ", x = " + model.getSecondResult());
	}

	private void powerCalculation(String firstInputText, String secondInputText) {

		if (!model.validateDouble(firstInputText) || !model.validateDouble(secondInputText)) {
			appFrame.dialogMessage("Please enter numbers!");
			return;
		}
		model.powerCalculation(Double.parseDouble(firstInputText), Double.parseDouble(secondInputText));
		powerPanel.setResultLabelText("= " + model.getResult());
	}

	private void logarithmCalculation(String firstInputText) {

		if (!model.validateDouble(firstInputText)) {
			appFrame.dialogMessage("Please enter numbers!");
			return;
		}
		model.logarithmCalculation(Double.parseDouble(firstInputText));
		logarthmPanel.setResultLabelText("= " + model.getResult());
	}

	private void trygonometryCalculation(String firstInputText) {

		if (!model.validateDouble(firstInputText)) {
			appFrame.dialogMessage("Please enter numbers!");
			return;
		}
		if (model.trygonometryCalculation(Double.parseDouble(firstInputText))) {
			appFrame.dialogMessage(model.getErrorMessage());
			return;
		}
		trygonometryPanel.setResultLabelText("x = " + model.getResult());
	}

	private void basicCalculation(String firstInputText, String secondInputText) {

		if (!model.validateDouble(firstInputText) || !model.validateDouble(secondInputText)) {
			appFrame.dialogMessage("Please enter numbers!");
			return;
		}
		if (model.basicCalcualtion(Double.parseDouble(firstInputText), Double.parseDouble(secondInputText))) {
			appFrame.dialogMessage(model.getErrorMessage());
			return;
		}
		basicPanel.setResultLabelText("= " + model.getResult());
	}

	private void setupClalculatorFrameListeners() {

		appFrame.addBasicCalculationListener((e) -> setPanel(basicPanel));
		appFrame.addTrigonometryCalculationListener((e) -> setPanel(trygonometryPanel));
		appFrame.addlogarithmCalculationListener((e) -> setPanel(logarthmPanel));
		appFrame.addPowerCalculationListener((e) -> setPanel(powerPanel));
		appFrame.addQuadraticEquationCalculationListener((e) -> setPanel(quadraticEquationPanel));
	}

	private void setupPanelsListeners() {
		// basicPanel
		basicPanel.addSumButtonListener((e) -> {
			model.setOperator(Operator.SUM);
			basicPanel.setOperatorLabelText("+");
		});
		basicPanel.addDifferenceButtonListener((e) -> {
			model.setOperator(Operator.DIFFERENCE);
			basicPanel.setOperatorLabelText("-");
		});
		basicPanel.addProductButtonListener((e) -> {
			model.setOperator(Operator.PRODUCT);
			basicPanel.setOperatorLabelText("*");
		});
		basicPanel.addQuotientButtonListener((e) -> {
			model.setOperator(Operator.QUOCIENT);
			basicPanel.setOperatorLabelText("/");
		});
		basicPanel.addCalculateButtonListener(
				(e) -> basicCalculation(basicPanel.getFirstInputText(), basicPanel.getSecondInputText()));

		// trygonometryPanel
		trygonometryPanel.addTanButtonListener((e) -> {
			model.setOperator(Operator.TANGENT);
			trygonometryPanel.setOperatorLabelText("tan");
		});
		trygonometryPanel.addCtanButtonListener((e) -> {
			model.setOperator(Operator.COTANGENT);
			trygonometryPanel.setOperatorLabelText("ctan");
		});
		trygonometryPanel.addSinButtonListener((e) -> {
			model.setOperator(Operator.SINE);
			trygonometryPanel.setOperatorLabelText("sin");
		});
		trygonometryPanel.addCosButtonListener((e) -> {
			model.setOperator(Operator.COSINE);
			trygonometryPanel.setOperatorLabelText("cos");
		});
		trygonometryPanel.addCalculateButtonListener((e) -> {
			trygonometryCalculation(trygonometryPanel.getFirstInputText());
		});

		logarthmPanel.addCalculateButtonListener((e) -> {
			logarithmCalculation(logarthmPanel.getFirstInputText());
		});

		powerPanel.addCalculateButtonListener((e) -> {
			powerCalculation(powerPanel.getFirstInputText(), powerPanel.getSecondInputText());
		});

		quadraticEquationPanel.addCalculateButtonListener((e) -> {
			quadraticEquationCalculation(quadraticEquationPanel.getFirstInputText(),
					quadraticEquationPanel.getSecondInputText(), quadraticEquationPanel.getThirdInputText());
		});
	}

	private void setupPanels() {

		appFrame = new CalculatorFrame();
		basicPanel = new BasicCalculationPanel();
		logarthmPanel = new LogarithmCalculationPanel();
		trygonometryPanel = new TrygonometryCalculationPanel();
		powerPanel = new PowerCalculationPanel();
		quadraticEquationPanel = new QuadraticEquationCalculationPanel();

		setPanel(basicPanel);
	}

}
