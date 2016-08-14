
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NodeWithWeight extends Node {
	ArrayList<NodeWithWeight> edges;
	Map<NodeWithWeight, Integer> map;

	public NodeWithWeight(String name) {
		super(name);
		edges = new ArrayList<NodeWithWeight>();
		map = new HashMap<NodeWithWeight, Integer>();
	}

	public void addEdge(NodeWithWeight other, int weight) {
		this.edges.add(other);
		this.map.put(other, weight);
		other.edges.add(this);
		other.map.put(this, weight);
	}

	public void addEdge(NodeWithWeight other) {
		addEdge(other, 0);
	}

	@Override
	public void addEdge(Node other) {
		NodeWithWeight o1 = new NodeWithWeight(other.getValue());
		addEdge(o1, 0);
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof NodeWithWeight) {
			NodeWithWeight o1 = (NodeWithWeight) other;
			return this.getValue().equals(o1.getValue());
		}
		return false;
	}
}
