package com.tencent.mm.pluginsdk.ui;

import com.tencent.mm.sdk.platformtools.ak.a;

class AbstractVideoView$5 implements a {
    final /* synthetic */ AbstractVideoView vjf;

    AbstractVideoView$5(AbstractVideoView abstractVideoView) {
        this.vjf = abstractVideoView;
    }

    public final boolean uF() {
        if (AbstractVideoView.a(this.vjf) <= 0) {
            return false;
        }
        if (!this.vjf.isPlaying()) {
            return true;
        }
        AbstractVideoView.b(this.vjf);
        return false;
    }
}
