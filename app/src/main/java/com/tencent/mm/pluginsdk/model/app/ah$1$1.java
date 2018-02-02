package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.ah.1;
import com.tencent.mm.pluginsdk.model.app.ai.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class ah$1$1 implements a {
    final /* synthetic */ keep_SceneResult hsD;
    final /* synthetic */ 1 veX;

    ah$1$1(1 1, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        this.veX = 1;
        this.hsD = com_tencent_mm_modelcdntran_keep_SceneResult;
    }

    public final void bn(int i, int i2) {
        x.d("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra NetSceneSendAppMsgForCdn callback %d,%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        g.pQN.h(10421, new Object[]{Integer.valueOf(i2), Integer.valueOf(1), Long.valueOf(this.veX.veW.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(b.MediaType_FILE), Integer.valueOf(this.hsD.field_fileLength), this.hsD.field_transInfo, "", "", "", "", "", "", "", this.hsD.report_Part2});
        this.veX.veW.gJT.a(i, i2, "", this.veX.veW);
    }
}
