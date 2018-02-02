package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class j$4 implements a {
    final /* synthetic */ j yGA;

    j$4(j jVar) {
        this.yGA = jVar;
    }

    public final void hX() {
        if (this.yGA.yDo != null) {
            this.yGA.yDo.yCY.cvf();
        }
    }

    public final void onError(int i, int i2) {
        x.w("MicroMsg.ImageGalleryViewHolder", "play video error what : " + i + " extra: " + i2);
        if (this.yGA.yDo != null) {
            this.yGA.yDo.yCY.eY(i, i2);
        }
        g.pQN.h(12084, new Object[]{Integer.valueOf(this.yGA.yGy), Integer.valueOf(this.yGA.rkQ * 1000), Integer.valueOf(0), Integer.valueOf(4), this.yGA.fzO, Integer.valueOf(this.yGA.yGz), this.yGA.fzR, Long.valueOf(this.yGA.hVE)});
    }

    public final void vh() {
        ag.y(new 1(this));
    }

    public final int cf(int i, int i2) {
        x.i("MicroMsg.ImageGalleryViewHolder", "dkvideo onplaytime:%d total:%d,%d size:%d cnt:%d user:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(this.yGA.rkQ), Integer.valueOf(i2), Integer.valueOf(this.yGA.yGy), Integer.valueOf(this.yGA.yGz), this.yGA.fzO});
        ar.Dm().F(new 2(this, i2, i));
        return 0;
    }

    public final void cg(int i, int i2) {
    }
}
