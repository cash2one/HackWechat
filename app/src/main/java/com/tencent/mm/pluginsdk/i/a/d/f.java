package com.tencent.mm.pluginsdk.i.a.d;

import android.os.Process;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class f<T extends b> {
    final Map<String, Future<?>> vhA = new ConcurrentHashMap();
    final Map<String, b> vhz = new ConcurrentHashMap();

    protected class a extends ThreadPoolExecutor {
        final /* synthetic */ f vhB;

        public a(f fVar, int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, t tVar) {
            this.vhB = fVar;
            super(i, i2, j, timeUnit, blockingQueue, tVar);
        }

        protected final <V> RunnableFuture<V> newTaskFor(Runnable runnable, V v) {
            if (runnable instanceof d) {
                return new c(runnable, v, ((d) runnable).vhC);
            }
            return super.newTaskFor(runnable, v);
        }

        protected final void terminated() {
            this.vhB.vhA.clear();
            super.terminated();
        }

        protected final void beforeExecute(Thread thread, Runnable runnable) {
            if (runnable instanceof c) {
                c cVar = (c) runnable;
                if (this.vhB.vhA.containsKey(cVar.vhC.bZj())) {
                    cVar.cancel(false);
                } else {
                    this.vhB.vhA.put(cVar.vhC.bZj(), cVar);
                    this.vhB.vhz.remove(cVar.vhC.bZj());
                }
            } else {
                x.i("MicroMsg.ResDownloader.IOWorker", "r = %s is not RequestFutureTask<?>", new Object[]{runnable.getClass().getSimpleName()});
            }
            super.beforeExecute(thread, runnable);
        }

        protected final void afterExecute(Runnable runnable, Throwable th) {
            if (runnable instanceof c) {
                c cVar = (c) runnable;
                this.vhB.vhA.remove(cVar.vhC.bZj());
                this.vhB.vhz.remove(cVar.vhC.bZj());
            } else {
                x.i("MicroMsg.ResDownloader.IOWorker", "r = %s is not RequestFutureTask<?>", new Object[]{runnable.getClass().getSimpleName()});
            }
            super.afterExecute(runnable, th);
        }
    }

    public interface b {
        String bZj();
    }

    protected static abstract class d<Req extends b> implements Runnable {
        private final Req vhC;

        public Req aai() {
            return this.vhC;
        }

        public d(Req req) {
            this.vhC = req;
        }

        public void run() {
            if (Process.getThreadPriority(Process.myTid()) != 10) {
                Process.setThreadPriority(10);
            }
        }
    }

    public abstract d a(T t);

    public abstract a bZq();

    public final void b(T t) {
        this.vhz.put(t.bZj(), t);
        bZq().submit(a(t));
    }

    public final synchronized boolean RU(String str) {
        boolean z;
        z = this.vhA.containsKey(str) || this.vhz.containsKey(str);
        return z;
    }
}
