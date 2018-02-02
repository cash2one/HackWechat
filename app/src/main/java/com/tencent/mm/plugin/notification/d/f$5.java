package com.tencent.mm.plugin.notification.d;

import com.tencent.mm.g.a.ce;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class f$5 extends c<ce> {
    final /* synthetic */ f oUP;

    f$5(f fVar) {
        this.oUP = fVar;
        this.xen = ce.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        f.a(this.oUP).bgt().dismiss();
        f.b(this.oUP).bgt().dismiss();
        x.i("MicroMsg.SubCoreNotification", "dismiss all fail msg notification");
        return false;
    }
}
