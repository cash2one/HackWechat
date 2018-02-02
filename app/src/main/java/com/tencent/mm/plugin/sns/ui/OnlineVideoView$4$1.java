package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.pr;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView.4;
import com.tencent.mm.sdk.platformtools.bh;

class OnlineVideoView$4$1 implements Runnable {
    final /* synthetic */ pr rvo;
    final /* synthetic */ 4 rvp;

    OnlineVideoView$4$1(4 4, pr prVar) {
        this.rvp = 4;
        this.rvo = prVar;
    }

    public final void run() {
        if (!bh.fu(this.rvo.fHu.fus, OnlineVideoView.a(this.rvp.rvm))) {
            OnlineVideoView.a(this.rvp.rvm, false);
            this.rvp.rvm.bzJ();
            this.rvp.rvm.onDestroy();
        } else if (OnlineVideoView.q(this.rvp.rvm)) {
            this.rvp.rvm.requestLayout();
        } else {
            OnlineVideoView.a(this.rvp.rvm, true);
            this.rvp.rvm.onResume();
        }
    }
}
