package com.tencent.mm.plugin.sns;

import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.lt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.v;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends c<lt> {
    public h() {
        this.xen = lt.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        lt ltVar = (lt) bVar;
        if (!(ltVar instanceof lt)) {
            x.f("MicroMsg.PostSnsTagMemberOptionListener", "mismatched event");
            return false;
        } else if (ltVar.fDg.list == null) {
            x.e("MicroMsg.PostSnsTagMemberOptionListener", "event.data.list is null!");
            return false;
        } else {
            k vVar = new v(ltVar.fDg.fut, ltVar.fDg.fDh, "", ltVar.fDg.list.size(), ltVar.fDg.list, ltVar.fDg.scene);
            x.i("MicroMsg.PostSnsTagMemberOptionListener", "opCode " + ltVar.fDg.fut + " memberList " + ltVar.fDg.list.size() + " scene " + ltVar.fDg.scene);
            g.Di().gPJ.a(vVar, 0);
            return true;
        }
    }
}
