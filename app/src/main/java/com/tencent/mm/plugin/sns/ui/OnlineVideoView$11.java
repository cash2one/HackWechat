package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import com.tencent.mm.sdk.platformtools.x;

class OnlineVideoView$11 implements Runnable {
    final /* synthetic */ boolean kTn;
    final /* synthetic */ float ruQ;
    final /* synthetic */ OnlineVideoView rvm;

    OnlineVideoView$11(OnlineVideoView onlineVideoView, boolean z, float f) {
        this.rvm = onlineVideoView;
        this.kTn = z;
        this.ruQ = f;
    }

    public final void run() {
        x.i("MicroMsg.OnlineVideoView", "%d switch video model isVideoPlay %b %f", new Object[]{Integer.valueOf(this.rvm.hashCode()), Boolean.valueOf(this.kTn), Float.valueOf(this.ruQ)});
        View view = (View) OnlineVideoView.d(this.rvm);
        if (this.kTn) {
            OnlineVideoView.f(this.rvm).setAlpha(this.ruQ);
            OnlineVideoView.f(this.rvm).setVisibility(0);
            view.setAlpha(this.ruQ);
            view.setVisibility(0);
            if (((double) this.ruQ) >= 1.0d) {
                OnlineVideoView.g(this.rvm).setVisibility(8);
                return;
            }
            return;
        }
        OnlineVideoView.f(this.rvm).setVisibility(8);
        view.setVisibility(8);
        OnlineVideoView.g(this.rvm).setVisibility(0);
    }
}
