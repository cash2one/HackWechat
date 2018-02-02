package com.tencent.mm.plugin.appbrand.b;

import android.os.Message;
import com.tencent.mm.plugin.appbrand.g.a.f;
import com.tencent.mm.plugin.appbrand.g.a.h;
import com.tencent.mm.plugin.appbrand.g.g;
import com.tencent.mm.sdk.platformtools.x;

final class c$e extends g {
    final /* synthetic */ c iHj;

    c$e(c cVar, h hVar) {
        this.iHj = cVar;
        super(hVar);
    }

    public final String getName() {
        return this.iHj.mName + "|Suspend";
    }

    public final void enter() {
        super.enter();
        this.iHj.xiR.sendEmptyMessageDelayed(11, ((long) this.iHj.irP.iqx.iOG) * 1000);
        g aav = aav();
        if (aav != null) {
            aav.pause();
            for (f fVar : this.iHj.irP.iqB.irS.isc.jwC.values()) {
                fVar.jwo.iqR = true;
            }
        }
    }

    public final void exit() {
        super.exit();
        this.iHj.xiR.removeMessages(11);
        g aav = aav();
        if (aav != null) {
            aav.resume();
            for (f fVar : this.iHj.irP.iqB.irS.isc.jwC.values()) {
                h hVar = fVar.jwo;
                hVar.iqR = false;
                hVar.jwx.interrupt();
            }
        }
    }

    public final boolean j(Message message) {
        switch (message.what) {
            case 3:
                c.a(this.iHj, this.iHj.iHa);
                return true;
            case 11:
                x.i(this.iHj.TAG, "suspend timeout");
                this.iHj.aar();
                return true;
            default:
                return super.j(message);
        }
    }

    private g aav() {
        return (g) this.iHj.irP.iqB.irR.v(g.class);
    }
}
