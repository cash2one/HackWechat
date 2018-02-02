package com.tencent.mm.plugin.wear.model.d;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bql;
import com.tencent.mm.protocal.c.bqm;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.UUID;

public final class c extends k implements com.tencent.mm.network.k {
    private String clientId;
    String filename = null;
    private b gJQ;
    e gJT;
    public boolean hWy = false;
    private boolean hYg = false;
    private int hYk = 0;
    ak hkO = new ak(new 1(this), true);
    public int pSO;
    public String talker;
    int tiH = 0;
    public String tiI;
    public boolean tiJ;

    public c(String str, String str2, int i) {
        this.pSO = i;
        this.talker = str2;
        this.filename = str;
        this.hYk = 0;
        this.clientId = UUID.randomUUID().toString();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        int bN = com.tencent.mm.a.e.bN(this.filename);
        if (bN <= 0) {
            x.e("MicroMsg.Wear.NetSceneVoiceToText", "doScene file length is zero: %s", this.filename);
            return -1;
        }
        int i = bN - this.tiH;
        if (i > 3960) {
            i = 3960;
        } else if (i < 3300 && !this.hWy) {
            x.e("MicroMsg.Wear.NetSceneVoiceToText", "try to send a buf less than MIN_SEND_BYTE_PER_PACK: canReadLen=%d | isRecordFinished=%b", Integer.valueOf(i), Boolean.valueOf(this.hWy));
            return -1;
        } else if (this.hWy) {
            this.hYg = true;
        }
        x.i("MicroMsg.Wear.NetSceneVoiceToText", "fileLength: %d | readOffset: %d | isRecordFinish=%b | endFlag=%b | filename=%s", Integer.valueOf(bN), Integer.valueOf(this.tiH), Boolean.valueOf(this.hWy), Boolean.valueOf(this.hYg), this.filename);
        byte[] d = com.tencent.mm.a.e.d(this.filename, this.tiH, i);
        if (d != null) {
            a aVar = new a();
            aVar.hmj = new bql();
            aVar.hmk = new bqm();
            aVar.uri = "/cgi-bin/micromsg-bin/uploadinputvoice";
            aVar.hmi = 349;
            aVar.hml = 158;
            aVar.hmm = 1000000158;
            this.gJQ = aVar.JZ();
            bql com_tencent_mm_protocal_c_bql = (bql) this.gJQ.hmg.hmo;
            ar.Hg();
            com_tencent_mm_protocal_c_bql.ksU = (String) com.tencent.mm.z.c.CU().get(2, (Object) "");
            com_tencent_mm_protocal_c_bql.vXz = new bdn().bj(d);
            com_tencent_mm_protocal_c_bql.vNW = this.tiH;
            com_tencent_mm_protocal_c_bql.wRR = this.clientId;
            com_tencent_mm_protocal_c_bql.vLj = this.hYg ? 1 : 0;
            com_tencent_mm_protocal_c_bql.wRS = 0;
            com_tencent_mm_protocal_c_bql.vIH = 0;
            com_tencent_mm_protocal_c_bql.wRT = this.hYk;
            com_tencent_mm_protocal_c_bql.vIE = 0;
            bN = a(eVar, this.gJQ, this);
            this.tiH = com_tencent_mm_protocal_c_bql.vXz.wJB + com_tencent_mm_protocal_c_bql.vNW;
            long j = this.hWy ? 0 : 500;
            x.i("MicroMsg.Wear.NetSceneVoiceToText", "doScene filename=%s | delay=%d | ret=%d", this.filename, Long.valueOf(j), Integer.valueOf(bN));
            this.hkO.J(j, j);
            return bN;
        } else if (this.hYg) {
            return 0;
        } else {
            x.e("MicroMsg.Wear.NetSceneVoiceToText", "Can not read file: canReadLen=%d | isRecordFinish=%b | endFlag=%b", Integer.valueOf(i), Boolean.valueOf(this.hWy), Boolean.valueOf(this.hYg));
            return -1;
        }
    }

    protected final int a(q qVar) {
        return b.hmP;
    }

    protected final int Bh() {
        return 20;
    }

    protected final void a(a aVar) {
        this.gJT.a(3, 0, "securityCheckError", this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.Wear.NetSceneVoiceToText", "onGYNetEnd errorType=%d | errorCode=%d |filename=%s", Integer.valueOf(i2), Integer.valueOf(i3), this.filename);
        bqm com_tencent_mm_protocal_c_bqm = (bqm) ((b) qVar).hmh.hmo;
        if (i2 == 0 && i3 == 0) {
            x.i("MicroMsg.Wear.NetSceneVoiceToText", "resp EndFlag=%d | Text=%s", Integer.valueOf(com_tencent_mm_protocal_c_bqm.vLj), d(com_tencent_mm_protocal_c_bqm.wRU));
            if (com_tencent_mm_protocal_c_bqm.vLj == 1) {
                this.tiJ = true;
                String d = d(com_tencent_mm_protocal_c_bqm.wRU);
                if (d != null) {
                    this.tiI = d;
                }
                this.gJT.a(i2, i3, str, this);
                return;
            }
            return;
        }
        this.gJT.a(i2, i3, str, this);
    }

    private static String d(bdn com_tencent_mm_protocal_c_bdn) {
        if (com_tencent_mm_protocal_c_bdn == null || com_tencent_mm_protocal_c_bdn.wJD == null) {
            return null;
        }
        return com_tencent_mm_protocal_c_bdn.wJD.cdp();
    }

    public final int getType() {
        return 349;
    }
}
