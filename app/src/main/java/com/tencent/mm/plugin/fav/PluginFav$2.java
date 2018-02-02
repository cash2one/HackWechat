package com.tencent.mm.plugin.fav;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.b.b.a;

class PluginFav$2 implements Runnable {
    final /* synthetic */ PluginFav mnP;
    final /* synthetic */ a mnQ;

    PluginFav$2(PluginFav pluginFav, a aVar) {
        this.mnP = pluginFav;
        this.mnQ = aVar;
    }

    public final void run() {
        g.CG().a(this.mnQ, 0);
    }
}
