package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import tp6.analysis.Analysis;
import tp6.node.AAssignment;
import tp6.node.ABinexpression;
import tp6.node.ABlock;
import tp6.node.AConditional;
import tp6.node.ADiviserOperatorarith;
import tp6.node.AEqualOperatorlogique;
import tp6.node.AInfOperatorlogique;
import tp6.node.AIntegervalue;
import tp6.node.AMinusOperatorarith;
import tp6.node.AModuloOperatorarith;
import tp6.node.AMultiplierOperatorarith;
import tp6.node.APlusOperatorarith;
import tp6.node.APrintS;
import tp6.node.AReadS;
import tp6.node.ASupOperatorlogique;
import tp6.node.AVariableref;
import tp6.node.AWhileS;
import tp6.node.PStatement;


public class Interpreter extends AbstractInterpreter implements Analysis {

	private int counter = -1;
	private boolean result;
	
	
	@Override
	public void caseAAssignment(AAssignment node) 
	{
		for(int i = 0 ; i<counter ; i++)
		{
			System.out.print("\t");
		}
		System.out.println(node);
	}



	@Override
	public void caseABinexpression(ABinexpression node) 
	{
		for(int i = 0 ; i<counter ; i++)
		{
			System.out.print("\t");
		}
		System.out.println(node);
	}


	@Override
	public void caseABlock(ABlock node) 
	{
		counter++;
		//System.out.println("Bloc de profondeur " + counter);
		
		for(PStatement statement : node.getStatement())
		{
			statement.apply(this);
		}
		counter--;
	}




	@Override
	public void caseAConditional(AConditional node) 
	{
		System.out.println(node.getIf().toString() + node.getLPar() + node.getCond() + node.getRPar());
        node.getThenpart().apply(this);
        
        if(node.getElsepart() != null)
        {	System.out.println(node.getElse().toString());
            node.getElsepart().apply(this);
        }

	}


	@Override
	public void caseAEqualOperatorlogique(AEqualOperatorlogique node) 
	{
		for(int i = 0 ; i<counter ; i++)
		{
			System.out.print("\t");
		}
		System.out.println(node);
	
	}



	@Override
	public void caseAInfOperatorlogique(AInfOperatorlogique node) 
	{
		for(int i = 0 ; i<counter ; i++)
		{
			System.out.print("\t");
		}
		System.out.println(node);
	
	}

	@Override
	public void caseAIntegervalue(AIntegervalue node) 
	{
		for(int i = 0 ; i<counter ; i++)
		{
			System.out.print("\t");
		}
		System.out.println(node);
	}



	@Override
	public void caseAMinusOperatorarith(AMinusOperatorarith node) 
	{
		for(int i = 0 ; i<counter ; i++)
		{
			System.out.print("\t");
		}
		System.out.println(node);
	
	}

	@Override
	public void caseAMultiplierOperatorarith(AMultiplierOperatorarith node) 
	{
		for(int i = 0 ; i<counter ; i++)
		{
			System.out.print("\t");
		}
		System.out.println(node);
	}



	@Override
	public void caseAPlusOperatorarith(APlusOperatorarith node) 
	{
		for(int i = 0 ; i<counter ; i++)
		{
			System.out.print("\t");
		}
		System.out.println(node);
	}

	@Override
	public void caseAPrintS(APrintS node) 
	{
		for(int i = 0 ; i<counter ; i++)
		{
			System.out.print("\t");
		}
		System.out.println(node);
		
	}


	@Override
	public void caseAReadS(AReadS node) 
	{
		for(int i = 0 ; i<counter ; i++)
		{
			System.out.print("\t");
		}
		System.out.println(node);
	
	}



	@Override
	public void caseASupOperatorlogique(ASupOperatorlogique node) {
		for(int i = 0 ; i<counter ; i++)
		{
			System.out.print("\t");
		}
		System.out.println(node);
	
	}

	

	@Override
	public void caseAVariableref(AVariableref node) {
		for(int i = 0 ; i<counter ; i++)
		{
			System.out.print("\t");
		}
		System.out.println(node);
	
	}


	@Override
	public void caseAWhileS(AWhileS node) 
	{
		node.getBody().apply(this);
	
	}


	@Override
	public void caseADiviserOperatorarith(ADiviserOperatorarith node) {
		for(int i = 0 ; i<counter ; i++)
		{
			System.out.print("\t");
		}
		System.out.println(node);
	
	}

	@Override
	public void caseAModuloOperatorarith(AModuloOperatorarith node) {
		for(int i = 0 ; i<counter ; i++)
		{
			System.out.print("\t");
		}
		System.out.println(node);
	
	}



}
