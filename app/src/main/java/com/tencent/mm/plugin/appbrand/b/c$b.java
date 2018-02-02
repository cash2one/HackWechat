package com.tencent.mm.plugin.appbrand.b;

import android.os.Message;

final class c$b extends g {
    final /* synthetic */ c iHj;

    c$b(c cVar, h hVar) {
        this.iHj = cVar;
        super(hVar);
    }

    public final String getName() {
        return this.iHj.mName + "|BackgroundKeepNoChange";
    }

    public final boolean j(Message message) {
        switch (message.what) {
            case 3:
                c.a(this.iHj, this.iHj.iHa);
                return true;
            default:
                return super.j(message);
        }
    }
}
