package com.tencent.mm.plugin.emoji.a.a;

import java.util.Iterator;

class c$a implements Iterator<f> {
    final /* synthetic */ c luL;
    private int mIndex;

    private c$a(c cVar) {
        this.luL = cVar;
        this.mIndex = 0;
    }

    public final /* synthetic */ Object next() {
        c cVar = this.luL;
        int i = this.mIndex;
        this.mIndex = i + 1;
        return cVar.oJ(i);
    }

    public final boolean hasNext() {
        return this.mIndex < this.luL.size();
    }

    public final void remove() {
    }
}
