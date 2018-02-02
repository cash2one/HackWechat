package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.modelcdntran.i$a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.exdevice.f.b.a.a;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;
import java.io.ByteArrayOutputStream;

public final class c implements i$a {
    String appName = null;
    String lON = null;

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] h(String str, byte[] bArr) {
        return null;
    }

    public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
        x.d("MicroMsg.ExdevicePictureUploader", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{str, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
        if (com_tencent_mm_modelcdntran_keep_SceneResult == null || !str.equals(this.lON)) {
            if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
                x.d("MicroMsg.ExdevicePictureUploader", "hy: upload progressing....");
            }
        } else if (i == 0 && com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode == 0) {
            x.d("MicroMsg.ExdevicePictureUploader", "hy: transfer done, upload callback success");
            x.i("MicroMsg.ExdevicePictureUploader", "transfer done, mediaid=%s, completeInfo=%s", new Object[]{str, com_tencent_mm_modelcdntran_keep_SceneResult.toString()});
            a aVar = new a();
            aVar.field_championUrl = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileUrl;
            aVar.field_username = q.FS();
            b.yW(aVar.field_championUrl);
            ad.aEo().a(aVar, true);
            ad.aEs();
            ar.CG().a(new m(aVar.field_championUrl, aVar.field_championMotto), 0);
        } else {
            x.w("MicroMsg.ExdevicePictureUploader", "hy: transfer done, fail");
        }
        return 0;
    }
}
