package com.tencent.mm.plugin.webview.fts.topstory.ui;

import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.webview.fts.topstory.a.d;
import com.tencent.mm.plugin.webview.fts.topstory.ui.widget.a;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.sdk.platformtools.x;

class f$15 implements b {
    final /* synthetic */ f tpL;

    f$15(f fVar) {
        this.tpL = fVar;
    }

    public final void c(String str, String str2, String str3, int i, int i2) {
        int i3 = 0;
        x.e("MicroMsg.WebSearch.TopStoryVideoViewContainer", "onError errorMsg=%s what=%d extra=%d", new Object[]{str3, Integer.valueOf(i), Integer.valueOf(i2)});
        this.tpL.eJ(this.tpL.getContext().getString(R.l.eSV, new Object[]{i + ":" + i2}), this.tpL.getContext().getString(R.l.eTp));
        d.Ac(i);
        if (d.tnO != null && d.tnO.sep > 0) {
            i3 = ((int) (System.currentTimeMillis() - d.tnO.sep)) / 1000;
        }
        d.a(f.e(this.tpL), i, str3, i3);
    }

    public final void bk(String str, String str2) {
        x.i("MicroMsg.WebSearch.TopStoryVideoViewContainer", "onPrepared");
        a h = f.h(this.tpL);
        h.jtA = -1;
        h.jtB = 0;
        h.jtz = 0.0f;
        f.f(this.tpL).kn(f.i(this.tpL));
        if (!f.i(this.tpL)) {
            this.tpL.bPO();
        }
    }

    public final void bl(String str, String str2) {
        x.i("MicroMsg.WebSearch.TopStoryVideoViewContainer", "onVideoEnded");
        g bQd = g.bQd();
        if (bQd.tpX != null && bQd.tpX.fqu.equals(str)) {
            if (d.tnO != null) {
                d.tnO.ses = 1;
            }
            bQd.stopPlay();
        }
        if (!((com.tencent.mm.plugin.topstory.a.a) g.h(com.tencent.mm.plugin.topstory.a.a.class)).aCc()) {
            this.tpL.bPR();
        } else if (d.bPB().nbV) {
            this.tpL.bPV();
        } else {
            d.tnP = 1;
            f.d(this.tpL).Ad(f.c(this.tpL) + 1);
        }
        f.f(this.tpL).setVisibility(8);
        f.b(this.tpL, false);
    }

    public final void d(String str, String str2, int i, int i2) {
        x.i("MicroMsg.WebSearch.TopStoryVideoViewContainer", "onGetVideoSize width=%d height=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (f.j(this.tpL) == f.a.tpM) {
            f.a(this.tpL, i < i2 ? f.a.tpO : f.a.tpN);
            x.i("MicroMsg.WebSearch.TopStoryVideoViewContainer", "onGetVideoSize adjust direction from AUTO to %s", new Object[]{f.j(this.tpL)});
        }
    }

    public final void bm(String str, String str2) {
    }

    public final void bn(String str, String str2) {
    }

    public final void bo(String str, String str2) {
        x.i("MicroMsg.WebSearch.TopStoryVideoViewContainer", "onVideoWaiting");
        this.tpL.bPT();
        f.b(this.tpL, true);
    }

    public final void bp(String str, String str2) {
        x.i("MicroMsg.WebSearch.TopStoryVideoViewContainer", "onVideoWaitingEnd");
        f.b(this.tpL, false);
        f.f(this.tpL).bQr();
        this.tpL.bPO();
    }
}
