package sandbox;

interface List<E> {
	public void add(E value);
	public E get(int index);
	public int size();
}

class ArrayList<E> implements List<E>{
	
	

	@Override
	public void add(E value) {
		// TODO Auto-generated method stub
		System.out.println("add");
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		System.out.println("get");
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		System.out.println("size");
		return 0;
	}
	
}

public class GenericsTest {

	public static void main(String[] args) {
		List<Integer> testList = new ArrayList<Integer>();
		testList.add(2);
		// TODO Auto-generated method stub

	}

}
