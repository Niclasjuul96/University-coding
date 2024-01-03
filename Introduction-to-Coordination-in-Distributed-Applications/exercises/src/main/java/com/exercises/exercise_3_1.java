// This is a model of the classic problem of the dining philosophers.
// The protocol uses tickets to limit concurrency and to avoid deadlocks.

package com.exercises;

import org.jspace.ActualField;
import org.jspace.SequentialSpace;
import org.jspace.Space;

public class exercise_3_1 {
    // N defines the number of philosophers.
    public static final int N = 10;

    public static void main(String[] args) {
        Space board = new SequentialSpace();

       // new Thread((Runnable) new waiter(board)).start();

        for (int i = 0; i < N; i ++) {
           // new Thread((Runnable) new philosopher(board, i)).start();
        }

        try {
            board.query(new ActualField("done")); // will never succeed
        } catch (InterruptedException e) {}
    }
}

