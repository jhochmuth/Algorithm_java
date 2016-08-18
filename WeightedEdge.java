
public class WeightedEdge <T> {
	private final T start;
	private final T end;
	private final int weight;
	
	public WeightedEdge(T start, T end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
	
	public T getStart() {
		return this.start;
	}
	
	public T getEnd() {
		return this.end;
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public T getOppositeNode(T node) {
		if (this.start.equals(node)) return end;
		return start;
	}
}
