package com.tencent.mm.pluginsdk.model.app;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.a.e;
import com.tencent.mm.aq.o;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;
import java.io.ByteArrayOutputStream;

class j$1 implements a {
    final /* synthetic */ String gIx;
    final /* synthetic */ long hAR;
    final /* synthetic */ String hAS;
    final /* synthetic */ long hAU;
    final /* synthetic */ int hAV;
    final /* synthetic */ String hAW;
    final /* synthetic */ int vet;
    final /* synthetic */ boolean veu;
    final /* synthetic */ j vev;

    j$1(j jVar, long j, String str, long j2, int i, String str2, String str3, int i2, boolean z) {
        this.vev = jVar;
        this.hAR = j;
        this.hAS = str;
        this.hAU = j2;
        this.hAV = i;
        this.gIx = str2;
        this.hAW = str3;
        this.vet = i2;
        this.veu = z;
    }

    public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
        if (i != 0) {
            x.e("MicroMsg.AppMessageExtension", "getThumbByCdn start failed: msgid:%d startRet:%d thumbUrl:%s", new Object[]{Long.valueOf(this.hAR), Integer.valueOf(i), this.hAS});
            g.pQN.h(10421, new Object[]{Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(this.hAU), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(b.MediaType_THUMBIMAGE), Integer.valueOf(this.hAV), ""});
            return i;
        } else if (com_tencent_mm_modelcdntran_keep_SceneResult == null) {
            return 0;
        } else {
            g gVar;
            if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                x.e("MicroMsg.AppMessageExtension", "getThumbByCdn failed: msgid:%d sceneResult.field_retCode:%d thumbUrl:%s", new Object[]{Long.valueOf(this.hAR), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), this.hAS});
            } else {
                ar.Hg();
                cf F = c.Fa().F(this.gIx, this.hAR);
                if (F.field_msgSvrId != this.hAR) {
                    x.e("MicroMsg.AppMessageExtension", "hy: appmsg %d has been deleted", new Object[]{Long.valueOf(this.hAR)});
                    return 0;
                }
                String a;
                long j;
                x.i("MicroMsg.AppMessageExtension", "hy: %d current msg type is %d", new Object[]{Long.valueOf(this.hAR), Integer.valueOf(F.getType())});
                byte[] d = e.d(this.hAW, 0, -1);
                if (this.vet == 33 || this.vet == 36) {
                    a = o.Pw().a(d, CompressFormat.JPEG);
                } else {
                    a = j.a(d, this.veu, F.cjk());
                }
                if (!bh.ov(a)) {
                    F.dT(a);
                    ar.Hg();
                    c.Fa().b(F.field_msgSvrId, F);
                }
                x.i("MicroMsg.AppMessageExtension", "getThumbByCdn finished msgid:%d talker:%s thumbUrl:%s path:%s", new Object[]{Long.valueOf(this.hAR), this.gIx, this.hAS, a});
                g.pQN.a(198, 16, (long) this.hAV, false);
                g.pQN.a(198, 17, 1, false);
                gVar = g.pQN;
                if (s.eV(this.gIx)) {
                    j = 19;
                } else {
                    j = 18;
                }
                gVar.a(198, j, 1, false);
            }
            gVar = g.pQN;
            Object[] objArr = new Object[16];
            objArr[0] = Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult == null ? -1 : com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode);
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
                gVar = g.pQN;
                objArr = new Object[16];
                objArr[0] = Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult == null ? -1 : com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode);
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
