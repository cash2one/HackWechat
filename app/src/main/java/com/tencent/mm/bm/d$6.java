package com.tencent.mm.bm;

import com.tencent.mm.sdk.platformtools.x;

class d$6 implements b {
    final /* synthetic */ String vzO;

    d$6(String str) {
        this.vzO = str;
    }

    public final void c(Exception exception) {
        x.e("MicroMsg.PluginHelper", "start wizard activity failed, plugin(%s) not loaded", new Object[]{this.vzO});
        x.e("MicroMsg.PluginHelper", "start wizard activity with exception:%s", new Object[]{exception});
    }
}
