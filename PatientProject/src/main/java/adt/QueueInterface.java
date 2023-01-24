package adt;
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author liewm
 */
public interface QueueInterface<T> {
    
    public void enqueue(T newEntry);
    // Task: Adds a new entry to the back of the queue. * * @param newEntry
    //an object to be added

    public T dequeue();
    //* * Task: Removes and returns the entry at the front of the queue.
     //* @return either the object at the front of the queue or, if the queue is *
    // * empty before the operation, null
    public T getFront();
    //* * Task: Retrieves the entry at the front of the queue. * * @return
     //* either the object at the front of the queue or, if the queue is * empty,
     //* null
    public boolean isEmpty();
    //* * Task: Detects whether the queue is empty. * * @return true if the
     //* queue is empty, or false otherwise

    public void clear();
    //* * Task: Removes all entries from the queue.
    
    public int getbackIndex();
    // get the number of entries of the data
      
    public T getEntry(T obj);
    // Retrieves the entry at obj in the queue
    
    public boolean contains(T anEntry);
    //Determine whether the queue contains anEntry

    public T getEntry(int givenPosition);
    //Retrieves the entry at givenPosition in the queue


}



