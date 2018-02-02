package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.b.a.u;
import com.tencent.mm.sdk.platformtools.ak.a;

class a$7 implements a {
    final /* synthetic */ a mMS;
    private int mMT = 0;

    a$7(a aVar) {
        this.mMS = aVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean uF() {
        PluginFTS pluginFTS = (PluginFTS) g.k(PluginFTS.class);
        byte b = (pluginFTS.isCharging() || !pluginFTS.isInBackground()) ? true : (byte) 0;
        if (b == (byte) 0) {
            int i = this.mMT + 1;
            this.mMT = i;
        }
        a.e(this.mMS).a(131093, new u(this.mMS, (byte) 0));
        this.mMT = 0;
        return true;
    }

    public final String toString() {
        return super.toString() + "|delayIndexTimer";
    }
}
