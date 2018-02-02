package com.tencent.mm.plugin.webview.fts.c;

import com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements a {
    final /* synthetic */ FtsWebVideoView trG;
    final /* synthetic */ b trH;

    b$1(b bVar, FtsWebVideoView ftsWebVideoView) {
        this.trH = bVar;
        this.trG = ftsWebVideoView;
    }

    public final void agt() {
        FtsWebVideoView ftsWebVideoView = this.trG;
        x.i("MicroMsg.FtsWebVideoView", "onExitFullScreen");
        if (ftsWebVideoView.tqS.jsY) {
            ftsWebVideoView.tqS.ags();
        }
        ftsWebVideoView.cZ(false);
    }
}
