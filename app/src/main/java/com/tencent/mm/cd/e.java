package com.tencent.mm.cd;

import com.tencent.mm.vending.h.d;

public final class e extends d {
    public final void f(Runnable runnable) {
        runnable.run();
    }

    public final void f(Runnable runnable, long j) {
        runnable.run();
    }

    public final String getType() {
        return "WxNoLooperScheduler";
    }

    public final void cancel() {
    }
}
