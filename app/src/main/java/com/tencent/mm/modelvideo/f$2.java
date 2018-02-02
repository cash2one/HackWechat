package com.tencent.mm.modelvideo;

import com.tencent.mm.modelcdntran.i.b;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class f$2 implements b {
    final /* synthetic */ f hUl;

    f$2(f fVar) {
        this.hUl = fVar;
    }

    public final void b(String str, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        if (com_tencent_mm_modelcdntran_keep_SceneResult == null) {
            x.w("MicroMsg.NetScenePreloadVideoFake", "%s onPreload completed but sceneResult is null", new Object[]{Integer.valueOf(this.hUl.hashCode())});
            if (this.hUl.hUk != null) {
                this.hUl.hUk.a(this.hUl, false, 0, 0);
                return;
            }
            return;
        }
        int i = com_tencent_mm_modelcdntran_keep_SceneResult.field_recvedBytes;
        int i2 = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength;
        x.i("MicroMsg.NetScenePreloadVideoFake", "%d onPreload Completed [%s] videoInfoName[%s] [%d, %d] videoFormat[%d]", new Object[]{Integer.valueOf(this.hUl.hashCode()), str, this.hUl.hUe, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_videoFormat)});
        if (i > 0 && i2 > 0) {
            this.hUl.hUh = (long) f.c(this.hUl.hUe, i, true);
        }
        if (this.hUl.hUk != null) {
            f$a com_tencent_mm_modelvideo_f_a = this.hUl.hUk;
            f fVar = this.hUl;
            boolean z = i > 0 && i2 > 0;
            com_tencent_mm_modelvideo_f_a.a(fVar, z, i, i2);
        }
        this.hUl.hUg = bh.Wo();
        this.hUl.ni(com_tencent_mm_modelcdntran_keep_SceneResult.getRptIpList());
        if (this.hUl.hUd) {
            g.pQN.a(354, 142, 1, false);
            if (this.hUl.hUi == 1) {
                g.pQN.a(354, 123, 1, false);
            } else {
                g.pQN.a(354, 124, 1, false);
            }
            g.pQN.a(354, (long) (com_tencent_mm_modelcdntran_keep_SceneResult.field_videoFormat + 240), 1, false);
            return;
        }
        g.pQN.a(354, 143, 1, false);
    }
}
