package sandbox;

interface A{
	public final int a = 0;
	void a();
	void b();
	void c();
	void d();
}

abstract class B implements A{
	public void a(){System.out.println("I am a");}
	public void b(){System.out.println("I am b");}
	public void c(){System.out.println("I am c");}
	public void d(){System.out.println("I am d");}
}

class C extends B{
	
}

public class InterfaceTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B c = new C();
		c.a();
		c.b();
		c.c();
	}

}

class Base{
    private void func(){
          System.out.println("In Base Class func method !!");         
    };
}

class Derived extends Base{
    public void func(){   //  Is this a Method Overriding..????        
          System.out.println("In Derived Class func method"); 
    }      
}

class InheritDemo{
    public static void main(String [] args){                      
          Derived d = new Derived();
          d.func(); 
    }
}
