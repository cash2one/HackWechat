package com.tencent.mm.modelvideo;

import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelvideo.g.1;
import com.tencent.mm.modelvideo.h.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;

class g$1$1 implements a {
    final /* synthetic */ 1 hUw;
    final /* synthetic */ keep_SceneResult hsD;

    g$1$1(1 1, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        this.hUw = 1;
        this.hsD = com_tencent_mm_modelcdntran_keep_SceneResult;
    }

    public final void bn(int i, int i2) {
        if (i == 4 && i2 == 102) {
            g.Dm().F(new 1(this));
            return;
        }
        com.tencent.mm.plugin.report.service.g.pQN.h(10421, Integer.valueOf(i2), Integer.valueOf(1), Long.valueOf(this.hUw.hUv.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(this.hUw.hUv.hTT), Integer.valueOf(this.hsD.field_fileLength), this.hsD.field_transInfo, "", "", "", "", "", "", "", this.hsD.report_Part2);
        a.a(this.hUw.hUv.hTR, 0);
        g.a(this.hUw.hUv, this.hsD);
        this.hUw.hUv.gJT.a(i, i2, "", this.hUw.hUv);
    }
}
