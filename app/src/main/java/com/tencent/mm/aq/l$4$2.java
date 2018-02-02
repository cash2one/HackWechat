package com.tencent.mm.aq;

import com.tencent.mm.aq.l.4;
import com.tencent.mm.aq.m.a;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class l$4$2 implements a {
    final /* synthetic */ e hBC;
    final /* synthetic */ 4 hBR;
    final /* synthetic */ keep_SceneResult hsD;

    l$4$2(4 4, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, e eVar) {
        this.hBR = 4;
        this.hsD = com_tencent_mm_modelcdntran_keep_SceneResult;
        this.hBC = eVar;
    }

    public final void a(long j, int i, int i2, int i3) {
        g.pQN.h(10421, new Object[]{Integer.valueOf(i3), Integer.valueOf(1), Long.valueOf(this.hBR.hBQ.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(this.hBR.hBQ.hBo), Integer.valueOf(this.hsD.field_fileLength), this.hsD.field_transInfo, "", "", "", "", "", "", "", l.lo(this.hsD.report_Part2)});
        x.i(this.hBR.hBQ.TAG, "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[]{this.hBR.hBQ.hBn, Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            this.hBR.hBQ.a(this.hBC, this.hBC.hlp, j, i, this.hsD);
            return;
        }
        i.hU((int) this.hBR.hBQ.hBk);
        i.hT((int) this.hBR.hBQ.hBk);
        this.hBR.hBQ.gJT.a(i2, i3, "", this.hBR.hBQ);
        if (this.hBR.hBQ.hBI != null) {
            this.hBR.hBQ.hBI.Pj();
        }
    }
}
