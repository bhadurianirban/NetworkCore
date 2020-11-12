/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.patronus.networkcore;

import java.util.HashSet;
import java.util.Set;
import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.JohnsonShortestPaths;
import org.jgrapht.graph.DefaultEdge;

/**
 *
 * @author dgrfi
 */
public class AverageShortestPath {
    private final String adjListFile;
    private  Double averageShortestPath;
    public AverageShortestPath(String adjListFile) {
        this.adjListFile = adjListFile;
        BuildGraph bg = new BuildGraph(adjListFile);
        Graph<String, DefaultEdge> graph = bg.getGraph();
        
        calculate(graph);
    }
    private void calculate (Graph<String, DefaultEdge> graph) {
        JohnsonShortestPaths<String, DefaultEdge> shortestPaths = new JohnsonShortestPaths(graph);
       //int totalShortestPathLength = 0;
        //int longestShortestPathLength = 0;
        //GraphPath<String, DefaultEdge> longestShortestPath = null;
        int totalPathCount = 0;
        Double allShortestPathSum = 0.0;
        Set<String> sourceVertexSet = new HashSet<>(graph.vertexSet());
        Set<String> sinkVertexSet = new HashSet<>(graph.vertexSet());
        for (String sourceVertex : sourceVertexSet) {
            for (String sinkVertex: sinkVertexSet) {
                if (!sourceVertex.equals(sinkVertex)) {
                    
                    allShortestPathSum = allShortestPathSum+shortestPaths.getPathWeight(sourceVertex, sinkVertex);
                    
                    //System.out.println(allShortestPathSum);
                    totalPathCount++;
                }
            }
            sinkVertexSet.remove(sourceVertex);
        }
        
        
        averageShortestPath = allShortestPathSum/totalPathCount;
    }

    public Double getAverageShortestPath() {
        return averageShortestPath;
    }
    
}
