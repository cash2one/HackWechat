package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.view.View;
import android.view.View.OnClickListener;

class y$7 implements OnClickListener {
    final /* synthetic */ y rlv;

    y$7(y yVar) {
        this.rlv = yVar;
    }

    public final void onClick(View view) {
        y yVar = this.rlv;
        yVar.rlc++;
        if (this.rlv.rle) {
            this.rlv.bwK();
            this.rlv.bwJ();
            this.rlv.rlr = true;
        } else {
            this.rlv.bwF();
        }
        this.rlv.rla = true;
    }
}
