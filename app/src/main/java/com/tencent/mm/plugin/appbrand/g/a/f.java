package com.tencent.mm.plugin.appbrand.g.a;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.utils.MemoryManager;
import com.tencent.mm.compatible.util.k;
import java.util.LinkedList;

public class f {
    private final a jvY;
    final V8 jwm;
    private final MemoryManager jwn;
    public final h jwo;
    private final LinkedList<b> jwp;

    class AnonymousClass4 implements Runnable {
        final /* synthetic */ String iTQ;
        final /* synthetic */ f jwq;
        final /* synthetic */ a jwr = null;
        final /* synthetic */ String jws;

        AnonymousClass4(f fVar, a aVar, String str, String str2) {
            this.jwq = fVar;
            this.iTQ = str;
            this.jws = str2;
        }

        public final void run() {
            if (this.jwr != null) {
                this.jwq.jwm.executeScript(this.iTQ, this.jws, 0).toString();
            } else {
                this.jwq.jwm.executeVoidScript(this.iTQ, this.jws, 0);
            }
        }
    }

    static {
        k.b("mmv8", f.class.getClassLoader());
        k.b("j2v8", f.class.getClassLoader());
    }

    public f() {
        this(null);
    }

    f(a aVar) {
        this.jwp = new LinkedList();
        this.jwm = V8.createV8Runtime();
        this.jwn = new MemoryManager(this.jwm);
        this.jwo = new h(this.jwm);
        if (aVar == null) {
            aVar = new g();
        }
        this.jvY = aVar;
        this.jwo.p(new 1(this));
        this.jwo.p(new 2(this));
    }
}
