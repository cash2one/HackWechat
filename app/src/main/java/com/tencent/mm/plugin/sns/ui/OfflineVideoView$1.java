package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.x;

class OfflineVideoView$1 implements Runnable {
    final /* synthetic */ String ruO;
    final /* synthetic */ OfflineVideoView ruP;

    OfflineVideoView$1(OfflineVideoView offlineVideoView, String str) {
        this.ruP = offlineVideoView;
        this.ruO = str;
    }

    public final void run() {
        if (OfflineVideoView.a(this.ruP) != null) {
            x.i("MicroMsg.OfflineVideoView", "%d fresh thumb image", new Object[]{Integer.valueOf(hashCode())});
            OfflineVideoView.a(this.ruP).setImageBitmap(b.b(this.ruO, 1.0f));
        }
    }
}
