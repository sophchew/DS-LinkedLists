
public class MyLL<E> {
    /*
        Note: All Object return types should be modified to utilize Generics instead
     */

    private Node head;
    private Boolean isDoubly;
    private Boolean isCircular;

    public MyLL() {
        isDoubly = false;
        isCircular = false;
    }

    public MyLL(Boolean isDoubly, Boolean isCircular) {
        this.isDoubly = isDoubly;
        this.isCircular = isCircular;
    }


    /**
     * Adds item to end of LL
     */
    public class Node {
        private E data;
        private Node pointer;
        private Node prevPointer;

        public Node (E data, Node prevPointer) {
            this.data = data;
            this.pointer = null;
            this.prevPointer = prevPointer;
        }
        public Node (E data) {
            this.data = data;
            this.pointer = null;
            this.prevPointer = null;
        }
        public Node getPointer(){
            return pointer;
        }

        public Node getPrevPointer(){
            return prevPointer;
        }

        @Override
        public String toString() {
            return this.data.toString();
        }
    }

    public void add(E item) { // adapted for doubly and circular
        if(head == null) {
            head = new Node(item, null);  //ask for circular?
            if(this.isCircular){
                head.pointer = head;
            }
            return;
        }
        Node currentNode = head;
        Node endNode = null;
        if(this.isCircular) {
            endNode = head;
        }
        while(currentNode.getPointer() != endNode) {
            currentNode = currentNode.getPointer();
        }
        if(this.isDoubly) {
            currentNode.pointer = new Node(item, currentNode);
            if(this.isCircular){
                head.prevPointer = currentNode.getPointer();
            }
        } else {
            currentNode.pointer = new Node(item, null);
        }

        currentNode.getPointer().pointer = endNode;

    }

    /**
     * Adds item at specified index value. If item already exists, item at current index is shuffled one index to the right.
     * Should ensure a proper index is specified. True means addition was successful, false if not.
     */

    public boolean add(int index, E item) { // adapted for circular and doubly
        // when index = currentIndex
        // set previous pointer to new node
        // set new node pointer to previous node's og pointer
        int currentIndex = 0;
        Node currentNode = head;
        Node prevNode = null;

        if(index > this.size()) { // invalid index
            return false;
        } else if (index == this.size() || this.size() == 1){ // end of list
            this.add(item);
            return true;
        }

        while(currentIndex < index) { // finding node at specified index
            prevNode = currentNode;
            currentNode = currentNode.getPointer();
            currentIndex++;

        }
        Node newNode = new Node(item);
        //for beginning of list, set head = new node
        if(index == 0) { // beginning of list

            newNode.pointer = head;
            if(this.isDoubly) {
                head.prevPointer = newNode;
            }
            if(this.isCircular) {
                Node lastNode = head;
                while(lastNode.getPointer() != head) {
                    lastNode = lastNode.getPointer();
                }
                lastNode.pointer = newNode;
                if(isDoubly) {
                    newNode.prevPointer = lastNode;
                }
            }
            head = newNode;

        } else {
            // if not beginning of list, need to set prev node pointer to new node, new node pointer to next node
            prevNode.pointer = newNode;
            newNode.pointer = currentNode;
            if(this.isDoubly) {
                newNode.prevPointer = prevNode;
                currentNode.prevPointer = newNode;
            }

        }
        return true;
    }

    /**
     * Add to start of LL. If existing element is there, ensure it, and all following nodes, are moved down one index.
     */
    public void addFirst(E item){ // adapted for doubly and circular
        this.add(0, item);

    }

