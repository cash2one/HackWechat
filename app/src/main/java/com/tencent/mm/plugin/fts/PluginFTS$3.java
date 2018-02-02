package com.tencent.mm.plugin.fts;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bv.a;

class PluginFTS$3 implements a {
    final /* synthetic */ PluginFTS mJM;

    PluginFTS$3(PluginFTS pluginFTS) {
        this.mJM = pluginFTS;
    }

    public final boolean If() {
        x.w("MicroMsg.FTS.PluginFTS", "HERE UninitForUEH is called! stg:%s ", new Object[]{PluginFTS.access$200(this.mJM)});
        PluginFTS.mJC = true;
        if (PluginFTS.access$200(this.mJM) != null) {
            PluginFTS.access$200(this.mJM).rollback();
            PluginFTS.access$200(this.mJM).close();
        }
        return true;
    }
}
