package com.tencent.mm.plugin.downloader.c;

import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class a$2 implements Runnable {
    final /* synthetic */ keep_ProgressInfo hsC;
    final /* synthetic */ keep_SceneResult hsD;
    final /* synthetic */ a lrf;
    final /* synthetic */ String uS;

    a$2(a aVar, String str, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        this.lrf = aVar;
        this.uS = str;
        this.hsC = com_tencent_mm_modelcdntran_keep_ProgressInfo;
        this.hsD = com_tencent_mm_modelcdntran_keep_SceneResult;
    }

    public final void run() {
        i iVar = (i) a.d(this.lrf).get(this.uS);
        if (iVar == null) {
            x.e("MicroMsg.CdnDownloadNativeService", " task in jni get info failed mediaid:%s", new Object[]{this.uS});
            return;
        }
        if (this.hsC != null) {
            this.hsC.mediaId = this.uS;
            x.i("MicroMsg.CdnDownloadNativeService", "MTL: total:%d, cur:%d, mtl:%b", new Object[]{Integer.valueOf(this.hsC.field_toltalLength), Integer.valueOf(this.hsC.field_finishedLength), Boolean.valueOf(this.hsC.field_mtlnotify)});
        }
        if (this.hsD != null) {
            this.hsD.mediaId = this.uS;
        }
        if (iVar.htt != null) {
            long Wp = bh.Wp();
            if (this.hsD != null || this.hsC == null || this.hsC.field_mtlnotify || an.getNetWorkType(ac.getContext()) != -1) {
                iVar.field_lastProgressCallbackTime = Wp;
                iVar.htt.a(this.uS, 0, this.hsC, this.hsD, iVar.field_onlycheckexist);
            } else {
                return;
            }
        }
        if (a.a(this.hsC)) {
            a.a(this.lrf).remove(this.uS);
        }
        if (this.hsD != null) {
            a.d(this.lrf).remove(this.uS);
            if (this.hsD.field_retCode == -5103011) {
                x.i("MicroMsg.CdnDownloadNativeService", "summersafecdn ERR_VALIDATE_AUTHKEY");
                g.pQN.a(546, 4, 1, true);
                a.e(this.lrf).keep_OnRequestDoGetCdnDnsInfo(999);
            }
        }
    }

    public final String toString() {
        return super.toString() + "|callback";
    }
}
