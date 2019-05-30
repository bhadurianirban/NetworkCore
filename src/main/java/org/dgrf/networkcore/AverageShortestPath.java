/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dgrf.networkcore;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm.SingleSourcePaths;
import org.jgrapht.alg.shortestpath.FloydWarshallShortestPaths;
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
        FloydWarshallShortestPaths<String, DefaultEdge> shortestPaths = new FloydWarshallShortestPaths(graph);
       //int totalShortestPathLength = 0;
        //int longestShortestPathLength = 0;
        //GraphPath<String, DefaultEdge> longestShortestPath = null;
        int totalPathCount = 0;
        Double allShortestPathSum = 0.0;
        for (String sourceVertex : graph.vertexSet()) {
            for (String sinkVertex:graph.vertexSet()) {
                if (sourceVertex.equals(sinkVertex)) {
                    System.out.println("Same");
                } else {
                    System.out.println("cal"+sourceVertex+" "+sinkVertex);
                    GraphPath<String, DefaultEdge> shortestPath = shortestPaths.getPath(sourceVertex, sinkVertex);
                    allShortestPathSum = shortestPath.getWeight();
                    System.out.println("caldone"+sourceVertex+" "+sinkVertex);
                    totalPathCount++;
                }
            }
            
        }
         averageShortestPath =  allShortestPathSum / totalPathCount;
        
    }

    public Double getAverageShortestPath() {
        return averageShortestPath;
    }
    
}
