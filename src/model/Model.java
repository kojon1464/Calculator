package model;

import java.util.ArrayList;
import java.util.List;

public class Model {

	public enum Operator {
		SUM, DIFFERENCE, PRODUCT, QUOCIENT, TANGENT, COTANGENT, SINE, COSINE
	}
	

	private Operator operator;
	private Double result;
	private String equationResult;

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public Operator getOperator() {
		return operator;
	}

	public String getResult() {
		return result.toString();
	}
	
	public String getEquationResult() {
		return equationResult;
	}

	public boolean basicCalcualtion(double first, double second) {
		boolean divisionByZero = false;
		
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
			if(second == 0)
				divisionByZero = true;
			result = first / second;
			break;
		}
		return divisionByZero;
	}
	
	public void trygonometryCalculation(double first) {
		switch (operator) {
		case TANGENT:
			result = Math.tan(first);
			break;
		case COTANGENT:
			result = 1d/Math.tan(first);
			break;
		case SINE:
			result = Math.sin(first);
			break;
		case COSINE:
			result = Math.cos(first);
			break;
		}
	}
	
	public void logarithmCalculation(double first) {
		result = Math.log(first);
	}
	
	public void powerCalculation(double first, double second) {
		result = Math.pow(first, second);
	}
	
	public void quadraticEquationCalculation(double first, double second, double third) {
		if(Math.pow(second, 2) -4*first*third < 0) {
			equationResult = "no results";
		}else {
			equationResult ="x = ";
			Double temp = ( -second + Math.sqrt(Math.pow(second, 2) - (4*first*third)))/(2*first);
			equationResult += temp.toString() + " and x = ";
			temp = (-second - Math.sqrt(Math.pow(second, 2) - (4*first*third)))/(2*first);
			equationResult += temp.toString();
		}
	}
	
	public boolean validateDouble(String text) {
		boolean canBeValidated = false;
		
		try{
			Double.parseDouble(text);
			canBeValidated = true;
		}	catch (Exception e) {
			//handle error;
		}
		return canBeValidated;
	}

}
