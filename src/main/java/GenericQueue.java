class GenericQueue<I> extends GenericList<I> {

	GenericQueue(I data) {

		head = new Node<I>();
		head.data = data;
		this.setLength(true);
	}

	public void enqueue(I data) {
		add(data);
		this.setLength(true);
	}

	public I dequeue() {

		if (head != null) {
			this.setLength(false);
		}

		return delete();
	}

	public void add(I data) {

		if (this.head == null) {
			Node<I> newNode = new Node<I>();
			newNode.data = data;
			this.head = newNode;
		} else {
			Node<I> temp = this.head;

			while (temp.next != null) {
				temp = temp.next;
			}
			Node<I> temp2 = new Node<I>();
			temp2.data = data;

			temp.next = temp2;
		}
	}

}
