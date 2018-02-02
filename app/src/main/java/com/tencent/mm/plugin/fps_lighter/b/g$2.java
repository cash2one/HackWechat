package com.tencent.mm.plugin.fps_lighter.b;

import com.tencent.mm.g.a.ki;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class g$2 extends c<ki> {
    final /* synthetic */ g mBk;

    g$2(g gVar) {
        this.mBk = gVar;
        this.xen = ki.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ki kiVar = (ki) bVar;
        x.i("MicroMsg.SubCoreFPSLighter", "[NotifyFragmentChangeEvent] name:%s id:%s visible:%s", new Object[]{kiVar.fBF.name, Integer.valueOf(kiVar.fBF.id), Boolean.valueOf(kiVar.fBF.visible)});
        if (g.a(this.mBk) != null) {
            if (!kiVar.fBF.visible) {
                g.a(this.mBk).Av("FRAGMENT_UNKNOW");
            } else if (kiVar.fBF.id == 1) {
                g.a(this.mBk).Av("FRAGMENT_ADDRESS");
            } else if (kiVar.fBF.id == 0) {
                g.a(this.mBk).Av("FRAGMENT_MAINUI");
            } else if (kiVar.fBF.id == Integer.MAX_VALUE) {
                g.a(this.mBk).Av("FRAGMENT_CHATTING");
            } else {
                g.a(this.mBk).Av("FRAGMENT_UNKNOW");
            }
        }
        return true;
    }
}
