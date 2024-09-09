
public class MyLL {
    /*
        Note: All Object return types should be modified to utilize Generics instead
     */

    /**
     * Adds item to end of LL
     */
    public void add(Object item) {

    }

    /**
     * Adds item at specified index value. If item already exists, item at current index is shuffled one index to the right.
     * Should ensure a proper index is specified. True means addition was successful, false if not.
     */
    public boolean add(int index, Object item) {
        return false;
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
    public Object remove(int index){
        return null;
    }

    /**
     * Removes and returns the first instance of found object. Should find object based on value of the object, not memory.
     * */
    public Object remove(Object obj){
            return null;
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
        return 0;
    }

    /**
     *  The boolean determines whether you start at Index 0 or Index 1. You will remove the starting index and then continuously remove every OTHER node in the LL. You should then have a new LL of the removed Nodes returned.
     * */
    public MyLL skipWithAHop(boolean skipState){
        return null;
    }

    //Outputs the entire LL - one node per line
    public String toString() {
        return null;
    }

}
