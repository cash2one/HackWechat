package com.tencent.mm.plugin.webview.fts.topstory.ui;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.sdk.platformtools.x;

class f$4 implements b {
    final /* synthetic */ f tpL;

    f$4(f fVar) {
        this.tpL = fVar;
    }

    public final void agX() {
        x.i("MicroMsg.WebSearch.TopStoryVideoViewContainer", "onSeekPre");
        f.f(this.tpL).bQq();
    }

    public final void kH(int i) {
        x.i("MicroMsg.WebSearch.TopStoryVideoViewContainer", "onSeekTo %d", new Object[]{Integer.valueOf(i)});
        f.seekTo(i);
        f.f(this.tpL).bQr();
        g.pQN.h(791, 22);
    }
}
