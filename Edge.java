
public class Edge <T> {
	private final T start;
	private final T end;
	
	public Edge(T start, T end) {
		this.start = start;
		this.end = end;
	}
	
	public T getStart() {
		return this.start;
	}
	
	public T getEnd() {
		return this.end;
	}
	
	public T getOppositeNode(T node) {
		if (this.start.equals(node)) return end;
		return start;
	}
}
