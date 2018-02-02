package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

class DanmuView$3 implements Runnable {
    final /* synthetic */ DanmuView jum;
    final /* synthetic */ d jun;

    public DanmuView$3(DanmuView danmuView, d dVar) {
        this.jum = danmuView;
        this.jun = dVar;
    }

    public final void run() {
        synchronized (DanmuView.a(this.jum)) {
            for (int i = 0; i < DanmuView.a(this.jum).size(); i++) {
                if (this.jun.ahq() <= ((d) DanmuView.a(this.jum).get(i)).ahq()) {
                    DanmuView.a(this.jum).add(i, this.jun);
                    break;
                }
            }
        }
    }
}
