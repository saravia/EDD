package eucl_al;

public class ListaEnlazada<E> {
	private Nodo<E> head = null;
    private Nodo<E> tail = null;
    private Nodo<E> temp = null;
    public Nodo<E> getHead() {
		return head;
	}
	public void setHead(Nodo<E> head) {
		this.head = head;
	}
	public Nodo<E> getTail() {
		return tail;
	}
	public void setTail(Nodo<E> tail) {
		this.tail = tail;
	}
	public Nodo<E> getTemp() {
		return temp;
	}
	public void setTemp(Nodo<E> temp) {
		this.temp = temp;
	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	private int counter = 0;
	
    public ListaEnlazada(){}
    
    public int size(){return counter;}
	public void insertar(E elem) {
	    if (head == null) {
	      head = new Nodo<E>();
	       head.elem = elem;
	        tail = head;
	        head.siguiente = tail;
	    } else {
	        tail.siguiente = new Nodo(); 
	        tail = tail.siguiente; 
	        tail.elem = elem; 
	    }
	    counter++;
	}

public E sacar(int index){
  assert (index >= 0 && index < size());
  temp = head; 
  for(int i = 0; i < index; i++) temp = temp.siguiente;
  return temp.elem; 

}
public E remove(int index) {
    assert (index >= 0 && index < size()); 
    temp = head; 
    for (int i = 0; i < index; i++) {
        temp = temp.siguiente;
    }
    Nodo<E> two = temp.siguiente;
    temp.siguiente = two.siguiente;
    E elem = two.elem; 
    two = null;
    return elem; 
}

}
