
public class WeightedEdge <T> extends Edge {
	public final int weight;
	
	public WeightedEdge(T start, T end, int weight) {
		super(start, end);
		this.weight = weight;
	}
	
	public int getWeight() {
		return this.weight;
	}
}
