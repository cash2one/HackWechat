package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.ByteArrayOutputStream;

class ah$1 implements a {
    final /* synthetic */ ah veW;

    ah$1(ah ahVar) {
        this.veW = ahVar;
    }

    public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
        x.d("MicroMsg.NetSceneSendAppMsg", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{this.veW.hBn, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
        if (i == -21005) {
            x.d("MicroMsg.NetSceneSendAppMsg", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[]{this.veW.hBn});
            return 0;
        } else if (i != 0) {
            this.veW.fEJ.eQ(5);
            d.pPH.a(111, 34, 1, true);
            ar.Hg();
            c.Fa().a(this.veW.fEJ.field_msgId, this.veW.fEJ);
            g.pQN.h(10421, new Object[]{Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(this.veW.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(com.tencent.mm.modelcdntran.d.bi(ac.getContext())), Integer.valueOf(b.MediaType_FILE), Integer.valueOf(0), ""});
            this.veW.gJT.a(3, i, "", this.veW);
            return 0;
        } else {
            if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                    x.e("MicroMsg.NetSceneSendAppMsg", "cdntra sceneResult.retCode :%d arg[%s] info[%s]", new Object[]{Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), com_tencent_mm_modelcdntran_keep_SceneResult.field_arg, com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2});
                    this.veW.fEJ.eQ(5);
                    d.pPH.a(111, 34, 1, true);
                    ar.Hg();
                    c.Fa().a(this.veW.fEJ.field_msgId, this.veW.fEJ);
                    g.pQN.h(10421, new Object[]{Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Integer.valueOf(1), Long.valueOf(this.veW.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(com.tencent.mm.modelcdntran.d.bi(ac.getContext())), Integer.valueOf(b.MediaType_FILE), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2});
                    g.pQN.h(13937, new Object[]{Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Integer.valueOf(1), Long.valueOf(this.veW.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(com.tencent.mm.modelcdntran.d.bi(ac.getContext())), Integer.valueOf(b.MediaType_FILE), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2});
                    this.veW.gJT.a(3, com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode, "", this.veW);
                } else {
                    if (this.veW.hUs > 0 && com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength > 0) {
                        aj.r("SendAppMsgThumbTooBig", this.veW.hUs + "," + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength + "," + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId, this.veW.hUs * 2 > com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength);
                    }
                    x.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdnCallback upload attach by cdn, isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], aesKey[%s], md5[%s]", new Object[]{Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_UploadHitCacheType), Boolean.valueOf(z), Boolean.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_exist_whencheck), bh.VT(com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey), com_tencent_mm_modelcdntran_keep_SceneResult.field_filemd5});
                    ar.CG().a(new ai(this.veW.fqm, false, com_tencent_mm_modelcdntran_keep_SceneResult, new 1(this, com_tencent_mm_modelcdntran_keep_SceneResult), this.veW.iKB, null), 0);
                }
            }
            return 0;
        }
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] h(String str, byte[] bArr) {
        return null;
    }
}
