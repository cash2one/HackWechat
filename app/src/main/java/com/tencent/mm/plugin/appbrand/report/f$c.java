package com.tencent.mm.plugin.appbrand.report;

import android.os.Message;

final class f$c extends d {
    final /* synthetic */ f jHk;

    private f$c(f fVar) {
        this.jHk = fVar;
    }

    public final String getName() {
        return this.jHk.mName + "|Init";
    }

    public final boolean j(Message message) {
        if (2 == message.what) {
            this.jHk.b(this.jHk.jHg);
            return true;
        } else if (1 != message.what) {
            return super.j(message);
        } else {
            this.jHk.b(this.jHk.jHh);
            return true;
        }
    }
}
