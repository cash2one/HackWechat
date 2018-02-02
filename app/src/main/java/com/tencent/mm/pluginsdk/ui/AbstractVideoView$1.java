package com.tencent.mm.pluginsdk.ui;

import com.tencent.mm.sdk.platformtools.ak.a;

class AbstractVideoView$1 implements a {
    final /* synthetic */ AbstractVideoView vjf;

    AbstractVideoView$1(AbstractVideoView abstractVideoView) {
        this.vjf = abstractVideoView;
    }

    public final boolean uF() {
        if (!this.vjf.isPlaying()) {
            return false;
        }
        if (this.vjf.viS) {
            if (this.vjf.jte != null) {
                this.vjf.jte.bn(this.vjf.bPL(), this.vjf.getMediaId());
            }
            this.vjf.viS = false;
        }
        this.vjf.mK(this.vjf.ahk());
        AbstractVideoView.a(this.vjf, this.vjf.isPlaying());
        return true;
    }
}
