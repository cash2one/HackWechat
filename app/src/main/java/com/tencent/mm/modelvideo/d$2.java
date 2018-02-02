package com.tencent.mm.modelvideo;

import com.tencent.mm.plugin.r.a.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.at;
import com.tencent.mm.z.s;
import java.util.Map;

class d$2 implements Runnable {
    final /* synthetic */ d hTX;
    final /* synthetic */ boolean hTY;
    final /* synthetic */ int hTZ;

    d$2(d dVar, boolean z, int i) {
        this.hTX = dVar;
        this.hTY = z;
        this.hTZ = i;
    }

    public final void run() {
        Map y = bi.y(this.hTX.hTR.Ug(), "msg");
        if (y != null) {
            s TU = o.TU();
            o.TU();
            TU.p(s.nt(this.hTX.fileName), (String) y.get(".msg.videomsg.$cdnvideourl"), (String) y.get(".msg.videomsg.$aeskey"));
        }
        boolean z = false;
        if (this.hTY) {
            z = t.X(this.hTX.fileName, this.hTZ);
            if (this.hTX.hTQ) {
                r nF = t.nF(this.hTX.fileName);
                if (nF != null) {
                    nF.videoFormat = 1;
                    nF.fDt = 2;
                    o.TU().b(nF);
                }
            }
        } else if (this.hTX.hTQ) {
            t.ny(this.hTX.fileName);
            g.pQN.a(354, 138, 1, false);
        } else {
            z = t.X(this.hTX.fileName, this.hTZ);
        }
        x.i("MicroMsg.NetSceneDownloadVideo", "%s ashutest::cdntra !FIN! file:%s svrid:%d human:%s user:%s updatedbsucc:%b  MediaCheckDuplicationStorage MD5:%s SIZE:%d renameFlag %b needRename %b", new Object[]{this.hTX.TL(), this.hTX.fileName, Long.valueOf(this.hTX.hTR.fFo), this.hTX.hTR.Ue(), this.hTX.hTR.Ud(), Boolean.valueOf(z), this.hTX.hBu, Integer.valueOf(this.hTX.hBv), Boolean.valueOf(this.hTY), Boolean.valueOf(this.hTX.hTV)});
        if (!bh.ov(this.hTX.hBu) && this.hTX.hBv > 0) {
            at Ff = ((a) com.tencent.mm.kernel.g.h(a.class)).Ff();
            String str = this.hTX.hBu;
            int i = this.hTX.hBv;
            o.TU();
            Ff.y(str, i, s.nt(this.hTX.fileName));
        }
        if (this.hTX.hTR.hVO == 3) {
            g.pQN.a(198, 38, (long) this.hTX.hTR.hlp, false);
            g.pQN.a(198, 40, (long) this.hTX.hTR.hVH, false);
            g.pQN.a(198, 41, 1, false);
            g.pQN.a(198, s.eV(this.hTX.hTR.Ud()) ? 43 : 42, 1, false);
        } else {
            g.pQN.a(198, 31, (long) this.hTX.hTR.hlp, false);
            g.pQN.a(198, 33, (long) this.hTX.hTR.hVH, false);
            g.pQN.a(198, 34, 1, false);
            g.pQN.a(198, s.eV(this.hTX.hTR.Ud()) ? 36 : 35, 1, false);
        }
        this.hTX.gJT.a(0, 0, "", this.hTX);
    }
}
