package com.tencent.mm.plugin.webview.fts.topstory.a;

import com.tencent.mm.modelcdntran.j.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class e$b implements a {
    final /* synthetic */ e tnX;

    private e$b(e eVar) {
        this.tnX = eVar;
    }

    public final void onMoovReady(String str, int i, int i2) {
        ag.y(new 1(this, str, i, i2));
    }

    public final void onDataAvailable(final String str, final int i, final int i2) {
        ag.y(new Runnable(this) {
            final /* synthetic */ e$b tnZ;

            public final void run() {
                if (e.c(this.tnZ.tnX) != null && e.c(this.tnZ.tnX, str)) {
                    e.c(this.tnZ.tnX).onDataAvailable(str, i, i2);
                }
            }
        });
    }

    public final void g(String str, int i, int i2) {
        ag.y(new 3(this, str, i, i2));
    }

    public final void K(String str, int i) {
        x.i("MicroMsg.WebSearch.TopStoryVideoPreloadMgr", "onFinish %s %d", new Object[]{str, Integer.valueOf(i)});
        ag.y(new 4(this, str, i));
        if (i != 0) {
            g.pQN.h(791, 9);
        }
    }
}
