package com.tencent.mm.booter;

import com.tencent.mm.booter.z.a;
import com.tencent.mm.g.a.ml;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class z$2 extends c<ml> {
    final /* synthetic */ z gzk;

    z$2(z zVar) {
        this.gzk = zVar;
        this.xen = ml.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ml mlVar = (ml) bVar;
        if (mlVar instanceof ml) {
            cf cfVar = mlVar.fEq.fnB;
            z zVar = this.gzk;
            if (!(zVar.gyY == null || zVar.gzb.contains(Long.valueOf(cfVar.field_msgSvrId)) || !zVar.gyY.gzl.equals(cfVar.field_talker))) {
                zVar.gzb.add(Long.valueOf(cfVar.field_msgSvrId));
                a aVar = zVar.gyY;
                aVar.gzr++;
                x.i("MicroMsg.StayTimeReport", "receiveMsg msgType:%d, recvCnt:%d", new Object[]{Integer.valueOf(cfVar.getType()), Integer.valueOf(zVar.gyY.gzr)});
            }
        }
        return false;
    }
}
