package com.tencent.mm.plugin.freewifi.model;

import android.os.HandlerThread;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;

public final class c {
    private HandlerThread mEb;
    private af mEc;

    public final af aLz() {
        if (this.mEb == null) {
            this.mEb = e.Wf("FreeWifiHandlerThread_handlerThread");
            this.mEb.start();
        }
        if (this.mEc == null) {
            this.mEc = new af(this.mEb.getLooper());
        }
        return this.mEc;
    }

    public final void release() {
        if (this.mEb != null) {
            this.mEb.quit();
            this.mEb = null;
        }
        this.mEc = null;
    }
}
