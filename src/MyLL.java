
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
            newNode.pointer = head;
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
    public void addFirst(E item){
        // make node, set item pointer to head, set head to item
        Node newNode = new Node(item);
        if(head != null){
            newNode.pointer = head;
        }
        head = newNode;
    }

    /**
     * Add to end of LL. If existing element is there, it should go after last item..
     */
    public void addLast(E item) {
        add(item);
    }

    /**
     * Should remove all Nodes within the LL.
     * */
    public void clear() {
        head = null;

    }

    /**
     * Searches the LL for a matching object (in context of object's value, not memory)
     * */
    public boolean contains(E item){
        Node currentNode = head;

        while(currentNode != null) {
            if(currentNode.data.equals(item)){
                return true;
            }
            currentNode = currentNode.getPointer();
        }

        return false;
    }

    /**
     * Returns object at specified index. Should return null if invalid range is selected.
     * */
    public E get(int index){
        Node currentNode = head;
        int currentIndex = 0;
        if(index >= this.size()){
            return null;
        }
        while(currentNode != null) {
            if(currentIndex == index){
                return currentNode.data;
            }
            currentIndex++;
            currentNode = currentNode.getPointer();

        }
        return null;
    }

    /**
     * Returns object when found. Should be based on value of object. Null if object can't be found.
     * */
    public E get(E item){ // test some more
        Node currentNode = head;
        while(currentNode != null) {
            if(currentNode.data.equals(item)){
                return currentNode.data;
            }
            currentNode = currentNode.getPointer();
        }

        return null;
    }

    /**
     * Returns object at first index. Should return null if LL is empty.
     * */
    public E getFirst(){
        if(head != null) {
            return head.data;
        }
        return null;
    }

    /**
     * Spoilers: Gets you the last item in the LL. Null if LL is empty.
     * */
    public E getLast(){
        Node currentNode = head;
        if(currentNode == null){
            return null;
        }
        while(currentNode.getPointer() != null){
            currentNode = currentNode.getPointer();
        }

        return currentNode.data;
    }

    /**
     * Returns index value of where item is. If item is not found, return -1. Should be based on value of object not memory..
     * */
    public int indexOf(E item){
        int currentIndex = 0;
        Node currentNode = head;
        while(currentIndex<this.size()){
            if(currentNode.data.equals(item)){
                return currentIndex;
            }
            currentNode = currentNode.getPointer();
            currentIndex++;
        }

        return -1;
    }

    /**
     * Returns LAST index value of where item is. If item is not found, return -1. Should be based on value of object not memory..
     * */
    public int lastIndexOf(E item){
        int currentIndex = 0;
        Node currentNode = head;
        int lastIndexFound = -1;

        while(currentNode != null) {
            if(currentNode.data.equals(item)){
                lastIndexFound = currentIndex;
            }
            currentNode = currentNode.getPointer();
            currentIndex++;
        }

        return lastIndexFound;
    }

    /**
     * Removes and returns the node at index 0. Return null if LL is empty.
     * */
    public E poll(){
        if(head != null){
            return this.remove(0);
        }
        return null;
    }

    /**
     * Removes and returns the last node. Return null if LL is empty.
     * */
    public E pollLast() {
        if(head != null) {
            return this.remove(this.size()-1);
        }
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
    public E set(int index, E item) {
        int currentIndex = 0;
        Node currentNode = head;
        Node prevNode = null;
        if(index > this.size() || index < 0) {
            return null;
        }
        if(index == this.size()) {
            this.add(item);
            return item;
        }
        Node newNode = new Node(item);
        if(index == 0) {
            newNode.pointer = head.getPointer();
            E toReturn = head.data;
            head = newNode;
            return toReturn;
        }
        while(currentNode != null)  {
            if(currentIndex == index) {
                newNode.pointer = currentNode.getPointer();
                E toReturn = currentNode.data;
                prevNode.pointer = newNode;
                return toReturn;
            }
            prevNode = currentNode;
            currentNode = currentNode.getPointer();
            currentIndex++;
        }

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
    public MyLL skipWithAHop(boolean skipState) {
        // 0 is true, 1 is false
        int startingIndex = skipState ? 0 : 1;
        MyLL removedNodes = new MyLL();
        System.out.println(startingIndex);
        for(int i = startingIndex; i < this.size(); i++) {
            removedNodes.add(this.remove(i));
        }
        return removedNodes;
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
