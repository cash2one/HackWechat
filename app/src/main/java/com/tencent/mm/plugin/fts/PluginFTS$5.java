package com.tencent.mm.plugin.fts;

import com.tencent.mm.g.a.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class PluginFTS$5 extends c<e> {
    final /* synthetic */ PluginFTS mJM;

    PluginFTS$5(PluginFTS pluginFTS) {
        this.mJM = pluginFTS;
        this.xen = e.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        e eVar = (e) bVar;
        f access$500 = PluginFTS.access$500(this.mJM);
        boolean z = eVar.fmQ.fmR;
        if (access$500.mJj != null) {
            access$500.mJj.fo(z);
        }
        PluginFTS.access$1302(this.mJM, !eVar.fmQ.fmR);
        return false;
    }
}
