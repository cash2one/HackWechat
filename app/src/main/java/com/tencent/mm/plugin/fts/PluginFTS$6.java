package com.tencent.mm.plugin.fts;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class PluginFTS$6 implements e {
    final /* synthetic */ PluginFTS mJM;

    PluginFTS$6(PluginFTS pluginFTS) {
        this.mJM = pluginFTS;
    }

    public final void a(int i, int i2, String str, k kVar) {
        g.Dk();
        if (bh.e((Integer) g.Dj().CU().get(15, null)) != 0) {
            g.CG().b(138, PluginFTS.access$1400(this.mJM));
            PluginFTS.access$1502(this.mJM, true);
            x.i("MicroMsg.FTS.PluginFTS", "*** User has finished initializing.");
            PluginFTS.access$1200(this.mJM);
        }
    }
}
