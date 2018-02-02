package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class OnlineVideoView$16 implements a {
    final /* synthetic */ OnlineVideoView rvm;

    OnlineVideoView$16(OnlineVideoView onlineVideoView) {
        this.rvm = onlineVideoView;
    }

    public final boolean uF() {
        if (OnlineVideoView.k(this.rvm) == null || OnlineVideoView.d(this.rvm) == null) {
            return false;
        }
        if (((View) OnlineVideoView.d(this.rvm)).getAlpha() < 1.0f) {
            OnlineVideoView.m(this.rvm);
        }
        if (OnlineVideoView.d(this.rvm).isPlaying()) {
            OnlineVideoView.n(this.rvm);
        }
        try {
            Object obj;
            if (bh.ov(OnlineVideoView.k(this.rvm).hTu)) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj == null) {
                return false;
            }
            return OnlineVideoView.k(this.rvm).iH(OnlineVideoView.d(this.rvm).getCurrentPosition() / 1000);
        } catch (Exception e) {
            x.e("MicroMsg.OnlineVideoView", "online video timer check error : " + e.toString());
            return false;
        }
    }
}
