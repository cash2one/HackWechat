package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.game.a.3;

class a$3$2 implements Runnable {
    final /* synthetic */ Bundle tAS;
    final /* synthetic */ 3 tFp;

    a$3$2(3 3, Bundle bundle) {
        this.tFp = 3;
        this.tAS = bundle;
    }

    public final void run() {
        this.tAS.putInt("height", this.tFp.tFo.tFg.bSH());
    }
}
