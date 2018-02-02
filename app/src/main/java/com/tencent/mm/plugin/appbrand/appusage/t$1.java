package com.tencent.mm.plugin.appbrand.appusage;

import android.database.Cursor;
import java.util.Iterator;

class t$1 implements Iterator<Object[]> {
    boolean iKo;
    final Object[] iKp = new Object[3];
    final /* synthetic */ Cursor iKq;
    final /* synthetic */ t iKr;

    t$1(t tVar, Cursor cursor) {
        this.iKr = tVar;
        this.iKq = cursor;
    }

    public final /* synthetic */ Object next() {
        this.iKp[0] = this.iKq.getString(0);
        this.iKp[1] = Integer.valueOf(this.iKq.getInt(1));
        this.iKp[2] = Integer.valueOf(0);
        return this.iKp;
    }

    public final boolean hasNext() {
        if (this.iKo) {
            boolean moveToNext = this.iKq.moveToNext();
            if (moveToNext) {
                return moveToNext;
            }
            this.iKq.close();
            return moveToNext;
        }
        this.iKo = true;
        return this.iKq.moveToFirst();
    }

    public final void remove() {
    }
}
