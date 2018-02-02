package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.ViewConfiguration;
import com.tencent.mm.sdk.platformtools.x;

class ac$1 implements Runnable {
    final /* synthetic */ ac jZv;

    ac$1(ac acVar) {
        this.jZv = acVar;
    }

    public final void run() {
        this.jZv.jZs = true;
        x.v(this.jZv.TAG, "[apptouch] pendingCheckForTap run, pointerDown TRUE");
        this.jZv.jZo.postDelayed(this.jZv.jZu, (long) ViewConfiguration.getLongPressTimeout());
    }
}
