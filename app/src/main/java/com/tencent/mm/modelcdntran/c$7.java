package com.tencent.mm.modelcdntran;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class c$7 implements Runnable {
    final /* synthetic */ keep_ProgressInfo hsC;
    final /* synthetic */ keep_SceneResult hsD;
    final /* synthetic */ c hsz;
    final /* synthetic */ String uS;

    c$7(c cVar, String str, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        this.hsz = cVar;
        this.uS = str;
        this.hsC = com_tencent_mm_modelcdntran_keep_ProgressInfo;
        this.hsD = com_tencent_mm_modelcdntran_keep_SceneResult;
    }

    public final void run() {
        int i = 0;
        i iVar = (i) this.hsz.hsu.get(this.uS);
        if (iVar == null) {
            x.e("MicroMsg.CdnTransportService", " task in jni get info failed mediaid[%s] hash[%s]", this.uS, Integer.valueOf(this.hsz.hashCode()));
            g.pQN.a(594, 7, 1, true);
            return;
        }
        if (this.hsC != null) {
            this.hsC.mediaId = this.uS;
            x.i("MicroMsg.CdnTransportService", "MTL: total:%d, cur:%d, mtl:%b", Integer.valueOf(this.hsC.field_toltalLength), Integer.valueOf(this.hsC.field_finishedLength), Boolean.valueOf(this.hsC.field_mtlnotify));
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
                x.e("MicroMsg.CdnTransportService", "callback sceneResult is null and no network, %s", this.uS);
                return;
            }
        }
        x.e("MicroMsg.CdnTransportService", "taskCallback is null:%s", this.uS);
        keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo = this.hsC;
        if (com_tencent_mm_modelcdntran_keep_ProgressInfo == null || com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength == com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength) {
            i = 1;
        }
        if (i != 0) {
            this.hsz.hsv.remove(this.uS);
        }
        if (this.hsD != null) {
            this.hsz.hsu.remove(this.uS);
            if (this.hsD.field_retCode == -5103011) {
                x.i("MicroMsg.CdnTransportService", "summersafecdn ERR_VALIDATE_AUTHKEY");
                g.pQN.a(546, 4, 1, true);
                g.MK().keep_OnRequestDoGetCdnDnsInfo(999);
            }
        }
    }

    public final String toString() {
        return super.toString() + "|callback";
    }
}
