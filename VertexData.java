/**********************************************************************
 *
 * The class VertexData implements the Comparable class and holds vertex
 * information for Dijkstra algorithm
 *
 * @author Litha Thampan
 *************************************************************************/

class VertexData implements Comparable<VertexData>{
        
    private int vertexIndex, 
                parentIndex,    // Index of parent vertex in BFS tree
                heapIndex;
    private double distance;    // Distance to source vertex in BFS tree
    
    // Constructor creates a vertex with parent initialized to -1 (no parent),
    //  distance initialized to infinity, and color initialized to white,
    //  adjacentVertexIterator initialized to 
    public VertexData(Graph aGraph, int vertexIndex) {
      this.vertexIndex = vertexIndex;
      parentIndex = -1;    // no parent
      distance = Double.POSITIVE_INFINITY;
    }
    
        // get and set methods
    public int getVertexIndex()  { return vertexIndex; }
    public int  getParentIndex() { return parentIndex; }
    public int  getHeapIndex() { return heapIndex; }
    public double getDistance()  { return distance; }
    
    public void setParent(int parentIndex)   { this.parentIndex = parentIndex; }
    public void setHeapIndex(int heapIndex)   { this.heapIndex = heapIndex; }
    public void setDistance(double distance) { this.distance = distance; }

        // Comparable implementation for comparing distance of Vertex
    public int compareTo(VertexData compareItem) {
      if (this.distance - compareItem.distance > 0) 
          return 1;
      else if (this.distance - compareItem.distance < 0)
          return -1;
      else 
          return 0;
    }
  } // inner class VertexData