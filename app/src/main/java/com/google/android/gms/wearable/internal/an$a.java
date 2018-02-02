package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.k.b;

abstract class an$a<T> extends a {
    private b<T> beT;

    public an$a(b<T> bVar) {
        this.beT = bVar;
    }

    public final void ap(T t) {
        b bVar = this.beT;
        if (bVar != null) {
            bVar.ac(t);
            this.beT = null;
        }
    }
}
