package com.tencent.mm.plugin.emoji.f;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ag.f;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ac;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bqf;
import com.tencent.mm.protocal.c.bqg;
import com.tencent.mm.protocal.c.ry;
import com.tencent.mm.protocal.c.rz;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.y.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bc;
import com.tencent.mm.z.c;
import junit.framework.Assert;

public final class r extends k implements com.tencent.mm.network.k {
    private EmojiInfo foU;
    private final b gJQ;
    private e gJT;
    private long hzX;
    private boolean lyG;

    public r(String str, String str2, EmojiInfo emojiInfo, long j) {
        this(str, str2, emojiInfo, j, (byte) 0);
    }

    private r(String str, String str2, EmojiInfo emojiInfo, long j, byte b) {
        int i = 1;
        this.lyG = true;
        this.hzX = 0;
        boolean z = (str2 == null || str2.length() <= 0 || emojiInfo == null) ? false : true;
        Assert.assertTrue(z);
        this.hzX = j;
        this.foU = emojiInfo;
        a aVar = new a();
        aVar.hmj = new bqf();
        aVar.hmk = new bqg();
        aVar.uri = "/cgi-bin/micromsg-bin/sendemoji";
        aVar.hmi = ac.CTRL_BYTE;
        aVar.hml = 68;
        aVar.hmm = 1000000068;
        this.gJQ = aVar.JZ();
        i.aBE().lwL.a(com.tencent.mm.sdk.platformtools.ac.getContext(), emojiInfo);
        bqf com_tencent_mm_protocal_c_bqf = (bqf) this.gJQ.hmg.hmo;
        ry ryVar = new ry();
        ryVar.vZU = emojiInfo.Nr();
        ryVar.vZY = str;
        ryVar.nko = str2;
        ryVar.vIB = emojiInfo.field_size;
        ryVar.vZW = emojiInfo.we();
        ryVar.ktN = emojiInfo.field_type;
        ryVar.vHc = bc.HD();
        ryVar.vZZ = 0;
        if (str2.endsWith("@chatroom")) {
            i = 2;
        }
        if (emojiInfo.field_catalog == EmojiInfo.xAj) {
            ryVar.vZX = "56,2," + i;
        } else if (emojiInfo.field_catalog == EmojiInfo.xAi) {
            ryVar.vZX = "56,1," + i;
        }
        com_tencent_mm_protocal_c_bqf.wab.add(ryVar);
        com_tencent_mm_protocal_c_bqf.wRO = com_tencent_mm_protocal_c_bqf.wab.size();
    }

