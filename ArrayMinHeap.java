/**********************************************************************
 *
 * The class KVPairArrayMinHeap implements the MinHeap ADT using an array to hold the
 * minHeap items.
 *
 * It uses the circular implementation so that the time complexities of both
 * push and pop are O(1)
 *
 * @author Litha Thampan
 *************************************************************************/

class ArrayMinHeap implements MinHeapInterface<VertexData>
{

  private VertexData[] minHeapItems;
  private int minHeapSize;
  
  public ArrayMinHeap(int capacity)
  {
    @SuppressWarnings("unchecked")
    VertexData[] temp = new VertexData[capacity];
    minHeapItems = temp;
    
    minHeapSize = 0;
  }
  
  // Adds item to heap
  public void insert(VertexData item)
  {
    minHeapItems[minHeapSize] = item;
    minHeapItems[minHeapSize].setHeapIndex(minHeapSize);
    siftUp(minHeapSize);
    minHeapSize++;
  }
  
  // Removes minimum item from heap
  public VertexData extractMin()
  {
      
    VertexData returnValue = minHeapItems[0];
    minHeapSize--;
    minHeapItems[0] = minHeapItems[minHeapSize];
    minHeapItems[0].setHeapIndex(0);
    siftDown(0);
    return returnValue;
  }

   // Fix heap for an updated element
  public void fixHeap(int n)
  {
    siftUp(n);
  }

  private void siftUp(int n)
   {
      // If n == 0 (n is root of tree), it can't be sifted up any further
      if (n > 0)
      {
         int parentIndex = (n-1)/2;
         
         if (minHeapItems[parentIndex].compareTo(minHeapItems[n]) > 0) {
           // Swap values at a[n] with its parent
           VertexData temp = minHeapItems[n];
           minHeapItems[n] = minHeapItems[parentIndex];
           minHeapItems[parentIndex] = temp;
           minHeapItems[n].setHeapIndex(n);
           minHeapItems[parentIndex].setHeapIndex(parentIndex);
           // Sift up from parent
           siftUp(parentIndex);
         } //inner if
      } // outer if
   } // siftUp 

     // Sifts the value at minHeapItems[n] down in the heap
   // pre-condition: The left and right subtrees of a[n] are heaps      
   private void siftDown(int n)
   {
      int leftChildIndex = 2*n + 1;
      int rightChildIndex = 2*n + 2;
      int minChildIndex = 0;           // Index of smaller child
      
      // If leftChildIndex >= heapsize, minHeapItems[n] is a leaf node
      //   There's no place to sift it.
      if (leftChildIndex < minHeapSize) {
        
        // Find smaller child
        if (leftChildIndex == minHeapSize-1)
          // only one child - so it's the "smallest"
          minChildIndex = leftChildIndex;
        else // two children - choose the smaller
          if (minHeapItems[leftChildIndex].compareTo(minHeapItems[rightChildIndex]) < 0)
            minChildIndex = leftChildIndex;
          else
            minChildIndex = rightChildIndex;
        
        // Swap a[n] with its smaller child if needed    
        if(minHeapItems[n].compareTo(minHeapItems[minChildIndex]) > 0)
        {
           VertexData temp = minHeapItems[minChildIndex];
           minHeapItems[minChildIndex] = minHeapItems[n];
           minHeapItems[n] = temp;
           
           minHeapItems[minChildIndex].setHeapIndex(minChildIndex);           
           minHeapItems[n].setHeapIndex(n);
           siftDown(minChildIndex);
        } // inner if
      } //outer if
   } // siftDown

  // Returns item at top node
  public VertexData getMin()
  {
    return minHeapItems[0];
  }
  
  // Returns true iff the minHeap is empty
  public boolean isEmpty()
  {
    return minHeapSize == 0;
  }
  
  // Removes all items from minHeap
  public void clear()
  {
    for (int i = 0; i < minHeapItems.length; i++)
      minHeapItems[i] = null;
    minHeapSize = 0;
  }
}
  
    