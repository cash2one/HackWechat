package com.tencent.mm.pluginsdk.i.a.b;

import com.tencent.mm.pluginsdk.i.a.b.b.c;
import com.tencent.mm.pluginsdk.i.a.d.o.a;
import com.tencent.mm.pluginsdk.i.a.d.q;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class b$4 implements Runnable {
    final /* synthetic */ String vgA;
    final /* synthetic */ int vgr;
    final /* synthetic */ int vgs;
    final /* synthetic */ int vgt;
    final /* synthetic */ b vgv;
    final /* synthetic */ boolean vgx;
    final /* synthetic */ String vgy;
    final /* synthetic */ int vgz;

    b$4(b bVar, String str, int i, int i2, int i3, int i4, String str2, boolean z) {
        this.vgv = bVar;
        this.vgy = str;
        this.vgr = i;
        this.vgs = i2;
        this.vgt = i3;
        this.vgz = i4;
        this.vgA = str2;
        this.vgx = z;
    }

    public final void run() {
        q RW = a.bZC().RW(this.vgy);
        int i = this.vgr;
        int i2 = this.vgs;
        int i3 = this.vgt;
        int i4 = this.vgz;
        String str = this.vgA;
        boolean z = this.vgx;
        x.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "record " + RW);
        x.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "delete version %d", new Object[]{Integer.valueOf(i3)});
        boolean z2 = false;
        if (RW == null) {
            j.I((long) i4, 47);
            j.I((long) i4, 22);
            z2 = true;
        } else if (bh.getInt(RW.field_fileVersion, 0) <= i3) {
            z2 = true;
        } else {
            j.I(RW.field_reportId, 47);
            j.I(RW.field_reportId, 22);
        }
        String ey = i.ey(i, i2);
        String RR = i.RR(ey);
        x.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "doDelete(%b), filePath(%s)", new Object[]{Boolean.valueOf(z2), RR});
        if (z2) {
            a.bZC().RY(ey);
            c.bZm().f(i, i2, 2, z);
            if ((((com.tencent.mm.pluginsdk.i.a.e.a.Sa(RR) & 1) & com.tencent.mm.pluginsdk.i.a.e.a.Sa(RR + ".decompressed")) & com.tencent.mm.pluginsdk.i.a.e.a.Sa(RR + ".decrypted")) != 0) {
                if (RW != null) {
                    j.I(RW.field_reportId, 21);
                    j.a(RW.field_resType, RW.field_subType, i3, z, RW.field_sampleId);
                }
            } else if (RW != null) {
                j.I(RW.field_reportId, 22);
                j.I(RW.field_reportId, 47);
            }
            if (RW == null) {
                q qVar = new q();
                qVar.field_urlKey = ey;
                qVar.field_resType = i;
                qVar.field_subType = i2;
                qVar.field_deleted = true;
                qVar.field_fileVersion = String.valueOf(i3);
                qVar.field_reportId = (long) i4;
                qVar.field_sampleId = str;
                a.bZC().e(qVar);
                return;
            }
            RW.field_deleted = true;
            RW.field_fileVersion = String.valueOf(i3);
            a.bZC().e(RW);
        }
    }
}
