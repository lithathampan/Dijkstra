/**
    An interface for the Min Heap of Vertex Data
    @author Litha Thampan
    @version 1.0
*/

public interface MinHeapInterface<T>
{
  /** Adds a new entry to the heap.
      @param newEntry  an object to be added to the
      heap */
  public void insert(VertexData newEntry);
  
  /** Removes and returns this heap's top node.
      @return either the object at the top of the
      heap or, if the heap is empty before the
      operation, return null */
  public VertexData extractMin();
  
  /** Retrieves this stack's top entry.
      @return either the object at the top
      of the stack or null if the stack is
      empty */
  public VertexData getMin();
  
  /** Detects whether this heap is empty.
      @return true iff the heap is empty */
  public boolean isEmpty();
  
  /** Removes all entries from this stack */
  public void clear();
  
} // end StackInterface
