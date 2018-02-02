package com.tencent.mm.plugin.game.gamewebview.ui;

import com.tencent.mm.sdk.platformtools.bc;

class d$19 extends bc<String> {
    final /* synthetic */ d mZC;

    d$19(d dVar, String str) {
        this.mZC = dVar;
        super(1000, str);
    }

    protected final /* synthetic */ Object run() {
        return d.n(this.mZC) == null ? "" : d.n(this.mZC).getTitle();
    }
}
