package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.ai.a;
import com.tencent.mm.pluginsdk.model.app.ak.1;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class ak$1$3 implements a {
    final /* synthetic */ keep_SceneResult hsD;
    final /* synthetic */ 1 vff;

    ak$1$3(1 1, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        this.vff = 1;
        this.hsD = com_tencent_mm_modelcdntran_keep_SceneResult;
    }

    public final void bn(int i, int i2) {
        x.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra NetSceneSendAppMsgForCdn callback %d,%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 4 && i2 == 102) {
            ar.Dm().F(new Runnable(this) {
                final /* synthetic */ ak$1$3 vfh;

                {
                    this.vfh = r1;
                }

                public final void run() {
                    this.vfh.vff.vfe.hBF = false;
                    this.vfh.vff.vfe.veF.field_createTime = bh.Wp();
                    this.vfh.vff.vfe.veF.field_lastModifyTime = bh.Wo();
                    this.vfh.vff.vfe.veF.field_offset = 0;
                    this.vfh.vff.vfe.veF.field_status = 101;
                    boolean c = an.aqd().c(this.vfh.vff.vfe.veF, new String[0]);
                    x.i("MicroMsg.NetSceneUploadAppAttach", "summersafecdn MM_ERR_GET_AESKEY_FAILED doScene again enableHitcheck[%b], ret[%b] new createtime:%d", Boolean.valueOf(this.vfh.vff.vfe.hBF), Boolean.valueOf(c), Long.valueOf(this.vfh.vff.vfe.veF.field_createTime));
                    this.vfh.vff.vfe.a(this.vfh.vff.vfe.hmA, this.vfh.vff.vfe.gJT);
                }
            });
            return;
        }
        g.pQN.h(10421, Integer.valueOf(i2), Integer.valueOf(1), Long.valueOf(this.vff.vfe.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(b.MediaType_FILE), Integer.valueOf(this.hsD.field_fileLength), this.hsD.field_transInfo, "", "", "", "", "", "", "", this.hsD.report_Part2);
        if (i == 0 && i2 == 0) {
            this.vff.vfe.d(this.hsD);
        }
        this.vff.vfe.gJT.a(i, i2, "", this.vff.vfe);
    }
}
