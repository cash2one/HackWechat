package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.aq.o;
import com.tencent.mm.modelcdntran.i$a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.pluginsdk.model.app.j.a;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;

class j$2 implements i$a {
    final /* synthetic */ String hAS;
    final /* synthetic */ j vev;
    final /* synthetic */ a vew;

    j$2(j jVar, String str, a aVar) {
        this.vev = jVar;
        this.hAS = str;
        this.vew = aVar;
    }

    public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
        x.i("MicroMsg.AppMessageExtension", "getThumbByCdn start callback: field_mediaId:%s thumbUrl:%s", new Object[]{str, this.hAS});
        if (i != 0) {
            x.e("MicroMsg.AppMessageExtension", "getThumbByCdn start failed: startRet:%d thumbUrl:%s", new Object[]{Integer.valueOf(i), this.hAS});
            return i;
        } else if (com_tencent_mm_modelcdntran_keep_SceneResult == null) {
            return 0;
        } else {
            if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                x.e("MicroMsg.AppMessageExtension", "getThumbByCdn failed: sceneResult.field_retCode:%d thumbUrl:%s", new Object[]{Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), this.hAS});
            } else {
                x.i("MicroMsg.AppMessageExtension", "getThumbByCdn finished thumbUrl:%s", new Object[]{this.hAS});
            }
            o.Pw().doNotify();
            if (this.vew != null) {
                this.vew.bYL();
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
