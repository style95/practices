package four;

import java.util.ArrayList;

public class FourPointTwo {

    public static void main(String[] args) {
        GraphNode a = new GraphNode("A");
        GraphNode b = new GraphNode("B");
        GraphNode c = new GraphNode("C");
        GraphNode d = new GraphNode("D");
        GraphNode e = new GraphNode("E");
        GraphNode f = new GraphNode("F");
        GraphNode g = new GraphNode("G");

        a.addNeighbor(b);
        b.addNeighbor(c);
        b.addNeighbor(g);
        c.addNeighbor(d);
        c.addNeighbor(e);
        g.addNeighbor(e);
        e.addNeighbor(f);

        GraphNode res = b.search("A");
        if(res != null)
            System.out.println(res.name);
        else
            System.out.println("not found!");
    }

}


class GraphNode {
    String name;
    ArrayList<GraphNode> neighbor = new ArrayList<>();
    public GraphNode(String nodeName) {
        this.name = nodeName;
    }

    public void addNeighbor(GraphNode n) {
        neighbor.add(n);
    }

    public GraphNode search(String searchName) {
        if(name.equals(searchName)) {
            return this;
        }

        for(int i = 0; i < neighbor.size(); i++) {
            GraphNode res = neighbor.get(i).search(searchName);
            if(res != null) {
                return res;
            }
        }
        return null;
    }
}

