package com.tencent.mm.plugin.sight.encode.a;

import android.database.Cursor;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.plugin.sight.encode.a.b.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class b$4 implements Runnable {
    final /* synthetic */ String jnw;
    final /* synthetic */ a qwp;
    final /* synthetic */ int qwq;
    final /* synthetic */ b qwr;
    final /* synthetic */ List qws;
    final /* synthetic */ String qwt;

    public b$4(b bVar, String str, List list, String str2, a aVar, int i) {
        this.qwr = bVar;
        this.jnw = str;
        this.qws = list;
        this.qwt = str2;
        this.qwp = aVar;
        this.qwq = i;
    }

    public final void run() {
        int i;
        long j;
        String Jp = d.Jp(this.jnw);
        if (!e.bO(Jp)) {
            x.w("MicroMsg.SightRecorderHelper", "thumb data not found, try to create thumb");
            try {
                com.tencent.mm.sdk.platformtools.d.a(d.R(this.jnw, 320, 240), 60, CompressFormat.JPEG, Jp, true);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SightRecorderHelper", e, "", new Object[0]);
                x.e("MicroMsg.SightRecorderHelper", "save bitmap to image error");
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String) this.qws.get(0));
        for (i = 1; i < this.qws.size(); i++) {
            stringBuilder.append(',');
            stringBuilder.append((String) this.qws.get(i));
        }
        String stringBuilder2 = stringBuilder.toString();
        Cursor a = o.TU().hhp.a("SELECT MAX(masssendid) FROM videoinfo2", null, 2);
        if (a == null) {
            j = 0;
        } else {
            j = 0;
            if (a.moveToFirst()) {
                j = a.getLong(0);
            }
            a.close();
        }
        long j2 = 1 + j;
        for (i = 0; i < this.qws.size(); i++) {
            String str = (String) this.qws.get(i);
            x.i("MicroMsg.SightRecorderHelper", "do prepare sight message for %s, massSendId %d, massSendList %s, videoMD5 %s", new Object[]{str, Long.valueOf(j2), stringBuilder2, this.qwt});
            String ns = s.ns(str);
            o.TU();
            String nu = s.nu(ns);
            o.TU();
            String nt = s.nt(ns);
            x.i("MicroMsg.SightRecorderHelper", "prepare to send sight to %s, sightThumbSize %d bytes", new Object[]{str, Long.valueOf(e.x(Jp, nu))});
            if (e.x(Jp, nu) <= 0) {
                x.e("MicroMsg.SightRecorderHelper", "copy remux thumb path from %s to %s error, index %d", new Object[]{Jp, nu, Integer.valueOf(i)});
                b.a(this.qwp, i);
            } else {
                x.i("MicroMsg.SightRecorderHelper", "prepare to send sight to %s, sightFileSize %d bytes", new Object[]{str, Long.valueOf(e.x(this.jnw, nt))});
                if (e.x(this.jnw, nt) <= 0) {
                    x.e("MicroMsg.SightRecorderHelper", "copy remux video path from %s to %s error, index %d", new Object[]{this.jnw, nt, Integer.valueOf(i)});
                    b.a(this.qwp, i);
                } else {
                    int i2 = this.qwq;
                    nt = this.qwt;
                    r rVar = new r();
                    rVar.fileName = ns;
                    rVar.hVH = i2;
                    rVar.fDC = str;
                    rVar.hVz = (String) g.Dj().CU().get(2, "");
                    rVar.hVE = bh.Wo();
                    rVar.hVF = bh.Wo();
                    rVar.hVN = null;
                    rVar.hTp = null;
                    rVar.hVL = 0;
                    rVar.hVO = 3;
                    o.TU();
                    int nv = s.nv(s.nt(ns));
                    if (nv <= 0) {
                        x.e("MicroMsg.VideoLogic", "initMassSendSight::get Video size failed:" + ns);
                    } else {
                        rVar.hlp = nv;
                        o.TU();
                        str = s.nu(ns);
                        i2 = s.nv(str);
                        if (i2 <= 0) {
                            x.e("MicroMsg.VideoLogic", "get Thumb size failed :" + str + " size:" + i2);
                        } else {
                            rVar.hVD = i2;
                            x.i("MicroMsg.VideoLogic", "initMassSendSight file:" + ns + " thumbsize:" + rVar.hVD + " videosize:" + rVar.hlp);
                            rVar.status = 200;
                            x.i("MicroMsg.VideoLogic", "massSendId %d, videoMD5 %s, massSendList %s", new Object[]{Long.valueOf(j2), nt, stringBuilder2});
                            rVar.hVP = stringBuilder2;
                            rVar.hUa = j2;
                            rVar.fHk = nt;
                            o.TU().a(rVar);
                        }
                    }
                }
            }
        }
        t.bu(j2);
        b.deleteFile(this.jnw);
        b.deleteFile(Jp);
    }
}
