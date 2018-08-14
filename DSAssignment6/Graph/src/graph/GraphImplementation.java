package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


/**
 * class to implement the Graph interface to represent an undirected weighted graph
 * @author Prakalpa-Rathore
 *
 */
public class GraphImplementation implements Graph
{
    int noOfVertices;
    List<Edge>[] edgeList; 
    
    
    /**
     * constructor
     * @param noOfVertices
     */
    public GraphImplementation(int noOfVertices)
    {
        this.noOfVertices = noOfVertices;
        edgeList = new LinkedList[noOfVertices];
        
        for(int i = 0; i < noOfVertices; i++)
            edgeList[i] = new LinkedList<Edge>();
    }
    
    
    /**
     * method to add an edge into the graph
     * @param source
     * @param destination
     * @param weight
     */
    public void addEdge(int source, int destination, int weight) 
    {
        edgeList[source].add(new Edge(source, destination, weight));
        edgeList[destination].add(new Edge(destination, source, weight));
    }

    
    /**
     * method to check whether the graph is connected or not using DFS traversal
     * @return boolean value
     */
    @Override
    public boolean isConnected() {
        
        Boolean[] nodeTraversed = new Boolean[noOfVertices];
        boolean isConnected = true;
        
        for(int i = 0; i < noOfVertices; i++)
            nodeTraversed[i] = false;
        
        DFSTraversal(0, nodeTraversed);
        
        for(int i = 0; i < noOfVertices; i++)
        {
            if(nodeTraversed[i] == false)
            {
                isConnected = false;
                break;
            }
                
        }
        
        return isConnected;
    }

    
    /**
     * method to find all the vertices which are reachable from the source vertex
     * @param source vertex
     * @return list of reachable vertices
     */
    @Override
    public List<Integer> reachable(int source)
    {
        List<Integer> reachableNodes = new ArrayList<>();
        Boolean[] nodeTraversed = new Boolean[noOfVertices];
        
        for(int i = 0; i < noOfVertices; i++)
            nodeTraversed[i] = false;
        
        DFSTraversal(source, nodeTraversed);
        
        for(int i = 0; i < noOfVertices; i++)
        {
            if(i != source && nodeTraversed[i] == true)
            {
                reachableNodes.add(i);
            }
        }
        
        return reachableNodes;
    }

    
    /**
     * method to create the minimum spanning tree using greedy approach
     * @return list of edges in minimum spanning tree
     */
    @Override
    public List<Edge> minimumSpanningTree()
    {
        List<Edge> minSpanningtree = new ArrayList<>();
        int parent[] = new int[noOfVertices];
        int key[] = new int[noOfVertices];
        Boolean mstSet[] = new Boolean[noOfVertices];
        
        for (int i = 0; i < noOfVertices; i++) 
        {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
        
        key[0] = 0; 
        parent[0] = -1; 
        
        for (int count = 0; count < noOfVertices - 1; count++) 
        {
            int minKey = minKey(key, mstSet);
            
            mstSet[minKey] = true;
            List<Edge> edges = edgeList[minKey];
            
            for (Edge edge : edges) 
            {
                int v = edge.getDestination();
                
                if (!mstSet[v] && edge.getWeight() < key[v]) 
                {   
                    parent[v] = minKey;
                    key[v] = edge.getWeight();                      
                }
            }
            
        }
       
        for (int i = 1; i < noOfVertices; i++) 
        {
            List<Edge> edges = edgeList[i];
            
            for (Edge edgeConnected : edges) 
            {
                if (edgeConnected.getDestination() == parent[i]) 
                {
                    Edge edge = new Edge(parent[i], i, edgeConnected.getWeight());
                    minSpanningtree.add(edge);
                }
            }
        }
        
        return minSpanningtree;
    }

    
    /**
     * method to find the distance of the shortest path from source to destination
     * @param source
     * @param destination
     * @return distance of shortest path
     */
    @Override
    public int shortestPath(int source, int destination) 
    {
        List<Edge> adjacentEdges = new LinkedList<>();
        int distance[] = new int[noOfVertices]; 
        
        Boolean processed[] = new Boolean[noOfVertices];
        
        for (int i = 0; i < noOfVertices; i++) 
        {
            distance[i] = Integer.MAX_VALUE;
            processed[i] = false;
        }
        
        distance[source] = 0;
        
        for (int count = 0; count < noOfVertices - 1; count++) 
        {
            int shortestDistanceNode = minKey(distance, processed);
        
            processed[shortestDistanceNode] = true;
            adjacentEdges = edgeList[shortestDistanceNode];
            
            for (Edge listEdges : adjacentEdges) 
            {
                int v = listEdges.getDestination();
                
                if (!processed[v] && distance[shortestDistanceNode] + listEdges.getWeight() < distance[v])
                    distance[v] = distance[shortestDistanceNode] + listEdges.getWeight();
                                    
            }            
        }
        
        return distance[destination];
    }
    
    
    /**
     * helper method to find the vertex with the minimum key
     * @param key
     * @param processed
     * @return vertex with the minimum key
     */
    private int minKey(int key[], Boolean processed[]) 
    {
        int min = Integer.MAX_VALUE, minIndex = -1;
        
        for (int vertex = 0; vertex < noOfVertices; vertex++)
        {
        	if (processed[vertex] == false && key[vertex] < min) 
            {
                min = key[vertex];
                minIndex = vertex;
            }
        }
            
        return minIndex;
    }
    
    
    /**
     * helper method for Depth First Traversal
     * @param graphNode
     * @param nodeTraversed
     */
    private void DFSTraversal(int graphNode, Boolean[] nodeTraversed) 
    {        
        nodeTraversed[graphNode] = true;
        
        Iterator<Edge> iterator = edgeList[graphNode].iterator();
        
        while(iterator.hasNext())
        {
            int node = iterator.next().getDestination();
            
            if(!nodeTraversed[node])
            {
                DFSTraversal(node, nodeTraversed);
            }
        }       
    }

}
