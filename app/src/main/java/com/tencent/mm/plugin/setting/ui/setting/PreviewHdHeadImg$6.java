package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.ad.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.aq;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;

class PreviewHdHeadImg$6 implements Runnable {
    final /* synthetic */ PreviewHdHeadImg qhv;

    PreviewHdHeadImg$6(PreviewHdHeadImg previewHdHeadImg) {
        this.qhv = previewHdHeadImg;
    }

    public final void run() {
        x.d("MicroMsg.PreviewHdHeadImg", "updateHeadImg hasUin:%b user:%s", new Object[]{Boolean.valueOf(ar.Hj()), q.FS()});
        if (ar.Hj()) {
            aq.hfP.hM(b.iW(q.FS()));
        }
        PreviewHdHeadImg.d(this.qhv);
    }
}
