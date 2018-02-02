package com.tencent.mm.bg;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.bsv;
import com.tencent.mm.protocal.c.bsw;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Set;

public final class c extends a implements k {
    String filename;
    private b gJQ;
    e gJT;
    int hOX;
    boolean hWy;
    private long hYf;
    private boolean hYg;
    private int hYh;
    private String[] hYi;
    ak hkO;
    int retCode;

    public final void UL() {
        this.hWy = true;
    }

    public final String[] UM() {
        return this.hYi;
    }

    public final long UN() {
        return this.hYf;
    }

    public final Set<String> UO() {
        return null;
    }

    public c(String str, int i) {
        this.retCode = 0;
        this.hOX = 0;
        this.filename = null;
        this.hYf = -1;
        this.hYg = false;
        this.hWy = false;
        this.hYi = new String[0];
        this.hkO = new ak(new 1(this), true);
        this.hYf = bh.Wp();
        this.filename = str;
        this.hYh = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i = 3960;
        this.gJT = eVar2;
        int bN = com.tencent.mm.a.e.bN(this.filename);
        x.d("MicroMsg.NetSceneVoiceAddr", g.zh() + " read file:" + this.filename + " filelen:" + bN + " oldoff:" + this.hOX + " isFin:" + this.hWy);
        if (bN <= 0) {
            x.e("MicroMsg.NetSceneVoiceAddr", "read failed :" + this.filename);
            this.retCode = g.getLine() + 40000;
            return -1;
        }
        int i2 = bN - this.hOX;
        if (i2 <= 3960) {
            if (i2 >= 3300 || this.hWy) {
                if (this.hWy) {
                    this.hYg = true;
                }
                i = i2;
            } else {
                x.e("MicroMsg.NetSceneVoiceAddr", g.zh() + " read failed :" + this.filename + "can read:" + i2 + " isfinish:" + this.hWy);
                this.retCode = g.getLine() + 40000;
                return -1;
            }
        }
        x.d("MicroMsg.NetSceneVoiceAddr", g.zh() + " read file:" + this.filename + " filelen:" + bN + " oldoff:" + this.hOX + " isFin:" + this.hWy + " endFlag:" + this.hYg);
        byte[] d = com.tencent.mm.a.e.d(this.filename, this.hOX, i);
        if (d == null) {
            x.e("MicroMsg.NetSceneVoiceAddr", g.zh() + " read failed :" + this.filename + " read:" + i);
            this.retCode = g.getLine() + 40000;
            return -1;
        }
        a aVar = new a();
        aVar.hmj = new bsv();
        aVar.hmk = new bsw();
        aVar.uri = "/cgi-bin/micromsg-bin/voiceaddr";
        aVar.hmi = com.tencent.mm.plugin.appbrand.jsapi.a.b.CTRL_INDEX;
        aVar.hml = 94;
        aVar.hmm = 1000000094;
        this.gJQ = aVar.JZ();
        bsv com_tencent_mm_protocal_c_bsv = (bsv) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bsv.vXz = new bdn().bj(d);
        x.d("MicroMsg.NetSceneVoiceAddr", g.zh() + " read file:" + this.filename + " readlen:" + d.length + " datalen:" + com_tencent_mm_protocal_c_bsv.vXz.wJD.toByteArray().length + " dataiLen:" + com_tencent_mm_protocal_c_bsv.vXz.wJB + " md5:" + com.tencent.mm.a.g.s(d) + " datamd5:" + com.tencent.mm.a.g.s(com_tencent_mm_protocal_c_bsv.vXz.wJD.toByteArray()));
        com_tencent_mm_protocal_c_bsv.ksU = (String) com.tencent.mm.kernel.g.Dj().CU().get(2, (Object) "");
        com_tencent_mm_protocal_c_bsv.vNW = this.hOX;
        com_tencent_mm_protocal_c_bsv.wRR = this.hYf;
        com_tencent_mm_protocal_c_bsv.vLj = this.hYg ? 1 : 0;
        com_tencent_mm_protocal_c_bsv.wRS = 0;
        com_tencent_mm_protocal_c_bsv.vIH = 0;
        com_tencent_mm_protocal_c_bsv.wRT = 0;
        com_tencent_mm_protocal_c_bsv.vIE = 0;
        com_tencent_mm_protocal_c_bsv.wTV = this.hYh;
        x.d("MicroMsg.NetSceneVoiceAddr", "clientId " + this.hYf);
        return a(eVar, this.gJQ, this);
    }

    protected final int a(q qVar) {
        return b.hmP;
    }

    protected final int Bh() {
        return 20;
    }

    protected final void a(a aVar) {
        this.gJT.a(3, g.getLine() + 40000, "ecurityCheckError", this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneVoiceAddr", g.zh() + " onGYNetEnd file:" + this.filename + " errtype:" + i2 + " errCode:" + i3);
        bsv com_tencent_mm_protocal_c_bsv = (bsv) ((b) qVar).hmg.hmo;
        bsw com_tencent_mm_protocal_c_bsw = (bsw) ((b) qVar).hmh.hmo;
        if (i2 == 0 && i3 == 0) {
            x.d("MicroMsg.NetSceneVoiceAddr", g.zh() + " onGYNetEnd  file:" + this.filename + " endflag:" + com_tencent_mm_protocal_c_bsw.vLj + " lst:" + com_tencent_mm_protocal_c_bsw.vLm);
            if (com_tencent_mm_protocal_c_bsv.vLj == 1) {
                this.hYi = new String[com_tencent_mm_protocal_c_bsw.vLm.size()];
                for (int i4 = 0; i4 < com_tencent_mm_protocal_c_bsw.vLm.size(); i4++) {
                    this.hYi[i4] = ((bdo) com_tencent_mm_protocal_c_bsw.vLm.get(i4)).wJF;
                }
                this.gJT.a(i2, i3, str, this);
                return;
            }
            this.hOX = com_tencent_mm_protocal_c_bsv.vXz.wJB + com_tencent_mm_protocal_c_bsv.vNW;
            long j = this.hWy ? 0 : 500;
            x.d("MicroMsg.NetSceneVoiceAddr", "onGYNetEnd file:" + this.filename + " delay:" + j);
            this.hkO.J(j, j);
            return;
        }
        x.e("MicroMsg.NetSceneVoiceAddr", g.zh() + " onGYNetEnd file:" + this.filename + " errType:" + i2 + " errCode:" + i3);
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.a.b.CTRL_INDEX;
    }
}
