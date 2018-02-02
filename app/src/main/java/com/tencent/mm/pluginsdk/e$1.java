package com.tencent.mm.pluginsdk;

import com.tencent.mm.compatible.util.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

class e$1 implements Runnable {
    final /* synthetic */ MMActivity jvm;

    e$1(MMActivity mMActivity) {
        this.jvm = mMActivity;
    }

    public final void run() {
        this.jvm.getWindow().getDecorView().setSystemUiVisibility(this.jvm.getWindow().getDecorView().getSystemUiVisibility() | 256);
        x.i("MicroMsg.FullScreenHelper", "setFullScreenAfterSetContentView to bodyView, height: %d, %d", Integer.valueOf(a.g(this.jvm)), Integer.valueOf(com.tencent.mm.bv.a.fromDPToPix(this.jvm, 2)));
        this.jvm.mController.xIy.setPadding(0, r0 - com.tencent.mm.bv.a.fromDPToPix(this.jvm, 2), 0, 0);
    }
}
