package com.tencent.mm.plugin.shake.b;

import com.tencent.mm.g.a.ne;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class m$3 extends c<ne> {
    final /* synthetic */ m qoh;

    m$3(m mVar) {
        this.qoh = mVar;
        this.xen = ne.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (((ne) bVar) instanceof ne) {
            g.pQN.h(10221, new Object[]{Integer.valueOf(r6.fFf.scene)});
        } else {
            x.e("MicroMsg.SubCoreShake", "mismatch event listener for ReportClickFindFriendShakeEvent");
        }
        return false;
    }
}
