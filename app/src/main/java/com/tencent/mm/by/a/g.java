package com.tencent.mm.by.a;

import android.util.SparseArray;
import java.util.ArrayList;

public abstract class g<K, T extends a> {
    public d xCa;

    public abstract ArrayList<T> ah(ArrayList<Object> arrayList);

    public abstract T ckZ();

    public g(d dVar, int i) {
        this.xCa = dVar;
        this.xCa.lJ(true);
        this.xCa.a(new 1(this));
        if (i != 0) {
            this.xCa.DD(i);
        }
        getCount();
    }

    public final void close() {
        this.xCa.close();
        this.xCa = null;
    }

    public final int getCount() {
        return this.xCa.getCount();
    }

    public final boolean isClosed() {
        return this.xCa.isClosed();
    }

    public final boolean ckP() {
        return this.xCa.ckP();
    }

    public final void c(Object obj, T t) {
        this.xCa.a(obj, t);
    }

    public final SparseArray<K>[] ckN() {
        return this.xCa.ckN();
    }

    public final boolean cd(Object obj) {
        return this.xCa.cd(obj);
    }
}
