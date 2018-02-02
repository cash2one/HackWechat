package com.tencent.mm.plugin.appbrand.q;

import android.os.Looper;
import com.tencent.mm.sdk.d.d;
import java.util.LinkedList;
import java.util.Queue;

public abstract class e<Task> extends d {
    final b jRR = new b(this, (byte) 0);
    private final a jRS = new a(this, (byte) 0);
    final String jRT;
    public final Queue<Task> jRU = new LinkedList();

    public abstract boolean afE();

    public abstract void bc(Task task);

    static /* synthetic */ void a(e eVar) {
        synchronized (eVar.jRU) {
            Object poll = eVar.jRU.poll();
        }
        if (poll != null) {
            eVar.b(eVar.jRS);
            eVar.bc(poll);
        }
    }

    public e(String str, Looper looper) {
        super(str, looper);
        this.jRT = str;
        a(this.jRR);
        a(this.jRS);
        b(this.jRR);
        start();
    }

    protected final void ZF() {
        super.ZF();
        synchronized (this.jRU) {
            this.jRU.clear();
        }
    }
}
