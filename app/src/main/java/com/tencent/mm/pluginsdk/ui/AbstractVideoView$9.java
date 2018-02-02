package com.tencent.mm.pluginsdk.ui;

import com.tencent.mm.sdk.platformtools.x;

class AbstractVideoView$9 implements Runnable {
    final /* synthetic */ AbstractVideoView vjf;

    AbstractVideoView$9(AbstractVideoView abstractVideoView) {
        this.vjf = abstractVideoView;
    }

    public final void run() {
        if (this.vjf.mvE != null && this.vjf.mvE.getVisibility() != 8) {
            x.i(this.vjf.TAG, "%s hide loading", new Object[]{this.vjf.asN()});
            this.vjf.mvE.setVisibility(8);
            if (this.vjf.jte != null) {
                this.vjf.jte.bp(this.vjf.bPL(), this.vjf.getMediaId());
            }
        }
    }
}
