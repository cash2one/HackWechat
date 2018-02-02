package com.tencent.mm.plugin.sns.model.a;

import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.a.c.1;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.sdk.platformtools.x;

class c$1$1 implements Runnable {
    final /* synthetic */ keep_SceneResult hsD;
    final /* synthetic */ int lpl;
    final /* synthetic */ 1 qZb;
    final /* synthetic */ String uS;

    c$1$1(1 1, String str, int i, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        this.qZb = 1;
        this.uS = str;
        this.lpl = i;
        this.hsD = com_tencent_mm_modelcdntran_keep_SceneResult;
    }

    public final void run() {
        c.bwl().remove(this.qZb.qZa.qYF.qTU);
        x.i("MicroMsg.SnsCdnDownloadBase", "download done result: %s, %d, url:%s, mediaID:%s, totalSize: %d, runningTasksSize: %d", new Object[]{this.uS, Integer.valueOf(this.lpl), this.qZb.qZa.qYF.url, this.qZb.qZa.qYF.mediaId, Integer.valueOf(this.hsD.field_fileLength), Integer.valueOf(c.bwl().size())});
        if (this.qZb.qZa.qYF.qYz && this.lpl != 2) {
            au.Kw(this.qZb.qZa.qYF.mediaId);
            this.qZb.qZa.bwk();
        } else if (!this.qZb.qZa.qYF.qYz && (this.qZb.qZa.qYF.qYB == 4 || this.qZb.qZa.qYF.qYB == 6)) {
            ae.bvs().dZ(this.qZb.qZa.qYF.mediaId, this.qZb.qZa.qYF.getPath() + i.j(this.qZb.qZa.fHC));
        }
        this.qZb.qZa.qYD.a(this.lpl, this.qZb.qZa.fHC, this.qZb.qZa.qYF.qYB, this.qZb.qZa.qYF.qYz, this.qZb.qZa.qYF.qTU, this.hsD.field_fileLength);
    }
}
