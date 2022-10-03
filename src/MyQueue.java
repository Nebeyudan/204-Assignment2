import java.util.ArrayList;

public class MyQueue<T> implements QueueInterface {
	private int front, back, size;
	private ArrayList<T> queue;
	//default constructor
	public MyQueue() {
		front =0;
		back =0;
		queue = new ArrayList<>();
		size = 100;
	}
	//param constructor.
	public MyQueue(int s) {
		queue = new ArrayList<>(size);
		this.size =s;
	}
	//checks if this queue is empty
	@Override
	public boolean isEmpty() {
		if(queue.isEmpty()) {
			return true;
		}
		 return false;
	}
	//checks if the queue is full or not
	@Override
	public boolean isFull() {
		if(queue.size() == size){
			return true;
		}
		return false;
	}
	//dequeue method
	@Override
	public Object dequeue() throws QueueUnderflowException {
		if(isEmpty()) {									//if it is full it throws exception
			throw new QueueUnderflowException();
		}
		else {
			
			T next = queue.get(front);		//otherwise it gets the item from the front removes it 
			queue.remove(front);            // then returns it
			return next;
		}
		
	}

	@Override
	public int size() {	
		return queue.size();
		
	}

	//enqueue
	@SuppressWarnings("unchecked")
	@Override
	public boolean enqueue(Object e) throws QueueOverflowException {
		if(queue.size() >= size) { //checks if it is full if not continues if throws exception
			throw new QueueOverflowException();
		}
		else queue.add((T) e);	//otherwise it adds the object to queue.
		return true;
		
	}
	public String toString() {
		String s="";
		for(int i =0;i<queue.size();i++) { // goes through each index adding it to "s" then returns
			s+=queue.get(i);
		}
		return s;
		
	}
	@Override
	public String toString(String delimiter) {
		String s="";
		for(int i =0;i<queue.size();i++) { //same thing except adds delimiter until the last point
			s+=queue.get(i);
			if(i==queue.size()-1) {
				break;
			}
			else s+=delimiter;
		}
		return s;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void fill(ArrayList list) {
		queue.clear();	//clears array then iterate it and add each piece of list to queue.
		for(int i=0; i<list.size();i++) {
			queue.add((T) list.get(i));
		}
		
	}

}
