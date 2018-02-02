package com.tencent.mm.booter;

import com.tencent.mm.booter.z.a;
import com.tencent.mm.g.a.ov;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class z$1 extends c<ov> {
    final /* synthetic */ z gzk;

    z$1(z zVar) {
        this.gzk = zVar;
        this.xen = ov.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ov ovVar = (ov) bVar;
        if (ovVar instanceof ov) {
            cf cfVar = ovVar.fGN.fnB;
            z zVar = this.gzk;
            if (!(zVar.gyY == null || zVar.gza.contains(Long.valueOf(cfVar.field_msgId)) || !zVar.gyY.gzl.equals(cfVar.field_talker))) {
                zVar.gza.add(Long.valueOf(cfVar.field_msgId));
                a aVar = zVar.gyY;
                aVar.gzs++;
                x.i("MicroMsg.StayTimeReport", "sendMsg msgType:%d, SendCnt:%d", new Object[]{Integer.valueOf(cfVar.getType()), Integer.valueOf(zVar.gyY.gzs)});
            }
        }
        return false;
    }
}
