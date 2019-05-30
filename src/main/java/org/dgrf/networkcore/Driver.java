/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dgrf.networkcore;

/**
 *
 * @author dgrfi
 */
public class Driver {

    public static void main(String args[]) {
        String adjListFile = "/home/dgrfi/MEGA/DGRFFractal/testdata/network/Upload/Network.csv";
        BuildGraph bg = new BuildGraph(adjListFile);
        Double acc = new AverageShortestPath(adjListFile).getAverageShortestPath();
        //Double lcc = clusteringCoefficient.getVertexScore("5");
        System.out.println(acc);
//        DefaultEdge de = graph.getEdge("7", "39");
//        Double w = graph.getEdgeWeight(de);
//        System.out.println(w);

    }

}
