/*******************************************************************************************
*
* The class Dijkstra contains a method to execute the Dijkstra algorithm to
*  find the shortest paths from a given source vertex in a weighted directed graph.
*
* @author Litha Thampan
*
**********************************************************************************************/
import java.util.*;  // for Iterator interface

class Dijkstra {
  
  // An inner class for the data needed for depth-first search
  
  
  private Graph theGraph;
  private int sourceIndex;
  private VertexData[] vertexData;
  private ArrayMinHeap vertexMinHeap;
   // Constructor sets graph and index of source vertex
  public Dijkstra (Graph theGraph, int sourceIndex) {
    this.theGraph = theGraph;
    this.sourceIndex = sourceIndex;
    vertexData = new VertexData[theGraph.getNumberOfVertices()];
    vertexMinHeap = new ArrayMinHeap(theGraph.getNumberOfVertices());
    for (int i = 0; i < theGraph.getNumberOfVertices(); i++)
      {
        vertexData[i] = new VertexData(theGraph, i);
        if (i == sourceIndex)
            vertexData[i].setDistance(0);
        vertexMinHeap.insert(vertexData[i]);
      }
      
  }
  
  // Constructor sets graph and default source index of 0
  public Dijkstra (Graph theGraph) {
    this(theGraph, 0);
  }
  // Relax Edge updates distance and parent for shorter overall distance
  private void relaxEdge(Edge theEdge) {
    int startVertexIndex = theEdge.getStartVertex();
    int endVertexIndex = theEdge.getEndVertex();
    double possibleShorterDistance = vertexData[startVertexIndex].getDistance() + theEdge.getWeight();
    
    if (possibleShorterDistance < vertexData[endVertexIndex].getDistance()) {
      vertexData[endVertexIndex].setDistance(possibleShorterDistance);
      vertexData[endVertexIndex].setParent(startVertexIndex);
      vertexMinHeap.fixHeap(vertexData[endVertexIndex].getHeapIndex());
    }
  }
  public void doDijkstra() {
    
    // Initialize data for source vertex
    vertexData[sourceIndex].setParent(-1);  // root - no parent
    vertexData[sourceIndex].setDistance(0);
    
    while (!vertexMinHeap.isEmpty()){
      VertexData currentVertex = vertexMinHeap.extractMin();
      Iterator<Edge> edgeIterator = theGraph.getVertexEdgeIterator(currentVertex.getVertexIndex());
      while (edgeIterator.hasNext()){
        Edge currentEdge = edgeIterator.next();
        relaxEdge(currentEdge);
      } 

    }
  }
  
  // Returns a string for the path to given index to source as a list of vertices in parentheses
  // If there is no path from source, returns a message indicating that fact
  public String getPathFromSource(int vertexIndex) {
    if(vertexData[vertexIndex].getDistance() == Double.POSITIVE_INFINITY)
      return ("No path from source vertex to vertex " + vertexIndex + ".");
    else
      return ("Shortest path to vertex " + vertexIndex + " is (" + getPathFromSourceHelper(vertexIndex) + ")\n  Path weight = "
              + vertexData[vertexIndex].getDistance() );
  }
  
  // Returns path vertices to current vertex
  public String getPathFromSourceHelper(int vertexIndex) {
    if (vertexData[vertexIndex].getParentIndex() == -1) 
      // at source vertex - the path has only this vertex
      return Integer.toString(vertexIndex);
    else
      // append vertex to path from source to parent
      return getPathFromSourceHelper(vertexData[vertexIndex].getParentIndex()) + " " + Integer.toString(vertexIndex);
  }
} 
