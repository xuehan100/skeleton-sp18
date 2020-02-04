public class ArrayDeque<T> {
    private int size;
    private T[] items;
    private static int CAPACITY = 8;
    private int head;
    private int tail;

    /*
    Creates an empty array deque
    The starting size of your array should be 8.
     */
    public ArrayDeque() {
        //initialize an array of generic type
        items = (T[]) new Object[CAPACITY];
        size = 0;
        head = 0;
        tail = 1;
    }

    /*
    Creates a deep copy of other
     */
    public  ArrayDeque(ArrayDeque other) {
        items = (T[]) new Object[CAPACITY];
        head = 0;
        tail = 1;
        for (int i = 0; i < other.size; ++i) {
            addLast((T) other.get(i));
        }
    }



    private void reSizing(int instruct) {
        int orig = items.length;
        int cur = 0;
        //increase the size

        if (instruct == 1) {
            cur = orig * 2;
        } else if (instruct == -1) {
            cur = orig / 2;
        } else {
            System.out.println("Wrong instruction");
        }

        T[] newItems = (T[]) new Object[cur];

        //copy the elements in the original array into the new array
        int i = 0;
        while (i < size) {
            newItems[i] = items[head];
            i++;
            head = (head + 1) % orig;
        }
        head = 0;
        tail = size + 1;
        items = newItems;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isLessThan25() {
        return (double) size / (double) items.length < 0.25;
    }

    private boolean isArrayFull() {
        if (size == items.length) {
            return true;
        } else {
            return false;
        }
    }



    public void addFirst(T item) {
        if (isArrayFull()) {
            //resizing the array, 1 indicates increasing size
            this.reSizing(1);
        }

        //put item in the array
        int len = items.length;
        if (head != 0) {
            items[head - 1] = item;
            head = (head - 1) % len;
        } else {
            items[len - 1] = item;
            head = len - 1;
        }
        size++;
    }

    public void addLast(T item) {
        if (isArrayFull()) {
            //System.out.println("The array is full, now resizing...");
            this.reSizing(1);
        }
        int len = items.length;
        items[tail - 1] = item;
        tail = tail % len + 1;
        size++;
    }


    public int size() {
        return size;
    }

    public void printDeque() {
        int cur;
        cur = head;
        int i = 0;
        while (i < size) {
            System.out.print(items[cur] + " ");
            cur = (cur + 1) % items.length;
            i++;
        }
        System.out.println();

    }

    public T removeFirst() {
        T res = null;
        if (!isEmpty()) {
            int len = items.length;
            res = items[head];
            items[head] = null;
            head = (head + 1) % len;
            size--;
            if (isLessThan25()) {
                this.reSizing(-1);
            }
        }
        return res;
    }

    public T removeLast() {
        T res = null;
        if (!isEmpty()) {
            int len = items.length;
            res = items[tail - 1];
            items[tail - 1] = null;
            tail = (tail - 1) % len;
            size--;
            if (isLessThan25()) {
                this.reSizing(-1);
            }
        }
        return res;
    }

    /*
    Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
    If no such item exists, returns null. Must not alter the deque!
     */
    public T get(int index) {
        int n = items.length;
        return items[index % n];
    }


}