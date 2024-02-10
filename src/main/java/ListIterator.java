import java.util.Iterator;

//Iterator defines methods that one expects from an Iterator
public class ListIterator<I> implements Iterator<I>{
	
	Node<I> theStack;	//keeps reference to node from object to be iterated
	
	//pass in the list to be iterated and set reference to the head node
	//note that this is a walker variable and does not move the head
	public ListIterator(GenericList<I> theList){
		this.theStack = theList.head;
		
	}

	//implement method from Iterator
	public boolean hasNext() {
		if(theStack == null){
		
		return false;
		}
		else{
			return true;
		}
	}

	//implement method from Iterator
	public I next() {
		I val = theStack.data;
		
		theStack = theStack.next;
		return val;
	}

}
