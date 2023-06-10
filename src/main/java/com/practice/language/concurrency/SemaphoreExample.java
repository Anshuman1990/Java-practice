package com.practice.language.concurrency;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) throws InterruptedException {
// creating a Semaphore object
        // with number of permits 1
        Semaphore sem = new Semaphore(1);
        // creating two threads with name A and B
        // Note that thread A will increment the count
        // and thread B will decrement the count
        SemaphoreThread mt1 = new SemaphoreThread(sem, "A");
        SemaphoreThread mt2 = new SemaphoreThread(sem, "B");
        // stating threads A and B
        mt1.start();
        mt2.start();
        // waiting for threads A and B
        mt1.join();
        mt2.join();
        // count will always remain 0 after
        // both threads will complete their execution
        System.out.println("count: " + Shared.count);
    }

}

class Shared
{
    static int count = 0;
}

class SemaphoreThread extends Thread {
    Semaphore semaphore;
    String threadName;
public SemaphoreThread(Semaphore sem, String threadName){
    super(threadName);
    this.semaphore = sem;
    this.threadName = threadName;
}

    @Override
    public void run() {
        // run by thread A
        if(this.getName().equals("A"))
        {
            System.out.println("Starting " + threadName);
            try
            {
                // First, get a permit.
                System.out.println(threadName + " is waiting for a permit.");
                // acquiring the lock
                semaphore.acquire();
                System.out.println(threadName + " gets a permit.");
                // Now, accessing the shared resource.
                // other waiting threads will wait, until this
                // thread release the lock
                for(int i=0; i < 5; i++)
                {
                    Shared.count++;
                    System.out.println(threadName + ": " + Shared.count);
                    // Now, allowing a context switch -- if possible.
                    // for thread B to execute
                    Thread.sleep(10);
                }
            } catch (InterruptedException exc) {
                System.out.println(exc);
            }
            // Release the permit.
            System.out.println(threadName + " releases the permit.");
            semaphore.release();
        }
        else{
            System.out.println("Starting " + threadName);
            try
            {
                // First, get a permit.
                System.out.println(threadName + " is waiting for a permit.");
                // acquiring the lock
                semaphore.acquire();

                System.out.println(threadName + " gets a permit.");
                // Now, accessing the shared resource.
                // other waiting threads will wait, until this
                // thread release the lock
                for(int i=0; i < 5; i++)
                {
                    Shared.count--;
                    System.out.println(threadName + ": " + Shared.count);
                    // Now, allowing a context switch -- if possible.
                    // for thread A to execute
                    Thread.sleep(10);
                }
            } catch (InterruptedException exc) {
                System.out.println(exc);
            }
            // Release the permit.
            System.out.println(threadName + " releases the permit.");
            semaphore.release();
        }
    }
}
