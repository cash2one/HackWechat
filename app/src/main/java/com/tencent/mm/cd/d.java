package com.tencent.mm.cd;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.vending.h.a;

public final class d implements a {
    private af mHandler;

    public d(af afVar) {
        this.mHandler = afVar;
    }

    public static d c(af afVar) {
        return new d(afVar);
    }

    public final void i(Runnable runnable) {
        this.mHandler.post(runnable);
    }

    public final void j(Runnable runnable, long j) {
        this.mHandler.postDelayed(runnable, j);
    }

    public final Looper getLooper() {
        return this.mHandler.getLooper();
    }

    public final void cn() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
