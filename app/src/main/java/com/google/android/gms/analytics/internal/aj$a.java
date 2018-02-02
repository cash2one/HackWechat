package com.google.android.gms.analytics.internal;

import com.google.android.gms.c.j;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.w;

public final class aj$a<V> {
    private final V aIj;
    private final j<V> aIk;
    private V aIl;

    aj$a(j<V> jVar, V v) {
        w.ag(jVar);
        this.aIk = jVar;
        this.aIj = v;
    }

    static aj$a<String> a(String str, String str2, String str3) {
        return new aj$a(j.n(str, str3), str2);
    }

    static aj$a<Integer> b(String str, int i, int i2) {
        return new aj$a(j.a(str, Integer.valueOf(i2)), Integer.valueOf(i));
    }

    static aj$a<Long> c(String str, long j, long j2) {
        return new aj$a(j.a(str, Long.valueOf(j2)), Long.valueOf(j));
    }

    static aj$a<Boolean> f(String str, boolean z) {
        return new aj$a(j.h(str, z), Boolean.valueOf(z));
    }

    public final V get() {
        return this.aIl != null ? this.aIl : (f.aNs && j.isInitialized()) ? this.aIk.pz() : this.aIj;
    }
}
