package com.tencent.xweb.sys;

import android.content.Context;
import android.webkit.CookieSyncManager;

public final class b implements com.tencent.xweb.c.b.b {
    CookieSyncManager Arb;

    public final void init(Context context) {
        this.Arb = CookieSyncManager.createInstance(context);
    }

    public final void sync() {
        if (this.Arb != null) {
            this.Arb.sync();
        }
    }
}
