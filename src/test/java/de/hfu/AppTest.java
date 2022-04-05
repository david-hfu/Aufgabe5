package de.hfu;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
    @Test
    public void utilTest() {
    	assert(Util.istErstesHalbjahr(1));
    }
    
    @Test (expected = IllegalStateException.class)
    public void queueLeerTest( ) {
    	Queue qEins = new Queue(3);
    	qEins.dequeue();
    }
    
    @Test 
    public void queueTest( ) {
    	Queue q = new Queue(3);
    	q.enqueue(1);
    	q.enqueue(2);
    	q.enqueue(3);
    	q.enqueue(4);
    	assert(q.dequeue() == 1);
    	assert(q.dequeue() == 2);
    	assert(q.dequeue() == 4);
    }
    
}
