package com.google.android.gms.common.api;

import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.m.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

class m$f extends i {
    final /* synthetic */ m aLb;
    private final ArrayList<b> aLo;

    public m$f(m mVar, ArrayList<b> arrayList) {
        this.aLb = mVar;
        super(mVar, (byte) 0);
        this.aLo = arrayList;
    }

    public final void oj() {
        Set set = this.aLb.aKH.aLz;
        Set or = set.isEmpty() ? this.aLb.or() : set;
        Iterator it = this.aLo.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(this.aLb.aKV, or);
        }
    }
}
