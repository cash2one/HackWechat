package com.tencent.mm.plugin.notification.c;

import com.tencent.mm.g.a.rw;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class a$1 extends c<rw> {
    final /* synthetic */ a oUi;

    a$1(a aVar) {
        this.oUi = aVar;
        this.xen = rw.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        rw rwVar = (rw) bVar;
        a aVar = this.oUi;
        long j = rwVar.fJD.fJE;
        x.i("MicroMsg.AbstractSendMsgFailNotification", "updateMsgIdInMsgList, oldMsgId:%d, newMsgId:%d", new Object[]{Long.valueOf(j), Long.valueOf(rwVar.fJD.fJF)});
        if (aVar.oTZ.dW(j)) {
            b bVar2 = aVar.oTZ;
            int indexOf = bVar2.oUk.indexOf(Long.valueOf(j));
            if (indexOf != -1) {
                bVar2.oUk.set(indexOf, Long.valueOf(r4));
            }
        }
        return false;
    }
}
