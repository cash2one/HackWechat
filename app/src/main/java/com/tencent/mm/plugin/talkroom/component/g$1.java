package com.tencent.mm.plugin.talkroom.component;

import com.tencent.mm.sdk.platformtools.bc;

class g$1 extends bc<Integer> {
    final /* synthetic */ g sav;

    g$1(g gVar, Integer num) {
        this.sav = gVar;
        super(3000, num);
    }

    protected final /* synthetic */ Object run() {
        return Integer.valueOf(g.a(this.sav).uninitLive());
    }
}
