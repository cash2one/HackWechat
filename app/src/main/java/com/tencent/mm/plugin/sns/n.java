package com.tencent.mm.plugin.sns;

import com.tencent.mm.g.a.qn;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends c<qn> {
    public n() {
        this.xen = qn.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        qn qnVar = (qn) bVar;
        if (qnVar instanceof qn) {
            qnVar.fId.fpW = a.a(qnVar.fIc.fIg, qnVar.fIc.url, qnVar.fIc.fIf);
            return true;
        }
        x.f("MicroMsg.SnsfillEventInfoListener", "mismatched event");
        return false;
    }
}
