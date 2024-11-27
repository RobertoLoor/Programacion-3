package es.ua.dlsi.prog3.p6.algorithms;

import java.util.*;
import es.ua.dlsi.prog3.p6.graph.Edge;
import es.ua.dlsi.prog3.p6.graph.Graph;
import es.ua.dlsi.prog3.p6.graph.Node;
import es.ua.dlsi.prog3.p6.graph.NodeNotFoundException;

public class DijkstraShortestPath<NodeLabelType, EdgeLabelType extends Comparable<EdgeLabelType>> {
    private final Graph<NodeLabelType, EdgeLabelType> graph;
    private final ICostOperators<EdgeLabelType> costOperators;
    private Map<Node<NodeLabelType>, EdgeLabelType> dist;
    private Set<Node<NodeLabelType>> settled;
    private PriorityQueue<Cost> priorityQueue;

    private class Cost implements Comparator<Cost> {
        Node<NodeLabelType> node;
        EdgeLabelType cost;

        Cost() {}
        Cost(Node<NodeLabelType> node, EdgeLabelType cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compare(Cost a, Cost b) {
            return a.cost.compareTo(b.cost);
        }
    }

    public DijkstraShortestPath(Graph<NodeLabelType, EdgeLabelType> graph, ICostOperators<EdgeLabelType> costOperators) {
        this.graph = graph;
        this.costOperators = costOperators;
    }

    public void compute(Node<NodeLabelType> fromNode) throws NodeNotFoundException {
        if (!graph.contains(fromNode)) {
            throw new NodeNotFoundException(fromNode);
        }
        dist = new HashMap<>();
        settled = new HashSet<>();
        priorityQueue = new PriorityQueue<>(new Cost());

        for (Node<NodeLabelType> node : graph.getNodes()) {
            dist.put(node, costOperators.maximumValue());
        }

        priorityQueue.add(new Cost(fromNode, costOperators.zero()));
        dist.put(fromNode, costOperators.zero());

        while (settled.size() != graph.getSize()) {
            if (priorityQueue.isEmpty()) return;

            Node<NodeLabelType> currentNode = priorityQueue.remove().node;

            if (!settled.contains(currentNode)) {
                settled.add(currentNode);
                processNeighbours(currentNode);
            }
        }
    }

    private void processNeighbours(Node<NodeLabelType> source) {
        try {
            for (Edge<NodeLabelType, EdgeLabelType> edge : graph.getOutEdges(source)) {
                Node<NodeLabelType> target = edge.getTarget();
                if (!settled.contains(target)) {
                    EdgeLabelType edgeDistance = edge.getLabel();
                    EdgeLabelType newDistance = costOperators.add(dist.get(source), edgeDistance);

                    if (newDistance.compareTo(dist.get(target)) < 0) {
                        dist.put(target, newDistance);
                        priorityQueue.add(new Cost(target, newDistance));
                    }
                }
            }
        } catch (NodeNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Map<Node<NodeLabelType>, EdgeLabelType> getComputedDistances() throws GraphAlgorithmException {
        if (dist == null) {
            throw new GraphAlgorithmException("Compute must be called first.");
        }
        return new HashMap<>(dist);
    }
}
