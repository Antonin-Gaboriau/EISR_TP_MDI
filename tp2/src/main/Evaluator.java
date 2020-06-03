package main;

import tp6.analysis.Analysis;
import tp6.node.*;

import java.util.*;


public class Evaluator extends AbstractInterpreter implements Analysis
{
	private int leftExprCalc, rightExprCalc;
	private HashMap<Integer, Integer> varList = new HashMap();
	private boolean name = false;
	private Stack<Integer> instructions = new Stack();

	private int getId(String var){
		int val = 0;
		for (char c : var.toCharArray()){val += (int) c;}
		return val;
	}


	@Override
	public void caseAAssignment(AAssignment node)
	{
		node.getRhs().apply(this);
		int result = this.instructions.pop();
		name = true;

		node.getVar().apply(this);
		int varId = this.instructions.pop();
		name = false;

		this.varList.replace(varId, result);
	}

	@Override
	public void caseABinexpression(ABinexpression node)
	{
		node.getRExp().apply(this);
		node.getLExp().apply(this);
		node.getOperator().apply(this);
	}

	@Override
	public void caseABlock(ABlock node)
	{
		for (PStatement statement : node.getStatement())
		{
			statement.apply(this);
		}
	}

	@Override
	public void caseAConditional(AConditional node)
	{
		node.getCond().apply(this);
		int cond = this.instructions.pop();

		if (cond != 0)
		{
			node.getThenpart().apply(this);
		}
		else
		{
			node.getElsepart().apply(this);
		}
	}

	@Override
	public void caseAEqualOperatorlogique(AEqualOperatorlogique node)
	{
		int val = 0;

		if (this.leftExprCalc == this.rightExprCalc)
		{
			val = 1;
		}

		this.instructions.push(val);
	}

	@Override
	public void caseAInfOperatorlogique(AInfOperatorlogique node)
	{
		int leftExpr = this.instructions.pop();
		int rightExpr = this.instructions.pop();
		int result = 0;

		if (leftExpr < rightExpr)
		{
			result = 1;
		}

		this.instructions.push(result);
	}

	@Override
	public void caseAIntegervalue(AIntegervalue node)
	{
		int value = Integer.parseInt(node.getNumber().toString().trim());
		this.instructions.push(value);
	}

	@Override
	public void caseAMinusOperatorarith(AMinusOperatorarith node)
	{
		int leftExpr = this.instructions.pop();
		int rightExpr = this.instructions.pop();

		int value = leftExpr - rightExpr;

		this.instructions.push(value);
	}

	@Override
	public void caseAMultiplierOperatorarith(AMultiplierOperatorarith node)
	{
		int leftExpr = this.instructions.pop();
		int rightExpr = this.instructions.pop();

		int value = leftExpr * rightExpr;

		this.instructions.push(value);
	}

	@Override
	public void caseAPlusOperatorarith(APlusOperatorarith node)
	{
		int leftExpr = this.instructions.pop();
		int rightExpr = this.instructions.pop();

		int value = leftExpr + rightExpr;

		this.instructions.push(value);
	}

	@Override
	public void caseAPrintS(APrintS node)
	{
		node.getValue().apply(this);

		int value = this.instructions.pop();
		System.out.println(value);
	}

	@Override
	public void caseAReadS(AReadS node)
	{
		Scanner sc = new Scanner(System.in);
		int readValue;
		System.out.print("Enter an integer value for " + node.getVar() + " : ");
		readValue = sc.nextInt();

		name = true;
		node.getVar().apply(this);
		int varId = this.instructions.pop();
		name = false;

		this.varList.replace(varId, readValue);
	}

	@Override
	public void caseADiviserOperatorarith(ADiviserOperatorarith node)
	{
		int leftExpr = this.instructions.pop();
		int rightExpr = this.instructions.pop();

		int res = Math.round((float) leftExpr / (float) rightExpr);

		this.instructions.push(res);
	}

	@Override
	public void caseAModuloOperatorarith(AModuloOperatorarith node)
	{
		int leftExpr = this.instructions.pop();
		int rightExpr = this.instructions.pop();

		int res = leftExpr % rightExpr;

		this.instructions.push(res);
	}

	@Override
	public void caseASupOperatorlogique(ASupOperatorlogique node)
	{
		int leftExpr = this.instructions.pop();
		int rightExpr = this.instructions.pop();
		int result = 0;


		if (leftExpr > rightExpr)
		{
			result = 1;
		}

		this.instructions.push(result);
	}

	@Override
	public void caseAVariableref(AVariableref node)
	{
		String varName = node.getIdentifier().toString();
		int varId = this.getId(varName);

		if (!this.varList.containsKey(varId))
		{
			varList.put(varId, -1);
		}

		if (name)
		{
			this.instructions.push(varId);
		}
		else
		{
			this.instructions.push(this.varList.get(varId));
		}
	}

	@Override
	public void caseAWhileS(AWhileS node)
	{
		int counter = 0;
		node.getCond().apply(this);
		int cond = this.instructions.pop();

		while (cond != 0)
		{
			node.getBody().apply(this);

			node.getCond().apply(this);
			cond = this.instructions.pop();

			counter++;

			if (counter >= 5)
				break;
		}

		System.out.println("End while (nbLoop : " + counter + ")");
	}
}
