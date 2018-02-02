package com.d.a.a;

import android.content.Context;
import android.os.Handler;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.LinkedList;

abstract class d {
    boolean bgH;
    private Collection<WeakReference<m>> bgI;
    private a bgJ;
    boolean isReady;
    private Handler mHandler;
    private Context tI;

    abstract void U(Context context);

    abstract void V(Context context);

    abstract void a(Context context, Handler handler, a aVar);

    abstract void rR();

    d() {
    }

    final void c(p pVar) {
        if (this.bgH && this.bgI != null) {
            for (WeakReference weakReference : this.bgI) {
                m mVar = (m) weakReference.get();
                if (mVar != null) {
                    mVar.a(pVar);
                }
            }
        }
    }

    final synchronized void a(Context context, m... mVarArr) {
        if (context == null) {
            throw new Exception("Module: context cannot be null");
        }
        rU();
        b(context.getApplicationContext(), mVarArr);
        this.isReady = true;
    }

    final synchronized void rU() {
        if (this.isReady) {
            stop();
            rR();
            this.isReady = false;
        }
    }

    synchronized void a(Handler handler, a aVar) {
        stop();
        this.mHandler = handler;
        this.bgJ = aVar;
        a(this.tI, this.mHandler, this.bgJ);
        this.bgH = true;
    }

    synchronized void stop() {
        if (this.bgH) {
            V(this.tI);
            this.mHandler = null;
            this.bgJ = null;
            this.bgH = false;
        }
    }

    private void b(Context context, m... mVarArr) {
        this.tI = context;
        if (mVarArr == null) {
            this.bgI = null;
        } else {
            this.bgI = new LinkedList();
            for (Object weakReference : mVarArr) {
                this.bgI.add(new WeakReference(weakReference));
            }
        }
        U(context);
    }
}
