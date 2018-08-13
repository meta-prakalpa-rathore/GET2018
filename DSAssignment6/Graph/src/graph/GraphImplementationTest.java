package graph;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class GraphImplementationTest {

    @Test
    public void test() {
        
        GraphImplementation graph = new GraphImplementation(4);
        graph.addEdge(0, 1, 2);
        graph.addEdge(1, 2, 6);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 0, 4);
        
        assertTrue(graph.isConnected());
    }

    
    @Test
    public void test1() {
        
        GraphImplementation graph = new GraphImplementation(6);
        graph.addEdge(0, 1, 2);
        graph.addEdge(1, 2, 6);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 0, 4);
        graph.addEdge(4, 5, 4);
        
        assertFalse(graph.isConnected());
    }
    
    
    @Test
    public void test2() {
        
        GraphImplementation graph = new GraphImplementation(6);
        graph.addEdge(0, 1, 2);
        graph.addEdge(1, 2, 6);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 0, 4);
        graph.addEdge(4, 5, 4);
        
        List<Integer> reachable = graph.reachable(5);
        
        for(Integer i: reachable)
            System.out.println(i);
    }
    
    
    @Test
    public void test3() {
        
        GraphImplementation graph = new GraphImplementation(4);
        graph.addEdge(0, 1, 2);
        graph.addEdge(1, 2, 6);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 0, 4);
        
        assertEquals(8, graph.shortestPath(0, 2));
        
    }
    
    @Test
    public void test4() {
        
        GraphImplementation graph = new GraphImplementation(4);
        graph.addEdge(0, 1, 2);
        graph.addEdge(1, 2, 6);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 0, 4);
        graph.addEdge(0, 2, 2);
        
        List<Edge> g = graph.minimumSpanningTree();
        for(Edge e: g)
        	System.out.println(e.getSource() + " " + e.getDestination() + " " + e.getWeight());
    }
}
