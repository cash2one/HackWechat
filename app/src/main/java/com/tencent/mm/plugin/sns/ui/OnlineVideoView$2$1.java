package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView.2;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class OnlineVideoView$2$1 implements Runnable {
    final /* synthetic */ boolean hyi;
    final /* synthetic */ 2 rvn;
    final /* synthetic */ String uS;

    OnlineVideoView$2$1(2 2, boolean z, String str) {
        this.rvn = 2;
        this.hyi = z;
        this.uS = str;
    }

    public final void run() {
        x.i("MicroMsg.OnlineVideoView", "%d weixin download finish[%b], go to prepare video", new Object[]{Integer.valueOf(this.rvn.rvm.hashCode()), Boolean.valueOf(this.hyi)});
        if (OnlineVideoView.e(this.rvn.rvm) != null && this.hyi && bh.fu(OnlineVideoView.e(this.rvn.rvm).nGJ, this.uS)) {
            ap.ec(OnlineVideoView.a(this.rvn.rvm), "");
            String a = ap.a(OnlineVideoView.a(this.rvn.rvm), OnlineVideoView.e(this.rvn.rvm));
            if (!bh.ov(a)) {
                this.rvn.rvm.aI(a, false);
            }
        }
    }
}
