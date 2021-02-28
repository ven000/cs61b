public class LinkedListDeque<T>{
    /**create a node for doubly linked list.**/
    private class LinkedNode{
        private T item;
        private LinkedNode prev;
        private LinkedNode next;
        //constructor
        public LinkedNode (T x){
            item = x;
            prev = this;
            next = this;
        }
    }

    private int size = 0;
    private LinkedNode sentinel = new LinkedNode((T) "babe");

    //constructor
    public LinkedListDeque(){
        sentinel = new LinkedNode((T) "babe");
        size = 0;
    }

    /**create a deep copy of other.*/
    public LinkedListDeque (LinkedListDeque other){
        sentinel = new LinkedNode((T) "babe");
        for (int i=0; i<other.size;i+=1){
            T itemi = (T) other.get(i);
            addLast(itemi);
        }
    }
    /**Add an item of type T to the front the deque*/
    public void addFirst(T item){
        LinkedNode addedFirst = new LinkedNode(item);
        sentinel.next.prev = addedFirst;
        addedFirst.next=sentinel.next;
        sentinel.next=addedFirst;
        addedFirst.prev=sentinel;
        size+=1;
    }

    /**Adds an item of type T to the end of the deque */
    public void addLast (T item){
        LinkedNode addedLast= new LinkedNode(item);
        sentinel.prev.next= addedLast;
        addedLast.prev=sentinel.prev;
        sentinel.prev=addedLast;
        addedLast.next=sentinel;
        size+=1;
    }

    /*returns true if deque is empty, false otherwise.*/
    public boolean isEmpty(){
        return sentinel.prev == sentinel;
    }

    /*returns the number of items in the deque*/
    public int size(){
        return size;
    }

    /*print the items in the deque from first to last, separated by a space.
    once all the items have been printed, print out a new line */

    public void printDeque(){
        LinkedNode p = sentinel;
        while (p.next!=sentinel){
            System.out.print(p.next.item);
            System.out.print(' ');
            p=p.next;
        }
        System.out.println();
    }

    /*removes and returns the item at the front of the deque*/
    public T removeFirst(){
        if (size==0){
            return null;
        }
        T removedF=sentinel.next.item;
        sentinel.next.next.prev=sentinel;
        sentinel.next=sentinel.next.next;
        size-=1;
        return removedF;
    }

    public T removeLast(){
        if (size==0){
            return null;
        }
        T removedL=sentinel.prev.item;
        sentinel.prev.prev.next=sentinel;
        sentinel.prev=sentinel.prev.prev;
        size-=1;
        return removedL;
    }

    /*get the item and the given index,
    where 0 is the front, 1 is the next item, and so forth
     */

    public T get(int index){
        if (index>=size){
            return null;
        }
        LinkedNode p=sentinel.next;
        while (index!=0){
            p=p.next;
            index-=1;
        }
        return p.item;
    }

    public T getrecursive (int index){
        if (index>=size){
            return null;
        } else {
            LinkedNode p = sentinel.next;
            if (index==0){
                return p.item;
            } else {
            sentinel.next=p.next;
            index-=1;
            return getrecursive(index);
            }
        }

    }

}