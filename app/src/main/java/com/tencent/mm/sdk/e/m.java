package com.tencent.mm.sdk.e;

import android.os.Looper;

public abstract class m implements g {
    private final k<b, a> xjE = new k<b, a>(this) {
        final /* synthetic */ m xjO;

        {
            this.xjO = r1;
        }

        protected final /* synthetic */ void p(Object obj, Object obj2) {
            b bVar = (b) obj;
            a aVar = (a) obj2;
            if (this.xjO.NE()) {
                bVar.a(aVar.fvZ, aVar.xjP, aVar.obj);
            }
        }
    };

    private class a {
        int fvZ;
        Object obj;
        final /* synthetic */ m xjO;
        m xjP;

        a(m mVar, int i, m mVar2, Object obj) {
            this.xjO = mVar;
            this.fvZ = i;
            this.obj = obj;
            this.xjP = mVar2;
        }
    }

    public interface b {
        void a(int i, m mVar, Object obj);
    }

    public abstract boolean NE();

    public final void a(b bVar) {
        if (bVar != null) {
            this.xjE.a(bVar, Looper.getMainLooper());
        }
    }

    public final void b(b bVar) {
        if (bVar != null) {
            this.xjE.remove(bVar);
        }
    }

    public final void b(int i, m mVar, Object obj) {
        this.xjE.ca(new a(this, i, mVar, obj));
        this.xjE.doNotify();
    }
}
