import java.util.ArrayList;
import java.util.Stack;

public class DepthFirstSearch {
	public static Stack<Node> stack;
	public static ArrayList<Node> checked;

	public static Node DFS(Node current, Node search) {
		stack = new Stack<Node>();
		checked = new ArrayList<Node>();

		int moves = 1;
		for (Node n : current.connected) {
			if (n.equals(search))
				return n;
			stack.add(n);
		}
		checked.add(current);
		
		while (stack != null) {
			moves++;
			current = stack.pop();
			checked.add(current);
			for (Node n : current.connected) {
				if (n.equals(search))
					return n;
				if (!checked.contains(n) && !stack.contains(n))
					stack.add(n);
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
		System.out.println(DFS(a, e));
	}
}
