package com.exercises;

// This is a model of the classic problem of the dining philosophers.
// The solution is based on using tickets to limit concurrency.
// This is a model of the classic problem of the dining philosophers.
// The solution is based on using tickets to limit concurrency.

import org.jspace.ActualField;
import org.jspace.SequentialSpace;
import org.jspace.Space;

public class exercise_2_1 {
    // N defines the number of philosophers.
    public static final int N = 10;

    public static void main(String[] args) {
        Space board = new SequentialSpace();

        new Thread(new waiter1(board)).start();

        for (int i = 0; i < N; i ++) {
            new Thread(new philosopher1(board, i)).start();
        }

        try {
            board.query(new ActualField("done")); // will never succeed
        } catch (InterruptedException e) {}
    }
}

// waiter prepares the board with forks.
class waiter2 implements Runnable {
    private Space board;

    public waiter2(Space space) {
        this.board = space;
    }

    public void run() {
        System.out.println("Waiter putting forks on the table...");

        for (int i = 0; i < exercise_2_1.N; i ++) {
            try {
                board.put("fork", i);
                System.out.println("Waiter put fork " + i + " on the table.");
            } catch (InterruptedException e) {}
        }

        System.out.println("Waiter done.");
    }
}



// philosopher defines the behaviour of a philosopher.
class philosopher2 implements Runnable {
    private Space board;
    private int me, left, right;

    public philosopher2(Space space, int me) {
        this.board = space;

        // We define variables to identify the left and right forks.
        this.me = me;
        this.left = me;
        this.right = (me + 1) % exercise_2_1.N;
    }

    public void run() {

        // The philosopher enters his endless life cycle.
        while (true) {
            try {

                // Wait until the left fork is ready (get the corresponding tuple).
                board.get(new ActualField("fork"), new ActualField(left));
                System.out.println("Philosopher " + me + " got left fork");

                // Wait until the right fork is ready (get the corresponding tuple).
                board.get(new ActualField("fork"), new ActualField(right));
                System.out.println("Philosopher " + me + " got right fork");

                // Lunch time.
                System.out.println("Philosopher " + me + " is eating...");

                // Return the forks (put the corresponding tuples).
                board.put("fork", left);
                board.put("fork", right);
                System.out.println("Philosopher " + me + " put both forks on the table");

            } catch (InterruptedException e) {}
        }
    }
}