package es.ua.dlsi.prog3.p6.algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import es.ua.dlsi.prog3.p6.graph.Graph;
import es.ua.dlsi.prog3.p6.graph.Node;
import es.ua.dlsi.prog3.p6.graph.NodeNotFoundException;

/**
 * Facade class providing easy access to graph algorithms
 */
public class Algorithms {
    /**
     * Returns a Depth First Search traversal of the graph starting with the provided node
     * @param graph Graph to work on
     * @param fromNode Starting node
     * @param <NodeLabelType> Type of node labels
     * @param <EdgeLabelType> Type of edge labels
     * @return List of visited nodes
     */
    public static <NodeLabelType, EdgeLabelType> List<Node<NodeLabelType>> dfs(
            Graph<NodeLabelType, EdgeLabelType> graph,
            Node<NodeLabelType> fromNode) {
        DFS<NodeLabelType, EdgeLabelType> dfs = new DFS<>(graph);
        dfs.run(fromNode);
        return dfs.getVisitSequence();
    }

    /**
     * Computes the cost to traverse from the source node to the target node
     * @param graph Graph to work on
     * @param fromNode Source node
     * @param toNode Target node
     * @param costOperators Implementation of ICostOperators for the edge label type
     * @param <NodeLabelType> Type of node labels
     * @param <EdgeLabelType> Type of edge labels
     * @return Cost of the shortest path
     * @throws NodeNotFoundException If any of the nodes do not belong to the graph
     * @throws GraphAlgorithmException If the graph has no edges or the path cannot be found
     */
    public static <NodeLabelType, EdgeLabelType extends Comparable<EdgeLabelType>> EdgeLabelType shortestPathCost(
            Graph<NodeLabelType, EdgeLabelType> graph,
            Node<NodeLabelType> fromNode,
            Node<NodeLabelType> toNode,
            ICostOperators<EdgeLabelType> costOperators)
            throws NodeNotFoundException, GraphAlgorithmException {
        DijkstraShortestPath<NodeLabelType, EdgeLabelType> dijkstra = new DijkstraShortestPath<>(graph, costOperators);
        dijkstra.compute(fromNode);

        if (!graph.contains(toNode)) {
            throw new NodeNotFoundException(toNode);
        }

        EdgeLabelType distance = dijkstra.getComputedDistances().get(toNode);
        if (distance == null) {
            throw new GraphAlgorithmException("Cannot find a distance to the target node " + toNode);
        }

        return distance;
    }

    /**
     * Exports the graph to a file using the Graphviz Dot format
     * @param file Output file
     * @param graph Graph to be exported
     * @param <NodeLabelType> Type of node labels
     * @param <EdgeLabelType> Type of edge labels
     * @throws FileNotFoundException If the file to be written cannot be created
     */
    public static <NodeLabelType, EdgeLabelType> void exportDot(
            File file,
            Graph<NodeLabelType, EdgeLabelType> graph) throws FileNotFoundException {
        DotExporter<NodeLabelType, EdgeLabelType> exporter = new DotExporter<>();
        exporter.export(file, graph);
    }
}
