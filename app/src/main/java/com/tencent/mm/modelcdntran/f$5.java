package com.tencent.mm.modelcdntran;

import com.tencent.mm.g.a.kz;
import com.tencent.mm.g.a.kz$a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.q;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;

class f$5 implements Runnable {
    final /* synthetic */ f hta;
    final /* synthetic */ int htd;
    final /* synthetic */ int hte;
    final /* synthetic */ String uS;

    f$5(f fVar, String str, int i, int i2) {
        this.hta = fVar;
        this.uS = str;
        this.htd = i;
        this.hte = i2;
    }

    public final void run() {
        boolean z = false;
        j jVar = (j) this.hta.hsu.get(this.uS);
        if (jVar != null) {
            jVar.htP = (long) this.htd;
            if (jVar.htQ != null) {
                jVar.htQ.onMoovReady(this.uS, this.htd, this.hte);
            } else if (q.nm(jVar.field_fullpath)) {
                x.w("MicroMsg.OnlineVideoService", "it is qt video, need finish all file. isPlayMode" + jVar.htJ);
                if (jVar.htJ == 1) {
                    f.f(jVar.field_mediaId, 0, jVar.field_totalLen);
                    g.pQN.a(354, 19, 1, false);
                }
            } else {
                b kzVar = new kz();
                kzVar.fCj.fuL = 1;
                kzVar.fCj.retCode = 0;
                kzVar.fCj.mediaId = this.uS;
                kzVar.fCj.offset = this.htd;
                kzVar.fCj.length = this.hte;
                kzVar.fCj.fCk = jVar.htG;
                kz$a com_tencent_mm_g_a_kz_a = kzVar.fCj;
                if (jVar.initialDownloadLength > 0) {
                    z = true;
                }
                com_tencent_mm_g_a_kz_a.fCl = z;
                a.xef.m(kzVar);
                r nF = t.nF(jVar.filename);
                if (nF != null) {
                    x.i("MicroMsg.OnlineVideoService", "on moov ready info: " + nF.getFileName() + " status : " + nF.status);
                    if (nF.status != 130 && nF.status != 122) {
                        nF = t.nF(jVar.filename);
                        if (nF != null) {
                            nF.status = 121;
                            nF.fDt = 256;
                            o.TU().b(nF);
                        }
                        if (jVar.htJ == 0) {
                            x.i("MicroMsg.OnlineVideoService", "stop download video");
                            o.TZ().Us();
                            o.TZ().run();
                        }
                    }
                }
            }
        }
    }
}
