package graph;

import java.util.List;


/**
 * interface for an  undirected weighted graph
 * @author Prakalpa-Rathore
 *
 */
public interface Graph 
{
    
    /**
     * method to check whether the graph is connected or not
     * @return boolean value
     */
    public boolean isConnected();
    
    
    /**
     * method to find all the vertices which are reachable from the source vertex
     * @param source vertex
     * @return list of reachable vertices
     */
    public List<Integer> reachable(int source);
    
    
    /**
     * method to create the minimum spanning tree 
     * @return list of edges in minimum spanning tree
     */
    public List<Edge> minimumSpanningTree();
    
    
    /**
     * method to find the distance of the shortest path from source to destination
     * @param source
     * @param destination
     * @return distance of shortest path
     */
    public int shortestPath(int source, int destination);
}
