package com.tencent.mm.plugin.shake.b;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateBackgroundAudio;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bhu;
import com.tencent.mm.protocal.c.bhv;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class b extends k implements com.tencent.mm.network.k {
    byte[] fKk;
    private final com.tencent.mm.ae.b gJQ;
    private e gJT;
    int ret;

    public b(float f, float f2, int i, int i2, String str, String str2) {
        a aVar = new a();
        aVar.hmj = new bhu();
        aVar.hmk = new bhv();
        aVar.uri = "/cgi-bin/micromsg-bin/shakereport";
        aVar.hmi = JsApiOperateBackgroundAudio.CTRL_INDEX;
        aVar.hml = 56;
        aVar.hmm = 1000000056;
        this.gJQ = aVar.JZ();
        bhu com_tencent_mm_protocal_c_bhu = (bhu) this.gJQ.hmg.hmo;
        x.i("MicroMsg.NetSceneShakeReport", "share reprot %f %f", new Object[]{Float.valueOf(f2), Float.valueOf(f)});
        com_tencent_mm_protocal_c_bhu.vDW = 0;
        com_tencent_mm_protocal_c_bhu.vQt = f;
        com_tencent_mm_protocal_c_bhu.vQu = f2;
        com_tencent_mm_protocal_c_bhu.wcr = i;
        com_tencent_mm_protocal_c_bhu.wcs = str;
        com_tencent_mm_protocal_c_bhu.wct = str2;
        com_tencent_mm_protocal_c_bhu.wcu = i2;
        ar.Hg();
        com_tencent_mm_protocal_c_bhu.wLx = bh.a((Integer) c.CU().get(4107, null), 0);
        ar.Hg();
        int e = bh.e((Integer) c.CU().get(4106, null));
        com_tencent_mm_protocal_c_bhu.wLy = e;
        e++;
        ar.Hg();
        c.CU().set(4106, Integer.valueOf(e));
        com_tencent_mm_protocal_c_bhu.wvs = new bdn().bj(d.oSu.bfJ());
        o.a(2002, f, f2, i);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.NetSceneShakeReport", "doScene");
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return JsApiOperateBackgroundAudio.CTRL_INDEX;
    }

    public final int brn() {
        return ((bhu) this.gJQ.hmg.hmo).wcu;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneShakeReport", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        bhv com_tencent_mm_protocal_c_bhv = (bhv) this.gJQ.hmh.hmo;
        this.ret = qVar.Hp().vBp;
        if (i2 == 0 && i3 == 0) {
            this.fKk = n.a(com_tencent_mm_protocal_c_bhv.vKf);
        }
        this.gJT.a(i2, i3, str, this);
    }
}
