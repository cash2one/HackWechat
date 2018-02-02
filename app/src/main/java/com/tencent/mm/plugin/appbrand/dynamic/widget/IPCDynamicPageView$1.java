package com.tencent.mm.plugin.appbrand.dynamic.widget;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.rtmp.TXLiveConstants;

class IPCDynamicPageView$1 implements Runnable {
    final /* synthetic */ IPCDynamicPageView iVu;

    IPCDynamicPageView$1(IPCDynamicPageView iPCDynamicPageView) {
        this.iVu = iPCDynamicPageView;
    }

    public final void run() {
        int i = 1;
        if (!IPCDynamicPageView.a(this.iVu)) {
            IPCDynamicPageView.a(this.iVu, true);
            IPCDynamicPageView.b(this.iVu);
            long currentTimeMillis = System.currentTimeMillis() - IPCDynamicPageView.c(this.iVu);
            if (currentTimeMillis <= 1000) {
                i = 0;
            } else if (currentTimeMillis > 2000) {
                i = currentTimeMillis <= 3000 ? 2 : currentTimeMillis <= 4000 ? 3 : currentTimeMillis <= 5000 ? 4 : currentTimeMillis <= 6000 ? 5 : currentTimeMillis <= 7000 ? 6 : currentTimeMillis <= 8000 ? 7 : currentTimeMillis <= 9000 ? 8 : currentTimeMillis <= 10000 ? 9 : 10;
            }
            g.pQN.a(645, (long) i, 1, false);
            this.iVu.jZ(TXLiveConstants.PLAY_WARNING_VIDEO_DISCONTINUITY);
        }
        IPCDynamicPageView.a(this.iVu, System.currentTimeMillis());
        IPCDynamicPageView.d(this.iVu).abh();
    }
}
