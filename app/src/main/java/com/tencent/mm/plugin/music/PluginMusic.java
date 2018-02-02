package com.tencent.mm.plugin.music;

import com.tencent.mm.av.a.a;
import com.tencent.mm.av.a.b;
import com.tencent.mm.av.e;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;

public class PluginMusic extends f implements b {
    public void configure(g gVar) {
        if (gVar.DS()) {
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.a(a.class, new e());
        }
    }

    public void execute(g gVar) {
    }
}
