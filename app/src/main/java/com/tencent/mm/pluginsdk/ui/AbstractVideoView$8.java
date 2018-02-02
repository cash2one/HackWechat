package com.tencent.mm.pluginsdk.ui;

import com.tencent.mm.sdk.platformtools.x;

class AbstractVideoView$8 implements Runnable {
    final /* synthetic */ AbstractVideoView vjf;

    AbstractVideoView$8(AbstractVideoView abstractVideoView) {
        this.vjf = abstractVideoView;
    }

    public final void run() {
        if (this.vjf.mvE != null && this.vjf.mvE.getVisibility() != 0) {
            x.i(this.vjf.TAG, "%s show loading", new Object[]{this.vjf.asN()});
            this.vjf.mvE.setVisibility(0);
            if (this.vjf.jte != null) {
                this.vjf.jte.bo(this.vjf.bPL(), this.vjf.getMediaId());
            }
        }
    }
}
