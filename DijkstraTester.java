/***********************************************************************************************
*
*  class DijkstraTester contains a main method that reads in a graph, performs breadth-first search
*  from a given source vertex, and prints out the shortest path to every vertex reachable
*  from the source.
*
*  @author Litha Thampan
*
************************************************************************************************/
import java.io.*; // for FileNotFoundException

class DijkstraTester {

 public static void main (String[] args) {
 
    // Read in a file and build graph
    String inputFileName = args[0];
    Graph myGraph = null;
    
    try {
      myGraph = GraphMaker.makeGraph(inputFileName);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File " + inputFileName + " not found.");
      System.exit(1);
    }


    // Execute Dijkstra Algorithm
    int sourceVertex = 0;
    if (args.length > 1)
      sourceVertex = Integer.parseInt(args[1]);
      
    Dijkstra dijkstraAlgorithm = new Dijkstra(myGraph,sourceVertex);
    
    dijkstraAlgorithm.doDijkstra();
    
   
    System.out.println("Shortest paths to the vertices from vertex " + sourceVertex + ": \n");
    for(int vertex = 0; vertex < myGraph.getNumberOfVertices(); vertex++) {
      System.out.print("Vertex " + vertex + ": ");
      System.out.println(dijkstraAlgorithm.getPathFromSource(vertex));
      }
  }
}    
