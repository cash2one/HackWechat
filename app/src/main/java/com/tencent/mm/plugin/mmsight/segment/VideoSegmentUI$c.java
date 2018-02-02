package com.tencent.mm.plugin.mmsight.segment;

import java.lang.ref.WeakReference;

class VideoSegmentUI$c implements Runnable {
    private int hOr;
    private WeakReference<c> hkd;
    private int oAh;

    public VideoSegmentUI$c(c cVar, int i, int i2) {
        this.hkd = new WeakReference(cVar);
        this.oAh = i;
        this.hOr = i2;
    }

    public final void run() {
        c cVar = (c) this.hkd.get();
        if (cVar != null) {
            cVar.al(((float) this.oAh) / ((float) this.hOr));
        }
    }
}
