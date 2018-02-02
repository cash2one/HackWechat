package com.tencent.mm.ui;

import com.tencent.mm.g.a.im;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.q.z;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;

class h$16 extends c<im> {
    final /* synthetic */ h xFs;

    h$16(h hVar) {
        this.xFs = hVar;
        this.xen = im.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (z.vcD != null) {
            g.pQN.h(11178, new Object[]{bh.ou(r0.bDX()), r0.bDY().bDJ(), Integer.valueOf(h.cmt())});
        }
        h.b(this.xFs);
        h.a(this.xFs).notifyDataSetChanged();
        return true;
    }
}
