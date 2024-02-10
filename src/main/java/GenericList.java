import java.util.Iterator;

abstract class GenericList<I> implements collection<I>{

	Node<I> head;	//A linked list, could change to another data structure
	private int length;

	public abstract void add(I data);

	public void setLength(boolean how) {

		if (how) {
			++length;
		}

		else {
			--length;
		}
	}

	public int getLength() {
		return length;
	}

	public I delete() {

		if (head == null) {
			return null;
		}

		I obj = head.data;
		head = head.next;
		return obj;

	}

	public void print() {

		if (head == null) {
			System.out.println("Empty List!");
		} else {

			Node<I> temp = head;

			while (temp != null) {
				System.out.println(temp.data);
				temp = temp.next;
			}
		}
	}
	
	//implements interface and returns object that defines how to iterate the
	//chosen data structure
	public Iterator<I> createIterator(){
		
		return new ListIterator<I>(this);
	}

	
}

class Node<T> {
	T data;
	Node<T> next;
}

//define an interface that the client can call
interface collection<I>{
	
	public Iterator<I> createIterator();
}



