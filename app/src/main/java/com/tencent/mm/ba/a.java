package com.tencent.mm.ba;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetClipboardData;
import com.tencent.mm.protocal.c.afc;
import com.tencent.mm.protocal.c.afd;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;

public final class a extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;
    public String hJU;
    public String hJV;
    public byte[] hJW;

    public a() {
        this(q.FS(), bh.e((Integer) g.Dj().CU().get(66561, null)), 0);
    }

    public a(String str, int i) {
        this(str, i, 0);
    }

    public a(String str, int i, int i2) {
        this.gJT = null;
        this.hJU = null;
        this.hJV = null;
        this.hJW = null;
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new afc();
        aVar.hmk = new afd();
        aVar.uri = "/cgi-bin/micromsg-bin/getqrcode";
        aVar.hmi = JsApiSetClipboardData.CTRL_INDEX;
        aVar.hml = 67;
        aVar.hmm = 1000000067;
        this.gJQ = aVar.JZ();
        afc com_tencent_mm_protocal_c_afc = (afc) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_afc.vYI = n.os(str);
        com_tencent_mm_protocal_c_afc.wmY = i;
        com_tencent_mm_protocal_c_afc.vDW = i2;
        x.i("MicroMsg.NetSceneGetQRCode", "username:%s, style:%d, opcode:%d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return JsApiSetClipboardData.CTRL_INDEX;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetQRCode", "onGYNetEnd errType:" + i2 + " errCode" + i3);
        if (i2 == 0 && i3 == 0) {
            afd com_tencent_mm_protocal_c_afd = (afd) this.gJQ.hmh.hmo;
            String a = n.a(((afc) this.gJQ.hmg.hmo).vYI);
            this.hJW = n.a(com_tencent_mm_protocal_c_afd.wmZ, new byte[0]);
            this.hJU = com_tencent_mm_protocal_c_afd.wna;
            x.i("MicroMsg.NetSceneGetQRCode", "expiredWording:%s, revokeId:%s, revokeWording:%s", new Object[]{this.hJU, com_tencent_mm_protocal_c_afd.wnb, com_tencent_mm_protocal_c_afd.wnc});
            if (q.FS().equals(a)) {
                String str2 = com_tencent_mm_protocal_c_afd.wnb;
                a = (String) g.Dj().CU().get(66563, "");
                if (!(str2 == null || a.equals(str2))) {
                    g.Dj().CU().set(66563, str2);
                    this.hJV = com_tencent_mm_protocal_c_afd.wnc;
                }
                g.Dj().CU().set(66561, Integer.valueOf(com_tencent_mm_protocal_c_afd.wmY));
            }
        }
        this.gJT.a(i2, i3, str, this);
    }
}
