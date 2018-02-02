package c.t.m.g;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public final class x {
    public ThreadPoolExecutor a;

    private x() {
        this.a = (ThreadPoolExecutor) Executors.newCachedThreadPool(new o("HalleyBusiTaskPoolHolder"));
    }
}
