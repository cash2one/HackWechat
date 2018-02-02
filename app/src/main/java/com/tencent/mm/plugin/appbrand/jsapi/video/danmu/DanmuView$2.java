package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

class DanmuView$2 implements Runnable {
    final /* synthetic */ DanmuView jum;

    DanmuView$2(DanmuView danmuView) {
        this.jum = danmuView;
    }

    public final void run() {
        DanmuView.a(this.jum, false);
        this.jum.invalidate();
    }
}
