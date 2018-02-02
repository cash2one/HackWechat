package com.tencent.mm.sdk.platformtools;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import com.tencent.mm.sdk.f.e;
import junit.framework.Assert;

public class ag {
    private static af xfx = null;
    private af mrL = null;
    public HandlerThread oAt = null;
    private String xfy = null;

    public interface a {
        boolean JB();

        boolean JC();
    }

    public interface b {
        void Dn();
    }

    private void Vf(String str) {
        this.mrL = null;
        if (bh.ov(str)) {
            str = "MMHandlerThread";
        }
        this.xfy = str;
        this.oAt = e.cZ(this.xfy, 0);
        this.oAt.start();
    }

    public static void Df(int i) {
        try {
            Process.setThreadPriority(i);
            x.i("MicroMsg.MMHandlerThread", "setCurrentPriority to %d ok", Integer.valueOf(i));
        } catch (Throwable e) {
            x.i("MicroMsg.MMHandlerThread", "setCurrentPriority to %d fail, %s", Integer.valueOf(i), e.getMessage());
            x.printErrStackTrace("MicroMsg.MMHandlerThread", e, "", new Object[0]);
        }
    }

    public final void cfC() {
        if (this.oAt == null || !this.oAt.isAlive()) {
            x.e("MicroMsg.MMHandlerThread", "setLowestPriority failed thread is dead");
            return;
        }
        int threadId = this.oAt.getThreadId();
        try {
            if (19 == Process.getThreadPriority(threadId)) {
                x.w("MicroMsg.MMHandlerThread", "setLowestPriority No Need.");
                return;
            }
            Process.setThreadPriority(threadId, 19);
            x.i("MicroMsg.MMHandlerThread", "thread:%d setLowestPriority to %d", Integer.valueOf(threadId), Integer.valueOf(Process.getThreadPriority(threadId)));
        } catch (Throwable e) {
            x.w("MicroMsg.MMHandlerThread", "thread:%d setLowestPriority failed", Integer.valueOf(threadId));
            x.printErrStackTrace("MicroMsg.MMHandlerThread", e, "", new Object[0]);
        }
    }

    public final int cfD() {
        if (this.oAt == null) {
            return -1;
        }
        return this.oAt.getThreadId();
    }

    public final void tS() {
        if (this.oAt == null || !this.oAt.isAlive()) {
            x.e("MicroMsg.MMHandlerThread", "setHighPriority failed thread is dead");
            return;
        }
        int threadId = this.oAt.getThreadId();
        try {
            if (-8 == Process.getThreadPriority(threadId)) {
                x.w("MicroMsg.MMHandlerThread", "setHighPriority No Need.");
                return;
            }
            Process.setThreadPriority(threadId, -8);
            x.i("MicroMsg.MMHandlerThread", "thread:%d setHighPriority to %d", Integer.valueOf(threadId), Integer.valueOf(Process.getThreadPriority(threadId)));
        } catch (Throwable e) {
            x.w("MicroMsg.MMHandlerThread", "thread:%d setHighPriority failed", Integer.valueOf(threadId));
            x.printErrStackTrace("MicroMsg.MMHandlerThread", e, "", new Object[0]);
        }
    }

    public final void cfE() {
        if (this.oAt == null || !this.oAt.isAlive()) {
            x.e("MicroMsg.MMHandlerThread", "setLowPriority failed thread is dead");
            return;
        }
        int threadId = this.oAt.getThreadId();
        try {
            if (Process.getThreadPriority(threadId) == 0) {
                x.w("MicroMsg.MMHandlerThread", "setLowPriority No Need.");
                return;
            }
            Process.setThreadPriority(threadId, 0);
            x.i("MicroMsg.MMHandlerThread", "thread:%d setLowPriority to %d", Integer.valueOf(threadId), Integer.valueOf(Process.getThreadPriority(threadId)));
        } catch (Throwable e) {
            x.w("MicroMsg.MMHandlerThread", "thread:%d setLowPriority failed", Integer.valueOf(threadId));
            x.printErrStackTrace("MicroMsg.MMHandlerThread", e, "", new Object[0]);
        }
    }

