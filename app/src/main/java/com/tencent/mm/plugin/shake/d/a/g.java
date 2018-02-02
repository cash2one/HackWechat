package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.ab;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.av;
import com.tencent.mm.protocal.c.bdf;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bhw;
import com.tencent.mm.protocal.c.bhx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.rtmp.TXLiveConstants;

public final class g extends e {
    private final b gJQ;
    private e gJT;

    public g(byte[] bArr, int i, long j, int i2, boolean z, int i3) {
        float f;
        float f2;
        int i4 = 1;
        int i5 = 0;
        super(j);
        a aVar = new a();
        aVar.hmj = new bhw();
        aVar.hmk = new bhx();
        aVar.uri = "/cgi-bin/micromsg-bin/shaketv";
        aVar.hmi = av.CTRL_INDEX;
        aVar.hml = i5;
        aVar.hmm = i5;
        this.gJQ = aVar.JZ();
        bhw com_tencent_mm_protocal_c_bhw = (bhw) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bhw.vXz = new bdn().bj(bArr);
        com_tencent_mm_protocal_c_bhw.wLl = i2;
        com_tencent_mm_protocal_c_bhw.vLj = z ? 1 : i5;
        com_tencent_mm_protocal_c_bhw.wLm = (float) i;
        if (!ab.bC(ac.getContext())) {
            i4 = 2;
        }
        com_tencent_mm_protocal_c_bhw.vWK = i4;
        com_tencent_mm_protocal_c_bhw.vHT = i3;
        try {
            ar.Hg();
            float f3 = bh.getFloat((String) c.CU().get(w.a.USERINFO_SHAKE_TV_LATITUDE_STRING, null), 0.0f);
            try {
                ar.Hg();
                f = bh.getFloat((String) c.CU().get(w.a.USERINFO_SHAKE_TV_LONGTITUDE_STRING, null), 0.0f);
                try {
                    ar.Hg();
                    i5 = bh.VI((String) c.CU().get(w.a.USERINFO_SHAKE_TV_ACCURACY_STRING, null));
                    f2 = f;
                    f = f3;
                } catch (Exception e) {
                    f2 = f;
                    f = f3;
                }
            } catch (Exception e2) {
                f2 = 0.0f;
                f = f3;
            }
        } catch (Exception e3) {
            f2 = 0.0f;
            f = 0.0f;
        }
        com_tencent_mm_protocal_c_bhw.vQu = f;
        com_tencent_mm_protocal_c_bhw.wLn = f2;
        o.a(TXLiveConstants.PLAY_EVT_CHANGE_RESOLUTION, com_tencent_mm_protocal_c_bhw.wLn, com_tencent_mm_protocal_c_bhw.vQu, i5);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        bhw com_tencent_mm_protocal_c_bhw = (bhw) this.gJQ.hmg.hmo;
        x.d("MicroMsg.NetSceneShakeTV", "MusicFingerPrintRecorder doscene dataid:%d data:%d endflag:%d voice:%f nettype:%d ver:%d", Integer.valueOf(com_tencent_mm_protocal_c_bhw.wLl), Integer.valueOf(com_tencent_mm_protocal_c_bhw.vXz.wJB), Integer.valueOf(com_tencent_mm_protocal_c_bhw.vLj), Float.valueOf(com_tencent_mm_protocal_c_bhw.wLm), Integer.valueOf(com_tencent_mm_protocal_c_bhw.vWK), Integer.valueOf(com_tencent_mm_protocal_c_bhw.vHT));
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        bhw com_tencent_mm_protocal_c_bhw = (bhw) this.gJQ.hmg.hmo;
        x.d("MicroMsg.NetSceneShakeTV", "MusicFingerPrintRecorder onGYNetEnd [%d,%d] dataid:%d endflag:%d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(com_tencent_mm_protocal_c_bhw.wLl), Integer.valueOf(((bhx) this.gJQ.hmh.hmo).vLj));
        if (i2 == 0 && i3 == 0 && r1.vLj == 1) {
            this.qpG = true;
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final bdf bsf() {
        return (bhx) this.gJQ.hmh.hmo;
    }

    public final int getType() {
        return av.CTRL_INDEX;
    }
}
