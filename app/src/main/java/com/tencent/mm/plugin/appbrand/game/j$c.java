package com.tencent.mm.plugin.appbrand.game;

import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.game.e.c;

class j$c extends c {
    String iXA;
    b iXB;

    private j$c() {
    }

    protected final void execute() {
        this.iXB.evaluateJavascript(this.iXA, null);
    }
}
