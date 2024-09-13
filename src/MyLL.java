
public class MyLL<E> {
    /*
        Note: All Object return types should be modified to utilize Generics instead
     */

    private Node head;

    /**
     * Adds item to end of LL
     */
    public class Node {
        private E data;
        private Node pointer;
        public Node (E data) {
            this.data = data;
            this.pointer = null;
        }

        public Node getPointer(){
            return pointer;
        }

    }

    public void add(E item) {
        if(head == null) {
            head = new Node(item);
            return;
        }
        Node currentNode = head;

        while(currentNode.getPointer() != null) {
            currentNode = currentNode.getPointer();
        }
        currentNode.pointer = new Node(item);

    }

    /**
     * Adds item at specified index value. If item already exists, item at current index is shuffled one index to the right.
     * Should ensure a proper index is specified. True means addition was successful, false if not.
     */
    public boolean add(int index, E item) {
        // not done
        // when index = currentIndex
        // set previous pointer to new node
        // set new node pointer to previous node's og pointer
        int currentIndex = 0;
        Node currentNode = head;
        Node prevNode = null;

        if(index > this.size()) {
            return false;
        } else if (index == this.size()){ // end of list
            this.add(item);
        }

        while(currentIndex < index) {
            prevNode = currentNode;
            currentNode = currentNode.getPointer();
            currentIndex++;

        }
        Node newNode = new Node(item);
        //for beginning of list, set head = new node
        if(index == 0) { // beginning of list doesn't have a previous node
            head = newNode;
        } else {
            // if not beginning of list, need to set prev node pointer to new node, new node pointer to next node
            prevNode.pointer = newNode;
            newNode.pointer = currentNode;
        }
        return true;
    }

    /**
     * Add to start of LL. If existing element is there, ensure it, and all following nodes, are moved down one index.
     */
    public void addFirst(Object item){


    }

    /**
     * Add to end of LL. If existing element is there, it should go after last item..
     */
    public void addLast(Object item) {

    }

    /**
     * Should remove all Nodes within the LL.
     * */
    public void clear() {

    }

    /**
     * Searches the LL for a matching object (in context of object's value, not memory)
     * */
    public boolean contains(Object item){
        return false;
    }

    /**
     * Returns object at specified index. Should return null if invalid range is selected.
     * */
    public Object get(int index){
        return false;
    }

    /**
     * Returns object when found. Should be based on value of object. Null if object can't be found.
     * */
    public Object get(Object item){
        return false;
    }

    /**
     * Returns object at first index. Should return null if LL is empty.
     * */
    public Object getFirst(){
        return false;
    }

    /**
     * Spoilers: Gets you the last item in the LL. Null if LL is empty.
     * */
    public Object getLast(){
        return false;
    }

    /**
     * Returns index value of where item is. If item is not found, return -1. Should be based on value of object not memory..
     * */
    public int indexOf(Object item){
        return -1;
    }

    /**
     * Returns LAST index value of where item is. If item is not found, return -1. Should be based on value of object not memory..
     * */
    public int lastIndexOf(Object item){
        return -1;
    }

    /**
     * Removes and returns the node at index 0. Return null if LL is empty.
     * */
    public Object poll(){
        return null;
    }

    /**
     * Removes and returns the last node. Return null if LL is empty.
     * */
    Object pollLast() {
        return null;
    }

    /**
     * Removes and returns the object at index. Removal behavior should mimic that of an ArrayList.
     * */
    public E remove(int index){
        // given node at certain index
        // get previous node and change pointer to following node
        // also need to return removed node (.data)
        int count = 0;
        Node currentNode = head;
        if(currentNode == null || index >= this.size() || index < 0) {
            return null;
        }
        while(count < index-1) {
            currentNode = currentNode.getPointer();
            count++;
        }
        // count is now one less than index, currentNode is one before removed node

        if (index == 0) { // if removing the head
            Node removedNode = head;
            head = currentNode.getPointer();
            return removedNode.data;
        }
        Node removedNode = currentNode.getPointer();
        currentNode.pointer = removedNode.getPointer();

        return removedNode.data;
    }

    /**
     * Removes and returns the first instance of found object. Should find object based on value of the object, not memory.
     * */
    public E remove(E obj){

        Node currentNode = head;
        Node prevNode = null;


        while(currentNode != null && !obj.equals(currentNode.data)) {
            prevNode = currentNode;
            currentNode = currentNode.getPointer();

        }
        if(currentNode == null) {
            return null;
        }

        if(currentNode == head) { // if removing head
            Node removedNode = head;
            head = currentNode.getPointer();
            return removedNode.data;
        }
        prevNode.pointer = currentNode.getPointer();
        return currentNode.data;


    }

    /**
     * Replaces object at specified index if possible. If index is one out of range, should be treated as an insert. Return the object being removed. Null if invalid index.
     * */
    public Object set(int index, Object item) {
        return null;
    }

    /**
     * Returns the number of items in the LL
     * */
    public int size() {
        Node currentNode = head;
        int count = 0;
        while(currentNode != null){
            count++;
            currentNode = currentNode.getPointer();
        }
        return count;
    }

    /**
     *  The boolean determines whether you start at Index 0 or Index 1. You will remove the starting index and then continuously remove every OTHER node in the LL. You should then have a new LL of the removed Nodes returned.
     * */
    public MyLL skipWithAHop(boolean skipState){
        return null;
    }

    //Outputs the entire LL - one node per line
    public String toString() {
        int index = 0;
        Node currentNode = head;
        String toReturn = "";
        while(currentNode != null){
            toReturn +=  index + ": " + currentNode.data + "\n";
            index++;
            currentNode = currentNode.getPointer();
        }
        return toReturn;
    }

}
