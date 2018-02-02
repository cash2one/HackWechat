package com.tencent.mm.aq;

import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.s;
import java.io.ByteArrayOutputStream;
import java.io.File;

class h$1 implements a {
    final /* synthetic */ long hAR;
    final /* synthetic */ String hAS;
    final /* synthetic */ String hAT;
    final /* synthetic */ long hAU;
    final /* synthetic */ int hAV;
    final /* synthetic */ String hAW;
    final /* synthetic */ h hAX;
    final /* synthetic */ au heR;
    final /* synthetic */ String heS;

    h$1(h hVar, long j, String str, String str2, String str3, au auVar, long j2, int i, String str4) {
        this.hAX = hVar;
        this.hAR = j;
        this.heS = str;
        this.hAS = str2;
        this.hAT = str3;
        this.heR = auVar;
        this.hAU = j2;
        this.hAV = i;
        this.hAW = str4;
    }

    public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
        if (i != 0) {
            x.e("MicroMsg.ImgMsgExtension", "getThumbByCdn failed. startRet:%d msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", new Object[]{Integer.valueOf(i), Long.valueOf(this.hAR), this.heS, this.hAS, this.hAT});
            this.heR.eQ(5);
            ((h) g.h(h.class)).aZi().b(this.heR.field_msgSvrId, this.heR);
            com.tencent.mm.plugin.report.service.g.pQN.h(10421, new Object[]{Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(this.hAU), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(b.MediaType_THUMBIMAGE), Integer.valueOf(this.hAV), ""});
            com.tencent.mm.plugin.report.service.g.pQN.h(13937, new Object[]{Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(this.hAU), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(b.MediaType_THUMBIMAGE), Integer.valueOf(this.hAV), ""});
            o.Pw().doNotify();
            return 0;
        } else if (com_tencent_mm_modelcdntran_keep_SceneResult == null) {
            return 0;
        } else {
            if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                x.e("MicroMsg.ImgMsgExtension", "getThumbByCdn failed. sceneResult.field_retCode:%d msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", new Object[]{Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Long.valueOf(this.hAR), this.heS, this.hAS, this.hAT});
                this.heR.eQ(5);
                if (!bh.ov(this.heR.field_talker)) {
                    ((h) g.h(h.class)).aZi().b(this.heR.field_msgSvrId, this.heR);
                }
            } else {
                new File(this.hAW).renameTo(new File(this.hAT));
                this.heR.eQ(6);
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                com.tencent.mm.sdk.platformtools.d.c(this.hAT, pInt, pInt2);
                this.heR.fc(pInt.value);
                this.heR.fd(pInt2.value);
                x.i("MicroMsg.ImgMsgExtension", "getThumbByCdn succ. sceneResult.field_retCode:%d msgSvrId:%d fromUser:%s thumb[%d,%d] thumbUrl:%s thumbPath:%s", new Object[]{Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Long.valueOf(this.hAR), this.heS, Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), this.hAS, this.hAT});
                if (!bh.ov(this.heR.field_talker)) {
                    ((h) g.h(h.class)).aZi().b(this.heR.field_msgSvrId, this.heR);
                }
                com.tencent.mm.plugin.report.service.g.pQN.a(198, 1, (long) this.hAV, false);
                com.tencent.mm.plugin.report.service.g.pQN.a(198, 2, 1, false);
                com.tencent.mm.plugin.report.service.g.pQN.a(198, s.eV(this.heS) ? 4 : 3, 1, false);
            }
            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
            Object[] objArr = new Object[16];
            objArr[0] = Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult == null ? i : com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode);
            objArr[1] = Integer.valueOf(2);
            objArr[2] = Long.valueOf(this.hAU);
            objArr[3] = Long.valueOf(bh.Wp());
            objArr[4] = Integer.valueOf(d.bi(ac.getContext()));
            objArr[5] = Integer.valueOf(b.MediaType_THUMBIMAGE);
            objArr[6] = Integer.valueOf(this.hAV);
            objArr[7] = com_tencent_mm_modelcdntran_keep_SceneResult == null ? "" : com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo;
            objArr[8] = "";
            objArr[9] = "";
            objArr[10] = "";
            objArr[11] = "";
            objArr[12] = "";
            objArr[13] = "";
            objArr[14] = "";
            objArr[15] = com_tencent_mm_modelcdntran_keep_SceneResult == null ? "" : com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2;
            gVar.h(10421, objArr);
            if (!(com_tencent_mm_modelcdntran_keep_SceneResult == null || com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode == 0)) {
                gVar = com.tencent.mm.plugin.report.service.g.pQN;
                objArr = new Object[16];
                if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                    i = com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode;
                }
                objArr[0] = Integer.valueOf(i);
                objArr[1] = Integer.valueOf(2);
                objArr[2] = Long.valueOf(this.hAU);
                objArr[3] = Long.valueOf(bh.Wp());
                objArr[4] = Integer.valueOf(d.bi(ac.getContext()));
                objArr[5] = Integer.valueOf(b.MediaType_THUMBIMAGE);
                objArr[6] = Integer.valueOf(this.hAV);
                objArr[7] = com_tencent_mm_modelcdntran_keep_SceneResult == null ? "" : com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo;
                objArr[8] = "";
                objArr[9] = "";
                objArr[10] = "";
                objArr[11] = "";
                objArr[12] = "";
                objArr[13] = "";
                objArr[14] = "";
                objArr[15] = com_tencent_mm_modelcdntran_keep_SceneResult == null ? "" : com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2;
                gVar.h(13937, objArr);
            }
            o.Pw().doNotify();
            return 0;
        }
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] h(String str, byte[] bArr) {
        return null;
    }
}
