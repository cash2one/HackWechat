package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import java.util.List;

class DanmuView$4 extends Thread {
    final /* synthetic */ DanmuView jum;
    final /* synthetic */ List juo;

    public DanmuView$4(DanmuView danmuView, List list) {
        this.jum = danmuView;
        this.juo = list;
    }

    public final void run() {
        synchronized (DanmuView.b(this.jum)) {
            DanmuView.b(this.jum).addAll(this.juo);
        }
        synchronized (DanmuView.a(this.jum)) {
            DanmuView.a(this.jum).addAll(this.juo);
        }
        this.jum.postInvalidate();
    }
}
