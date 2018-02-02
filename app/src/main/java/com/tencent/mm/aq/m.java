package com.tencent.mm.aq;

import android.graphics.BitmapFactory.Options;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bqt;
import com.tencent.mm.protocal.c.bqu;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;

public final class m extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;
    private int gLQ;
    private e hBU;
    private a hBV;

    public m(int i, bqt com_tencent_mm_protocal_c_bqt, e eVar, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, a aVar) {
        int i2;
        a aVar2 = new a();
        aVar2.hmj = new bqt();
        aVar2.hmk = new bqu();
        aVar2.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
        aVar2.hmi = 110;
        aVar2.hml = 9;
        aVar2.hmm = 1000000009;
        this.gJQ = aVar2.JZ();
        this.hBV = aVar;
        this.gLQ = i;
        this.hBU = eVar;
        bqt com_tencent_mm_protocal_c_bqt2 = (bqt) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bqt2.vGX = com_tencent_mm_protocal_c_bqt.vGX;
        com_tencent_mm_protocal_c_bqt2.vGY = com_tencent_mm_protocal_c_bqt.vGY;
        com_tencent_mm_protocal_c_bqt2.wSf = com_tencent_mm_protocal_c_bqt.wSf;
        com_tencent_mm_protocal_c_bqt2.ngq = com_tencent_mm_protocal_c_bqt.ngq;
        com_tencent_mm_protocal_c_bqt2.vHc = com_tencent_mm_protocal_c_bqt.vHc;
        com_tencent_mm_protocal_c_bqt2.vQD = com_tencent_mm_protocal_c_bqt.vQD;
        Options UL = d.UL(o.Pw().m(eVar.hzS, "", ""));
        com_tencent_mm_protocal_c_bqt2.wSn = UL != null ? UL.outWidth : 0;
        if (UL != null) {
            i2 = UL.outHeight;
        } else {
            i2 = 0;
        }
        com_tencent_mm_protocal_c_bqt2.wSm = i2;
        com_tencent_mm_protocal_c_bqt2.wSk = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId;
        com_tencent_mm_protocal_c_bqt2.wSl = com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbimgLength;
        com_tencent_mm_protocal_c_bqt2.vIB = com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbimgLength;
        com_tencent_mm_protocal_c_bqt2.vIC = 0;
        com_tencent_mm_protocal_c_bqt2.vID = com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbimgLength;
        com_tencent_mm_protocal_c_bqt2.vXz = new bdn().bj(new byte[0]);
        com_tencent_mm_protocal_c_bqt2.ngo = com_tencent_mm_protocal_c_bqt.ngo;
        com_tencent_mm_protocal_c_bqt2.vFC = com_tencent_mm_protocal_c_bqt.vFC;
        com_tencent_mm_protocal_c_bqt2.vFE = com_tencent_mm_protocal_c_bqt.vFE;
        com_tencent_mm_protocal_c_bqt2.vFD = com_tencent_mm_protocal_c_bqt.vFD;
        com_tencent_mm_protocal_c_bqt2.vQB = 1;
        if (com_tencent_mm_modelcdntran_keep_SceneResult.isUploadBySafeCDNWithMD5()) {
            x.i("MicroMsg.NetSceneUploadMsgImgForCdn", "summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s]", new Object[]{Boolean.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_upload_by_safecdn), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_UploadHitCacheType), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_filecrc), com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey});
            com_tencent_mm_protocal_c_bqt2.wKA = 1;
            com_tencent_mm_protocal_c_bqt2.vQA = "";
            com_tencent_mm_protocal_c_bqt2.wrT = "";
        } else {
            com_tencent_mm_protocal_c_bqt2.vQA = com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey;
            com_tencent_mm_protocal_c_bqt2.wrT = com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey;
        }
        com_tencent_mm_protocal_c_bqt2.wmj = com_tencent_mm_protocal_c_bqt.wmj;
        if (com_tencent_mm_protocal_c_bqt.wmj == 1) {
            com_tencent_mm_protocal_c_bqt2.wSi = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength;
            com_tencent_mm_protocal_c_bqt2.wSj = com_tencent_mm_modelcdntran_keep_SceneResult.field_midimgLength;
            com_tencent_mm_protocal_c_bqt2.wSg = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId;
            com_tencent_mm_protocal_c_bqt2.wSh = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId;
        } else {
            com_tencent_mm_protocal_c_bqt2.wSi = 0;
            com_tencent_mm_protocal_c_bqt2.wSj = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength;
            com_tencent_mm_protocal_c_bqt2.wSg = "";
            com_tencent_mm_protocal_c_bqt2.wSh = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId;
        }
        com_tencent_mm_protocal_c_bqt2.vQC = com_tencent_mm_modelcdntran_keep_SceneResult.field_filecrc;
        com_tencent_mm_protocal_c_bqt2.vZL = com_tencent_mm_modelcdntran_keep_SceneResult.field_filemd5;
        x.i("MicroMsg.NetSceneUploadMsgImgForCdn", "summersafecdn NetSceneUploadMsgImgForCdn MsgForwardType[%d], hitmd5[%d], key[%s], crc[%d]", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bqt2.vQD), Integer.valueOf(com_tencent_mm_protocal_c_bqt2.wKA), bh.VT(com_tencent_mm_protocal_c_bqt2.vQA), Integer.valueOf(com_tencent_mm_protocal_c_bqt2.vQC)});
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.NetSceneUploadMsgImgForCdn", "cdntra req[%s]", new Object[]{((bqt) this.gJQ.hmg.hmo).toString()});
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneUploadMsgImgForCdn", "onGYNetEnd errtype:" + i2 + " errcode:" + i3);
        bqu com_tencent_mm_protocal_c_bqu = (bqu) ((b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneUploadMsgImgForCdn", "onGYNetEnd createtime:%d msgId:%d ", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bqu.pbl), Long.valueOf(com_tencent_mm_protocal_c_bqu.vHe)});
        if (this.hBV != null) {
            this.hBV.a(com_tencent_mm_protocal_c_bqu.vHe, com_tencent_mm_protocal_c_bqu.pbl, i2, i3);
        }
        this.gJT.a(0, 0, "", this);
    }

    public final int getType() {
        return 110;
    }
}
