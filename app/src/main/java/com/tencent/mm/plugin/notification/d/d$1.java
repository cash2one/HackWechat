package com.tencent.mm.plugin.notification.d;

import com.tencent.mm.g.a.os;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;

class d$1 extends c<os> {
    final /* synthetic */ d oUs;

    d$1(d dVar) {
        this.oUs = dVar;
        this.xen = os.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        final os osVar = (os) bVar;
        ag.y(new Runnable(this) {
            final /* synthetic */ d$1 oUu;

            public final void run() {
                cf cfVar = osVar.fGK.fnB;
                if (d.GN(cfVar.field_talker)) {
                    this.oUu.oUs.bB(cfVar);
                }
            }
        });
        return false;
    }
}
