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
 * @author dgrfi
 */
public class Driver {

    public static void main(String args[]) {
        String adjListFile = "/home/bhaduri/MEGA/DGRFFractal/testdata/network/Upload/Network.csv";
        BuildGraph bg = new BuildGraph(adjListFile);
        Double acc = new AverageClusteringCoefficient(adjListFile).getAverageClustertingCoeffient();
        //Double lcc = clusteringCoefficient.getVertexScore("5");
        System.out.println(acc);
//        DefaultEdge de = graph.getEdge("7", "39");
//        Double w = graph.getEdgeWeight(de);
//        System.out.println(w);

    }

}
