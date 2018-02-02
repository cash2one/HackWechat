package com.tencent.mm.modelcdntran;

import com.tencent.mm.sdk.platformtools.x;

class c$8 implements Runnable {
    final /* synthetic */ keep_SceneResult hsD;
    final /* synthetic */ c hsz;
    final /* synthetic */ String uS;

    c$8(c cVar, String str, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        this.hsz = cVar;
        this.uS = str;
        this.hsD = com_tencent_mm_modelcdntran_keep_SceneResult;
    }

    public final void run() {
        i iVar = (i) this.hsz.hsu.get(this.uS);
        if (iVar == null) {
            x.d("MicroMsg.CdnTransportService", " task in jni get info failed mediaid:%s", this.uS);
        } else if (iVar.htF != null) {
            iVar.htF.b(this.uS, this.hsD);
        }
    }
}
