package com.tencent.mm.modelvideo;

import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.f;
import com.tencent.mm.modelcdntran.i$a;
import com.tencent.mm.modelcdntran.j;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;

class d$1 implements i$a {
    final /* synthetic */ d hTX;

    d$1(d dVar) {
        this.hTX = dVar;
    }

    public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
        if (i == -21006) {
            x.d("MicroMsg.NetSceneDownloadVideo", "%s cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[]{this.hTX.TL(), this.hTX.hBn});
            return 0;
        } else if (i != 0) {
            t.ny(this.hTX.fileName);
            g.pQN.h(10421, new Object[]{Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(this.hTX.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(this.hTX.hTT), Integer.valueOf(this.hTX.hlp), ""});
            g.pQN.h(13937, new Object[]{Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(this.hTX.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(this.hTX.hTT), Integer.valueOf(this.hTX.hlp), ""});
            this.hTX.gJT.a(3, i, "", this.hTX);
            return 0;
        } else {
            this.hTX.hTR = t.nF(this.hTX.fileName);
            int i2;
            if (this.hTX.hTR == null || this.hTX.hTR.status == 113) {
                x.i("MicroMsg.NetSceneDownloadVideo", "%s upload video info is null or has paused, status:%d", new Object[]{this.hTX.TL(), Integer.valueOf(this.hTX.hTR == null ? -1 : this.hTX.hTR.status)});
                this.hTX.vo();
                this.hTX.gJT.a(3, i, "upload video info is null or has paused, status" + i2, this.hTX);
                return 0;
            } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo == null) {
                if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                    x.i("MicroMsg.NetSceneDownloadVideo", "%s cdntra sceneResult.retCode:%d useTime:%d ", new Object[]{this.hTX.TL(), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Long.valueOf(bh.Wp() - this.hTX.hTW)});
                    d dVar = this.hTX;
                    j jVar = this.hTX.hTS;
                    if (jVar == null || com_tencent_mm_modelcdntran_keep_SceneResult == null) {
                        x.w("MicroMsg.NetSceneDownloadVideo", "it had not task info or scene Result, don't report.");
                    } else if (jVar.field_smallVideoFlag == 1) {
                        x.i("MicroMsg.NetSceneDownloadVideo", "it download short video, don't report.");
                    } else if (!(jVar == null || com_tencent_mm_modelcdntran_keep_SceneResult == null)) {
                        x.i("MicroMsg.NetSceneDownloadVideo", "%s sceneResult.field_recvedBytes %d, time [%d, %d]", new Object[]{dVar.TL(), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_recvedBytes), Long.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_startTime), Long.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_endTime)});
                        o.TV();
                        f.a(null, com_tencent_mm_modelcdntran_keep_SceneResult, jVar, true);
                    }
                    if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                        t.ny(this.hTX.fileName);
                        if (this.hTX.hTP) {
                            g.pQN.a(354, 13, 1, false);
                        }
                        if (this.hTX.hTQ) {
                            g.pQN.a(354, 136, 1, false);
                        }
                        this.hTX.gJT.a(3, com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode, "", this.hTX);
                    } else {
                        if (this.hTX.hTP) {
                            g.pQN.a(354, 12, 1, false);
                        }
                        if (this.hTX.hTQ) {
                            g.pQN.a(354, 137, 1, false);
                        }
                        this.hTX.iJ(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength);
                    }
                    g.pQN.h(10421, new Object[]{Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Integer.valueOf(2), Long.valueOf(this.hTX.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(this.hTX.hTT), Integer.valueOf(this.hTX.hlp), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2});
                    if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                        g.pQN.h(13937, new Object[]{Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Integer.valueOf(2), Long.valueOf(this.hTX.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(this.hTX.hTT), Integer.valueOf(this.hTX.hlp), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2});
                    }
                    a.a(this.hTX.hTR, 1);
                    this.hTX.hTS = null;
                }
                return 0;
            } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength == this.hTX.hlp) {
                x.d("MicroMsg.NetSceneDownloadVideo", "cdntra ignore progress 100%");
                return 0;
            } else if (this.hTX.hTR.hVB <= com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength || this.hTX.hTP) {
                i2 = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                this.hTX.hTR.hVF = bh.Wo();
                if (this.hTX.hTR.hVB < com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength) {
                    this.hTX.hTR.hVB = com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength;
                    i2 = 1040;
                }
                this.hTX.hTR.fDt = i2;
                t.e(this.hTX.hTR);
                x.d("MicroMsg.NetSceneDownloadVideo", "%s cdntra progresscallback id:%s finish:%d total:%d", new Object[]{this.hTX.TL(), this.hTX.hBn, Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength), Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength)});
                return 0;
            } else {
                x.e("MicroMsg.NetSceneDownloadVideo", "%s cdnEndProc error oldpos:%d newpos:%d", new Object[]{this.hTX.TL(), Integer.valueOf(this.hTX.hTR.hVB), Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength)});
                t.ny(this.hTX.fileName);
                this.hTX.gJT.a(3, i, "", this.hTX);
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
