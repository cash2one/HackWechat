package com.tencent.b.a.a;

import android.content.Context;

public abstract class q {
    protected Context context = null;

    protected abstract void a(a aVar);

    protected abstract boolean sG();

    protected abstract String sH();

    protected abstract a sI();

    protected abstract void write(String str);

    protected q(Context context) {
        this.context = context;
    }

    public final g sP() {
        String decode;
        if (sG()) {
            decode = s.decode(sH());
        } else {
            decode = null;
        }
        if (decode != null) {
            return g.bI(decode);
        }
        return null;
    }

    public final void b(g gVar) {
        if (gVar != null) {
            String gVar2 = gVar.toString();
            if (sG()) {
                write(s.encode(gVar2));
            }
        }
    }

    public final a sQ() {
        if (sG()) {
            return sI();
        }
        return null;
    }

    public final void b(a aVar) {
        if (aVar != null && sG()) {
            a(aVar);
        }
    }
}
