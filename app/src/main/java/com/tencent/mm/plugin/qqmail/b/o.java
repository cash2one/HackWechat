package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.f;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.k.a;
import com.tencent.mm.network.q;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bqh;
import com.tencent.mm.protocal.c.bqi;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Random;

public final class o extends k implements com.tencent.mm.network.k {
    private String fDJ;
    public String filePath = null;
    private b gJQ;
    private e gJT;
    private f hBj;
    private int hlp = 0;
    private int hlq = 0;

    public o(String str, String str2, f fVar) {
        this.filePath = str;
        this.fDJ = str2 + "_" + System.nanoTime() + "_" + Math.abs(new Random().nextInt() / 2);
        this.hBj = fVar;
        x.i("MicroMsg.NetSceneUploadFie", "msgId: %s, filePath: %s", new Object[]{this.fDJ, this.filePath});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, netId: %d, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            bqi com_tencent_mm_protocal_c_bqi = (bqi) ((b) qVar).hmh.hmo;
            String str2 = com_tencent_mm_protocal_c_bqi.vGQ;
            x.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, clientId: %s, totalLen: %d, attachId: %s", new Object[]{com_tencent_mm_protocal_c_bqi.vGQ, Integer.valueOf(com_tencent_mm_protocal_c_bqi.vIB), com_tencent_mm_protocal_c_bqi.vYg});
            if (str2.equals(this.fDJ)) {
                this.hlq = com_tencent_mm_protocal_c_bqi.vIC;
                if (this.hlq < this.hlp) {
                    x.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, startPos: %d, totalLen: %d, continue to upload", new Object[]{Integer.valueOf(this.hlq), Integer.valueOf(this.hlp)});
                    if (a(this.hmA, this.gJT) < 0) {
                        x.e("MicroMsg.NetSceneUploadFie", "continue to upload fail");
                        if (this.gJT != null) {
                            this.gJT.a(i2, i3, str, this);
                        }
                        if (this.hBj != null) {
                            this.hBj.a(this.hlq, this.hlp, this);
                            return;
                        }
                        return;
                    }
                }
                String str3 = com_tencent_mm_protocal_c_bqi.vYg;
                x.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, finish upload, startPos: %d, totalLen: %d, attachId: %s", new Object[]{Integer.valueOf(this.hlq), Integer.valueOf(this.hlp), str3});
                if (this.gJT != null) {
                    this.gJT.a(i2, i3, str, this);
                }
                if (this.hBj != null) {
                    this.hBj.a(this.hlq, this.hlp, this);
                }
            }
        } else if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }

    protected final int Bh() {
        return 640;
    }

    protected final int a(q qVar) {
        if (!bh.ov(this.filePath) && com.tencent.mm.a.e.bO(this.filePath)) {
            return k.b.hmP;
        }
        x.e("MicroMsg.NetSceneUploadFie", "securityVerificationChecked failed, file not exist");
        return k.b.hmQ;
    }

    protected final void a(a aVar) {
    }

    public final int getType() {
        return 484;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        if (bh.ov(this.filePath)) {
            x.e("MicroMsg.NetSceneUploadFie", "doScene, filePath is null");
            return -1;
        } else if (com.tencent.mm.a.e.bO(this.filePath)) {
            if (this.hlp == 0) {
                this.hlp = com.tencent.mm.a.e.bN(this.filePath);
                x.i("MicroMsg.NetSceneUploadFie", "doScene, totalLen: %d", new Object[]{Integer.valueOf(this.hlp)});
            }
            int min = Math.min(this.hlp - this.hlq, WXMediaMessage.THUMB_LENGTH_LIMIT);
            x.i("MicroMsg.NetSceneUploadFie", "doScene, startPos: %d, dataLen: %d", new Object[]{Integer.valueOf(this.hlq), Integer.valueOf(min)});
            byte[] d = com.tencent.mm.a.e.d(this.filePath, this.hlq, min);
            if (d == null) {
                x.e("MicroMsg.NetSceneUploadFie", "doScene, read file buf is null");
                return -1;
            }
            x.i("MicroMsg.NetSceneUploadFie", "doScene, buf.length: %d", new Object[]{Integer.valueOf(d.length)});
            b.a aVar = new b.a();
            aVar.hmj = new bqh();
            aVar.hmk = new bqi();
            aVar.uri = "/cgi-bin/micromsg-bin/uploadfile";
            aVar.hmi = 484;
            aVar.hml = 0;
            aVar.hmm = 0;
            this.gJQ = aVar.JZ();
            bqh com_tencent_mm_protocal_c_bqh = (bqh) this.gJQ.hmg.hmo;
            com_tencent_mm_protocal_c_bqh.vGQ = this.fDJ;
            com_tencent_mm_protocal_c_bqh.vIB = this.hlp;
            com_tencent_mm_protocal_c_bqh.vIC = this.hlq;
            com_tencent_mm_protocal_c_bqh.vID = min;
            com_tencent_mm_protocal_c_bqh.vXz = n.N(d);
            x.i("MicroMsg.NetSceneUploadFie", "doScene, ret: %d", new Object[]{Integer.valueOf(a(eVar, this.gJQ, this))});
            return a(eVar, this.gJQ, this);
        } else {
            x.e("MicroMsg.NetSceneUploadFie", "doScene, file: %s not exist", new Object[]{this.filePath});
            return -1;
        }
    }

    public final bqi bkm() {
        if (this.gJQ != null) {
            return (bqi) this.gJQ.hmh.hmo;
        }
        return null;
    }
}
