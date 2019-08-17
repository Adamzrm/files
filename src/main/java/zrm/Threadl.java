package zrm;
class Threadl1 extends Thread {
    /**
     * If this thread was constructed using a separate
     * {@code Runnable} run object, then that
     * {@code Runnable} object's {@code run} method is called;
     * otherwise, this method does nothing and returns.
     * <p>
     * Subclasses of {@code Thread} should override this method.
     *
     * @see #start()
     * @see #stop()
     */
    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            System.out.println("this is second method:"+i);
        }
    }
}
public class Threadl {
    /*thread*/
    public static void main(String[] args) {
        Threadl1 threadl1 = new Threadl1();
        threadl1.start();
        /*sleep()*/
        try{
            threadl1.sleep(4000);
        }catch (InterruptedException E){
            E.printStackTrace();
        }

        for(int a=0;a<1000;a++){
        System.out.println("this is main thread:"+a);}
        /*方法一：
        Runner1 runner1 = new Runner1();
        Thread thread = new Thread(runner1);
        thread.start();
        for (int ii = 0; ii < 1000; ii++) {
            System.out.println("this is the main thread:" + ii);
        }
    }
}
/*重写Runnable接口*/
/*class Runner1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("this is runnale's run():" + i);
        }
    }
}*/
        /*方法二：直接继承Thread类，并且重写run（）方法来创建一个新的线程*/

    }
    }