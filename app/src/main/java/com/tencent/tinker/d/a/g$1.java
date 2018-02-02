package com.tencent.tinker.d.a;

import java.util.Enumeration;
import java.util.Iterator;

class g$1 implements Enumeration<f> {
    final /* synthetic */ g Ami;
    final /* synthetic */ Iterator abx;

    public g$1(g gVar, Iterator it) {
        this.Ami = gVar;
        this.abx = it;
    }

    public final /* synthetic */ Object nextElement() {
        g.a(this.Ami);
        return (f) this.abx.next();
    }

    public final boolean hasMoreElements() {
        g.a(this.Ami);
        return this.abx.hasNext();
    }
}
