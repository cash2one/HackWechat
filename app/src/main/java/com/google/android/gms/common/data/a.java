package com.google.android.gms.common.data;

import java.util.Iterator;

public abstract class a<T> implements b<T> {
    public final DataHolder aMc;

    protected a(DataHolder dataHolder) {
        this.aMc = dataHolder;
        if (this.aMc != null) {
            this.aMc.aMo = this;
        }
    }

    public int getCount() {
        return this.aMc == null ? 0 : this.aMc.aMn;
    }

    public Iterator<T> iterator() {
        return new e(this);
    }

    public final void release() {
        if (this.aMc != null) {
            this.aMc.close();
        }
    }
}
