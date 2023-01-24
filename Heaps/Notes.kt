//Heaps Notes

/*

Definition of a Binary Heap:

    - Complete Binary Tree

    - Able to be constructed using just an array in memory(!!)
      This is a huge boon over the hassle of maintaining a binary tree
      in memory. In exchange, the binary heap gives up the tree's
      performance benefits and range of operations, and also must
      maintain the heap property

*/


/*

The concept of the heap is valid for more data types than just Ints
and can apply to all Comparable types, or any type for which a
Comparator is provided.

*/


/*

Definition of Heap Property(AKA Heap Invariant):

    - For maxheaps, parent nodes must always contain a value
      that is greater than or equal to the value in its children.
      The root node will always contain the highest value.

    - For minheaps, parent nodes must always contain a value
      that is less than or equal to its children. The root
      node will always contain the lowest value.
      
    - Another important property of binary heaps, that of being
      a complete binary tree, means that every level of the
      tree must be completely filled except for the last,
      which must be filled from left to right.
         
*/

/*

Heap Applications:

    - Calculating the min or max element of a collection
    - Heap Sort
    - Implementing a priority queue
    - Supporting graph algorithms with a priority queue

*/

/*

Traversing down an actual binary tree to get the left
and right child of a node O(log n) operation. In a random
access data structure like an array, that same operation
becomes O(1)!!! This is because the left and right child of any 
node at index i can be identified by the formulas 
2i + 1 and 2i + 2 respectively.

*/

/*

Removing from a Heap:

A basic remove operation will remove the root node from the heap.
This is a 4 step process:

    1) Swap the root with the last element of the heap
    2) Delete the root which is now at the last position
    3) Check if the heap satisfies the heap property
    4) Sift the new root down until heap property is satisfied


*/

