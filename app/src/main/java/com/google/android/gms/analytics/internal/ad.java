package com.google.android.gms.analytics.internal;

import com.google.android.gms.analytics.b;

final class ad implements b {
    private int aFH = 2;
    private boolean aHj;

    ad() {
    }

    public final int getLogLevel() {
        return this.aFH;
    }

    public final void setLogLevel(int i) {
        this.aFH = i;
        if (!this.aHj) {
            aj.aHu.get();
            new StringBuilder("Logger is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag.").append((String) aj.aHu.get()).append(" DEBUG");
            this.aHj = true;
        }
    }
}
