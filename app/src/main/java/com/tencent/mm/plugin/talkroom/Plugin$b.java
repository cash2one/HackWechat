package com.tencent.mm.plugin.talkroom;

import com.tencent.mm.g.a.ri;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class Plugin$b extends c<ri> {
    private Plugin$b() {
        this.xen = ri.class.getName().hashCode();
    }

    /* synthetic */ Plugin$b(byte b) {
        this();
        this.xen = ri.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ri riVar = (ri) bVar;
        if (riVar != null) {
            if (!(riVar instanceof ri)) {
                x.f("MicroMsg.TalkRoomServerListener", "mismatch %s", riVar.getClass().getName());
            } else if (riVar.fJc.fJf) {
                com.tencent.mm.plugin.talkroom.model.b.bEC().aWa();
                return true;
            } else if (!(!riVar.fJc.fJe || riVar.fJd == null || com.tencent.mm.plugin.talkroom.model.b.bEC() == null)) {
                riVar.fJd.fJg = com.tencent.mm.plugin.talkroom.model.b.bEC().sbR;
                return true;
            }
        }
        return false;
    }
}
