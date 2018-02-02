package com.tencent.mm.sdk.platformtools;

import android.os.Looper;
import android.os.Message;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class as {
    boolean fCO;
    Object lock;
    String name;
    int priority;
    public LinkedBlockingQueue<a> xhp;
    private int xhq;
    Vector<b> xhr;
    af xhs;

    public interface a {
        boolean JB();

        boolean JC();
    }

    final class b extends Thread {
        private int twh;
        final /* synthetic */ as xht;

        private b(as asVar) {
            this.xht = asVar;
            super(asVar.name);
            this.twh = 60;
            setPriority(asVar.priority);
            asVar.xhr.add(this);
        }

        public final void run() {
            while (this.twh > 0) {
                a aVar;
                synchronized (this.xht.lock) {
                    try {
                        if (this.xht.fCO) {
                            this.xht.lock.wait();
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("QueueWorkerThread.QueueWorkerThread", e, "", new Object[0]);
                    }
                }
                try {
                    aVar = (a) this.xht.xhp.poll(2000, TimeUnit.MILLISECONDS);
                } catch (Throwable e2) {
                    x.printErrStackTrace("QueueWorkerThread.QueueWorkerThread", e2, "", new Object[0]);
                    aVar = null;
                }
                if (aVar == null) {
                    this.twh--;
                } else {
                    this.twh = 60;
                    if (aVar.JB()) {
                        this.xht.xhs.sendMessage(this.xht.xhs.obtainMessage(0, aVar));
                    }
                }
            }
            this.xht.xhr.remove(this);
            x.d("QueueWorkerThread.QueueWorkerThread", "dktest Finish queueToReqSize:" + this.xht.xhp.size() + " ThreadSize:" + this.xht.xhr.size());
        }
    }

    public as(int i, String str) {
        this(i, str, 1);
    }

    public as(int i, String str, int i2) {
        this(i, str, i2, Looper.myLooper());
    }

    public as(int i, String str, int i2, Looper looper) {
        this.xhp = new LinkedBlockingQueue();
        this.fCO = false;
        this.xhq = 1;
        this.priority = 1;
        this.name = "";
        this.lock = new byte[0];
        this.xhr = new Vector();
        this.xhq = i2;
        this.name = str;
        this.priority = i;
        if (looper == null && Looper.getMainLooper() != null) {
            looper = Looper.getMainLooper();
            x.i("QueueWorkerThread.QueueWorkerThread", "looper is null use MainLooper!");
        }
        this.xhs = new af(this, looper) {
            final /* synthetic */ as xht;

            public final void handleMessage(Message message) {
                if (message != null && message.obj != null) {
                    ((a) message.obj).JC();
                }
            }
        };
    }

    public final int c(a aVar) {
        if (aVar == null) {
            x.e("QueueWorkerThread.QueueWorkerThread", "add empty thread object");
            return -1;
        }
        try {
            if (!this.xhp.offer(aVar, 1, TimeUnit.MILLISECONDS)) {
                x.e("QueueWorkerThread.QueueWorkerThread", "add To Queue failed");
                return -2;
            } else if (this.xhr.size() != 0 && (this.xhp.size() <= 0 || this.xhq <= this.xhr.size())) {
                return 0;
            } else {
                new b().start();
                return 0;
            }
        } catch (Throwable e) {
            x.e("QueueWorkerThread.QueueWorkerThread", "add To Queue failed :" + e.getMessage());
            x.printErrStackTrace("QueueWorkerThread.QueueWorkerThread", e, "", new Object[0]);
            return -3;
        }
    }

    @Deprecated
    public final boolean cfT() {
        if (this.xhr == null || this.xhr.size() == 0) {
            return true;
        }
        return false;
    }

    public final void lD(boolean z) {
        synchronized (this.lock) {
            this.fCO = z;
            if (!z) {
                synchronized (this.lock) {
                    this.lock.notifyAll();
                }
            }
        }
    }
}
