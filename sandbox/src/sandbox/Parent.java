package sandbox;

public abstract class Parent {
	private String parentName;
	private String parentOtherName;
	public int randnum;
	double randdouble;

	abstract void test();

}

class Child extends Parent {

	@Override
	void test() {
		System.out.println("Hello");
	}

	public static void main(String[] args) {
		Parent child = new Child();
		child.test();
	}

}