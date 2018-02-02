package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.cq;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.bqd;
import com.tencent.mm.protocal.c.bqe;
import com.tencent.mm.protocal.c.sa;
import com.tencent.mm.protocal.c.sb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class f extends k implements com.tencent.mm.network.k {
    private EmojiInfo foU;
    private final b gJQ;
    private e gJT;
    private boolean lyG = true;

    public f(EmojiInfo emojiInfo) {
        this.foU = emojiInfo;
        a aVar = new a();
        aVar.hmj = new sa();
        aVar.hmk = new sb();
        aVar.uri = "/cgi-bin/micromsg-bin/mmemojiupload";
        aVar.hmi = 703;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        sa saVar = (sa) this.gJQ.hmg.hmo;
        bqd com_tencent_mm_protocal_c_bqd = new bqd();
        if (this.foU != null) {
            i.aBE().lwL.a(ac.getContext(), this.foU);
            com_tencent_mm_protocal_c_bqd.vZU = this.foU.Nr();
            com_tencent_mm_protocal_c_bqd.vIB = this.foU.field_size;
            saVar.wab.add(com_tencent_mm_protocal_c_bqd);
        }
    }

    public final int getType() {
        return 703;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i = 8192;
        int i2 = -1;
        this.gJT = eVar2;
        bqd com_tencent_mm_protocal_c_bqd = (bqd) ((sa) this.gJQ.hmg.hmo).wab.get(0);
        int i3;
        Object a;
        byte[] bArr;
        Object obj;
        if (this.lyG) {
            x.d("MicroMsg.emoji.NetSceneEmojiUpload", "dispatcher, firstSend. md5=" + com_tencent_mm_protocal_c_bqd.vZU);
            com_tencent_mm_protocal_c_bqd.vIC = 0;
            i3 = this.foU.field_size + 0;
            if (i3 <= 8192) {
                i = i3;
            }
            if ((this.foU.field_reserved4 & EmojiInfo.xAz) == EmojiInfo.xAz) {
                a = com.tencent.mm.plugin.emoji.e.e.aAR().a(this.foU);
                if (bh.bw(a)) {
                    x.w("MicroMsg.emoji.NetSceneEmojiUpload", "buffer is null.");
                    bArr = new byte[0];
                } else {
                    obj = new byte[i];
                    x.d("MicroMsg.emoji.NetSceneEmojiUpload", "total length:%d dataLen:%d ", new Object[]{Integer.valueOf(a.length), Integer.valueOf(i)});
                    System.arraycopy(a, 0, obj, 0, i);
                    bArr = obj;
                }
            } else {
                bArr = this.foU.eI(0, i);
            }
            if (bArr == null || bArr.length <= 0) {
                x.e("MicroMsg.emoji.NetSceneEmojiUpload", "readFromFile is null.");
                return -1;
            }
            com_tencent_mm_protocal_c_bqd.vIC = 0;
            com_tencent_mm_protocal_c_bqd.wRN = new com.tencent.mm.bq.b(bArr);
            String str = "MicroMsg.emoji.NetSceneEmojiUpload";
            String str2 = "buf len:%d, string len:%d dispatcher, first emoji start:%d emoji total:%d";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(bArr.length);
            objArr[1] = Integer.valueOf(com_tencent_mm_protocal_c_bqd.wRN.oz.length);
            objArr[2] = Integer.valueOf(this.foU == null ? -1 : this.foU.field_start);
            if (this.foU != null) {
                i2 = this.foU.field_size;
            }
            objArr[3] = Integer.valueOf(i2);
            x.i(str, str2, objArr);
            return a(eVar, this.gJQ, this);
        } else if (this.foU == null || this.foU.field_start == 0) {
            x.e("MicroMsg.emoji.NetSceneEmojiUpload", "emoji info is null. or start position is 0.");
            return -1;
        } else {
            i3 = this.foU.field_size - this.foU.field_start;
            if (i3 <= 8192) {
                i = i3;
            }
            if ((this.foU.field_reserved4 & EmojiInfo.xAz) == EmojiInfo.xAz) {
                a = com.tencent.mm.plugin.emoji.e.e.aAR().a(this.foU);
                if (bh.bw(a)) {
                    x.w("MicroMsg.emoji.NetSceneEmojiUpload", "buffer is null.");
                    bArr = new byte[0];
                } else {
                    obj = new byte[i];
                    x.d("MicroMsg.emoji.NetSceneEmojiUpload", "total length:%d dataLen:%d", new Object[]{Integer.valueOf(a.length), Integer.valueOf(i)});
                    System.arraycopy(a, this.foU.field_start, obj, 0, i);
                    bArr = obj;
                }
            } else {
                bArr = this.foU.eI(this.foU.field_start, i);
            }
            if (bArr == null || bArr.length <= 0) {
                x.e("MicroMsg.emoji.NetSceneEmojiUpload", "readFromFile is null.");
                return -1;
            }
            i3 = bArr.length;
            com_tencent_mm_protocal_c_bqd.vIC = this.foU.field_start;
            com_tencent_mm_protocal_c_bqd.wRN = new com.tencent.mm.bq.b(bArr);
            x.i("MicroMsg.emoji.NetSceneEmojiUpload", "buf len:%d, string len:%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(com_tencent_mm_protocal_c_bqd.wRN.oz.length)});
            x.d("MicroMsg.emoji.NetSceneEmojiUpload", "dispatcher, start:" + this.foU.field_start + ", total:" + this.foU.field_size + ", len:" + i3);
            return a(eVar, this.gJQ, this);
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.emoji.NetSceneEmojiUpload", "onGYNetEnd  errtype:" + i2 + " errcode:" + i3);
        if (i2 == 0 && i3 == 0) {
            sa saVar = (sa) ((b) qVar).hmg.hmo;
            sb sbVar = (sb) ((b) qVar).hmh.hmo;
            if (saVar.wab.size() != sbVar.wab.size()) {
                x.e("MicroMsg.emoji.NetSceneEmojiUpload", "onGYNetEnd failed. RequestSize not equal RespSize. req size:" + saVar.wab.size() + ", resp size:" + sbVar.wab.size());
                aBO();
                this.gJT.a(i2, i3, str, this);
                d(this.foU, false);
                return;
            }
            bqe com_tencent_mm_protocal_c_bqe = null;
            if (sbVar.wab != null && sbVar.wab.size() > 0) {
                com_tencent_mm_protocal_c_bqe = (bqe) sbVar.wab.get(0);
            }
            String str2;
            if (com_tencent_mm_protocal_c_bqe == null || com_tencent_mm_protocal_c_bqe.vZU == null || !com_tencent_mm_protocal_c_bqe.vZU.equals(this.foU.Nr()) || com_tencent_mm_protocal_c_bqe.vIC < this.foU.field_start) {
                int i4;
                String str3 = "MicroMsg.emoji.NetSceneEmojiUpload";
                str2 = "md5:%s invalid server return value. respInfo.TotalLen:%d respInfo.StartPos:%d emoji.getStart():%d emoji total:%d";
                Object[] objArr = new Object[5];
                objArr[0] = com_tencent_mm_protocal_c_bqe.vZU;
                objArr[1] = Integer.valueOf(com_tencent_mm_protocal_c_bqe.vIB);
                objArr[2] = Integer.valueOf(com_tencent_mm_protocal_c_bqe == null ? -1 : com_tencent_mm_protocal_c_bqe.vIC);
                if (this.foU == null) {
                    i4 = -1;
                } else {
                    i4 = this.foU.field_start;
                }
                objArr[3] = Integer.valueOf(i4);
                if (this.foU == null) {
                    i4 = -1;
                } else {
                    i4 = this.foU.field_size;
                }
                objArr[4] = Integer.valueOf(i4);
                x.e(str3, str2, objArr);
                aBO();
                this.gJT.a(4, -2, "", this);
                d(this.foU, false);
                return;
            } else if (com_tencent_mm_protocal_c_bqe != null && this.foU != null && com_tencent_mm_protocal_c_bqe.vJU != 0 && com_tencent_mm_protocal_c_bqe.vIC == com_tencent_mm_protocal_c_bqe.vIB && com_tencent_mm_protocal_c_bqe.vIC > 0) {
                x.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] emoji upload success, but md5 backup faild.try to do batch emoji backup. %s respInfo.Ret:%d respInfo.StartPos:%d respInfo.TotalLen:%d", new Object[]{this.foU.Nr(), Integer.valueOf(com_tencent_mm_protocal_c_bqe.vJU), Integer.valueOf(com_tencent_mm_protocal_c_bqe.vIC), Integer.valueOf(com_tencent_mm_protocal_c_bqe.vIB)});
                aBO();
                this.gJT.a(i2, i3, "", this);
                return;
            } else if (sbVar.wJr.vJU == 0 && (com_tencent_mm_protocal_c_bqe == null || com_tencent_mm_protocal_c_bqe.vJU == 0)) {
                if (this.lyG) {
                    this.lyG = false;
                }
                if (com_tencent_mm_protocal_c_bqe.vIC >= com_tencent_mm_protocal_c_bqe.vIB) {
                    this.foU.field_start = 0;
                    this.foU.field_state = EmojiInfo.xAs;
                    this.foU.field_needupload = EmojiInfo.xAx;
                    i.aBE().lwL.p(this.foU);
                    this.gJT.a(i2, i3, "", this);
                    d(this.foU, true);
                    x.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] emoji upload success.");
                    return;
                }
                x.i("MicroMsg.emoji.NetSceneEmojiUpload", "next start pos is :%d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bqe.vIC)});
                this.foU.field_start = com_tencent_mm_protocal_c_bqe.vIC;
                i.aBE().lwL.p(this.foU);
                if (a(this.hmA, this.gJT) < 0) {
                    this.gJT.a(3, -1, "", this);
                    d(this.foU, false);
                    return;
                }
                return;
            } else {
                str2 = "MicroMsg.emoji.NetSceneEmojiUpload";
                String str4 = "onGYNetEnd failed. resp.BaseResponse.Ret:%d respInfo.Ret:%d";
                Object[] objArr2 = new Object[2];
                objArr2[0] = Integer.valueOf(sbVar.wJr.vJU);
                objArr2[1] = Integer.valueOf(com_tencent_mm_protocal_c_bqe == null ? -1 : com_tencent_mm_protocal_c_bqe.vJU);
                x.e(str2, str4, objArr2);
                aBO();
                this.gJT.a(i2, i3, "", this);
                return;
            }
        }
        aBO();
        this.gJT.a(i2, i3, str, this);
        d(this.foU, false);
    }

    protected final int Bh() {
        return 256;
    }

    protected final int a(q qVar) {
        return k.b.hmP;
    }

    private void aBO() {
        this.foU.field_start = 0;
        i.aBE().lwL.p(this.foU);
    }

    private static void d(EmojiInfo emojiInfo, boolean z) {
        if (emojiInfo != null && !bh.ov(emojiInfo.Nr())) {
            x.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] publicEmojiSyncTaskEvent emoji md5:%s success:%b", new Object[]{emojiInfo.Nr(), Boolean.valueOf(z)});
            com.tencent.mm.sdk.b.b cqVar = new cq();
            cqVar.fqQ.fqR = emojiInfo.Nr();
            cqVar.fqQ.fpr = 0;
            cqVar.fqQ.success = z;
            com.tencent.mm.sdk.b.a.xef.m(cqVar);
        }
    }
}
