package com.tencent.mm.plugin.webview.modelcache;

import android.os.Looper;
import android.os.Process;
import com.tencent.mm.plugin.webview.modelcache.q.3;

class q$3$1 implements Runnable {
    final /* synthetic */ Runnable gMQ;
    final /* synthetic */ 3 tua;

    q$3$1(3 3, Runnable runnable) {
        this.tua = 3;
        this.gMQ = runnable;
    }

    public final void run() {
        if ((Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId() ? 1 : null) == null && Process.getThreadPriority(Process.myTid()) != 10) {
            Process.setThreadPriority(10);
        }
        if (this.gMQ != null) {
            this.gMQ.run();
        }
    }
}
