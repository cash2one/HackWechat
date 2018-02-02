package com.tencent.mm.plugin.appbrand.report;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.bh;

final class f$a extends d {
    private long jHj;
    final /* synthetic */ f jHk;

    private f$a(f fVar) {
        this.jHk = fVar;
    }

    public final String getName() {
        return this.jHk.mName + "|Background";
    }

    public final boolean j(Message message) {
        if (2 != message.what) {
            return super.j(message);
        }
        this.jHk.b(this.jHk.jHg);
        return true;
    }

    public final void enter() {
        super.enter();
        this.jHj = bh.Wp();
    }

    public final void exit() {
        super.exit();
        this.jHk.jHd = bh.Wp() - this.jHj;
    }
}
