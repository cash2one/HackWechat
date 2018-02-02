package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import com.tencent.mm.sdk.platformtools.x;

class DanmuView$5 implements Runnable {
    final /* synthetic */ DanmuView jum;
    final /* synthetic */ int jup;

    public DanmuView$5(DanmuView danmuView, int i) {
        this.jum = danmuView;
        this.jup = i;
    }

    public final void run() {
        synchronized (DanmuView.b(this.jum)) {
            for (int size = DanmuView.a(this.jum).size() - 1; size >= 0; size--) {
                d dVar = (d) DanmuView.a(this.jum).get(size);
                if (dVar.ahq() < this.jup) {
                    break;
                }
                x.v("MicroMsg.DanmuView", "seekToPlayTime addBack i=%d showTime=%d", new Object[]{Integer.valueOf(size), Integer.valueOf(dVar.ahq())});
                DanmuView.b(this.jum).addFirst(dVar);
            }
        }
        DanmuView.c(this.jum);
    }
}
