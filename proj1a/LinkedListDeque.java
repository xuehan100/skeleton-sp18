public class LinkedListDeque<T>{  //T is the generic type
	private IntNode sentinel;
	//size variable tracking the current size
	private int size;

	//try to implement with static later
	//
	public class IntNode {
		IntNode prev;
		IntNode next;
		T item;

		IntNode(T i, IntNode p, IntNode n){
			prev=p;
			item=i;
			next=n;
		}

	}

	/*
	create an empty linked list deque
	 */
	public LinkedListDeque(){
		//make a circle, sentinal's next is the first node of the linked list
		//sentinal's previous is the last node of the linked list
		sentinel=new IntNode(null, null, null);
		sentinel.prev=sentinel;
		sentinel.next=sentinel;
		size=0;
	}

	/*
	add an item of type T to the front of the deque
	the running time should be constant
	must not involving any looping or recursion
	 */
	public void addFirst(T item){
		size += 1;
		IntNode first_item=new IntNode(item, sentinel, sentinel.next);
		sentinel.next.prev=first_item;
		sentinel.next=first_item;

	}

	public void addLast(T item){
		size+=1;
		IntNode last_item=new IntNode(item,sentinel.prev,sentinel);
		sentinel.prev.next=last_item;
		sentinel.prev=last_item;
	}

	public boolean isEmpty(){
		return size==0;
	}

	/*
	must take constant time
	 */
	public int size(){
		return size;
	}

	public void printDeque(){
		IntNode cur = sentinel.next;
		while(cur != sentinel){
			System.out.print(cur.item + " ");
			cur = cur.next;
		}
		System.out.println();
	}

	/*
	removes and returns the item at the front of the deque, if no such item exists, return null
	 */
	public T removeFirst(){
		if(sentinel.next==sentinel){
			return null;
		}
		T res=sentinel.next.item;
		sentinel.next=sentinel.next.next;
		sentinel.next.prev=sentinel;
		size--;

		return res;
	}

	/*
	removes and returns the item at the back of the deque. If no such item exists, return null
	 */
	public T removeLast(){
		if(sentinel.next == sentinel){
			return null;
		}
		T res=sentinel.prev.item;
		sentinel.prev=sentinel.prev.prev;
		sentinel.prev.next = sentinel;
		size--;

		return res;

	}

	/*
	gets the item at the given index, where 0 is the front, 1 is the next item and so forth
	if no such item exists returns null, must not alter the deque
	must use iteration, not recursion
	 */
	public T get(int index){
		if(index > size-1){
			return null;
		}

		IntNode cur = sentinel.next;
		int i = 0;

		while(i < index){
			cur=cur.next;
			i++;
		}

		if(cur == sentinel){
			return null;
		}else {
			return cur.item;
		}
	}

	/*
	must use recursion, can add any private helper classes or methods in LinkeListDeuqe.java
	 */
	private T recursion_help(IntNode cur, int index, int i){
		//base case
		if(cur == null){
			return  null;
		}

		if(i == index){
			return cur.item;
		}

		//recursion
		return recursion_help(cur.next, index, i+1);

	}

	public T getRecursion(int index){
		IntNode cur =  sentinel.next;
		return recursion_help(sentinel.next, index, 0);
	}

	/*
	creates a deep copy of other
	 */
	public LinkedListDeque(LinkedListDeque other){
		sentinel = new IntNode(null, null, null);
		sentinel.prev = sentinel;
		sentinel.next = sentinel;
		size = 0;

		for(int i = 0; i < other.size(); ++i){
			addLast((T) other.get(i));
		}

	}


}