package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.g.b.cf;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;
import java.io.ByteArrayOutputStream;
import java.io.File;

class ab$1 implements a {
    final /* synthetic */ ab veO;

    ab$1(ab abVar) {
        this.veO = abVar;
    }

    public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
        String str2 = "MicroMsg.NetSceneDownloadAppAttach";
        String str3 = "summerbig callback mediaId[%s], startRet[%d], progressInfo[%s], sceneResult[%s], finish[%b]";
        Object[] objArr = new Object[5];
        objArr[0] = str;
        objArr[1] = Integer.valueOf(i);
        objArr[2] = com_tencent_mm_modelcdntran_keep_ProgressInfo;
        objArr[3] = com_tencent_mm_modelcdntran_keep_SceneResult;
        objArr[4] = Boolean.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo == null);
        x.d(str2, str3, objArr);
        if (i == -21006) {
            x.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[]{this.veO.hBn});
            return 0;
        } else if (i != 0) {
            l.fr(this.veO.veF.xjy);
            g.pQN.h(10421, new Object[]{Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(this.veO.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(b.MediaType_FILE), Integer.valueOf(0), ""});
            this.veO.gJT.a(3, i, "", this.veO);
            return 0;
        } else {
            this.veO.veF = l.af(str, this.veO.fqm);
            if (this.veO.veF == null) {
                x.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig attachInfo is null");
                this.veO.gJT.a(3, i, "", this.veO);
                return 0;
            } else if (this.veO.veF.field_status == 102) {
                x.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig dancy attach download has paused, status:%d", new Object[]{Long.valueOf(this.veO.veF.field_status)});
                com.tencent.mm.modelcdntran.g.MJ().kH(this.veO.hBn);
                this.veO.gJT.a(3, i, "attach  has paused, status=" + this.veO.veF.field_status, this.veO);
                return 0;
            } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo == null) {
                if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                    if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                        l.fr(this.veO.veF.xjy);
                        x.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra sceneResult.retCode :%d", new Object[]{Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode)});
                        this.veO.gJT.a(3, com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode, "", this.veO);
                    } else {
                        new File(this.veO.veK).renameTo(new File(this.veO.veF.field_fileFullPath));
                        this.veO.veF.field_status = 199;
                        this.veO.veF.field_offset = this.veO.veF.field_totalLen;
                        an.aqd().c(this.veO.veF, new String[0]);
                        g.pQN.a(198, 45, this.veO.veF.field_totalLen, false);
                        g.pQN.a(198, 46, 1, false);
                        g.pQN.a(198, s.eV(this.veO.fEJ == null ? "" : this.veO.fEJ.field_talker) ? 48 : 47, 1, false);
                        ar.Hg();
                        cf dH = c.Fa().dH(this.veO.veF.field_msgInfoId);
                        if (dH.field_status == 5) {
                            dH.eQ(3);
                            ar.Hg();
                            c.Fa().a(dH.field_msgId, dH);
                        } else {
                            ar.Hg();
                            c.Fa().a(new com.tencent.mm.plugin.messenger.foundation.a.a.c.c(dH.field_talker, "update", dH));
                        }
                        this.veO.gJT.a(0, 0, "", this.veO);
                    }
                    g.pQN.h(10421, new Object[]{Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Integer.valueOf(2), Long.valueOf(this.veO.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(b.MediaType_FILE), Long.valueOf(this.veO.veF.field_totalLen), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2});
                    if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                        g.pQN.h(13937, new Object[]{Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Integer.valueOf(2), Long.valueOf(this.veO.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(b.MediaType_FILE), Long.valueOf(this.veO.veF.field_totalLen), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2});
                    }
                    if (this.veO.hBj != null) {
                        ag.y(new 2(this));
                    }
                }
                return 0;
            } else if (((long) com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength) == this.veO.veF.field_totalLen) {
                x.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra ignore progress 100%");
                return 0;
            } else if (this.veO.veF.field_offset > ((long) com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength)) {
                x.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdnEndProc error oldpos:%d newpos:%d", new Object[]{Long.valueOf(this.veO.veF.field_offset), Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength)});
                l.fr(this.veO.veF.xjy);
                this.veO.gJT.a(3, i, "", this.veO);
                return 0;
            } else {
                this.veO.veF.field_offset = (long) com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength;
                an.aqd().c(this.veO.veF, new String[0]);
                if (this.veO.hBj != null) {
                    ag.y(new 1(this));
                }
                x.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra progresscallback id:%s finish:%d total:%d", new Object[]{this.veO.hBn, Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength), Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength)});
                return 0;
            }
        }
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] h(String str, byte[] bArr) {
        return null;
    }
}
