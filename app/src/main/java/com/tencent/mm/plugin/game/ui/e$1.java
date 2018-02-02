package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.sdk.platformtools.ak.a;

class e$1 implements a {
    final /* synthetic */ e nlA;

    e$1(e eVar) {
        this.nlA = eVar;
    }

    public final boolean uF() {
        if (e.a(this.nlA) != null) {
            e.a(this.nlA).cancel();
        }
        return true;
    }
}
