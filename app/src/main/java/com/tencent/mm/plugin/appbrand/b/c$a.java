package com.tencent.mm.plugin.appbrand.b;

import android.os.Message;
import com.tencent.mm.plugin.appbrand.e;

final class c$a extends f {
    final /* synthetic */ c iHj;

    c$a(c cVar, h hVar, e eVar) {
        this.iHj = cVar;
        super(hVar, eVar);
    }

    public final String getName() {
        return this.iHj.mName + "|Background";
    }

    public final boolean j(Message message) {
        switch (message.what) {
            case 3:
                c.a(this.iHj, this.iHj.iHa);
                return true;
            case 12:
                super.jA(16);
                return true;
            default:
                return super.j(message);
        }
    }

    public final void enter() {
        super.enter();
    }

    public final void exit() {
        super.exit();
    }

    final void aau() {
        if (this.iHj.cgH() == this) {
            c.a(this.iHj, this.iHj.iHd);
            this.iHj.jz(1000);
        }
    }
}
