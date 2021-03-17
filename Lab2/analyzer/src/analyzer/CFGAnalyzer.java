package analyzer;

import graph.DGraph;

/**
 * @desc build and analyze CFG of a given method.
 * @author you
 */
public class CFGAnalyzer {

	protected DGraph<Integer> graph;

	public DGraph<Integer> setGraph() {
		return this.graph;
	}

}

abstract class CFGAnalyzerBuilder {

	protected CFGAnalyzer analyzer;

	public CFGAnalyzer getAnalyzer() {
		return this.analyzer;
	}

	public void createNewCFGAnalyzer() {
		this.analyzer = new CFGAnalyzer();
	}

	public abstract void print();

}

class MatrixBuilder extends CFGAnalyzerBuilder {
	@Override
	public void print() {
		System.out.println("This is the Matrix method");
	}
}

class ShowBranchesBuilder extends CFGAnalyzerBuilder {
	@Override
	public void print() {
		System.out.println("This is the ShowBranches method");
	}
}

class NumberOfBranchesBuilder extends CFGAnalyzerBuilder {
	@Override
	public void print() {
		System.out.println("This is the NumberOfBranches method");
	}
}

class Director {
	private CFGAnalyzerBuilder analyzerBuilder;

	public void setCFGBuilder(CFGAnalyzerBuilder cfgBuilder) {
		this.analyzerBuilder = cfgBuilder;
	}

	public CFGAnalyzer getCFGAnalyzer() {
		return this.analyzerBuilder.getAnalyzer();
	}

	public void constructCFGAnalyzer() {
		analyzerBuilder.createNewCFGAnalyzer();
		analyzerBuilder.print();
	}
}
