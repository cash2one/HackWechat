package c.t.m.g;

import java.util.concurrent.CountDownLatch;

final class z implements Runnable {
    private /* synthetic */ boolean[] a;
    private /* synthetic */ CountDownLatch b;

    z(boolean[] zArr, CountDownLatch countDownLatch) {
        this.a = zArr;
        this.b = countDownLatch;
    }

    public final void run() {
        try {
            this.a[0] = y.c();
        } catch (Throwable th) {
            this.a[0] = y.b();
        }
        this.b.countDown();
    }
}
