package com.google.android.gms.analytics.internal;

import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.w;

public final class i$a {
    final long aFB;
    final /* synthetic */ i aFC;
    private final String mName;

    private i$a(i iVar, String str, long j) {
        this.aFC = iVar;
        w.aM(str);
        w.as(j > 0);
        this.mName = str;
        this.aFB = j;
    }

    private String mz() {
        return this.mName + ":start";
    }

    String mA() {
        return this.mName + ":count";
    }

    String mB() {
        return this.mName + ":value";
    }

    void mx() {
        long currentTimeMillis = this.aFC.aFo.aFD.currentTimeMillis();
        Editor edit = this.aFC.aFx.edit();
        edit.remove(mA());
        edit.remove(mB());
        edit.putLong(mz(), currentTimeMillis);
        edit.commit();
    }

    long my() {
        return this.aFC.aFx.getLong(mz(), 0);
    }
}
