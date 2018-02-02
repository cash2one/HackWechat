package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.ab;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bdf;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bhs;
import com.tencent.mm.protocal.c.bht;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class f extends e {
    private final b gJQ;
    private e gJT;

    public f(byte[] bArr, int i, long j, int i2, boolean z, int i3) {
        float f;
        int VI;
        float f2;
        int i4 = 1;
        float f3 = 0.0f;
        super(j);
        a aVar = new a();
        aVar.hmj = new bhs();
        aVar.hmk = new bht();
        aVar.uri = "/cgi-bin/micromsg-bin/shakemusic";
        this.gJQ = aVar.JZ();
        bhs com_tencent_mm_protocal_c_bhs = (bhs) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bhs.vXz = new bdn().bj(bArr);
        com_tencent_mm_protocal_c_bhs.wLl = i2;
        com_tencent_mm_protocal_c_bhs.vLj = z ? 1 : 0;
        com_tencent_mm_protocal_c_bhs.wLm = (float) i;
        com_tencent_mm_protocal_c_bhs.vWK = ab.bC(ac.getContext()) ? 1 : 2;
        com_tencent_mm_protocal_c_bhs.vHT = i3;
        try {
            ar.Hg();
            f = bh.getFloat((String) c.CU().get(w.a.USERINFO_SHAKE_TV_LATITUDE_STRING, null), 0.0f);
            try {
                ar.Hg();
                f3 = bh.getFloat((String) c.CU().get(w.a.USERINFO_SHAKE_TV_LONGTITUDE_STRING, null), 0.0f);
                ar.Hg();
                VI = bh.VI((String) c.CU().get(w.a.USERINFO_SHAKE_TV_ACCURACY_STRING, null));
            } catch (Exception e) {
                f2 = f3;
                f3 = f;
                f = f3;
                f3 = f2;
                VI = 0;
                com_tencent_mm_protocal_c_bhs.vQu = f;
                com_tencent_mm_protocal_c_bhs.wLn = f3;
                com_tencent_mm_protocal_c_bhs.wmT = com.tencent.mm.av.c.Qz() ? 0 : 1;
                if (!com.tencent.mm.av.c.Qy()) {
                    i4 = 0;
                }
                com_tencent_mm_protocal_c_bhs.wmU = i4;
                o.a(2014, com_tencent_mm_protocal_c_bhs.wLn, com_tencent_mm_protocal_c_bhs.vQu, VI);
            }
        } catch (Exception e2) {
            f2 = 0.0f;
            f = f3;
            f3 = f2;
            VI = 0;
            com_tencent_mm_protocal_c_bhs.vQu = f;
            com_tencent_mm_protocal_c_bhs.wLn = f3;
            if (com.tencent.mm.av.c.Qz()) {
            }
            com_tencent_mm_protocal_c_bhs.wmT = com.tencent.mm.av.c.Qz() ? 0 : 1;
            if (com.tencent.mm.av.c.Qy()) {
                i4 = 0;
            }
            com_tencent_mm_protocal_c_bhs.wmU = i4;
            o.a(2014, com_tencent_mm_protocal_c_bhs.wLn, com_tencent_mm_protocal_c_bhs.vQu, VI);
        }
        com_tencent_mm_protocal_c_bhs.vQu = f;
        com_tencent_mm_protocal_c_bhs.wLn = f3;
        if (com.tencent.mm.av.c.Qz()) {
        }
        com_tencent_mm_protocal_c_bhs.wmT = com.tencent.mm.av.c.Qz() ? 0 : 1;
        if (com.tencent.mm.av.c.Qy()) {
            i4 = 0;
        }
        com_tencent_mm_protocal_c_bhs.wmU = i4;
        o.a(2014, com_tencent_mm_protocal_c_bhs.wLn, com_tencent_mm_protocal_c_bhs.vQu, VI);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        bhs com_tencent_mm_protocal_c_bhs = (bhs) this.gJQ.hmg.hmo;
        x.d("MicroMsg.NetSceneShakeMusic", "MusicFingerPrintRecorder doscene dataid:%d data:%d endflag:%d voice:%f nettype:%d ver:%d", Integer.valueOf(com_tencent_mm_protocal_c_bhs.wLl), Integer.valueOf(com_tencent_mm_protocal_c_bhs.vXz.wJB), Integer.valueOf(com_tencent_mm_protocal_c_bhs.vLj), Float.valueOf(com_tencent_mm_protocal_c_bhs.wLm), Integer.valueOf(com_tencent_mm_protocal_c_bhs.vWK), Integer.valueOf(com_tencent_mm_protocal_c_bhs.vHT));
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        bhs com_tencent_mm_protocal_c_bhs = (bhs) this.gJQ.hmg.hmo;
        x.d("MicroMsg.NetSceneShakeMusic", "MusicFingerPrintRecorder onGYNetEnd [%d,%d] dataid:%d endflag:%d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(com_tencent_mm_protocal_c_bhs.wLl), Integer.valueOf(((bht) this.gJQ.hmh.hmo).vLj));
        if (i2 == 0 && i3 == 0 && r1.vLj == 1) {
            this.qpG = true;
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final bdf bsf() {
        return (bht) this.gJQ.hmh.hmo;
    }

    public final int getType() {
        return 367;
    }
}
