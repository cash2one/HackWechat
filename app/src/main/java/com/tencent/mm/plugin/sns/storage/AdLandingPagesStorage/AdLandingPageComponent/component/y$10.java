package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.view.View;
import android.view.View.OnClickListener;

class y$10 implements OnClickListener {
    final /* synthetic */ y rlv;

    y$10(y yVar) {
        this.rlv = yVar;
    }

    public final void onClick(View view) {
        boolean z = true;
        if (this.rlv.rkT) {
            this.rlv.rli = true;
            if (this.rlv.rkO.getVisibility() == 0) {
                this.rlv.rkO.setVisibility(4);
                this.rlv.rlb.setVisibility(8);
                this.rlv.jWc.setVisibility(4);
            } else {
                this.rlv.rkO.setVisibility(0);
                this.rlv.rlb.setVisibility(0);
                this.rlv.jWc.setVisibility(0);
            }
            if (this.rlv.rkM != null) {
                ab abVar = this.rlv.rkM;
                if (this.rlv.rkO.getVisibility() != 0) {
                    z = false;
                }
                abVar.iD(z);
            }
        }
    }
}