    public ag() {
        x.i("MicroMsg.MMHandlerThread", "init stack:%s", bh.cgy());
        Vf(null);
    }

    public ag(String str) {
        Vf(str);
    }

    public final af cfF() {
        if (this.mrL == null) {
            this.mrL = new af(this.oAt.getLooper());
        }
        return this.mrL;
    }

    public final int a(final b bVar) {
        int a;
        x.i("MicroMsg.MMHandlerThread", "syncReset tid[%d] stack:%s", Long.valueOf(Thread.currentThread().getId()), bh.cgy());
        Assert.assertTrue("syncReset should in mainThread", isMainThread());
        long id = this.oAt.getId();
        final Object obj = new byte[0];
        final String str = this.xfy;
        a anonymousClass1 = new a(this) {
            final /* synthetic */ ag xfB;

            public final boolean JC() {
                x.i("MicroMsg.MMHandlerThread", "syncReset onPostExecute");
                return true;
            }

            public final boolean JB() {
                x.i("MicroMsg.MMHandlerThread", "syncReset doInBackground tid[%d]", Long.valueOf(Thread.currentThread().getId()));
                if (bVar != null) {
                    bVar.Dn();
                }
                x.i("MicroMsg.MMHandlerThread", "syncReset doInBackground callback done tid[%d]", Long.valueOf(Thread.currentThread().getId()));
                this.xfB.oAt.quit();
                x.i("MicroMsg.MMHandlerThread", "syncReset init start old tid[%d]", Long.valueOf(this.xfB.oAt.getId()));
                this.xfB.Vf(str);
                x.i("MicroMsg.MMHandlerThread", "syncReset init done new tid[%d]", Long.valueOf(this.xfB.oAt.getId()));
                synchronized (obj) {
                    x.i("MicroMsg.MMHandlerThread", "syncReset notify tid[%d]", Long.valueOf(Thread.currentThread().getId()));
                    obj.notify();
                }
                return true;
            }
        };
        synchronized (obj) {
            a = a(anonymousClass1);
            x.i("MicroMsg.MMHandlerThread", "syncReset postAtFrontOfWorker ret[%d], oldTid[%d], curTid[%d]", Integer.valueOf(a), Long.valueOf(id), Long.valueOf(this.oAt.getId()));
            if (a == 0 && id == r4) {
                try {
                    obj.wait();
                } catch (Exception e) {
                    x.d("MicroMsg.MMHandlerThread", "syncReset lock wait end with exception[%s]", e.getMessage());
                }
            }
        }
        return a;
    }

    public int F(Runnable runnable) {
        if (runnable == null) {
            return -1;
        }
        cfF().post(runnable);
        return 0;
    }

    public final int J(Runnable runnable) {
        cfF().postAtFrontOfQueueV2(runnable);
        return 0;
    }

    public final int g(Runnable runnable, long j) {
        if (runnable == null) {
            return -1;
        }
        cfF().postDelayed(runnable, j);
        return 0;
    }

    public final int a(final a aVar) {
        return new af(this.oAt.getLooper()).postAtFrontOfQueueV2(new Runnable(this) {
            final /* synthetic */ ag xfB;

            public final void run() {
                aVar.JB();
                ag.cfG().postAtFrontOfQueueV2(new Runnable(this) {
                    final /* synthetic */ AnonymousClass2 xfD;

                    {
                        this.xfD = r1;
                    }

                    public final void run() {
                        aVar.JC();
                    }
                });
            }

            public final String toString() {
                return super.toString() + "|" + aVar.toString();
            }
        }) ? 0 : -2;
    }

    public static boolean isMainThread() {
        return Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId();
    }

    private static af cfG() {
        if (xfx == null) {
            xfx = new af(Looper.getMainLooper());
        }
        return xfx;
    }

    public static void y(Runnable runnable) {
        if (runnable != null) {
            cfG().post(runnable);
        }
    }

    public static void h(Runnable runnable, long j) {
        if (runnable != null) {
            cfG().postDelayed(runnable, j);
        }
    }

    public static void K(Runnable runnable) {
        if (runnable != null) {
            cfG().removeCallbacks(runnable);
        }
    }
}
