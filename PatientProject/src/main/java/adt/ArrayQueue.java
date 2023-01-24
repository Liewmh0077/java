/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author liewm
 */
package adt;

import java.util.Iterator;

public class ArrayQueue<T> implements QueueInterface<T> {

    private T[] array;
    private final static int frontIndex = 0;
    private int backIndex=0;//no of entries
    private static final int DEFAULT_CAPACITY = 50;

    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayQueue(int initialCapacity) {
        array = (T[]) new Object[initialCapacity];
        
    }

    public void enqueue(T newEntry) {
        if (!isArrayFull()) {
            
            array[backIndex] = newEntry;
            backIndex++;
        }
    }

    public T getFront() {
        T front = null;
        if (!isEmpty()) {
            front = array[frontIndex];
        }
        return front;
    }
    
    public T getEntry(T obj) {
        T result = null;
        int i=0;
        for(i=0;i<backIndex;i++){
            if(array[i].equals(obj)){
                result = array[i];
                break;
            }
        }

        return result;
    }
    
    public T getEntry(int givenPosition) {
        T result = null;
        if ((givenPosition >= 1) && (givenPosition <= backIndex)) {
            result = array[givenPosition - 1];
        }

        return result;
    }

    
     public boolean contains(T anEntry) {
        boolean found = false;
        for (int index = 0; !found && (index < backIndex); index++) {
            if (anEntry.equals(array[index])) {
                found = true;
            }
        }
        return found;
    }

    public T dequeue() {
        T front = null;
        if (!isEmpty()) {
            front = array[frontIndex];      // shift remaining array items forward one position      
            for (int i = frontIndex; i < backIndex; ++i) {
                array[i] = array[i + 1];
            }
            backIndex--;
        }
        return front;
    }

    public boolean isEmpty() {
        return frontIndex > backIndex;
    }

    public void clear() {
        if (!isEmpty()) { // deallocates only the used portion      
            for (int index = frontIndex; index <= backIndex; index++) {
                array[index] = null;
            }
            backIndex = -1;
        }
    }


    private boolean isArrayFull() {
        return backIndex == array.length - 1;
    }

    // get the number of entries of the data.
    public int getbackIndex(){
        return backIndex;
    }
    
    // this method is to print out the data by using a loop in a string
    public String toString() {
        String outputStr = "";
        for (int index = 0; index < backIndex; ++index) {
        outputStr += array[index] + "\n";
        }   

        return outputStr;
    }
}