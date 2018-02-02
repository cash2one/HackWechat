package com.google.android.gms.common.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class j<R extends g> implements e<R> {
    private h<R> aKA;
    private volatile R aKB;
    private volatile boolean aKC;
    private boolean aKD;
    private boolean aKE;
    private q aKF;
    private final Object aKw = new Object();
    protected final a<R> aKx;
    private final CountDownLatch aKy = new CountDownLatch(1);
    private final ArrayList<Object> aKz = new ArrayList();

    public static class a<R extends g> extends Handler {
        public a() {
            this(Looper.getMainLooper());
        }

        public a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Pair pair = (Pair) message.obj;
                    Object obj = pair.first;
                    Object obj2 = pair.second;
                    return;
                case 2:
                    ((j) message.obj).a(Status.aKt);
                    return;
                default:
                    Log.wtf("AbstractPendingResult", "Don't know how to handle this message.");
                    return;
            }
        }
    }

    protected j(Looper looper) {
        this.aKx = new a(looper);
    }

    private void b(R r) {
        this.aKB = r;
        this.aKF = null;
        this.aKy.countDown();
        g gVar = this.aKB;
        if (this.aKA != null) {
            this.aKx.removeMessages(2);
            if (!this.aKD) {
                a aVar = this.aKx;
                aVar.sendMessage(aVar.obtainMessage(1, new Pair(this.aKA, oi())));
            }
        }
        Iterator it = this.aKz.iterator();
        while (it.hasNext()) {
            it.next();
        }
        this.aKz.clear();
    }

    private static void c(g gVar) {
        if (gVar instanceof f) {
            try {
                ((f) gVar).release();
            } catch (RuntimeException e) {
                new StringBuilder("Unable to release ").append(gVar);
            }
        }
    }

    private boolean is() {
        return this.aKy.getCount() == 0;
    }

    private R oi() {
        R r;
        boolean z = true;
        synchronized (this.aKw) {
            if (this.aKC) {
                z = false;
            }
            w.d(z, "Result has already been consumed.");
            w.d(is(), "Result is not ready.");
            r = this.aKB;
            this.aKB = null;
            this.aKA = null;
            this.aKC = true;
        }
        oh();
        return r;
    }

    public final void a(Status status) {
        synchronized (this.aKw) {
            if (!is()) {
                a(b(status));
                this.aKE = true;
            }
        }
    }

    public final void a(R r) {
        boolean z = true;
        synchronized (this.aKw) {
            if (this.aKE || this.aKD) {
                c(r);
                return;
            }
            w.d(!is(), "Results have already been set");
            if (this.aKC) {
                z = false;
            }
            w.d(z, "Result has already been consumed");
            b((g) r);
        }
    }

    public abstract R b(Status status);

    public final R b(TimeUnit timeUnit) {
        boolean z = true;
        boolean z2 = 2 <= 0 || Looper.myLooper() != Looper.getMainLooper();
        w.d(z2, "await must not be called on the UI thread when time is greater than zero.");
        if (this.aKC) {
            z = false;
        }
        w.d(z, "Result has already been consumed.");
        try {
            if (!this.aKy.await(2, timeUnit)) {
                a(Status.aKt);
            }
        } catch (InterruptedException e) {
            a(Status.aKr);
        }
        w.d(is(), "Result is not ready.");
        return oi();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void cancel() {
        synchronized (this.aKw) {
            if (this.aKD || this.aKC) {
            } else {
                c(this.aKB);
                this.aKA = null;
                this.aKD = true;
                b(b(Status.aKu));
            }
        }
    }

    public final R of() {
        boolean z = true;
        w.d(Looper.myLooper() != Looper.getMainLooper(), "await must not be called on the UI thread");
        if (this.aKC) {
            z = false;
        }
        w.d(z, "Result has already been consumed");
        try {
            this.aKy.await();
        } catch (InterruptedException e) {
            a(Status.aKr);
        }
        w.d(is(), "Result is not ready.");
        return oi();
    }

    protected void oh() {
    }
}
