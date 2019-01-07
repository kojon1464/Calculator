package model;

import java.util.ArrayList;
import java.util.List;

public class Model {

	public enum Operator {
		SUM, DIFFERENCE, PRODUCT, QUOCIENT, TANGENT, COTANGENT, SINE, COSINE, NONE
	}

	private Operator operator;
	private Double result;
	private Double secondresult; //used for quadratic equation;
	private String errorMessage;

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public Operator getOperator() {
		return operator;
	}

	public String getResult() {
		return result.toString();
	}
	
	public String getSecondResult() {
		return secondresult.toString();
	}
	
	public String getErrorMessage() {
		return errorMessage.toString();
	}

	public boolean basicCalcualtion(double first, double second) {
		boolean error = false;

		switch (operator) {
		case SUM:
			result = first + second;
			break;
		case DIFFERENCE:
			result = first - second;
			break;
		case PRODUCT:
			result = first * second;
			break;
		case QUOCIENT:
			if (second == 0) {
				error = true;
				errorMessage = "Can not divide by zero!";
			}
			result = first / second;
			break;
		default:
			error = true;
			errorMessage = "Please select operation!";
		}
		return error;
	}

	public boolean trygonometryCalculation(double first) {
		boolean error = false;

		switch (operator) {
		case TANGENT:
			result = Math.tan(first);
			break;
		case COTANGENT:
			result = 1d / Math.tan(first);
			break;
		case SINE:
			result = Math.sin(first);
			break;
		case COSINE:
			result = Math.cos(first);
			break;
		default:
			error = true;
			errorMessage = "Please select operation!";
		}
		return error;
	}

	public void logarithmCalculation(double first) {
		result = Math.log(first);
	}

	public void powerCalculation(double first, double second) {
		result = Math.pow(first, second);
	}

	//returning true when equation don't have results;
	public boolean quadraticEquationCalculation(double first, double second, double third) {
		
		if (Math.pow(second, 2) - 4 * first * third < 0) {
			return true;
		} else {
			result = (-second + Math.sqrt(Math.pow(second, 2) - (4 * first * third))) / (2 * first);
			secondresult = (-second - Math.sqrt(Math.pow(second, 2) - (4 * first * third))) / (2 * first);
		}
		return false;
	}

	public boolean validateDouble(String text) {
		boolean canBeValidated = false;

		try {
			Double.parseDouble(text);
			canBeValidated = true;
		} catch (Exception e) {
			// handle error;
		}
		return canBeValidated;
	}

}
