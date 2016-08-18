import java.util.ArrayList;
import java.util.HashMap;

public class AdjacencyListGraph <T1, T2> {
	// T1 is node type; T2 is edge type
	public Object type;
	public ArrayList<T1> nodes;
	public HashMap<T1, ArrayList<T2>> adjacencyList;
	
	public AdjacencyListGraph() {
		this.nodes = new ArrayList<T1>();
		this.adjacencyList = new HashMap<T1, ArrayList<T2>>();
	}
	
	public void addNode(T1 node, ArrayList<T2> adjacent) {
		if (!this.containsNode(node)) {
			nodes.add(node);
			adjacencyList.put(node, adjacent);
		}
		else throw new IllegalArgumentException();
	}
	
	public void addNode(T1 node) {
		addNode(node, new ArrayList<T2>());
	}
	
	public void removeNode(T1 node) {
		nodes.remove(node);
		adjacencyList.remove(node);
	}
	
	// Problems with using T2 instead of WeightedEdge
	// Will add nodes if the start and end nodes of specified edge do not exist in the graph
	public void addEdge(WeightedEdge edge) {
		T1 start = (T1) edge.getStart();
		T1 end = (T1) edge.getEnd();
		if (!this.containsNode(start)) {
			nodes.add(start);
			adjacencyList.put(start, new ArrayList<T2>());
		}
		if (!this.containsNode(end)) {
			nodes.add(end);
			adjacencyList.put(end, new ArrayList<T2>());
		}
		ArrayList<T2> startList = adjacencyList.get(start);
		ArrayList<T2> endList = adjacencyList.get(end);
		startList.add((T2) edge);
		endList.add((T2) edge);
	}
	
	public Iterable<T2> getConnected(T1 node) {
		return adjacencyList.get(node);
	}
	
	public boolean containsNode(T1 o) {
		return nodes.contains(o);
	}
}
