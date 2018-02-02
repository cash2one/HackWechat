package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.pluginsdk.ui.tools.f.e;
import com.tencent.mm.sdk.platformtools.x;

class OfflineVideoView$8 implements e {
    final /* synthetic */ OfflineVideoView ruP;

    OfflineVideoView$8(OfflineVideoView offlineVideoView) {
        this.ruP = offlineVideoView;
    }

    public final void bbH() {
        x.i("MicroMsg.OfflineVideoView", "%d on texture update.", new Object[]{Integer.valueOf(this.ruP.hashCode())});
        try {
            OfflineVideoView.e(this.ruP);
        } catch (Exception e) {
            x.e("MicroMsg.OfflineVideoView", "texture view update. error " + e.toString());
        }
    }
}
