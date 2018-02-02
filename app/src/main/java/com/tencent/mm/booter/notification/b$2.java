package com.tencent.mm.booter.notification;

import com.tencent.mm.g.a.nz;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.k.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class b$2 extends c<nz> {
    final /* synthetic */ b gzI;

    b$2(b bVar) {
        this.gzI = bVar;
        this.xen = nz.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        nz nzVar = (nz) bVar;
        if (nzVar != null && (nzVar instanceof nz)) {
            cf cfVar = nzVar.fFS.fEJ;
            if (cfVar != null) {
                b bVar2 = this.gzI;
                if (cfVar.field_isSend == 1) {
                    x.w("MicroMsg.MMNotification", "notifyRevorkMessage is sender , msgid:%d ", new Object[]{Long.valueOf(cfVar.field_msgSvrId)});
                } else {
                    bVar2.fEJ = cfVar;
                    int d = f.d(cfVar);
                    bVar2.talker = cfVar.field_talker;
                    String str = cfVar.field_content;
                    int type = cfVar.getType();
                    bVar2.gzx = "";
                    bVar2.gzy = null;
                    x.i("MicroMsg.MMNotification", "notifyRevorkMessage talker:%s msgid:%d type:%d tipsFlag:%d content:%s", new Object[]{bVar2.talker, Long.valueOf(cfVar.field_msgSvrId), Integer.valueOf(type), Integer.valueOf(d), bh.VT(str)});
                    if (bVar2.gzD.a(bVar2.talker, bVar2.fEJ, d, true)) {
                        bVar2.gzF.sendMessageDelayed(b.a(bVar2.talker, str, type, d, 1), 200);
                    } else {
                        x.w("MicroMsg.MMNotification", "[no notificaion], preNotificationCheck");
                    }
                }
            }
        }
        return false;
    }
}
