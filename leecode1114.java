package cn.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Foo{
    public Foo() {}
    //定义标志位
    private int flag=1;//1 AA  2 BB   3 CC
    //创建锁
    private Lock lock=new ReentrantLock();

    private Condition c1=lock.newCondition();
    private Condition c2=lock.newCondition();
    private Condition c3=lock.newCondition();

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            //判断
            while (flag!=1){
                c1.await();
            }
            System.out.println("first");
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            flag=2;//修改标志位
            c2.signal();//通知
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            //判断
            while (flag!=2){
                c2.await();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            System.out.println("second");
            printSecond.run();
            flag=3;//修改标志位
            c3.signal();//通知
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            //判断
            while (flag!=3){
                c3.await();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            System.out.println("third");
            printThird.run();
            flag=1;//修改标志位
            c1.signal();//通知
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
public class leecode1114 {
    public static void main(String[] args) throws InterruptedException {
        Foo foo=new Foo();


        new Thread(()->{
            try {
                foo.third(new Runnable() {
                    @Override
                    public void run() {}
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BB").start();
        new Thread(()->{
            try {
                foo.second(new Runnable() {
                    @Override
                    public void run() {}
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"CC").start();
        new Thread(()->{
            try {
                foo.first(new Runnable() {
                    @Override
                    public void run() {}
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AA").start();

    }
}
