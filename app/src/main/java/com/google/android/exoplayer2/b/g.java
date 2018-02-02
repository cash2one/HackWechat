package com.google.android.exoplayer2.b;

import com.google.android.exoplayer2.i.a;
import java.util.LinkedList;

public abstract class g<I extends e, O extends f, E extends Exception> implements c<I, O, E> {
    private int aib;
    private final Thread aii;
    private final LinkedList<I> aij = new LinkedList();
    private final LinkedList<O> aik = new LinkedList();
    public final I[] ail;
    private final O[] aim;
    public int ain;
    private int aio;
    private I aip;
    private boolean aiq;
    private E exception;
    private final Object lock = new Object();
    private boolean released;

    public abstract E a(I i, O o, boolean z);

    public abstract I jl();

    public abstract O jm();

    public final /* synthetic */ void V(Object obj) {
        e eVar = (e) obj;
        synchronized (this.lock) {
            jh();
            a.am(eVar == this.aip);
            this.aij.addLast(eVar);
            ji();
            this.aip = null;
        }
    }

    public final /* synthetic */ Object ja() {
        return jf();
    }

    public final /* synthetic */ Object jb() {
        return jg();
    }

    public g(I[] iArr, O[] oArr) {
        int i = 0;
        this.ail = iArr;
        this.ain = 2;
        for (int i2 = 0; i2 < this.ain; i2++) {
            this.ail[i2] = jl();
        }
        this.aim = oArr;
        this.aio = 2;
        while (i < this.aio) {
            this.aim[i] = jm();
            i++;
        }
        this.aii = new 1(this);
        this.aii.start();
    }

    private I jf() {
        I i;
        synchronized (this.lock) {
            e eVar;
            jh();
            a.an(this.aip == null);
            if (this.ain == 0) {
                eVar = null;
            } else {
                e[] eVarArr = this.ail;
                int i2 = this.ain - 1;
                this.ain = i2;
                eVar = eVarArr[i2];
            }
            this.aip = eVar;
            i = this.aip;
        }
        return i;
    }

    private O jg() {
        O o;
        synchronized (this.lock) {
            jh();
            if (this.aik.isEmpty()) {
                o = null;
            } else {
                f fVar = (f) this.aik.removeFirst();
            }
        }
        return o;
    }

    public void a(O o) {
        synchronized (this.lock) {
            b(o);
            ji();
        }
    }

    public final void flush() {
        synchronized (this.lock) {
            this.aiq = true;
            this.aib = 0;
            if (this.aip != null) {
                a(this.aip);
                this.aip = null;
            }
            while (!this.aij.isEmpty()) {
                a((e) this.aij.removeFirst());
            }
            while (!this.aik.isEmpty()) {
                b((f) this.aik.removeFirst());
            }
        }
    }

    public final void release() {
        synchronized (this.lock) {
            this.released = true;
            this.lock.notify();
        }
        try {
            this.aii.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void jh() {
        if (this.exception != null) {
            throw this.exception;
        }
    }

    private void ji() {
        if (jk()) {
            this.lock.notify();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final boolean jj() {
        synchronized (this.lock) {
            while (!this.released && !jk()) {
                this.lock.wait();
            }
            if (this.released) {
                return false;
            }
            e eVar = (e) this.aij.removeFirst();
            f[] fVarArr = this.aim;
            int i = this.aio - 1;
            this.aio = i;
            f fVar = fVarArr[i];
            boolean z = this.aiq;
            this.aiq = false;
        }
    }

    private boolean jk() {
        return !this.aij.isEmpty() && this.aio > 0;
    }

    private void a(I i) {
        i.clear();
        e[] eVarArr = this.ail;
        int i2 = this.ain;
        this.ain = i2 + 1;
        eVarArr[i2] = i;
    }

    private void b(O o) {
        o.clear();
        f[] fVarArr = this.aim;
        int i = this.aio;
        this.aio = i + 1;
        fVarArr[i] = o;
    }
}
