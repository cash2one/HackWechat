package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.sdk.platformtools.x;

class y$5 implements b {
    final /* synthetic */ y rlv;

    y$5(y yVar) {
        this.rlv = yVar;
    }

    public final void agX() {
        if (this.rlv.rkN != null) {
            this.rlv.rkN.bzH();
        }
    }

    public final void kH(int i) {
        x.i("MicroMsg.Sns.AdLandingPageStreamVideoComponentOnlinePlayer", "onSeek time " + i);
        if (this.rlv.rle) {
            this.rlv.bwF();
        } else {
            this.rlv.bwJ();
        }
        this.rlv.rkN.M(i, this.rlv.rkO.fvG);
    }
}
