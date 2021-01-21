package sandbox;

abstract class Shape {
	Shape(){
		System.out.println("A shape was created");
	}
	void WhatAmI() {
		System.out.println("I am a shape\n");
	}
	abstract void draw(); // if there are abstract methods then the class must be abstract
}

class Rectangle extends Shape {
	void draw() {
		System.out.println("Drawing rectangle");
	}
}

class Circle extends Shape {
	void draw() {
		System.out.println("Drawing circle");
	}
}

// u can't instantiate an abstract class, you must instantiate the children

class TestAbstractClass1 {
	public static void main(String[] args) {
		Shape circle = new Circle();
		circle.draw();
		circle.WhatAmI();
		
		Shape rectangle = new Rectangle();
		rectangle.draw();
		rectangle.WhatAmI();
	}
	
	
}