package com.tencent.mm.plugin.appbrand.q;

import android.os.Message;
import com.tencent.mm.plugin.appbrand.report.d;

final class e$b extends d {
    final /* synthetic */ e jRV;

    private e$b(e eVar) {
        this.jRV = eVar;
    }

    public final void enter() {
        super.enter();
        e.a(this.jRV);
    }

    public final boolean j(Message message) {
        if (1 != message.what && 2 != message.what) {
            return super.j(message);
        }
        e.a(this.jRV);
        return true;
    }

    public final String getName() {
        return this.jRV.jRT + "|StateIdle";
    }
}
