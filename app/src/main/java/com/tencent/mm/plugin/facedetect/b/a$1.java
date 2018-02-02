package com.tencent.mm.plugin.facedetect.b;

import android.os.Bundle;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;

class a$1 implements a {
    final /* synthetic */ a meV;

    a$1(a aVar) {
        this.meV = aVar;
    }

    public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
        if (i == -21005) {
            x.i("MicroMsg.FaceUploadProcessor", "hy: ERR_CNDCOM_MEDIA_IS_UPLOADING cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{str, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
        } else if (com_tencent_mm_modelcdntran_keep_SceneResult != null && com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode == 0) {
            x.i("MicroMsg.FaceUploadProcessor", "hy: sceneResult.field_retCode == 0 cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{str, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
            String str2 = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId;
            Bundle bundle = new Bundle();
            bundle.putString("key_pic_cdn_id", str2);
            bundle.putString("key_cdn_aes_key", com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey);
            a aVar = this.meV;
            String str3 = "ok";
            if (aVar.meL != null) {
                aVar.meL.a(0, 0, str3, bundle);
            }
        } else if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
            x.w("MicroMsg.FaceUploadProcessor", "hy: cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{str, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
            this.meV.g(3, 90020, "cdn ret error");
        } else if (i != 0) {
            x.w("MicroMsg.FaceUploadProcessor", "hy: start error!; cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{str, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
            this.meV.g(3, 90021, "cdn start error");
        } else {
            x.i("MicroMsg.FaceUploadProcessor", "hy: on process, cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{str, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
            if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
                x.d("MicroMsg.FaceUploadProcessor", "hy: cdn process: %f", new Object[]{Double.valueOf(((double) com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength) / ((double) com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength))});
                a aVar2 = this.meV;
                if (aVar2.meL != null) {
                    aVar2.meL.l(r0);
                }
            }
        }
        return 0;
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] h(String str, byte[] bArr) {
        return null;
    }
}
