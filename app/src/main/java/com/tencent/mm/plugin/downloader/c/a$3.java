package com.tencent.mm.plugin.downloader.c;

import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.x;

class a$3 implements Runnable {
    final /* synthetic */ keep_SceneResult hsD;
    final /* synthetic */ a lrf;
    final /* synthetic */ String uS;

    a$3(a aVar, String str, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        this.lrf = aVar;
        this.uS = str;
        this.hsD = com_tencent_mm_modelcdntran_keep_SceneResult;
    }

    public final void run() {
        i iVar = (i) a.d(this.lrf).get(this.uS);
        if (iVar == null) {
            x.e("MicroMsg.CdnDownloadNativeService", " task in jni get info failed mediaid:%s", new Object[]{this.uS});
        } else if (iVar.htF != null) {
            iVar.htF.b(this.uS, this.hsD);
        }
    }
}
