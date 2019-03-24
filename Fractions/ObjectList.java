/**
 * ObjectList stores each unique fraction as an element in Object[]. Class contains size and resize methods which
 * increase the list as it fills with data. Object[] is initialized to a size of 100 to prevent out of bound errors.
 *
 * Jakob Wilter
 * April 13, 2018
 * Fractions
 **/

public class ObjectList {

    private Object[] data = new Object[100];
    private int elementCount = 0;

    // Increases the array size each time array is filled by elementCount.
    public void add(Object f) {
        if (elementCount == data.length)
            resize();
        data[elementCount] = f;
        elementCount++;
    }

    public int size() { //returns the elementCount of the array.
        return elementCount;
    }

    public void resize() { //Doubles the array size in case array gets filled. (Size increases by elementCount)
        this.data = java.util.Arrays.copyOf(this.data, elementCount + elementCount);
    }

    public Object get(int n) { //returns the indexed value of the data array.
        return data[n];
    }

}
