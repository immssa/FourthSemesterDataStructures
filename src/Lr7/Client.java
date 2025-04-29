package Lr7;

public class Client {
    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph(6);

        // создаём вершины A–F
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');

        // добавляем ориентированные рёбра по именам
        graph.addEdge('A','D');
        graph.addEdge('A','E');
        graph.addEdge('B','E');
        graph.addEdge('C','F');
        graph.addEdge('D','B');
        graph.addEdge('E','C');
        graph.addEdge('E','F');

        // выполняем и выводим топологическую сортировку
        System.out.println("Результат топологической сортировки:");
        graph.topologicSearch();

        // добавляем цикл
        graph.addEdge('F','E');

        // выполняем и выводим топологическую сортировку
        System.out.println("Результат топологической сортировки:");
        graph.topologicSearch();
    }
}