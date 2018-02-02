package com.tencent.mm.plugin.talkroom.component;

import com.tencent.mm.sdk.platformtools.bc;

class g$7 extends bc<e> {
    final /* synthetic */ c saF;
    final /* synthetic */ g sav;

    g$7(g gVar, c cVar) {
        this.sav = gVar;
        this.saF = cVar;
        super(3000, null);
    }

    protected final /* synthetic */ Object run() {
        return new h(g.a(this.sav), this.saF);
    }
}
