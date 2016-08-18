
public class Node1 <T> {
	private T value;
	
	public Node1(T value) {
		this.value = value;
	}
	
	public T getValue() {
		return this.value;
	}
	
	public boolean equals(Object o) {
		if (o instanceof Node1) {
			Node1 o1 = (Node1) o;
			return o1.getValue().equals(this.getValue());
		}
		return false;
	}
	
	public String toString() {
		return String.format("Value: %T", this.value);
	}
}
