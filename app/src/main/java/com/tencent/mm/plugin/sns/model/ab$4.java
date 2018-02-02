package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;

class ab$4 implements a {
    final /* synthetic */ ab qVi;

    ab$4(ab abVar) {
        this.qVi = abVar;
    }

    public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
        if (i == -21005) {
            x.d("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{this.qVi.hBn, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
            this.qVi.qVe.ij(true);
            return 0;
        } else if (com_tencent_mm_modelcdntran_keep_SceneResult != null && com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode == 0) {
            x.i("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{this.qVi.hBn, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
            this.qVi.T(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileUrl, com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbUrl, "upload_" + this.qVi.hBn);
            g.pQN.h(10421, new Object[]{Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.qVi.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(this.qVi.hBo), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2});
            n TS = n.TS();
            int i2 = this.qVi.hVm;
            if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                String str2 = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileUrl;
                String str3 = str2.hashCode();
                n.a aVar = (n.a) TS.hUV.get(str3);
                if (aVar == null) {
                    aVar = new n.a(TS);
                }
                String str4 = "";
                aVar.gjF = str4;
                aVar.toUser = str4;
                aVar.hVi = str4;
                aVar.hVm = i2;
                aVar.hVl = 1;
                aVar.fzT = str2;
                aVar.hUz = com_tencent_mm_modelcdntran_keep_SceneResult;
                aVar.startTime = bh.Wp();
                TS.hUV.put(str3, aVar);
                x.i("MicroMsg.SubCoreMediaRpt", "note sns video sendScene %d snsKey[%s] url[%s]", new Object[]{Integer.valueOf(i2), str3, str2});
            }
            this.qVi.qVe.ij(true);
            return 0;
        } else if (com_tencent_mm_modelcdntran_keep_SceneResult != null && com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
            x.i("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{this.qVi.hBn, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
            this.qVi.wz(0);
            g.pQN.h(10421, new Object[]{Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Integer.valueOf(1), Long.valueOf(this.qVi.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(this.qVi.hBo), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2});
            g.pQN.h(13937, new Object[]{Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Integer.valueOf(1), Long.valueOf(this.qVi.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(this.qVi.hBo), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2});
            this.qVi.qVe.ij(false);
            return 0;
        } else if (i != 0) {
            x.i("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{this.qVi.hBn, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
            this.qVi.wz(0);
            if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                g.pQN.h(10421, new Object[]{Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(this.qVi.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(this.qVi.hBo), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2});
            }
            this.qVi.qVe.ij(false);
            return 0;
        } else {
            x.d("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{this.qVi.hBn, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
            return 0;
        }
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] h(String str, byte[] bArr) {
        return null;
    }
}
