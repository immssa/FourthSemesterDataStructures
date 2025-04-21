package Lr6;

public class Client {
    public static void main(String[] args) {
        Graph graph = new Graph(5);

        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');

        graph.addEdge('A', 'B');
        graph.addEdge('A', 'C');
        graph.addEdge('B', 'D');
        graph.addEdge('B', 'E');
        graph.addEdge('C', 'D');

        graph.depthFirstTraversal();
    }
} 