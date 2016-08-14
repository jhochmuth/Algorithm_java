import java.util.ArrayList;
import java.util.Set;

public class BreadthFirstSearch {
	public static ArrayList<Node> frontier;
	public static ArrayList<Node> checked;

	public static Node BFS(Node current, Node search) {
		frontier = new ArrayList<Node>();
		checked = new ArrayList<Node>();

		for (Node n : current.connected) {
			if (n.equals(search))
				return n;
			frontier.add(n);
		}
		checked.add(current);
		
		while (frontier != null) {
			current = frontier.get(0);
			checked.add(current);
			frontier.remove(0);
			for (Node n : current.connected) {
				if (n.equals(search))
					return n;
				if (!checked.contains(n) && !frontier.contains(n))
					frontier.add(n);
			}
		}
		return null;
	}

	public static void main(String[] args) {
		Node a = new Node("a");
		Node b = new Node("b");
		Node c = new Node("c");
		Node d = new Node("d");
		Node e = new Node("e");
		a.addEdge(b);
		a.addEdge(c);
		c.addEdge(d);
		b.addEdge(d);
		d.addEdge(e);
		System.out.println(BFS(a, e));
	}
}