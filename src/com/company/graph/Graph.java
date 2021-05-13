package com.company.graph;

import java.util.*;

public class Graph {

    Map<Vertex, List<Vertex>> adjVertices;

    public void addVertex(int value) {
        adjVertices.putIfAbsent(new Vertex(value), new ArrayList<>());
    }

    public void removeVertex(int value) {
        Vertex v = new Vertex(value);
        adjVertices.values().stream().forEach(e -> e.remove(v));
        adjVertices.remove(new Vertex(value));
    }

    public void addEdge(int value1, int value2) {
        Vertex v1 = new Vertex(value1);
        Vertex v2 = new Vertex(value2);
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
    }

    public void removeEdge(int value1, int value2) {
        Vertex v1 = new Vertex(value1);
        Vertex v2 = new Vertex(value2);
        List<Vertex> eV1 = adjVertices.get(v1);
        List<Vertex> eV2 = adjVertices.get(v2);
        if (eV1 != null)
            eV1.remove(v2);
        if (eV2 != null)
            eV2.remove(v1);
    }

    public Set<Integer> depthFirstTraversal(Graph graph, Integer root) {
        Set<Integer> visited = new LinkedHashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Integer vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Vertex v : graph.adjVertices.get(vertex)) {
                    stack.push(v.value);
                }
            }
        }
        return visited;
    }
}
