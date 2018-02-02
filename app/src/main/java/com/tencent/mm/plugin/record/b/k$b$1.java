package com.tencent.mm.plugin.record.b;

import com.tencent.mm.ae.k;
import com.tencent.mm.aq.d.a;
import com.tencent.mm.aq.e;
import com.tencent.mm.aq.f;
import com.tencent.mm.aq.o;
import com.tencent.mm.plugin.record.b.k.b;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import java.util.Map;

class k$b$1 implements a {
    final /* synthetic */ e hBC;
    final /* synthetic */ au heR;
    final /* synthetic */ long pFx;
    final /* synthetic */ b pFy;

    k$b$1(b bVar, e eVar, au auVar, long j) {
        this.pFy = bVar;
        this.hBC = eVar;
        this.heR = auVar;
        this.pFx = j;
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, k kVar) {
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, k kVar) {
        boolean z = i3 == 0 && i4 == 0;
        x.i("MicroMsg.RecordMsgSendService", "download image succed: %s, errType: %s, errCode:%s", Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4));
        if (obj instanceof uq) {
            uq uqVar = (uq) obj;
            uqVar.TE(o.Pw().m(f.c(this.hBC), "", ""));
            uqVar.TF(o.Pw().B(this.heR.field_imgPath, true));
            Map y = bi.y(this.hBC.hAa, "msg");
            if (y != null) {
                uqVar.Tu((String) y.get(".msg.img.$cdnbigimgurl"));
                uqVar.fw((long) bh.getInt((String) y.get(".msg.img.$length"), 0));
                uqVar.Tv((String) y.get(".msg.img.$aeskey"));
                b.b(this.pFy).field_dataProto.weU.set(b.a(this.pFy), uqVar);
            } else {
                x.i("MicroMsg.RecordMsgSendService", "parse cdnInfo failed. [%s]", this.hBC.hAa);
            }
            this.pFy.pFs.put(Long.valueOf(uqVar.wdP), Boolean.valueOf(true));
        } else {
            this.pFy.pFs.put(Long.valueOf(this.pFx), Boolean.valueOf(true));
        }
        b.a(this.pFy, this.pFy.pFs, b.c(this.pFy), b.b(this.pFy));
    }

    public final void a(long j, long j2, int i, int i2, Object obj) {
        this.pFy.pFs.put(Long.valueOf(this.pFx), Boolean.valueOf(true));
        b.a(this.pFy, this.pFy.pFs, b.c(this.pFy), b.b(this.pFy));
    }
}
