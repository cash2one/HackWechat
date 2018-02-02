package com.google.android.gms.c;

import com.google.android.gms.common.internal.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ag<T extends ag> {
    public final ah aYj;
    protected final ae aYk;
    private final List<Object> aYl = new ArrayList();

    public ag(ah ahVar, v vVar) {
        w.ag(ahVar);
        this.aYj = ahVar;
        ae aeVar = new ae(this, vVar);
        aeVar.aYg = true;
        this.aYk = aeVar;
    }

    public void a(ae aeVar) {
    }

    public ae nK() {
        ae pN = this.aYk.pN();
        pQ();
        return pN;
    }

    public final ae pO() {
        return this.aYk;
    }

    public final List<ai> pP() {
        return this.aYk.aYi;
    }

    public final void pQ() {
        Iterator it = this.aYl.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }
}
