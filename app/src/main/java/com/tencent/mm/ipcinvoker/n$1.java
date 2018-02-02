package com.tencent.mm.ipcinvoker;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mm.ipcinvoker.e.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.ThreadFactory;

class n$1 implements ThreadFactory {
    final /* synthetic */ HandlerThread gMO;
    final /* synthetic */ n gMP;
    int index = 0;

    n$1(n nVar, HandlerThread handlerThread) {
        this.gMP = nVar;
        this.gMO = handlerThread;
    }

    public final Thread newThread(final Runnable runnable) {
        StringBuilder stringBuilder = new StringBuilder("IPCThreadPool#Thread-");
        int i = this.index;
        this.index = i + 1;
        Thread thread = new Thread(new Runnable(this) {
            final /* synthetic */ n$1 gMR;

            public final void run() {
                ThreadLocal threadLocal = (ThreadLocal) new a(Looper.class, "sThreadLocal").BB();
                if (threadLocal == null || threadLocal.get() != null) {
                    x.d("IPC.IPCThreadPool", "ThreadLocal Looper variable is null or has set.(%s)", new Object[]{threadLocal});
                } else {
                    x.d("IPC.IPCThreadPool", "create a new Looper ThreadLocal variable.");
                    threadLocal.set(this.gMR.gMO.getLooper());
                }
                runnable.run();
            }
        }, stringBuilder.append(i).toString());
        x.i("IPC.IPCThreadPool", "newThread(thread : %s)", new Object[]{r0});
        return thread;
    }
}
