package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class y$6 implements OnClickListener {
    final /* synthetic */ y rlv;

    y$6(y yVar) {
        this.rlv = yVar;
    }

    public final void onClick(View view) {
        x.d("MicroMsg.Sns.AdLandingPageStreamVideoComponentOnlinePlayer", "btn onclick view [%b] bar[%b]", new Object[]{Boolean.valueOf(this.rlv.rkN.isPlaying()), Boolean.valueOf(this.rlv.rkO.fvG)});
        this.rlv.rkS = true;
        if (this.rlv.rkO.fvG) {
            this.rlv.bxv();
            this.rlv.rlg = 4;
        } else {
            if (this.rlv.rle) {
                this.rlv.bwF();
            } else {
                this.rlv.bwJ();
                this.rlv.rlr = true;
            }
            this.rlv.ayL();
            this.rlv.rlg = 3;
            if (this.rlv.rfC) {
                this.rlv.bwK();
            }
        }
        if (this.rlv.rfE) {
            y yVar = this.rlv;
            yVar.rkY++;
        }
    }
}
