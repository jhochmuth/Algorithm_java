import java.util.ArrayList;
import java.util.Map;

public class Dijkstra1 <T1, T2>{
	public AdjacencyListGraph<T1, T2> graph;
	public ArrayList<T1> queue;
	public Map<T1, Integer> weightMap;
	public Map<T1, T1> pathMap;
	
	public Dijkstra1(AdjacencyListGraph<T1, T2> graph, T1 start) {
		this.graph = graph;
		for (T2 edge : graph.getConnected(start)) {
			T1 first = (T1) ((WeightedEdge)edge).getStart();
			T1 second = (T1) ((WeightedEdge)edge).getEnd();
		}
	}
}
