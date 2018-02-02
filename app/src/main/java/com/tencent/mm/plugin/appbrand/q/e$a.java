package com.tencent.mm.plugin.appbrand.q;

import android.os.Message;
import com.tencent.mm.plugin.appbrand.report.d;

final class e$a extends d {
    final /* synthetic */ e jRV;

    private e$a(e eVar) {
        this.jRV = eVar;
    }

    public final boolean j(Message message) {
        if (2 != message.what) {
            return super.j(message);
        }
        this.jRV.b(this.jRV.jRR);
        return true;
    }

    public final String getName() {
        return this.jRV.jRT + "|StateExecuting";
    }
}
