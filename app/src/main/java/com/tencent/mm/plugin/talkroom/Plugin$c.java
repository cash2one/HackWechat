package com.tencent.mm.plugin.talkroom;

import com.tencent.mm.g.a.rk;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class Plugin$c extends c<rk> {
    final /* synthetic */ Plugin saq;

    private Plugin$c(Plugin plugin) {
        this.saq = plugin;
        this.xen = rk.class.getName().hashCode();
    }

    /* synthetic */ Plugin$c(Plugin plugin, byte b) {
        this(plugin);
        this.xen = rk.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (!(((rk) bVar) instanceof rk)) {
            x.f("MicroMsg.TalkRoom.Plugin", "mismatch %s", new Object[]{((rk) bVar).getClass().getName()});
        }
        return false;
    }
}
