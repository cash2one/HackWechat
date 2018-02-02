package com.tencent.mm.be;

import com.tencent.mm.a.g;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.bqp;
import com.tencent.mm.protocal.c.bqq;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends k implements com.tencent.mm.network.k {
    private String filemd5;
    String filename;
    private b gJQ;
    e gJT;
    private String hOU;
    private int hOV;
    private int hOW;
    int hOX;
    private int hOY;
    ak hkO;
    private int sampleRate;

    public a(String str, int i, int i2, int i3, int i4) {
        this.hOU = null;
        this.filemd5 = null;
        this.filename = null;
        this.sampleRate = 0;
        this.hOV = 0;
        this.hOW = 0;
        this.hOX = 0;
        this.hOY = 5;
        this.hkO = new ak(new 1(this), true);
        this.hOU = bh.Wp();
        this.filename = str;
        this.hOY = i;
        this.sampleRate = i2;
        this.hOV = i3;
        this.hOW = i4;
        this.filemd5 = g.s(com.tencent.mm.a.e.d(this.filename, 0, com.tencent.mm.a.e.bN(this.filename)));
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i = 3960;
        this.gJT = eVar2;
        int bN = com.tencent.mm.a.e.bN(this.filename);
        x.d("MicroMsg.NetSceneUploadMedia", com.tencent.mm.compatible.util.g.zh() + " read file:" + this.filename + " filelen:" + bN + " oldoff:" + this.hOX + "this.filemd5 " + this.filemd5);
        if (bN <= 0) {
            x.e("MicroMsg.NetSceneUploadMedia", "read failed :" + this.filename);
            return -1;
        }
        int i2 = bN - this.hOX;
        if (i2 <= 3960) {
            i = i2;
        }
        x.i("MicroMsg.NetSceneUploadMedia", com.tencent.mm.compatible.util.g.zh() + " read file:" + this.filename + " filelen:" + bN + " oldoff:" + this.hOX + "  canReadLen " + i);
        byte[] d = com.tencent.mm.a.e.d(this.filename, this.hOX, i);
        if (d == null) {
            x.e("MicroMsg.NetSceneUploadMedia", "read data error");
            return -1;
        }
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new bqp();
        aVar.hmk = new bqq();
        aVar.uri = "/cgi-bin/micromsg-bin/mmuploadmedia";
        aVar.hmi = 240;
        aVar.hml = 111;
        aVar.hmm = 1000000111;
        this.gJQ = aVar.JZ();
        bqp com_tencent_mm_protocal_c_bqp = (bqp) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bqp.wRY = new bdo().UA(this.hOU);
        com_tencent_mm_protocal_c_bqp.vXz = new bdn().bj(d);
        com_tencent_mm_protocal_c_bqp.vID = d.length;
        com_tencent_mm_protocal_c_bqp.wRZ = new bdo().UA(this.filemd5);
        com_tencent_mm_protocal_c_bqp.vIB = bN;
        com_tencent_mm_protocal_c_bqp.vIC = this.hOX;
        com_tencent_mm_protocal_c_bqp.njA = this.hOY;
        com_tencent_mm_protocal_c_bqp.wSa = 1;
        com_tencent_mm_protocal_c_bqp.wSb = this.sampleRate;
        com_tencent_mm_protocal_c_bqp.wSc = this.hOV;
        com_tencent_mm_protocal_c_bqp.wSd = this.hOW;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 240;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneUploadMedia", com.tencent.mm.compatible.util.g.zh() + " onGYNetEnd file:" + this.filename + " errtype:" + i2 + " errCode:" + i3);
        bqp com_tencent_mm_protocal_c_bqp = (bqp) ((b) qVar).hmg.hmo;
        String str2 = ((bqq) ((b) qVar).hmh.hmo).vZq;
        x.i("MicroMsg.NetSceneUploadMedia", "fileName:%s, md5:%s, totalLen:%d, dataLen:%d, startPos:%d", new Object[]{this.filename, str2, Integer.valueOf(com_tencent_mm_protocal_c_bqp.vIB), Integer.valueOf(com_tencent_mm_protocal_c_bqp.vID), Integer.valueOf(com_tencent_mm_protocal_c_bqp.vIC)});
        if (i2 != 0 || i3 != 0) {
            x.e("MicroMsg.NetSceneUploadMedia", com.tencent.mm.compatible.util.g.zh() + " onGYNetEnd file:" + this.filename + " errType:" + i2 + " errCode:" + i3);
            this.gJT.a(i2, i3, str, this);
        } else if (com_tencent_mm_protocal_c_bqp.vIB > com_tencent_mm_protocal_c_bqp.vID + com_tencent_mm_protocal_c_bqp.vIC || str2 == null || str2.equals("0")) {
            this.hOX = com_tencent_mm_protocal_c_bqp.vXz.wJB + com_tencent_mm_protocal_c_bqp.vIC;
            x.d("MicroMsg.NetSceneUploadMedia", "onGYNetEnd file:" + this.filename + " delay:500");
            this.hkO.J(500, 500);
        } else {
            this.gJT.a(i2, i3, str, this);
        }
    }

    protected final int a(q qVar) {
        return k.b.hmP;
    }

    protected final int Bh() {
        return 60;
    }
}
