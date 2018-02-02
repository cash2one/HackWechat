package com.tencent.mm.bg;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bql;
import com.tencent.mm.protocal.c.bqm;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Set;

public final class d extends a implements k {
    String filename;
    private b gJQ;
    e gJT;
    int hOX;
    boolean hWy;
    private long hYf;
    private boolean hYg;
    private String[] hYi;
    private int hYk;
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

    public d(String str, int i) {
        this.retCode = 0;
        this.hWy = false;
        this.hOX = 0;
        this.filename = null;
        this.hYf = -1;
        this.hYg = false;
        this.hYk = 0;
        this.hYi = new String[0];
        this.hkO = new ak(new 1(this), true);
        this.hYf = (long) (bh.Wp()).hashCode();
        this.filename = str;
        this.hYk = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        int bN = com.tencent.mm.a.e.bN(this.filename);
        x.d("MicroMsg.NetSceneVoiceInput", "read file: %s, filelen: %d, oldoff: %d, isFin: %b", new Object[]{this.filename, Integer.valueOf(bN), Integer.valueOf(this.hOX), Boolean.valueOf(this.hWy)});
        if (bN <= 0) {
            x.e("MicroMsg.NetSceneVoiceInput", "read failed :" + this.filename);
            this.retCode = g.getLine() + 40000;
            return -1;
        }
        int i = bN - this.hOX;
        if (i > 3960) {
            i = 3960;
        } else if (i < 3300 && !this.hWy) {
            x.e("MicroMsg.NetSceneVoiceInput", g.zh() + " read failed :" + this.filename + "can read:" + i + " isfinish:" + this.hWy);
            this.retCode = g.getLine() + 40000;
            return -1;
        } else if (this.hWy) {
            this.hYg = true;
        }
        x.d("MicroMsg.NetSceneVoiceInput", "read file: %s, filelen: %d, oldoff: %b, isFin:%b, endFlag: %b", new Object[]{this.filename, Integer.valueOf(bN), Boolean.valueOf(this.hWy), Boolean.valueOf(this.hWy), Boolean.valueOf(this.hYg)});
        byte[] d = com.tencent.mm.a.e.d(this.filename, this.hOX, i);
        if (d == null) {
            x.e("MicroMsg.NetSceneVoiceInput", g.zh() + " read failed :" + this.filename + " read:" + i);
            this.retCode = g.getLine() + 40000;
            return -1;
        }
        a aVar = new a();
        aVar.hmj = new bql();
        aVar.hmk = new bqm();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadinputvoice";
        aVar.hmi = 349;
        aVar.hml = 158;
        aVar.hmm = 1000000158;
        this.gJQ = aVar.JZ();
        bql com_tencent_mm_protocal_c_bql = (bql) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bql.ksU = (String) com.tencent.mm.kernel.g.Dj().CU().get(2, "");
        com_tencent_mm_protocal_c_bql.vXz = new bdn().bj(d);
        x.d("MicroMsg.NetSceneVoiceInput", g.zh() + " read file:" + this.filename + " readlen:" + d.length + " datalen:" + com_tencent_mm_protocal_c_bql.vXz.wJD.toByteArray().length + " dataiLen:" + com_tencent_mm_protocal_c_bql.vXz.wJB + " md5:" + com.tencent.mm.a.g.s(d) + " datamd5:" + com.tencent.mm.a.g.s(com_tencent_mm_protocal_c_bql.vXz.wJD.toByteArray()));
        com_tencent_mm_protocal_c_bql.vNW = this.hOX;
        com_tencent_mm_protocal_c_bql.wRR = this.hYf;
        com_tencent_mm_protocal_c_bql.vLj = this.hYg ? 1 : 0;
        com_tencent_mm_protocal_c_bql.wRS = 0;
        com_tencent_mm_protocal_c_bql.vIH = 0;
        com_tencent_mm_protocal_c_bql.wRT = this.hYk;
        com_tencent_mm_protocal_c_bql.vIE = 0;
        x.d("MicroMsg.NetSceneVoiceInput", "clientId " + this.hYf);
        return a(eVar, this.gJQ, this);
    }

    protected final int a(q qVar) {
        return com.tencent.mm.ae.k.b.hmP;
    }

    protected final int Bh() {
        return 20;
    }

    protected final void a(com.tencent.mm.ae.k.a aVar) {
        this.gJT.a(3, g.getLine() + 40000, "ecurityCheckError", this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneVoiceInput", "onGYNetEnd file:" + this.filename + " errtype:" + i2 + " errCode:" + i3);
        bql com_tencent_mm_protocal_c_bql = (bql) ((b) qVar).hmg.hmo;
        bqm com_tencent_mm_protocal_c_bqm = (bqm) ((b) qVar).hmh.hmo;
        if (i2 == 0 && i3 == 0) {
            x.d("MicroMsg.NetSceneVoiceInput", g.zh() + " onGYNetEnd  file:" + this.filename + " endflag:" + com_tencent_mm_protocal_c_bqm.vLj);
            if (com_tencent_mm_protocal_c_bql.vLj == 1) {
                if (!(com_tencent_mm_protocal_c_bqm.wRU == null || com_tencent_mm_protocal_c_bqm.wRU.wJD == null)) {
                    this.hYi = new String[]{com_tencent_mm_protocal_c_bqm.wRU.wJD.cdp()};
                }
                this.gJT.a(i2, i3, str, this);
                return;
            }
            this.hOX = com_tencent_mm_protocal_c_bql.vXz.wJB + com_tencent_mm_protocal_c_bql.vNW;
            long j = this.hWy ? 0 : 500;
            x.d("MicroMsg.NetSceneVoiceInput", "onGYNetEnd file:" + this.filename + " delay:" + j);
            this.hkO.J(j, j);
            return;
        }
        x.e("MicroMsg.NetSceneVoiceInput", g.zh() + " onGYNetEnd file:" + this.filename + " errType:" + i2 + " errCode:" + i3);
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 349;
    }
}
