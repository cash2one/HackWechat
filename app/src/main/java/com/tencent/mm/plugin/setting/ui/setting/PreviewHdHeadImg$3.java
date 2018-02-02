package com.tencent.mm.plugin.setting.ui.setting;

import android.graphics.Bitmap;
import com.tencent.mm.ad.d;
import com.tencent.mm.ad.e.b;
import com.tencent.mm.ad.n;
import com.tencent.mm.sdk.platformtools.x;

class PreviewHdHeadImg$3 implements b {
    final /* synthetic */ PreviewHdHeadImg qhv;
    final /* synthetic */ Bitmap qhx;

    PreviewHdHeadImg$3(PreviewHdHeadImg previewHdHeadImg, Bitmap bitmap) {
        this.qhv = previewHdHeadImg;
        this.qhx = bitmap;
    }

    public final int ba(int i, int i2) {
        PreviewHdHeadImg.c(this.qhv).JD();
        x.i("MicroMsg.PreviewHdHeadImg", "onSceneEnd: errType=%d, errCode=%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 && i2 == 0) {
            n.Jz();
            Bitmap je = d.je(PreviewHdHeadImg.a(this.qhv));
            if (je != null) {
                PreviewHdHeadImg previewHdHeadImg = this.qhv;
                n.Jz();
                PreviewHdHeadImg.a(previewHdHeadImg, je, d.x(PreviewHdHeadImg.a(this.qhv), true));
            } else {
                PreviewHdHeadImg.a(this.qhv, this.qhx, null);
            }
        } else {
            PreviewHdHeadImg.a(this.qhv, this.qhx, null);
        }
        return 0;
    }
}
