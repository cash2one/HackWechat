package com.tencent.mm.plugin.collect.reward.b;

import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.collect.reward.b.a.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements Runnable {
    final /* synthetic */ keep_SceneResult hsD;
    final /* synthetic */ int ljC;
    final /* synthetic */ a ljD;
    final /* synthetic */ String uS;

    a$1(a aVar, String str, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, int i) {
        this.ljD = aVar;
        this.uS = str;
        this.hsD = com_tencent_mm_modelcdntran_keep_SceneResult;
        this.ljC = i;
    }

    public final void run() {
        a aVar = (a) a.a(this.ljD).get(this.uS);
        if (aVar == null) {
            x.w("MicroMsg.QrRewardCdnDownloadHelper", "no callback");
        } else if (this.hsD != null) {
            aVar.C(this.uS, this.ljC, this.hsD.field_retCode);
            a.a(this.ljD).remove(this.uS);
            if (this.hsD.field_retCode == 0) {
                g.pQN.a(724, 8, 1, false);
            } else {
                g.pQN.a(724, 9, 1, false);
            }
        } else {
            x.v("MicroMsg.QrRewardCdnDownloadHelper", "download is not end");
        }
    }
}
