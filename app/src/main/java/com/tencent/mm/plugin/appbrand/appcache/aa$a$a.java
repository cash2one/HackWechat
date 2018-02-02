package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Looper;
import com.tencent.mm.a.e;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.modelcdntran.i$a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.appbrand.appcache.aa.d;
import com.tencent.mm.pluginsdk.i.a.d.l;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ak;
import java.io.ByteArrayOutputStream;
import java.util.Locale;
import javax.net.ssl.SSLException;

abstract class aa$a$a implements i$a {
    private final d iFE;
    private final tw iFF = new tw();

    abstract void b(l lVar);

    aa$a$a(d dVar) {
        this.iFE = dVar;
    }

    public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
        if (i != 0) {
            b(new l(this.iFE, new SSLException(String.format(Locale.US, "CdnHttpsAddTaskFailed$%s$%d", new Object[]{this.iFE.bZj(), Integer.valueOf(i)})), 3));
            x.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "urlKey %s, startRet %d", new Object[]{this.iFE.bZj(), Integer.valueOf(i)});
            return 0;
        } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
            try {
                this.iFF.fMH.fMI = str;
                this.iFF.fMH.fMJ = (int) ((((float) com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength) / ((float) com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength)) * 100.0f);
                a.xef.a(this.iFF, Looper.getMainLooper());
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", e, "notify progress", new Object[0]);
            }
            return 0;
        } else {
            if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                x.i("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "urlKey %s, retCode %d, responseHeader %s", new Object[]{this.iFE.bZj(), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), com_tencent_mm_modelcdntran_keep_SceneResult.field_httpResponseHeader});
                if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                    l lVar;
                    if (com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength <= 0 || this.iFE.bD((long) com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength)) {
                        lVar = new l(this.iFE, new SSLException(String.format(Locale.US, "CdnHttpsDownloadFailed$%s$%d", new Object[]{this.iFE.bZj(), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode)})), com_tencent_mm_modelcdntran_keep_SceneResult.field_httpStatusCode, 3);
                    } else {
                        lVar = new l(this.iFE, new com.tencent.mm.pluginsdk.i.a.c.a(), com_tencent_mm_modelcdntran_keep_SceneResult.field_httpStatusCode, 3);
                    }
                    b(lVar);
                } else {
                    b(new l(this.iFE, (long) com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength, null));
                    int bN = e.bN(this.iFE.aaa().getFilePath());
                    if (ak.a.hfM != null) {
                        ak.a.hfM.aV(bN, 0);
                    }
                }
            }
            return 0;
        }
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] h(String str, byte[] bArr) {
        return new byte[0];
    }
}
