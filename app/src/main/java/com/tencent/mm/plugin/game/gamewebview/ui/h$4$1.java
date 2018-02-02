package com.tencent.mm.plugin.game.gamewebview.ui;

import com.tencent.mm.plugin.game.gamewebview.ui.h.4;
import com.tencent.mm.pluginsdk.ui.tools.s.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class h$4$1 implements b {
    final /* synthetic */ 4 nab;

    h$4$1(4 4) {
        this.nab = 4;
    }

    public final void sS(String str) {
        if (bh.ov(str)) {
            x.w("MicroMsg.GameWebViewMenuListHelper", "share image to friend fail, imgPath is null");
        } else {
            h.a(this.nab.mZZ, str);
        }
    }
}
