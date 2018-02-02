package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import com.tencent.mm.sdk.platformtools.ak.a;

class OnlineVideoView$17 implements a {
    final /* synthetic */ OnlineVideoView rvm;

    OnlineVideoView$17(OnlineVideoView onlineVideoView) {
        this.rvm = onlineVideoView;
    }

    public final boolean uF() {
        if (OnlineVideoView.d(this.rvm) == null) {
            return false;
        }
        if (((View) OnlineVideoView.d(this.rvm)).getAlpha() < 1.0f) {
            OnlineVideoView.m(this.rvm);
        }
        if (OnlineVideoView.d(this.rvm).isPlaying()) {
            OnlineVideoView.n(this.rvm);
            OnlineVideoView.d(this.rvm).getCurrentPosition();
        }
        return true;
    }
}
