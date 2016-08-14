import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Dijkstra {
	public static ArrayList<NodeWithWeight> queue;
	public static Map<NodeWithWeight, Integer> weightMap;
	public static Map<NodeWithWeight, NodeWithWeight> pathMap;

	public static ArrayList<NodeWithWeight> shortestPath(NodeWithWeight start, NodeWithWeight end) {
		queue = new ArrayList<NodeWithWeight>();
		weightMap = new HashMap<NodeWithWeight, Integer>();
		pathMap = new HashMap<NodeWithWeight, NodeWithWeight>();
		NodeWithWeight current = start;

		weightMap.put(current, 0);
		pathMap.put(current, null);
		for (NodeWithWeight n : current.edges) {
			weightMap.put(n, current.map.get(n));
			pathMap.put(n, current);
			queue.add(n);
		}
		while (!queue.isEmpty()) {
			current = extractMinimum();
			relaxEdges(current);
		}
		return getPathTo(end);
	}

	public static NodeWithWeight extractMinimum() {
		NodeWithWeight min = null;
		int minWeight = Integer.MAX_VALUE;
		for (NodeWithWeight n : queue) {
			int currentWeight = weightMap.get(n);
			if (currentWeight < minWeight) {
				min = n;
				minWeight = currentWeight;
			}
		}
		queue.remove(min);
		return min;
	}

	public static void relaxEdges(NodeWithWeight current) {
		for (NodeWithWeight n : current.edges) {
			if (!weightMap.containsKey(n)) {
				pathMap.put(n, current);
				weightMap.put(n, getPathWeight(n));
				queue.add(n);
			} else {
				int currentPath = getPathWeight(n, current);
				if (currentPath < weightMap.get(n)) {
					weightMap.put(n, currentPath);
					pathMap.put(n, current);
				}
			}
		}
	}

	public static int getPathWeight(NodeWithWeight node) {
		NodeWithWeight previous = pathMap.get(node);
		return getPathWeight(node, previous);
	}

	public static int getPathWeight(NodeWithWeight node, NodeWithWeight previous) {
		return weightMap.get(previous) + previous.map.get(node);
	}

	public static ArrayList<NodeWithWeight> getPathTo(NodeWithWeight end) {
		NodeWithWeight current = end;
		ArrayList<NodeWithWeight> path = new ArrayList<>();
		path.add(current);
		while (pathMap.get(current) != null) {
			current = pathMap.get(current);
			path.add(0, current);
		}
		return path;
	}

	public static void main(String[] args) {
		NodeWithWeight a = new NodeWithWeight("a");
		NodeWithWeight b = new NodeWithWeight("b");
		NodeWithWeight c = new NodeWithWeight("c");
		NodeWithWeight d = new NodeWithWeight("d");
		NodeWithWeight e = new NodeWithWeight("e");
		a.addEdge(b, 1);
		a.addEdge(c, 3);
		b.addEdge(c, 1);
		b.addEdge(d, 4);
		c.addEdge(d, 1);
		d.addEdge(e, 3);
		System.out.println(shortestPath(a, e));
		System.out.println(getPathWeight(e));
	}
}
