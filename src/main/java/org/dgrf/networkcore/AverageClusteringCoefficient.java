/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dgrf.networkcore;

import org.jgrapht.Graph;
import org.jgrapht.alg.scoring.ClusteringCoefficient;
import org.jgrapht.graph.DefaultEdge;

/**
 *
 * @author bhaduri
 */
public class AverageClusteringCoefficient {
    private final String adjListFile;
    private final Double averageClustertingCoeffient;
    public AverageClusteringCoefficient(String adjListFile) {
        this.adjListFile = adjListFile;
        BuildGraph bg = new BuildGraph(adjListFile);
        Graph<String, DefaultEdge> graph = bg.getGraph();
        ClusteringCoefficient clusteringCoefficient = new ClusteringCoefficient(graph);
        averageClustertingCoeffient = clusteringCoefficient.getAverageClusteringCoefficient();
    }

    public Double getAverageClustertingCoeffient() {
        return averageClustertingCoeffient;
    }
    
    
    
}
