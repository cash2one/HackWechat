package com.tencent.mm.plugin.facedetect.service;

import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.facedetect.b.r;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;

class FaceUploadVideoService$a implements a {
    private String mAppId;
    private String mFileName;
    private long mgb;
    final /* synthetic */ FaceUploadVideoService mix;

    private FaceUploadVideoService$a(FaceUploadVideoService faceUploadVideoService, long j, String str, String str2) {
        this.mix = faceUploadVideoService;
        this.mgb = -1;
        this.mAppId = null;
        this.mFileName = null;
        this.mgb = j;
        this.mAppId = str;
        this.mFileName = str2;
    }

    public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
        x.i("MicroMsg.FaceUploadVideoService", "hy: sceneResult.field_retCode == 0 cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{str, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
        if (com_tencent_mm_modelcdntran_keep_SceneResult != null && com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode == 0) {
            x.i("MicroMsg.FaceUploadVideoService", "hy: upload video done. now upload");
            FaceDetectReporter.e(this.mgb, 0, 0);
            g.CG().a(1197, this.mix);
            g.CG().a(new r(this.mFileName, this.mgb, this.mAppId, com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId, com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey), 0);
        } else if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
            x.w("MicroMsg.FaceUploadVideoService", "hy: upload video cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{str, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
            b.deleteFile(this.mFileName);
            FaceDetectReporter.e(this.mgb, 1, com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode);
        } else if (i != 0) {
            x.w("MicroMsg.FaceUploadVideoService", "hy: upload video start error!; cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{str, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
            b.deleteFile(this.mFileName);
            FaceDetectReporter.e(this.mgb, 1, i);
        }
        return 0;
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] h(String str, byte[] bArr) {
        return new byte[0];
    }
}
