package com.tencent.mm.bm;

import com.tencent.mm.sdk.platformtools.x;

class d$10 implements b {
    final /* synthetic */ String vzO;

    d$10(String str) {
        this.vzO = str;
    }

    public final void c(Exception exception) {
        x.f("MicroMsg.PluginHelper", "start activity failed, plugin(%s) not loaded", new Object[]{this.vzO});
        x.e("MicroMsg.PluginHelper", "start activity failed,%s", new Object[]{exception});
    }
}
