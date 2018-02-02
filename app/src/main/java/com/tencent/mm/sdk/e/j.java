package com.tencent.mm.sdk.e;

import android.os.Looper;

public abstract class j implements f {
    public final k<a, l> xjE = new k<a, l>(this) {
        final /* synthetic */ j xjG;

        {
            this.xjG = r1;
        }

        protected final /* synthetic */ void p(Object obj, Object obj2) {
            l lVar = (l) obj2;
            ((a) obj).a(lVar.fok, lVar);
        }
    };
    private final k<Object, String> xjF = new k<Object, String>(this) {
        final /* synthetic */ j xjG;

        {
            this.xjG = r1;
        }

        protected final /* bridge */ /* synthetic */ void p(Object obj, Object obj2) {
        }
    };

    public interface a {
        void a(String str, l lVar);
    }

    public void lock() {
        this.xjE.lock();
    }

    public void unlock() {
        this.xjE.unlock();
    }

    public void c(a aVar) {
        this.xjE.a(aVar, Looper.getMainLooper());
    }

    public void a(a aVar, Looper looper) {
        this.xjE.a(aVar, looper);
    }

    public final void j(a aVar) {
        this.xjE.remove(aVar);
    }

    public final void doNotify() {
        this.xjE.ca(new l("*"));
        this.xjE.doNotify();
    }

    public final void Wc(String str) {
        this.xjE.ca(new l(str));
        this.xjE.doNotify();
    }

    public void b(String str, int i, Object obj) {
        l lVar = new l();
        lVar.fok = str;
        lVar.iYZ = i;
        lVar.obj = obj;
        lVar.xjN = this;
        this.xjE.ca(lVar);
        this.xjE.doNotify();
    }
}
