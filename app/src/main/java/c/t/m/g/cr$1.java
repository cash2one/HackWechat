package c.t.m.g;

import java.util.concurrent.ThreadFactory;

class cr$1 implements ThreadFactory {
    cr$1() {
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "network_request_pool");
    }
}
