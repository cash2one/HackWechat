package com.tencent.mm.plugin.talkroom;

import com.tencent.mm.g.a.rh;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class Plugin$a extends c<rh> {
    final /* synthetic */ Plugin saq;

    private Plugin$a(Plugin plugin) {
        this.saq = plugin;
        this.xen = rh.class.getName().hashCode();
    }

    /* synthetic */ Plugin$a(Plugin plugin, byte b) {
        this(plugin);
        this.xen = rh.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        rh rhVar = (rh) bVar;
        if (!(rhVar instanceof rh)) {
            x.f("MicroMsg.TalkRoomReportMgrListener", "mismatch %s", rhVar.getClass().getName());
        } else if (rhVar.fJa.fJb) {
            com.tencent.mm.plugin.talkroom.model.b.bEF().sbv = 1;
            return true;
        }
        return false;
    }
}
