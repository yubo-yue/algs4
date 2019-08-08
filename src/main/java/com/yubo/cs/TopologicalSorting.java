package com.yubo.cs;

import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSorting {

    public static class Graph {
        private final int verticesCount;
        private LinkedList<Integer> adjacentVetices[];

        public Graph(int verticesCount) {
            this.verticesCount = verticesCount;
            adjacentVetices = new LinkedList[verticesCount];

            for (int i = 0; i < verticesCount; i++) {
                adjacentVetices[i] = new LinkedList<>();
            }
        }

        public void addEdge(int from, int to) {
            adjacentVetices[from].add(to);
        }

        public void topologicalSort() {
            final Stack<Integer> stack = new Stack<>();

            final boolean[] visited = new boolean[verticesCount];
            for (int i = 0; i < verticesCount; i++) {
                visited[i] = false;
            }

            for (int i = 0; i < verticesCount; i++) {
                if (!visited[i]) {
                    visit(i, visited, stack);
                }
            }

            while (!stack.empty()) {
                System.out.print(stack.pop() + ", ");
            }
        }

        private void visit(int i, boolean[] visited, Stack<Integer> stack) {
            visited[i] = true;

            for (Integer next : adjacentVetices[i]) {
                if (!visited[next]) {
                    visit(next, visited, stack);
                }
            }

            stack.push(i);
        }

    }

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological " +
                "sort of the given graph");
        g.topologicalSort();
        System.out.println();
    }
}
