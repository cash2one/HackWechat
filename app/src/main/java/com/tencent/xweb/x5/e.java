package com.tencent.xweb.x5;

import android.content.Context;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.xweb.c.b.b;

public final class e implements b {
    CookieSyncManager ArJ;

    public final void init(Context context) {
        this.ArJ = CookieSyncManager.createInstance(context);
    }

    public final void sync() {
        if (this.ArJ != null) {
            this.ArJ.sync();
        }
    }
}
