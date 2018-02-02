package com.tencent.mm.plugin.label;

import com.tencent.mm.g.a.lu;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public final class d extends c<lu> {
    public d() {
        this.xen = lu.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ar.Hg();
        if (System.currentTimeMillis() - ((Long) com.tencent.mm.z.c.CU().get(209408, Long.valueOf(0))).longValue() > 86400000) {
            x.i("MicroMsg.Label.PostTaskGetContactLabelListener", "cpan[callback] get contact label list.");
            ar.CG().a(new com.tencent.mm.plugin.label.b.c(), 0);
            ar.Hg();
            com.tencent.mm.z.c.CU().set(209408, Long.valueOf((System.currentTimeMillis() - 86400000) + 1800000));
        }
        return false;
    }
}
