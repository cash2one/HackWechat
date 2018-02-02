package com.tencent.mm.plugin.webview.fts.ui;

import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.sdk.platformtools.x;

class FtsWebVideoView$4 implements b {
    final /* synthetic */ FtsWebVideoView trm;

    FtsWebVideoView$4(FtsWebVideoView ftsWebVideoView) {
        this.trm = ftsWebVideoView;
    }

    public final void agX() {
        x.i("MicroMsg.FtsWebVideoView", "onSeekPre");
        FtsWebVideoView.c(this.trm).bQq();
    }

    public final void kH(int i) {
        x.i("MicroMsg.FtsWebVideoView", "onSeekTo %d", new Object[]{Integer.valueOf(i)});
        this.trm.w(i, false);
        FtsWebVideoView.c(this.trm).bQr();
        if (FtsWebVideoView.h(this.trm) != null) {
            FtsWebVideoView.h(this.trm).bQy();
        }
    }
}
