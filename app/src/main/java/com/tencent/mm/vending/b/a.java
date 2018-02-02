package com.tencent.mm.vending.b;

import com.tencent.mm.vending.h.d;
import com.tencent.mm.vending.h.f;
import com.tencent.mm.vending.h.g;
import java.util.LinkedList;
import junit.framework.Assert;

public abstract class a<_Callback> {
    protected d ffh;
    private LinkedList<b> zBK;
    public f zBL;

    public a() {
        this(g.czY());
    }

    public a(d dVar) {
        this.zBK = new LinkedList();
        Assert.assertNotNull(dVar);
        this.ffh = dVar;
        this.zBL = new f(dVar, null);
    }

    public final synchronized b a(b bVar) {
        this.zBK.add(bVar);
        return bVar;
    }

    public final synchronized void b(b bVar) {
        if (bVar != null) {
            this.zBK.remove(bVar);
        }
    }

    public final synchronized LinkedList<b> czM() {
        return new LinkedList(this.zBK);
    }

    public final synchronized int size() {
        return this.zBK.size();
    }

    public final synchronized boolean contains(_Callback _Callback) {
        return this.zBK.contains(new b(_Callback, this));
    }
}