    /**
     * Add to end of LL. If existing element is there, it should go after last item..
     */
    public void addLast(E item) { // adapted for doubly and circular
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
    public boolean contains(E item){ // adapted for circular and doubly
        Node currentNode = head;

        if(head == null) {
            return false;
        } else if(!head.equals(item)) {
            currentNode = currentNode.getPointer();
        } else {
            return true;
        }

        while(currentNode != null && currentNode != head) {
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
    public E get(int index){ //  adapted for circular and doubly
        Node currentNode = head;
        int currentIndex = 0;
        if(index >= this.size() && currentNode == null){
            return null;
        }
        if(index == 0) {
            return head.data;
        }
        currentNode = currentNode.getPointer();
        currentIndex++;
        while(currentNode != null && currentNode != head) {
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
    public E get(E item){ // adapted for circular and doubly
        Node currentNode = head;
        if(currentNode == null) {
            return null;
        } else if (head.data.equals(item)) {
            return head.data;
        }
        currentNode = currentNode.getPointer();
        while(currentNode != null && currentNode != head) {
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
    public E getFirst(){ // adapted for circular and doubly (didn't do anything)
        if(head != null) {
            return head.data;
        }
        return null;
    }

    /**
     * Spoilers: Gets you the last item in the LL. Null if LL is empty.
     * */
    public E getLast(){ // adapted for circular and doubly
        Node currentNode = head;
        if(currentNode == null){
            return null;
        }

        while(currentNode.getPointer() != null && currentNode.getPointer() != head){
            currentNode = currentNode.getPointer();
        }

        return currentNode.data;
    }

    /**
     * Returns index value of where item is. If item is not found, return -1. Should be based on value of object not memory..
     * */
    public int indexOf(E item){ // adapted for circular and doubly (didn't do anything)
        int currentIndex = 0;
        Node currentNode = head;
        while(currentIndex<this.size()) {
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
    public int lastIndexOf(E item){ // adapted for circular and doubly (didn't do anything)
        int currentIndex = 0;
        Node currentNode = head;
        int lastIndexFound = -1;

        while(currentIndex<this.size()) {
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
    public E poll(){ // adapted for circular and doubly (didn't do anything)
        if(head != null){
            return this.remove(0);
        }
        return null;
    }

    /**
     * Removes and returns the last node. Return null if LL is empty.
     * */
    public E pollLast() { // adapted for circular and doubly (didn't do anything)
        if(head != null) {
            return this.remove(this.size()-1);
        }
        return null;
    }

    /**
     * Removes and returns the object at index. Removal behavior should mimic that of an ArrayList.
     * */
    public E remove(int index){  // adapted for doubly and circular
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
            if(this.size() == 1) {
                head = null;
                return removedNode.data;
            }
            if(this.isDoubly) {
                removedNode.getPointer().prevPointer = null;
            }
            if(this.isCircular){ // last node has to point to new head
                Node lastNode = currentNode;
                while(lastNode.getPointer() != head){
                    lastNode = lastNode.getPointer();
                }
                lastNode.pointer = removedNode.getPointer();
                if(this.isDoubly) {
                    removedNode.getPointer().prevPointer = lastNode; // doubly circular, new head prev pointer is last node
                }
            }
            head = currentNode.getPointer();
            return removedNode.data;
        }


        Node removedNode = currentNode.getPointer();
        currentNode.pointer = removedNode.getPointer();
        if(this.isDoubly) {
            removedNode.getPointer().prevPointer = currentNode;
        }

        return removedNode.data;
    }

    /**
     * Removes and returns the first instance of found object. Should find object based on value of the object, not memory.
     * */
    public E remove(E obj){ // adapted for doubly and circular

        Node currentNode = head;
        Node prevNode = null;

        if(currentNode == null) {
            return null;
        }

        while(currentNode.getPointer() != null && currentNode.getPointer() != head) {
            if(obj.equals(currentNode.data)){
                break;
            }
            prevNode = currentNode;
            currentNode = currentNode.getPointer();
        }
        if(!currentNode.data.equals(obj)) {
            return null;
        }

        if(currentNode == head) { // if removing head
            Node removedNode = head;
            if(this.size() == 1) {
                head = null;
                return removedNode.data;
            }
            if(this.isDoubly) {
                removedNode.getPointer().prevPointer = null;
            }
            if(this.isCircular){ // last node has to point to new head
                Node lastNode = currentNode;
                while(lastNode.getPointer() != head){
                    lastNode = lastNode.getPointer();
                }
                lastNode.pointer = removedNode.getPointer();
                if(this.isDoubly) {
                    removedNode.getPointer().prevPointer = lastNode; // doubly circular, new head prev pointer is last node
                }
            }
            head = currentNode.getPointer();
            return removedNode.data;
        }
        prevNode.pointer = currentNode.getPointer();
        if(this.isDoubly) {
            currentNode.getPointer().prevPointer = prevNode;
        }
        return currentNode.data;


    }

    /**
     * Replaces object at specified index if possible. If index is one out of range, should be treated as an insert. Return the object being removed. Null if invalid index.
     * */
    public E set(int index, E item) { //  adapted for doubly and circular
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
            if(this.isDoubly) {
                head.getPointer().prevPointer = newNode;
            }
            if(this.isCircular) {
                Node lastNode = head;
                while(lastNode.getPointer() != head) {
                    lastNode = lastNode.getPointer();
                }
                lastNode.pointer = newNode;
                if(isDoubly) {
                    newNode.prevPointer = lastNode;
                }
            }
            E toReturn = head.data;
            head = newNode;
            return toReturn;
        }
        while(currentIndex < this.size()) {
            if(currentIndex == index) {
                newNode.pointer = currentNode.getPointer();
                E toReturn = currentNode.data;
                prevNode.pointer = newNode;
                if(this.isDoubly) {
                    currentNode.getPointer().prevPointer = newNode;
                    newNode.prevPointer = prevNode;
                }
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
    public int size() { // adapted for doubly and circular
        Node currentNode = head;
        int count = 0;
        if(currentNode != null) {
            count++;
            currentNode = currentNode.getPointer();
        }
        while(currentNode != null && currentNode != head){
            count++;
            currentNode = currentNode.getPointer();
        }
        return count;
    }

    /**
     *  The boolean determines whether you start at Index 0 or Index 1. You will remove the starting index and then continuously remove every OTHER node in the LL. You should then have a new LL of the removed Nodes returned.
     * */
    public MyLL skipWithAHop(boolean skipState) { // adapted for circular and doubly
        // 0 is true, 1 is false
        int startingIndex = skipState ? 0 : 1;
        MyLL removedNodes = new MyLL();
        if(this.isCircular) {
            if(this.isDoubly) {
                removedNodes = new MyLL(true, true);
            } else {
                removedNodes = new MyLL(false, true);
            }
        } else if(isDoubly) {
            removedNodes = new MyLL(true, false);
        }
        for(int i = startingIndex; i < this.size(); i++) {
            removedNodes.add(this.remove(i));
        }
        return removedNodes;
    }

    //Outputs the entire LL - one node per line
    public String toString() { // adapted for doubly and circular
        int index = 0;
        Node currentNode = head;
        String toReturn = "";
        if(currentNode != null){
            toReturn +=  index + ": " + currentNode.data + "\n";
            index++;
            currentNode = currentNode.getPointer();
        }
        while(currentNode != null && currentNode != head){
            toReturn +=  index + ": " + currentNode.data + "\n";
            index++;
            currentNode = currentNode.getPointer();
        }
        return toReturn;
    }

}
