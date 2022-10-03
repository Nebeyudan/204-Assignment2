import java.util.ArrayList;

public class MyStack<T> implements StackInterface{
		private int size;
		private ArrayList<T> stack;
		//default constr
		public MyStack() {
			stack = new ArrayList<T>();
			size = 100;
		}
		//param constr
		public MyStack(int size) {
			stack = new ArrayList<>(size);
			this.size = size;
		}
	@Override
	//checks if the stack is empty
	public boolean isEmpty() {
		if(stack.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
	//check if full
	@Override
	public boolean isFull() {
		if(stack.size() == size) {
		return true;
		}
		else return false;
	}
	
	@Override
	public T pop() throws StackUnderflowException {
		if(stack.isEmpty()) { //throws exception if this stack is full
			throw new StackUnderflowException();
		}
		T top = stack.get(stack.size()-1);	// top is the last item out in a stack this is the query to find it
		stack.remove(top);                  // then it removes it 
		return top;
	}

	@Override
	public T top() throws StackUnderflowException {
		if(stack.size()==0) {
			throw new StackUnderflowException();
			
		}
		T temp = stack.get(stack.size()-1); // query to find top
		return temp;
	}

	@Override
	public int size() {
		return stack.size();
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public boolean push(Object e) throws StackOverflowException {
		if(stack.size() >= size) {
			throw new StackOverflowException();
		}
		stack.add((T) e); // just adds an item at the bottom.
		return true;
	}
	public String toString() {
		String s= "";
		for(int i =0;i<stack.size();i++) { // goes through each index adding it to "s" then returns
			s+=stack.get(i);
		}
		return s;
		
	}
	@Override
	public String toString(String delimiter) {
		String s="";
		for(int i =0;i<stack.size();i++) { //same thing except adds delimiter until the last point
			s+=stack.get(i);
			if(i==stack.size()-1) {
				break;
			}
			else s+=delimiter;
		}
		return s;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public void fill(ArrayList list) {
		stack.clear();	//clears array then iterate it and add each piece of list to queue.
		for(int i=0; i<list.size();i++) {
			stack.add((T) list.get(i));
		}
		
	}

}
