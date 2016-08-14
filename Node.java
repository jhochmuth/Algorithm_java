import java.util.ArrayList;

class Node {
	private String name;
	public ArrayList<Node> connected;

	public Node(String name) {
		this.name = name;
		this.connected = new ArrayList<Node>();
	}

	public String getValue() {
		return this.name;
	}

	public void addEdge(Node other) {
		this.connected.add(other);
		other.connected.add(other);
	}

	public void removeEdge(Node other) {
		if (!this.connected.contains(other))
			throw new IllegalArgumentException();
		this.connected.remove(this.connected.indexOf(other));
		other.connected.remove(other.connected.indexOf(this));
	}

	public boolean equals(Node o) {
		if (o instanceof Node) {
			Node o1 = (Node) o;
			return o1.getValue().equals(this.getValue());
		}
		return false;
	}

	public String toString() {
		String result = "";
		result += "Name: " + this.getValue();
		return result;
	}
}