    public final int getType() {
        return ac.CTRL_BYTE;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i = 8192;
        this.gJT = eVar2;
        ry ryVar = (ry) ((bqf) this.gJQ.hmg.hmo).wab.get(0);
        if (this.lyG) {
            x.d("MicroMsg.emoji.NetSceneUploadEmoji", "dispatcher, firstSend. md5=" + ryVar.vZU);
            ryVar.vZV = new bdn();
            ryVar.vIC = 0;
            return a(eVar, this.gJQ, this);
        }
        byte[] bArr;
        int i2 = this.foU.field_size - this.foU.field_start;
        if (i2 <= 8192) {
            i = i2;
        }
        if ((this.foU.field_reserved4 & EmojiInfo.xAz) == EmojiInfo.xAz) {
            Object a = com.tencent.mm.plugin.emoji.e.e.aAR().a(this.foU);
            if (bh.bw(a)) {
                x.w("MicroMsg.emoji.NetSceneUploadEmoji", "buffer is null.");
                bArr = new byte[0];
            } else {
                Object obj = new byte[i];
                x.d("MicroMsg.emoji.NetSceneUploadEmoji", "total length:%d dataLen:%d", new Object[]{Integer.valueOf(a.length), Integer.valueOf(i)});
                System.arraycopy(a, this.foU.field_start, obj, 0, i);
                bArr = obj;
            }
        } else {
            bArr = this.foU.eI(this.foU.field_start, i);
        }
        if (EmojiLogic.aj(bArr) == EmojiInfo.xAa && this.lyG) {
            x.e("MicroMsg.emoji.NetSceneUploadEmoji", "Bitmap type error. delete emoji file.");
            this.foU.ckt();
            return -1;
        } else if (bArr == null || bArr.length <= 0) {
            x.e("MicroMsg.emoji.NetSceneUploadEmoji", "readFromFile is null.");
            return -1;
        } else {
            i2 = bArr.length;
            ryVar.vIC = this.foU.field_start;
            ryVar.vZV = new bdn().b(com.tencent.mm.bq.b.bc(bArr));
            if (f.eE(ryVar.nko)) {
                ar.Hg();
                ryVar.vHc = com.tencent.mm.ag.a.e.kr(c.Fa().dH(this.hzX).gjF);
                x.d("MicroMsg.emoji.NetSceneUploadEmoji", "MsgSource:%s", new Object[]{ryVar.vHc});
            }
            x.d("MicroMsg.emoji.NetSceneUploadEmoji", "dispatcher, start:" + this.foU.field_start + ", total:" + this.foU.field_size + ", len:" + i2);
            return a(eVar, this.gJQ, this);
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            bqf com_tencent_mm_protocal_c_bqf = (bqf) ((b) qVar).hmg.hmo;
            bqg com_tencent_mm_protocal_c_bqg = (bqg) ((b) qVar).hmh.hmo;
            if (com_tencent_mm_protocal_c_bqf.wab.size() != com_tencent_mm_protocal_c_bqg.wab.size()) {
                x.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd failed. RequestSize not equal RespSize. req size:" + com_tencent_mm_protocal_c_bqg.wab.size() + ", resp size:" + com_tencent_mm_protocal_c_bqf.wab.size());
                this.gJT.a(i2, i3, str, this);
                return;
            }
            rz rzVar = (rz) com_tencent_mm_protocal_c_bqg.wab.get(0);
            if (rzVar.vZU == null || !rzVar.vZU.equals(this.foU.Nr()) || rzVar.vIC < this.foU.field_start) {
                x.e("MicroMsg.emoji.NetSceneUploadEmoji", "invalid server return value; start=" + rzVar.vIC + ", size=" + this.foU.field_size);
                this.gJT.a(4, -2, "", this);
                this.foU.field_start = 0;
                i.aBE().lwL.q(this.foU);
                return;
            } else if (com_tencent_mm_protocal_c_bqg.wJr.vJU != 0) {
                x.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd failed. resp.BaseResponse.Ret:%d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bqg.wJr.vJU)});
                this.gJT.a(4, -2, "", this);
                return;
            } else {
                if (this.lyG) {
                    this.lyG = false;
                }
                if (rzVar.vIC >= rzVar.vIB) {
                    x.d("MicroMsg.emoji.NetSceneUploadEmoji", "respInfo.getMsgID() " + rzVar.waa);
                    ar.Hg();
                    au dH = c.Fa().dH(this.hzX);
                    x.d("MicroMsg.emoji.NetSceneUploadEmoji", "dkmsgid  set svrmsgid %d -> %d", new Object[]{Integer.valueOf(rzVar.waa), Integer.valueOf(com.tencent.mm.platformtools.r.idu)});
                    if (CdnLogic.kMediaTypeFavoriteBigFile == com.tencent.mm.platformtools.r.idt && com.tencent.mm.platformtools.r.idu != 0) {
                        rzVar.waa = com.tencent.mm.platformtools.r.idu;
                        com.tencent.mm.platformtools.r.idu = 0;
                    }
                    dH.ap((long) rzVar.waa);
                    ar.Hg();
                    c.Fa().a(this.hzX, dH);
                    this.foU.field_start = 0;
                    this.foU.field_lastUseTime = System.currentTimeMillis();
                    this.foU.field_state = EmojiInfo.xAs;
                    i.aBE().lwL.q(this.foU);
                    if (dH.aNc()) {
                        com.tencent.mm.modelstat.b.hPA.a(dH, h.g(dH));
                    } else {
                        com.tencent.mm.modelstat.b.hPA.f(dH);
                    }
                    this.gJT.a(i2, i3, "", this);
                    return;
                }
                this.foU.field_start = rzVar.vIC;
                this.foU.field_lastUseTime = System.currentTimeMillis();
                i.aBE().lwL.q(this.foU);
                if (a(this.hmA, this.gJT) < 0) {
                    this.gJT.a(3, -1, "", this);
                    return;
                }
                return;
            }
        }
        x.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd failed errtype:" + i2 + " errcode:" + i3);
        this.gJT.a(i2, i3, str, this);
    }

    protected final int Bh() {
        return 256;
    }

    protected final int a(q qVar) {
        return k.b.hmP;
    }
}
