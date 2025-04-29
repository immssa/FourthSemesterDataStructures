package Lr7;

import java.util.LinkedList;
import java.util.Queue;

public class DirectedGraph {
    private final int maxVertex;
    private Vertex[] vertexList;
    private int[][] matrix;
    private int vertexNumber;

    public DirectedGraph(int maxVertex) {
        this.maxVertex = maxVertex;
        this.vertexList = new Vertex[maxVertex];
        this.matrix = new int[maxVertex][maxVertex];
        this.vertexNumber = 0;
    }

    public void addVertex(char label) {
        vertexList[vertexNumber++] = new Vertex(label);
    }

    public void addEdge(char startLabel, char endLabel) {
        int u = indexOf(startLabel);
        int v = indexOf(endLabel);
        if (u < 0 || v < 0) {
            throw new IllegalArgumentException("Вершина с такой меткой не найдена: "
                    + startLabel + " или " + endLabel);
        }
        matrix[u][v] = 1;
    }

    private int indexOf(char label) {
        for (int i = 0; i < vertexNumber; i++) {
            if (vertexList[i].getLabel() == label) {
                return i;
            }
        }
        return -1;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].getLabel());
    }

    public void topologicSearch() {
        int[] inDegree = new int[vertexNumber];
        for (int i = 0; i < vertexNumber; i++) {
            for (int j = 0; j < vertexNumber; j++) {
                if (matrix[i][j] > 0) {
                    inDegree[j]++;
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < vertexNumber; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        char[] sorted = new char[vertexNumber];
        int idx = 0;
        while (!queue.isEmpty()) {
            int v = queue.remove();
            sorted[idx++] = vertexList[v].getLabel();

            for (int j = 0; j < vertexNumber; j++) {
                if (matrix[v][j] > 0) {
                    if (--inDegree[j] == 0) {
                        queue.add(j);
                    }
                }
            }
        }

        if (idx < vertexNumber) {
            System.out.println("Ошибка: граф содержит цикл");
            return;
        }

        for (char c : sorted) {
            System.out.print(c);
        }
        System.out.println();
    }
}