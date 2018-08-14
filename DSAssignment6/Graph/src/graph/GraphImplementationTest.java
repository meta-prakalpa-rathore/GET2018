package graph;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GraphImplementationTest {

    /**
     * test case for isConnected when graph is connected
     */
    @Test
    public void isConnectedTest1() {
        
        GraphImplementation graph = new GraphImplementation(4);
        graph.addEdge(0, 1, 2);
        graph.addEdge(1, 2, 6);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 0, 4);
        
        assertTrue(graph.isConnected());
    }

    
    /**
     * test case for isConnected when graph is not connected
     */
    @Test
    public void isConnectedTest2() {
        
        GraphImplementation graph = new GraphImplementation(6);
        graph.addEdge(0, 1, 2);
        graph.addEdge(1, 2, 6);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 0, 4);
        graph.addEdge(4, 5, 4);
        
        assertFalse(graph.isConnected());
    }
    
    
    /**
     * test case for reachable
     */
    @Test
    public void reachableTest() {
        
        GraphImplementation graph = new GraphImplementation(6);
        graph.addEdge(0, 1, 2);
        graph.addEdge(1, 2, 6);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 0, 4);
        graph.addEdge(4, 5, 4);
        
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(4);
        
        assertEquals(expected, graph.reachable(5));
        
        
        graph.addEdge(3, 4, 1);
        
        List<Integer> newExpected = new ArrayList<Integer>();
        newExpected.add(0);
        newExpected.add(1);
        newExpected.add(2);
        newExpected.add(3);
        newExpected.add(4);
        
        assertEquals(newExpected, graph.reachable(5));
             
    }
    
    
    /**
     * test case for shortestPath
     */
    @Test
    public void shortestPathTest() {
        
        GraphImplementation graph = new GraphImplementation(4);
        graph.addEdge(0, 1, 2);
        graph.addEdge(1, 2, 6);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 0, 4);
        
        assertEquals(8, graph.shortestPath(0, 2));
        
    }
    
    
    /**
     * test case for minimumSpanningTree
     */
    @Test
    public void minimumSpanningTreeTest() {
        
        GraphImplementation graph = new GraphImplementation(4);
        graph.addEdge(0, 1, 2);
        graph.addEdge(1, 2, 6);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 0, 4);
        graph.addEdge(0, 2, 2);
        
        List<Edge> expected = new ArrayList<Edge>();
        expected.add(new Edge(0, 1, 2));
        expected.add(new Edge(0, 2, 2));
        expected.add(new Edge(0, 3, 4));
        
        List<Edge> mst = graph.minimumSpanningTree();
        
        for(int i = 0; i < mst.size(); i++)
        {
            assertEquals(expected.get(i).getSource(), mst.get(i).getSource());
            assertEquals(expected.get(i).getDestination(), mst.get(i).getDestination());
            assertEquals(expected.get(i).getWeight(), mst.get(i).getWeight());
        }
    }
}
