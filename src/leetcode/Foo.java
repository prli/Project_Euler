package leetcode;

//https://leetcode.com/problems/print-in-order/
class Foo {
    volatile boolean firstFinished, secondFinished;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        this.firstFinished = true;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (!this.firstFinished) {
            wait();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        this.secondFinished = true;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (!this.secondFinished) {
//            wait();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}